package Player;

import static Player.Player.PLAYER_WIDTH;
import static Player.Player.PLAYER_HEIGHT;
import static Swing.Panel.PANEL_WIDTH;
import static Swing.Panel.PANEL_HEIGHT;
public class Collision {
    public static boolean xCollision(float x) {
        if (!(x >= 0 && x + PLAYER_WIDTH <= PANEL_WIDTH)) {
            return true;
        }
        return false;
    }
    public static boolean yCollision(float y) {
        if (!(y >= 0 && y + PLAYER_HEIGHT <= PANEL_HEIGHT)) {
            return true;
        }
        return false;
    }
}
