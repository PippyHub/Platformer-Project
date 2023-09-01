package Player;

import Swing.GamePanel;

public class PlayerEvent {
    Player player;
    GamePanel gamePanel;
    public PlayerEvent(GamePanel gamePanel) {
        this.player = gamePanel.player;
        this.gamePanel = gamePanel;
    }
    public void actionPerformed() {
        player.gravity();
        player.move();
        gamePanel.repaint();
    }
}
