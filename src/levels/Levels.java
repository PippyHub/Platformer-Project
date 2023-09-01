package levels;

import java.util.LinkedList;

import static levels.csv.LevelsReader.readCSV;

public class Levels {
    public enum LevelSelect {
        ONE(readCSV("src/Levels/csv/Level1.csv")),
        TWO(readCSV("src/Levels/csv/Level2.csv"));
        private final int[][] levelCreator;
        LevelSelect(int[][] levelCreator) {
            this.levelCreator = levelCreator;
        }
        public int[][] createLevel() {
            return levelCreator;
        }
    }
    public static final int TILE_WIDTH = 32;
    public static final int TILE_HEIGHT = 32;
    LevelSelect levelSelect;
    public LevelsCollision levelsCollision;
    public static final LinkedList<LevelsTiles> tc = new LinkedList<>();
    public int[][] currentLevel;
    public Levels() {
        this.levelSelect = LevelSelect.ONE;
        this.currentLevel = this.levelSelect.createLevel();
        this.levelsCollision = new LevelsCollision(currentLevel, tc);
    }
    void setLevelSelect(LevelSelect levelSelect) {
        this.levelSelect = levelSelect;
        this.currentLevel = this.levelSelect.createLevel();
        this.levelsCollision = new LevelsCollision(currentLevel, tc);
    }
    public static LevelsTiles getTile(int mouseX, int mouseY) {
        for (LevelsTiles t : tc) {
            if (mouseX >= t.tX && mouseX <= t.tX + TILE_WIDTH &&
                    mouseY >= t.tY && mouseY <= t.tY + TILE_HEIGHT) {
                return t;
            }
        }
        return null;
    }
}