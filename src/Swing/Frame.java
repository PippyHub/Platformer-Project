package Swing;

import javax.swing.*;
import java.awt.*;
public class Frame extends JFrame {
    static final int PANEL_WIDTH = Panel.PANEL_WIDTH;
    static final int PANEL_HEIGHT = Panel.PANEL_HEIGHT;
    public static Panel panel = new Panel();
    public Frame() {
        setTitle("Platformer");
        this.getContentPane().setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.add(panel);
        panel.setFocusable(true);

        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }
}