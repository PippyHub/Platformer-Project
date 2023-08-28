package Terrain;

import java.awt.Graphics;
import java.awt.Image;

import Images.TileMapImage;
import Swing.Panel;

public class RenderLevel {
    final int SUB_IMAGE_SIZE = TileMapImage.SUB_IMAGE_SIZE;
    Panel panel;
    private final int[][] mapData;
    private static final Image[] tileMapImg;
    static {
        TileMapImage tileMapImage = new TileMapImage();
        tileMapImg = tileMapImage.loadImages();
    }
    public RenderLevel(Panel panel, int[][] mapData) {
        this.mapData = mapData;
    }
    public void render(Graphics g, Panel observer) {
        for (int y = 0; y < mapData.length; y++) {
            for (int x = 0; x < mapData[y].length; x++) {
                int tileIndex = mapData[y][x];
                if (tileIndex >= 0 && tileIndex < tileMapImg.length) {
                    Image tile = tileMapImg[tileIndex];
                    g.drawImage(tile, x * SUB_IMAGE_SIZE, y * SUB_IMAGE_SIZE, observer);
                }
            }
        }
    }
}
