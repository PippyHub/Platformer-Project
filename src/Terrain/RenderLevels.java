package Terrain;

import java.awt.*;
import Images.TileMapImage;
import Swing.Panel;
public class RenderLevels {
    Panel panel;
    private final int[][] mapData;
    private static final Image[] tileMapImg;
    static {
        TileMapImage tileMapImage = new TileMapImage();
        tileMapImg = tileMapImage.loadImages();
    }

    public RenderLevels(Panel panel, int[][] mapData) {
        this.mapData = mapData;
        this.panel = panel;
    }

    public void render(Graphics g) {
        for (int y = 0; y < mapData.length; y++) {
            for (int x = 0; x < mapData[y].length; x++) {
                int tileIndex = mapData[y][x];
                if (tileIndex >= 0 && tileIndex < tileMapImg.length) {
                    g.drawImage(tileMapImg[tileIndex], x, y, panel);
                }
            }
        }
    }
}