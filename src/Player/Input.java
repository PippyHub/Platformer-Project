package Player;

import java.awt.event.KeyEvent;

import Swing.Panel;
public class Input {
    Panel panel;
    Player player;
    boolean leftKeyPressed, rightKeyPressed;
    public Input(Panel panel) {
        this.panel = panel;
        this.player = panel.player;
    }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT -> leftKeyPressed = true;
            case KeyEvent.VK_RIGHT -> rightKeyPressed = true;
        }

        // Check if both left and right keys are pressed
        if (leftKeyPressed && rightKeyPressed) {
            player.direction = Player.Direction.IDLE;
        } else if (leftKeyPressed) {
            player.direction = Player.Direction.LEFT;
        } else if (rightKeyPressed) {
            player.direction = Player.Direction.RIGHT;
        }
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT -> leftKeyPressed = false;
            case KeyEvent.VK_RIGHT -> rightKeyPressed = false;
        }
        if (!leftKeyPressed && !rightKeyPressed) {
            player.direction = Player.Direction.IDLE;
        } else if (leftKeyPressed) {
            player.direction = Player.Direction.LEFT;
        } else {
            player.direction = Player.Direction.RIGHT;
        }
    }
}
