package Swing;

import javax.swing.*;
import java.awt.*;
public class Frame extends JFrame {
    static final int Panel_WIDTH = Panel.Panel_WIDTH;
    static final int Panel_HEIGHT = Panel.Panel_HEIGHT;
    public static Panel panel = new Panel();
    public Frame() {
        setTitle("Platformer");
        this.getContentPane().setPreferredSize(new Dimension(Panel_WIDTH, Panel_HEIGHT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.add(panel);

        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }
}