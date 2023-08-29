package Swing;

import javax.swing.*;
import java.awt.*;

import static Swing.Panel.PANEL_WIDTH;
import static Swing.Panel.PANEL_HEIGHT;
public class Frame extends JFrame {
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