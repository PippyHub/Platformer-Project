package Terrain;
import java.util.LinkedList;
public class TerrainCollision {
    int[][] currentLevel;
    public TerrainCollision(int[][] currentLevel, LinkedList<Tile> tc) {
        this.currentLevel = currentLevel;
        addHitBox(tc);
    }
    public void addHitBox(LinkedList<Tile> tc) {
        for (int y = 0; y < currentLevel.length; y++) {
            for (int x = 0; x < currentLevel[0].length; x++) {
                if (currentLevel[y][x] >= 0) {
                    new Tile(x, y, tc);
                }
            }
        }
    }
}