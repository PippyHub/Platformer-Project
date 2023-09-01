package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Editor.EditorEvent;
import Editor.EditorInput;
import Editor.EditorRender;
import Levels.Levels;

import static Swing.GamePanel.FRAMES_PER_SECOND;
public class EditorPanel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {
    public static final int EDITOR_PANEL_WIDTH = 1280;
    public static final int EDITOR_PANEL_HEIGHT = 768;
    EditorEvent editorEvent;
    EditorInput editorInput;
    EditorRender editorRender;
    public Levels levels;
    public EditorPanel() {
        loadGame();
        addMouseListener(this);
        addKeyListener(this);
    }
    public void loadGame() {
        levels = new Levels();
        loadTimer();
        loadListeners();
        loadRender();
    }
    public void loadTimer() {
        int frames = 1000 / FRAMES_PER_SECOND;
        Timer timer = new Timer(frames, this);
        timer.start();
    }
    public void loadListeners() {
        editorEvent = new EditorEvent(this);
        editorInput = new EditorInput(this);
    }
    public void loadRender() {
        editorRender = new EditorRender(this, levels.currentLevel);
    }
    public void paint(Graphics g) {
        editorRender.render(g);
    }
    @Override
    public void actionPerformed(ActionEvent e) { editorEvent.actionPerformed(); }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) { }
    @Override
    public void mousePressed(MouseEvent e) { editorInput.mousePressed(e); }
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
}