package editor;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;

public class MainWindowFrame extends JFrame {
    RSyntaxTextArea textEditor;
    FileTreePanel fileTree;

    public MainWindowFrame() {
        super("JBuild");
        setJMenuBar(createMenu());
        setupPanes();
    }

    private void editFile(File f) {
        BufferedReader r;
        try {
            r = new BufferedReader(new FileReader(f));
            textEditor.read(r, null);
            r.close();
            textEditor.setCaretPosition(0);
            textEditor.discardAllEdits();
        } catch (RuntimeException re) {
            throw re; // FindBugs
        } catch (Exception e) { // Never happens
            textEditor.setText("Type here to see syntax highlighting");
        }
    }

    private void setupPanes() {
        textEditor = new RSyntaxTextArea(20, 60);
        RTextScrollPane sp = new RTextScrollPane(textEditor);

        JPanel canvas = new JPanel();
        canvas.setBackground(Color.RED);

        fileTree = new FileTreePanel("/home/mathias/Desktop");
        fileTree.addFileSelectedListener(new FileSelectedListener() {
            @Override
            public void fileSelected(File file) {
                editFile(file);
            }
        });

        fileTree.setBackground(Color.GREEN);
        fileTree.setMinimumSize(new Dimension(200, 200));

        JSplitPane rightPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, fileTree, sp);

        JSplitPane main_panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, canvas, rightPanel);
        main_panel.setPreferredSize(new Dimension(1600, 900));
        main_panel.setResizeWeight(1.0);
        main_panel.setResizeWeight(1.0);

        Dimension minimumSize = new Dimension(300, 50);
        canvas.setMinimumSize(minimumSize);

        JLabel label = new JLabel();
        label.setText("TEST");

        getContentPane().add(main_panel);
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.getPopupMenu().setLightWeightPopupEnabled(false);
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem newProject = new JMenuItem("New");
        newProject.setMnemonic(KeyEvent.VK_N);
        newProject.setToolTipText("New project");
        newProject.addActionListener((event) -> System.exit(0));
        fileMenu.add(newProject);

        JMenuItem open = new JMenuItem("Open");
        open.setMnemonic(KeyEvent.VK_O);
        open.setToolTipText("Open project");
        open.addActionListener((event) -> System.exit(0));
        fileMenu.add(open);

        JMenuItem exit = new JMenuItem("Exit");
        exit.setMnemonic(KeyEvent.VK_E);
        exit.setToolTipText("Exit JBuild");
        exit.addActionListener((event) -> System.exit(0));
        fileMenu.add(exit);

        menuBar.add(fileMenu);
        return menuBar;
    }
}
