package Terrain;

import Images.TileMapImage;
import Swing.Panel;
public class Level1 {
    static final int PANEL_WIDTH = Panel.PANEL_WIDTH;
    static final int PANEL_HEIGHT = Panel.PANEL_HEIGHT;
    static final int SUB_IMAGE_SIZE = TileMapImage.SUB_IMAGE_SIZE;
    private static final int LEVEL_WIDTH = PANEL_WIDTH / SUB_IMAGE_SIZE;
    private static final int LEVEL_HEIGHT = PANEL_HEIGHT / SUB_IMAGE_SIZE;
    public static int[][] createLevel() {
        int[][] levelData = new int[LEVEL_HEIGHT][LEVEL_WIDTH];
        for (int y = 0; y < LEVEL_HEIGHT; y++) {
            for (int x = 0; x < LEVEL_WIDTH; x++) {
                levelData[y][x] = 0;
            }
        }
        for (int x = 0; x < LEVEL_WIDTH; x++) {
            levelData[LEVEL_HEIGHT - 1][x] = 1;
        }
        return levelData;
    }
}