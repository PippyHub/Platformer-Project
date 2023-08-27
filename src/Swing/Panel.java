package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Images.PlayerImage;

import Player.Input;
import Player.Event;
import Player.Player;

public class Panel extends JPanel implements ActionListener, KeyListener {
    static final int Panel_WIDTH = 1280;
    static final int Panel_HEIGHT = 720;
    PlayerImage playerImage = new PlayerImage();
    private final Image[] playerImg = playerImage.loadImages();
    private final Input input;
    private final Event event;
    public final Player player;
    public Panel() {
        addKeyListener(this);
        this.setFocusable(true);
        player = new Player(0, 0);
        input = new Input(this);
        event = new Event(this);
        Timer timer = new Timer(16, this);
        timer.start();
    }
    public void paint(Graphics g) {
        g.drawImage(playerImg[0], player.x, player.y, this);
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
        input.keyReleased();
    }
}