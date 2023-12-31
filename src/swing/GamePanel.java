package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import levels.Levels;
import levels.LevelsRender;
import player.Player;
import player.PlayerInput;
import player.PlayerEvent;
import player.PlayerRender;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {
    public static final int GAME_PANEL_WIDTH = 1280;
    public static final int GAME_PANEL_HEIGHT = 768;
    public static final int FRAMES_PER_SECOND = 60;
    public Player player;
    private PlayerEvent event;
    private PlayerInput input;
    public PlayerRender playerRender;
    Levels level;
    public LevelsRender renderLevels;
    public GamePanel() {
        addKeyListener(this);
        loadGame();
    }
    public void loadGame() {
        level = new Levels();
        player = new Player(450, 100, level);
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
        event = new PlayerEvent(this);
        input = new PlayerInput(this);
    }
    public void loadRender() {
        renderLevels = new LevelsRender(this, level.currentLevel);
        playerRender = new PlayerRender(this, player);
    }
    public void paint(Graphics g) {
        renderLevels.render(g);
        playerRender.render(g);
    }
    @Override
    public void actionPerformed(ActionEvent e) { event.actionPerformed(); }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) { input.keyPressed(e); }
    @Override
    public void keyReleased(KeyEvent e) { input.keyReleased(e); }
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
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