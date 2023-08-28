package Terrain;

import java.awt.Graphics;
import java.awt.Image;

import Images.TileMapImage;
import Swing.Panel;

public class RenderLevel {
    final int SQUARE_SIZE = TileMapImage.SQUARE_SIZE;
    Panel panel;
    private final int[][] mapData;
    private static final Image[] tileMapImg;
    static {
        TileMapImage tileMapImage = new TileMapImage();
        tileMapImg = tileMapImage.loadImages();
    }
    public RenderLevel(Panel panel, int[][] mapData) {
        this.mapData = mapData;
        this.panel = panel;
    }
    public void render(Graphics g) {
        for (int y = 0; y < mapData.length; y++) {
            for (int x = 0; x < mapData[y].length; x++) {
                int tileIndex = mapData[y][x];
                if (tileIndex >= 0 && tileIndex < tileMapImg.length) {
                    g.drawImage(tileMapImg[tileIndex], x * SQUARE_SIZE, y * SQUARE_SIZE, panel);
                }
            }
        }
    }
}
