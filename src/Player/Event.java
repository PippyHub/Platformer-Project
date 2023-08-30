package Player;

import Swing.GamePanel;
public class Event {
    Player player;
    GamePanel gamePanel;
    public Event(GamePanel gamePanel) {
        this.player = gamePanel.player;
        this.gamePanel = gamePanel;
    }
    public void actionPerformed() {
        player.gravity();
        player.move();
        gamePanel.repaint();
    }
}
