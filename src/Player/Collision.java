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
        int playerLeftTile = (int) (newX / TILE_SIZE);
        int playerRightTile = (int) ((newX + PLAYER_WIDTH) / TILE_SIZE);
        if (playerLeftTile < 0 || playerRightTile >= level[0].length) {
            return true;
        }
        System.out.println(playerLeftTile);
        /*int playerTopTile = (int) (player.y / TILE_SIZE);
        int playerBottomTile = (int) ((player.y + PLAYER_HEIGHT) / TILE_SIZE);

        for (int y = playerTopTile; y <= playerBottomTile; y++) {
            if (level[y][playerLeftTile] == 0 || level[y][playerRightTile] == 0) {
                return true;
            }
        }*/
        return false;
    }
    public boolean yCollision(float newY, int[][] level) {
        int playerTopTile = (int) (newY / TILE_SIZE);
        int playerBottomTile = (int) ((newY + PLAYER_HEIGHT) / TILE_SIZE);

        if (playerTopTile < 0 || playerBottomTile >= level.length) {
            return true;
        }

        /*int playerLeftTile = (int) (player.x / TILE_SIZE);
        int playerRightTile = (int) ((player.x + PLAYER_WIDTH) / TILE_SIZE);

        for (int x = playerLeftTile; x <= playerRightTile; x++) {
            if (level[playerTopTile][x] == 0 || level[playerBottomTile][x] == 0) {
                return true;
            }
        }*/

        return false;
    }
}