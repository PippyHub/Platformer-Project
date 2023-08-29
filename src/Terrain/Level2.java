package Terrain;

import static Swing.Panel.PANEL_WIDTH;
import static Swing.Panel.PANEL_HEIGHT;
import static Terrain.Levels.TILE_SIZE;
public class Level2 {
    public static int[][] createLevel() {
        int[][] levelData = new int[PANEL_HEIGHT][PANEL_WIDTH];
        for (int y = 0; y < PANEL_HEIGHT; y++) {
            for (int x = 0; x < PANEL_WIDTH; x++) {
                levelData[y][x] = -1;
            }
        }
        levelData[9 * TILE_SIZE][15 * TILE_SIZE] = 0;
        return levelData;
    }
}