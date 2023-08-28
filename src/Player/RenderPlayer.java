package Player;

import java.awt.*;

import Images.PlayerImage;
import Swing.Panel;
public class RenderPlayer {
    Panel panel;
    Player player;
    private static final Image[] playerImg;
    static {
        PlayerImage playerImage = new PlayerImage();
        playerImg = playerImage.loadImages();
    }
    public RenderPlayer(Panel panel, Player player) {
        this.panel = panel;
        this.player = player;
    }
    public void render(Graphics g) {
        g.drawImage(playerImg[0], player.x, player.y, panel);
    }
}
