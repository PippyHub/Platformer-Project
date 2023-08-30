package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class EditorPanel extends JPanel implements ActionListener, KeyListener {
    public EditorPanel() {
        addKeyListener(this);
    }
    public void loadGame() {
        loadListeners();
    }
    public void loadListeners() {
        //event = new Event(this);
        //input = new Input(this);
    }
    public void loadRender() {
        //renderLevels = new RenderLevels(this, levels.currentLevel);
    }
    public void paint(Graphics g) {

    }
    @Override
    public void actionPerformed(ActionEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}