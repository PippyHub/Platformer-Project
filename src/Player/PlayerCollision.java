package Player;

import Terrain.Tile;

import static Player.Player.PLAYER_WIDTH;
import static Player.Player.PLAYER_HEIGHT;
import static Swing.GamePanel.PANEL_WIDTH;
import static Swing.GamePanel.PANEL_HEIGHT;
import static Terrain.Levels.TILE_SIZE;
import static Terrain.Levels.tc;
public class PlayerCollision {
    Player player;
    public PlayerCollision(Player player) {
        this.player = player;
    }
    public boolean xCollision(float newX) {
        if (newX < 0 || newX + PLAYER_WIDTH > PANEL_WIDTH) {
            return true;
        }
        for (Tile tile : tc) {
            if (newX < tile.tX + TILE_SIZE && newX + PLAYER_WIDTH > tile.tX) {
                if (player.y < tile.tY + TILE_SIZE && player.y + PLAYER_HEIGHT > tile.tY) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean yCollision(float newY) {
        if (newY < 0 || newY + PLAYER_HEIGHT > PANEL_HEIGHT) {
            return true;
        }
        for (Tile tile : tc) {
            if (newY < tile.tY + TILE_SIZE && newY + PLAYER_HEIGHT > tile.tY) {
                if (player.x < tile.tX + TILE_SIZE && player.x + PLAYER_WIDTH > tile.tX) {
                    return true;
                }
            }
        }
        return false;
    }
}