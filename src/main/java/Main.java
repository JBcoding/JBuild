import editor.MainWindowFrame;
import javax.swing.*;
import java.awt.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        JFrame window = new MainWindowFrame();
        Dimension frameSize = window.getContentPane().getPreferredSize();
        window.setSize(frameSize);
        window.setVisible(true);
        window.requestFocus();
    }
}
