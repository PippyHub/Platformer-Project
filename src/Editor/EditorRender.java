package Editor;

import java.awt.*;

import Images.TileMapImage;
import Swing.EditorPanel;

public class EditorRender {
    EditorPanel editorPanel;
    private final int[][] mapData;
    private static final Image[] tileMapImg;
    static {
        TileMapImage tileMapImage = new TileMapImage();
        tileMapImg = tileMapImage.loadImages();
    }
    public EditorRender(EditorPanel editorPanel, int[][] mapData) {
        this.editorPanel = editorPanel;
        this.mapData = mapData;
    }
    public void render(Graphics g) {
        if (mapData == null) return;
        for (int y = 0; y < mapData.length; y++) {
            for (int x = 0; x < mapData[y].length; x++) {
                int tileIndex = mapData[y][x];
                if (tileIndex >= 0 && tileIndex < tileMapImg.length) {
                    g.drawImage(tileMapImg[tileIndex], x, y, editorPanel);
                }

            }
        }
    }
}