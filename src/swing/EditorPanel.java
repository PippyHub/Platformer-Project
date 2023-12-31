package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import editor.EditorEvent;
import editor.EditorInput;
import editor.EditorRender;
import levels.Levels;

import static swing.GamePanel.FRAMES_PER_SECOND;
public class EditorPanel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {
    public static final int EDITOR_PANEL_WIDTH = 1280;
    public static final int EDITOR_PANEL_HEIGHT = 768;
    EditorEvent editorEvent;
    EditorInput editorInput;
    EditorRender editorRender;
    public Levels level;
    public EditorPanel() {
        loadGame();
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void loadGame() {
        level = new Levels();
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
        editorRender = new EditorRender(this, level.currentLevel);
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
    public void mouseReleased(MouseEvent e) { editorInput.mouseReleased(e); }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) { editorInput.mouseDragged(e); }
    @Override
    public void mouseMoved(MouseEvent e) {}
}