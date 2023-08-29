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
import Terrain.Levels;
import Terrain.RenderLevels;
public class Panel extends JPanel implements ActionListener, KeyListener {
    public static final int PANEL_WIDTH = 1200;
    public static final int PANEL_HEIGHT = 700;
    final int FRAMES_PER_SECOND = 60;
    private Event event;
    private Input input;
    public Player player;
    public RenderPlayer renderPlayer;
    public Levels levels;
    public RenderLevels renderLevels;
    public Panel() {
        addKeyListener(this);
        loadGame();
    }
    public void loadGame() {
        levels = new Levels();
        player = new Player(450, 100, levels);
        loadListeners();
        loadTimer();
        loadRender();
    }
    public void loadListeners() {
        event = new Event(this);
        input = new Input(this);
    }
    public void loadTimer() {
        int frames = 1000 / FRAMES_PER_SECOND;
        Timer timer = new Timer(frames, this);
        timer.start();
    }
    public void loadRender() {
        renderPlayer = new RenderPlayer(this, player);
        renderLevels = new RenderLevels(this, levels.currentLevel);
    }
    public void paint(Graphics g) {
        renderLevels.render(g);
        renderPlayer.render(g);
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