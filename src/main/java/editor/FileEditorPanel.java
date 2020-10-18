package editor;

import abstract_syntax.AST;
import abstract_syntax.BuildAstVisitor;
import abstract_syntax.TypeCheckingVisitor;
import building.antlr.BuildingBaseVisitor;
import building.antlr.BuildingLexer;
import building.antlr.BuildingParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileEditorPanel extends JPanel {
    RSyntaxTextArea textEditor = new RSyntaxTextArea(20, 60);
    List<FileChangedListener> listeners = new ArrayList<>();
    JTextPane errorMessages = new JTextPane();
    JScrollPane vertical;
    private File activeFile;

    public File getActiveFile() {
        return activeFile;
    }

    public void setActiveFile(File activeFile) {
        this.activeFile = activeFile;
    }

    public void addFileChangedListener(FileChangedListener listener) {
        listeners.add(listener);
    }

    private void emitFileChangedEvent(File file, FileChangeType type) {
        for (FileChangedListener listener : listeners) {
            listener.fileChanged(file, type);
        }
    }

    public FileEditorPanel() {
        super();
        try {
            textEditor.read(new StringReader("Open a project and select a file"), null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));

        setLayout(new BorderLayout());
        Theme theme;
        try {
            theme = Theme.load(getClass().getResourceAsStream(
                    "/org/fife/ui/rsyntaxtextarea/themes/monokai.xml"));
            theme.apply(textEditor);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance();
        atmf.putMapping("text/jbuild", "editor.JBuildSyntaxTokenMaker");
        textEditor.setSyntaxEditingStyle("text/jbuild");

        RTextScrollPane sp = new RTextScrollPane(textEditor);
        textEditor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 83 && e.isControlDown()) {
                    BuildingLexer lexer = new BuildingLexer(CharStreams.fromString(textEditor.getText()));
                    CommonTokenStream tokenStream = new CommonTokenStream(lexer);
                    BuildingParser parser = new BuildingParser(tokenStream);
                    SyntaxErrorListener errorListener = new SyntaxErrorListener();
                    parser.getErrorListeners().clear();
                    parser.addErrorListener(errorListener);
                    BuildingParser.ProgramContext unit = parser.program();

                    if (parser.getNumberOfSyntaxErrors() > 0) {
                        String result = errorListener.getErrors().stream().collect(Collectors.joining("\n"));
                        errorMessages.setText(result);
                        vertical.setVisible(true);
                        revalidate();
                        return;
                    } else {
                        BuildingBaseVisitor<AST> ASTBuilder = new BuildAstVisitor();
                        AST ast = ASTBuilder.visitProgram(unit);
                        TypeCheckingVisitor typeChecker = new TypeCheckingVisitor();
                        List<String> errors = (List<String>) ast.accept(typeChecker);

                        if (errors.size() > 0) {
                            String result = errors.stream().collect(Collectors.joining("\n"));
                            errorMessages.setText(result);
                            vertical.setVisible(true);
                            revalidate();
                            return;

                        } else {
                            vertical.setVisible(false);
                            errorMessages.setText("");
                            revalidate();
                        }

                    }

                    // SAVE
                    try {
                        if (activeFile == null) return;
                        Files.write(activeFile.toPath(), textEditor.getText().getBytes());
                        emitFileChangedEvent(activeFile, FileChangeType.SAVED);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        wrapper.add(sp);

        add(wrapper);

        errorMessages.setForeground(Color.red);

        vertical = new JScrollPane(errorMessages);
        vertical.setVisible(false);

        vertical.setPreferredSize(new Dimension(200,100));
        vertical.setMaximumSize(new Dimension(1000, 100));

        wrapper.add(vertical);
    }

    public void editFile(File f) {
        errorMessages.setText("");
        vertical.setVisible(false);
        revalidate();
        activeFile =  f;
        BufferedReader r;
        try {

            r = new BufferedReader(new FileReader(f));
            textEditor.read(r, null);
            r.close();
            textEditor.setCaretPosition(0);
            textEditor.discardAllEdits();
            this.activeFile = f;
        } catch (RuntimeException re) {
            throw re; // FindBugs
        } catch (Exception e) { // Never happens
            textEditor.setText("Type here to see syntax highlighting");
        }
    }
}
