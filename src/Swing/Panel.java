package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Player.Input;
import Player.Event;
import Player.Player;
import Player.RenderPlayer;
import Terrain.Level;
import Terrain.RenderLevel;

public class Panel extends JPanel implements ActionListener, KeyListener {
    public static final int PANEL_WIDTH = 1200;
    public static final int PANEL_HEIGHT = 700;
    final int FRAMES_PER_SECOND = 60;
    private Input input;
    private Event event;
    public Player player;
    public Level level;
    public RenderPlayer renderPlayer;
    public RenderLevel renderLevel;
    public Panel() {
        addKeyListener(this);
        loadGame();
    }
    public void loadGame() {
        level = new Level();
        player = new Player(0, 0, level);
        loadListeners();
        loadTimer();
        loadRender();
    }
    public void loadListeners() {
        input = new Input(this);
        event = new Event(this);
    }
    public void loadTimer() {
        int frames = 1000 / FRAMES_PER_SECOND;
        Timer timer = new Timer(frames, this);
        timer.start();
    }
    public void loadRender() {
        renderPlayer = new RenderPlayer(this, player);
        renderLevel = new RenderLevel(this, level.currentLevel);
    }
    public void paint(Graphics g) {
        renderPlayer.render(g);
        renderLevel.render(g);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        event.actionPerformed();
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
        input.keyPressed(e);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        input.keyReleased(e);
    }
}