package Player;

import static Player.Player.PLAYER_WIDTH;
import static Player.Player.PLAYER_HEIGHT;
import static Terrain.Levels.TILE_SIZE;

public class Collision {
    Player player;
    public Collision(Player player) {
        this.player = player;
    }
    public  boolean xCollision(float newX, int[][] level) {
        if (newX < 0 || newX + PLAYER_WIDTH > level[0].length * TILE_SIZE) {
            return true;
        }
        for (float y = player.y; y <= player.y + PLAYER_HEIGHT; y++) {
            if (level[(int) y / TILE_SIZE][(int) newX / TILE_SIZE] >= 0 || level[(int) y / TILE_SIZE][(int) (newX + PLAYER_WIDTH) / TILE_SIZE] >= 0) {
                return true;
            }
        }
        return false;
    }
    public boolean yCollision(float newY, int[][] level) {
        if (newY < 0 || newY + PLAYER_HEIGHT > level.length * TILE_SIZE) {
            return true;
        }
        for (float x = player.x; x <= player.x + PLAYER_WIDTH; x++) {
            if (level[(int) newY / TILE_SIZE][(int) x / TILE_SIZE] >= 0 || level[(int) (newY + PLAYER_HEIGHT) / TILE_SIZE][(int) x / TILE_SIZE] >= 0) {
                return true;
            }
        }
        return false;
    }
}