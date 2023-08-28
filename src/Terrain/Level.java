package Terrain;

public class Level {
    enum LevelSelect {
        ONE (Level1::createLevel),
        TWO (Level1::createLevel);
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
    LevelSelect levelSelect;
    public int[][] currentLevel;
    public Level() {
        levelSelect = LevelSelect.ONE;
        currentLevel = levelSelect.createLevel();
    }
    public void setLevelSelect(LevelSelect newLevel) {
        levelSelect = newLevel;
        currentLevel = levelSelect.createLevel();
    }
}
