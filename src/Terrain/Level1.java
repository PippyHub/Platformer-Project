package Terrain;

import static Swing.GamePanel.PANEL_WIDTH;
import static Swing.GamePanel.PANEL_HEIGHT;
import static Terrain.Levels.TILE_SIZE;

public class Level1 {
    public static int[][] createLevel() {
        int[][] levelData = new int[PANEL_HEIGHT][PANEL_WIDTH];
        for (int y = 0; y < PANEL_HEIGHT; y++) {
            for (int x = 0; x < PANEL_WIDTH; x++) {
                levelData[y][x] = -1;
            }
        }
        for (int x = 0; x < PANEL_WIDTH; x += TILE_SIZE) {
            levelData[0][x] = 0;
            levelData[PANEL_HEIGHT - TILE_SIZE][x] = 0;
        }
        levelData[20 * TILE_SIZE][18 * TILE_SIZE] = 0;
        levelData[21 * TILE_SIZE][18 * TILE_SIZE] = 0;
        levelData[17 * TILE_SIZE][21 * TILE_SIZE] = 0;
        levelData[15 * TILE_SIZE][25 * TILE_SIZE] = 0;
        return levelData;
    }
}