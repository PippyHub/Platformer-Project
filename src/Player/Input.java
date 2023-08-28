package Player;

import java.awt.event.KeyEvent;

import Swing.Panel;
public class Input {
    Panel panel;
    Player player;
    boolean leftKeyPressed, rightKeyPressed, upKeyPressed, downKeyPressed;
    public Input(Panel panel) {
        this.panel = panel;
        this.player = panel.player;
    }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT -> leftKeyPressed = true;
            case KeyEvent.VK_RIGHT -> rightKeyPressed = true;
            case KeyEvent.VK_UP -> upKeyPressed = true;
            case KeyEvent.VK_DOWN -> downKeyPressed = true;
        }

        if (leftKeyPressed && rightKeyPressed || upKeyPressed && downKeyPressed) {
            player.direction = Player.Direction.IDLE;
        } else if (leftKeyPressed) {
            player.direction = Player.Direction.LEFT;
        } else if (rightKeyPressed) {
            player.direction = Player.Direction.RIGHT;
        } else if (upKeyPressed) {
            player.direction = Player.Direction.UP;
        } else if (downKeyPressed) {
            player.direction = Player.Direction.DOWN;
        }
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT -> leftKeyPressed = false;
            case KeyEvent.VK_RIGHT -> rightKeyPressed = false;
            case KeyEvent.VK_UP -> upKeyPressed = false;
            case KeyEvent.VK_DOWN -> downKeyPressed = false;
        }
        if (!leftKeyPressed && !rightKeyPressed && !upKeyPressed && !downKeyPressed) {
            player.direction = Player.Direction.IDLE;
        } else if (leftKeyPressed) {
            player.direction = Player.Direction.LEFT;
        } else if (rightKeyPressed) {
            player.direction = Player.Direction.RIGHT;
        } else if (upKeyPressed) {
            player.direction = Player.Direction.UP;
        } else {
            player.direction = Player.Direction.DOWN;
        }
    }
}
