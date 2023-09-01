package player;

import levels.LevelsTiles;

import static levels.Levels.TILE_WIDTH;
import static levels.Levels.TILE_HEIGHT;
import static levels.Levels.tc;
import static player.Player.PLAYER_WIDTH;
import static player.Player.PLAYER_HEIGHT;
import static swing.GamePanel.GAME_PANEL_WIDTH;
import static swing.GamePanel.GAME_PANEL_HEIGHT;

public class PlayerCollision {
    final Player player;
    public PlayerCollision(Player player) {
        this.player = player;
    }
    public boolean xCollision(float newX) {
        if (newX < 0 || newX + PLAYER_WIDTH > GAME_PANEL_WIDTH) {
            return false;
        }
        for (LevelsTiles tile : tc) {
            if (newX < tile.tX + TILE_WIDTH && newX + PLAYER_WIDTH > tile.tX) {
                if (player.y < tile.tY + TILE_HEIGHT && player.y + PLAYER_HEIGHT > tile.tY) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean yCollision(float newY) {
        if (newY < 0 || newY + PLAYER_HEIGHT > GAME_PANEL_HEIGHT) {
            return true;
        }
        for (LevelsTiles tile : tc) {
            if (newY < tile.tY + TILE_HEIGHT && newY + PLAYER_HEIGHT > tile.tY) {
                if (player.x < tile.tX + TILE_WIDTH && player.x + PLAYER_WIDTH > tile.tX) {
                    return true;
                }
            }
        }
        return false;
    }
}