package Terrain;

import Images.TileMapImage;
import Swing.Panel;
public class Level1 {
    static final int PANEL_WIDTH = Panel.PANEL_WIDTH;
    static final int PANEL_HEIGHT = Panel.PANEL_HEIGHT;
    static final int SQUARE_SIZE = TileMapImage.SQUARE_SIZE;
    private static final int LEVEL_WIDTH = PANEL_WIDTH / SQUARE_SIZE;
    private static final int LEVEL_HEIGHT = PANEL_HEIGHT / SQUARE_SIZE;
    public static int[][] createLevel() {
        int[][] levelData = new int[LEVEL_HEIGHT][LEVEL_WIDTH];
        for (int y = 0; y < LEVEL_HEIGHT; y++) {
            for (int x = 0; x < LEVEL_WIDTH; x++) {
                levelData[y][x] = -1;
            }
        }
        for (int x = 0; x < LEVEL_WIDTH; x++) {
            levelData[LEVEL_HEIGHT - 1][x] = 0;
            levelData[0][x] = 0;
        }
        for (int y = 0; y < LEVEL_HEIGHT; y++) {
            levelData[y][LEVEL_WIDTH - 1] = 0;
            levelData[y][0] = 0;
        }
        return levelData;
    }
}