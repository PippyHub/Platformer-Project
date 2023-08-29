package Player;

import java.awt.*;

import Images.PlayerImage;
import Swing.Panel;

import static Player.Player.PLAYER_WIDTH;
import static Player.Player.PLAYER_HEIGHT;
public class RenderPlayer {
    Player player;
    Panel panel;
    private static final Image[] playerImg;
    static {
        PlayerImage playerImage = new PlayerImage();
        playerImg = playerImage.loadImages();
    }
    public RenderPlayer(Panel panel, Player player) {
        this.player = player;
        this.panel = panel;
    }
    public void render(Graphics g) {
        g.drawImage(playerImg[0], (int) player.x, (int) player.y, panel);
        hitBox(g);
    }
    public void hitBox(Graphics g) {
        int hitBoxSize = 4;
        g.setColor(Color.red);
        g.fillRect((int) player.x, (int) player.y, PLAYER_WIDTH, hitBoxSize);
        g.fillRect((int) player.x, (int) player.y + PLAYER_HEIGHT - hitBoxSize, PLAYER_WIDTH, hitBoxSize);
        g.fillRect((int) player.x, (int) player.y, hitBoxSize, PLAYER_HEIGHT);
        g.fillRect((int) player.x + PLAYER_WIDTH - hitBoxSize, (int) player.y, hitBoxSize, PLAYER_HEIGHT);
    }
}
