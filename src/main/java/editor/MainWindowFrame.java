package editor;

import building.antlr.BuildingLexer;
import building.antlr.BuildingParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rtextarea.RTextScrollPane;
import renderer.Building;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class MainWindowFrame extends JFrame {
    private FileEditorPanel fileEditor;
    private FileTreePanel fileTree;
    private RendererPanel renderer;
    private BuildingUpdater buildingUpdater;
    private Project project;

    public MainWindowFrame() {
        super("JBuild");
        setJMenuBar(createMenu());
        setupPanes();

        String recent = EditorProperties.getInstance().get("recent_project");
        if (recent != null && !recent.isEmpty()) {
            openProject(new File(recent));
        }

    }

    private void addBuildingFromFile(File file) {
        if (!file.exists()) {
            return;
        }
        try {
            Building b = Building.buildFromFile(file, System.nanoTime());
            buildingUpdater.buildingChanged(b, BuildingChangeType.MOVED);
            renderer.addBuilding(b);
            renderer.forceRedraw();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openProject(File file) {
        if (!file.exists()) {
            return;
        }
        renderer.clearAllBuildings();
        EditorProperties.getInstance().set("recent_project", file.getAbsolutePath());
        try {
            project = Project.fromDirectory(file);
            buildingUpdater.setProject(project);
            fileTree.setRootDirectory(file);

            for (BuildingInformation bi : project.getBuildings()) {
                try {
                    Building b = Building.buildFromFile(new File(bi.getFilePath()), bi.getSeed());
                    b.setTranslation(new Vector3D(bi.translation));
                    b.setRotationAngle(bi.getRotation());
                    buildingUpdater.addHash(b, bi);
                    renderer.addBuilding(b);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            renderer.forceRedraw();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void setupPanes() {
        buildingUpdater = new BuildingUpdater();

        renderer = new RendererPanel();
        renderer.addBuildingChangedListener(buildingUpdater);

        renderer.addBuildingChangedListener(new BuildingChangedListener() {
            @Override
            public void buildingChanged(Building building, BuildingChangeType type) {
                if (type == BuildingChangeType.REGENERATE_REQUESTED) {
                    Building b = redrawBuilding(building);
                    renderer.setSelectedBuilding(b);
                }
            }
        });

        renderer.addBuildingChangedListener(new BuildingChangedListener() {
            @Override
            public void buildingChanged(Building building, BuildingChangeType type) {
                renderer.forceRedraw();
            }
        });



        fileEditor = new FileEditorPanel();
        fileEditor.addFileChangedListener(new FileChangedListener() {
            @Override
            public void fileChanged(File file, FileChangeType type) {
                redrawFromFile(file);
                renderer.forceRedraw();
            }
        });

        fileTree = new FileTreePanel();
        fileTree.addFileSelectedListener(new FileChangedListener() {
            @Override
            public void fileChanged(File file, FileChangeType type) {
                if (type != FileChangeType.SELECT) return;
                fileEditor.editFile(file);
            }
        });

        fileTree.addFileSelectedListener(new FileChangedListener() {
            @Override
            public void fileChanged(File file, FileChangeType type) {
                if (type != FileChangeType.ADD) return;
                addBuildingFromFile(file);
                renderer.revalidate();
            }
        });

        fileTree.setMinimumSize(new Dimension(200, 200));

        JSplitPane rightPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, fileTree, fileEditor);

        JSplitPane main_panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, renderer, rightPanel);
        main_panel.setPreferredSize(new Dimension(1600, 900));
        main_panel.setResizeWeight(1.0);

        getContentPane().add(main_panel);
    }

    private void redrawFromFile(File file) {
        for (BuildingInformation bi : project.getBuildings()) {
            if (file.getAbsolutePath().equals(bi.getFilePath())) {
                Building b = buildingUpdater.map.inverse().get(bi);
                redrawBuilding(b);
            }
        }
    }

    private Building redrawBuilding(Building b) {
        try {
            BuildingInformation bi = buildingUpdater.map.get(b);
            bi.setSeed(System.nanoTime());
            Building newBuilding = Building.buildFromFile(new File(bi.getFilePath()), bi.getSeed());
            if (b == null) return null;
            buildingUpdater.map.remove(b);
            renderer.buildings.remove(b);
            buildingUpdater.addHash(newBuilding, bi);
            newBuilding.setRotationAngle(bi.getRotation());
            newBuilding.setTranslation(new Vector3D(bi.translation));
            renderer.addBuilding(newBuilding);
            project.saveToFile();
            return newBuilding;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void redrawBuildings() {
        try {
            renderer.clearAllBuildings();
            buildingUpdater.clear();
            for (BuildingInformation bi : project.getBuildings()) {
                    Building b = Building.buildFromFile(new File(bi.getFilePath()), bi.getSeed());
                    if (b == null) continue;
                    b.setRotationAngle(bi.getRotation());
                    b.setTranslation(new Vector3D(bi.translation));
                    buildingUpdater.addHash(b, bi);
                    renderer.addBuilding(b);
            }
            renderer.forceRedraw();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.getPopupMenu().setLightWeightPopupEnabled(false);
        fileMenu.setMnemonic(KeyEvent.VK_F);


        final Component self = this;

        JMenuItem newProject = new JMenuItem("New");
        newProject.setMnemonic(KeyEvent.VK_N);
        newProject.setToolTipText("New project");
        newProject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(FileSystemView.getFileSystemView().getHomeDirectory());
                chooser.setDialogTitle("Select directory");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                // disable the "All files" option.
                chooser.setAcceptAllFileFilterUsed(false);

                if (chooser.showOpenDialog(self) == JFileChooser.APPROVE_OPTION) {
                    File f = chooser.getSelectedFile();
                    String fileName = JOptionPane.showInputDialog("Please enter name of file");
                    if (fileName == null || fileName.isEmpty()) return;
                    f = new File(f, fileName);
                    if (f.exists()) return;
                    f.mkdir();
                    openProject(f);
                }
            }
        });
        fileMenu.add(newProject);

        JMenuItem open = new JMenuItem("Open");
        open.setMnemonic(KeyEvent.VK_O);
        open.setToolTipText("Open project");
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(FileSystemView.getFileSystemView().getHomeDirectory());
                chooser.setDialogTitle("Select directory");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                // disable the "All files" option.
                chooser.setAcceptAllFileFilterUsed(false);

                if (chooser.showOpenDialog(self) == JFileChooser.APPROVE_OPTION) {
                    File f = chooser.getSelectedFile();
                    EditorProperties.getInstance().set("recent_project", f.getAbsolutePath());
                    openProject(f);
                }
            }
        });
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
