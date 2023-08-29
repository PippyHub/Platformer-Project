package Player;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import Swing.Panel;
public class Input {
    final int PLAYER_SPEED = 5;
    Player player;
    Panel panel;
    Set<Integer> pressedKeys = new HashSet<>();
    public Input(Panel panel) {
        this.player = panel.player;
        this.panel = panel;
    }
    public void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
        int speedX = 0;
        for (Integer key : pressedKeys) {
            switch (key) {
                case KeyEvent.VK_LEFT -> speedX -= PLAYER_SPEED;
                case KeyEvent.VK_RIGHT -> speedX += PLAYER_SPEED;
                case KeyEvent.VK_UP -> { player.jump(); }
            }
        }
        player.setSpeedX(speedX);
    }
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
        int speedX = 0;
        for (Integer key : pressedKeys) {
            switch (key) {
                case KeyEvent.VK_LEFT -> speedX -= PLAYER_SPEED;
                case KeyEvent.VK_RIGHT -> speedX += PLAYER_SPEED;
            }
        }
        player.setSpeedX(speedX);
    }
}