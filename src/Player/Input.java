package Player;

import java.awt.event.KeyEvent;

import Swing.Panel;
public class Input {
    Panel panel;
    Player player;
    public Input(Panel panel) {
        this.panel = panel;
        this.player = panel.player;
    }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT -> player.direction =  Player.Direction.LEFT;
            case KeyEvent.VK_RIGHT -> player.direction = Player.Direction.RIGHT;
        }
    }
    public void keyReleased() {
        player.direction = Player.Direction.IDLE;
    }
}
