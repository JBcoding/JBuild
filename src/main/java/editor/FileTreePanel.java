package editor;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FileTreePanel extends JPanel {

    JTree tree;
    DefaultMutableTreeNode root;
    List<FileSelectedListener> listeners = new ArrayList<>();
    public FileTreePanel(String rootDirectory) {
        root = generateTree(new File(rootDirectory));
        tree = new JTree(root);
        tree.setRootVisible(false);
        tree.setCellRenderer(new FileTreeCellRenderer());
        setLayout(new BorderLayout());
        add(new JScrollPane(tree),"Center");
        MouseListener ml = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int selRow = tree.getRowForLocation(e.getX(), e.getY());
                TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
                if(selRow != -1) {
                    if(e.getClickCount() == 2) {
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) selPath.getLastPathComponent();
                        File f = (File) node.getUserObject();
                        if (f.isFile()) {
                            fileSelected(f);
                        }
                    }
                }
            }
        };
        tree.addMouseListener(ml);
    }

    public void addFileSelectedListener(FileSelectedListener listener) {
        listeners.add(listener);
    }

    private void fileSelected(File f) {
        for (FileSelectedListener listener : this.listeners) {
            listener.fileSelected(f);
        }
    }

    public Dimension getPreferredSize(){
        return new Dimension(200, 120);
    }

    DefaultMutableTreeNode generateTree(File f) {
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