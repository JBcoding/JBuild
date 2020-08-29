package editor;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FileTreePanel extends JPanel {

    JTree tree;
    DefaultMutableTreeNode root;
    List<FileChangedListener> listeners = new ArrayList<>();
    JPanel tree_wrapper = new JPanel();
    File rootDirectory;

    public FileTreePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addMenu();
        tree_wrapper.setLayout(new BorderLayout());
        add(tree_wrapper);
    }

    private void addMenu() {
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton addBuildingButton = new JButton("Add");
        buttons.add(addBuildingButton);

        addBuildingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tree.getSelectionPath() == null) return;
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
                File f = (File)node.getUserObject();
                if (f.isDirectory()) return;
                fileChanged(f, FileChangeType.ADD);
            }
        });


        JButton newFileButton = new JButton("New file");
        newFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rootDirectory == null) return;
                String fileName = JOptionPane.showInputDialog("Please enter name of file");
                if (fileName == null || fileName.isEmpty()) return;
                if (!fileName.endsWith(".jbuild")) {
                    fileName = fileName.concat(".jbuild");
                }
                File newFile = new File(rootDirectory, fileName);
                if (newFile.exists()) return;
                try {
                    newFile.createNewFile();
                    setRootDirectory(rootDirectory);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }


            }
        });
        buttons.add(newFileButton);

        add(buttons);
    }

    public void setRootDirectory(File f) {
        rootDirectory = f;
        tree_wrapper.removeAll();
        root = generateTree(f);
        tree = new JTree(root);
        tree.setRootVisible(false);
        tree.setCellRenderer(new FileTreeCellRenderer());

        tree_wrapper.add(new JScrollPane(tree),"Center");
        MouseListener ml = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int selRow = tree.getRowForLocation(e.getX(), e.getY());
                TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
                if(selRow != -1) {
                    if(e.getClickCount() == 2) {
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) selPath.getLastPathComponent();
                        File f = (File) node.getUserObject();
                        if (f.isFile()) {
                            fileChanged(f, FileChangeType.SELECT);
                        }
                    }
                }
            }
        };
        tree.addMouseListener(ml);
        tree.revalidate();
        tree_wrapper.revalidate();
    }

    public void addFileSelectedListener(FileChangedListener listener) {
        listeners.add(listener);
    }

    private void fileChanged(File f, FileChangeType type) {
        for (FileChangedListener listener : this.listeners) {
            listener.fileChanged(f, type);
        }
    }

    public Dimension getPreferredSize(){
        return new Dimension(200, 120);
    }

    private DefaultMutableTreeNode generateTree(File f) {
        return generateTree(f, 0);
    }

    private DefaultMutableTreeNode generateTree(File f, int depth) {
        if (depth > 5) return null;
        if (f.isDirectory()) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(f);
            for (File cf : f.listFiles()) {
                DefaultMutableTreeNode subTree = generateTree(cf);
                if (subTree != null) {
                    node.add(subTree);
                }
            }
            return node;
        } else {
            if (!f.getName().endsWith(".jbuild")) return null;
            return new DefaultMutableTreeNode(f);
        }
    }
}

class FileTreeCellRenderer implements TreeCellRenderer {
    private JLabel label;

    FileTreeCellRenderer() {
        label = new JLabel();
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        DefaultTreeCellRenderer dr = new DefaultTreeCellRenderer();

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        File file = (File) node.getUserObject();
        if (file.isDirectory()) {
            boolean anyChildren = Arrays.stream(file.listFiles()).anyMatch(x -> x.getName().endsWith(".jbuild") || x.isDirectory());
            if (expanded || !anyChildren) {
                label.setIcon(UIManager.getIcon("FileView.directoryIcon"));
            } else {
                label.setIcon(UIManager.getIcon("FileView.directoryIcon"));
            }
        } else {
            label.setIcon(UIManager.getIcon("FileView.fileIcon"));
        }

        label.setText(file.getName());
        return label;
    }
}