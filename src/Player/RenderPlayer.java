package Player;

import java.awt.*;

import Images.PlayerImage;
import Swing.Panel;
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
    }
}
