package editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RendererPanelMenu extends JPanel {
    private final JButton addPathButton;

    public RendererPanelMenu() {
        super();
        setLayout(new FlowLayout(FlowLayout.LEFT));
        addPathButton = new JButton("Add path");
        add(addPathButton);
    }

    public void addPathClickedListener(ActionListener l) {
        addPathButton.addActionListener(l);
    }
}
