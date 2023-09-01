package Levels;

import java.util.LinkedList;

public class LevelsCollision {
    int[][] currentLevel;
    public LevelsCollision(int[][] currentLevel, LinkedList<LevelsTiles> tc) {
        this.currentLevel = currentLevel;
        if (currentLevel != null) addHitBox(tc);
    }
    public void addHitBox(LinkedList<LevelsTiles> tc) {
        for (int y = 0; y < currentLevel.length; y++) {
            for (int x = 0; x < currentLevel[0].length; x++) {
                if (currentLevel[y][x] >= 0) {
                    new LevelsTiles(x, y, tc);
                }
            }
        }
    }
}