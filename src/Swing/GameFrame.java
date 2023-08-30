package Swing;

import javax.swing.*;
import java.awt.*;

import static Swing.GamePanel.PANEL_WIDTH;
import static Swing.GamePanel.PANEL_HEIGHT;
public class GameFrame extends JFrame {
    public static GamePanel gamePanel = new GamePanel();
    public GameFrame() {
        setTitle("Game");
        this.getContentPane().setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.add(gamePanel);
        gamePanel.setFocusable(true);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}