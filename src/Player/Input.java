package Player;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import Swing.Panel;
public class Input {
    Panel panel;
    Player player;
    Set<Integer> pressedKeys = new HashSet<>();
    public Input(Panel panel) {
        this.panel = panel;
        this.player = panel.player;
    }
    public void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
        int speedX = 0;
        int speedY = 0;
        for (Integer key : pressedKeys) {
            switch (key) {
                case KeyEvent.VK_LEFT -> speedX -= 5;
                case KeyEvent.VK_RIGHT -> speedX += 5;
                case KeyEvent.VK_UP -> speedY -= 5;
                case KeyEvent.VK_DOWN -> speedY += 5;
            }
        }
        player.setSpeedX(speedX);
        player.setSpeedY(speedY);
    }
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
        int speedX = 0;
        int speedY = 0;
        for (Integer key : pressedKeys) {
            switch (key) {
                case KeyEvent.VK_LEFT -> speedX -= 5;
                case KeyEvent.VK_RIGHT -> speedX += 5;
                case KeyEvent.VK_UP -> speedY -= 5;
                case KeyEvent.VK_DOWN -> speedY += 5;
            }
        }
        player.setSpeedX(speedX);
        player.setSpeedY(speedY);
    }
}
