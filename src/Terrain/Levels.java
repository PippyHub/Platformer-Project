package Terrain;

import java.util.LinkedList;

public class Levels {
    enum LevelSelect {
        ONE (Level1::createLevel),
        TWO (Level2::createLevel);
        private final LevelCreator levelCreator;
        LevelSelect(LevelCreator levelCreator) {
            this.levelCreator = levelCreator;
        }
        public int[][] createLevel() {
            return levelCreator.createLevel();
        }
    }
    interface LevelCreator {
        int[][] createLevel();
    }
    public static final int TILE_SIZE = 30;
    public static LinkedList<Tile> tc = new LinkedList<>();
    LevelSelect levelSelect;
    TerrainCollision terrainCollision;
    public int[][] currentLevel;
    public Levels() {
        levelSelect = LevelSelect.ONE;
        currentLevel = levelSelect.createLevel();
        terrainCollision = new TerrainCollision(currentLevel, tc);
    }
    public void setLevelSelect(LevelSelect newLevel) {
        levelSelect = newLevel;
        currentLevel = levelSelect.createLevel();
        terrainCollision = new TerrainCollision(currentLevel, tc);
    }
}