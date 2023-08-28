package Player;

import Terrain.Levels;

public class Player {
    public static final int PLAYER_WIDTH = 50;
    public static final int PLAYER_HEIGHT = 100;
    public static final int PANEL_WIDTH = Swing.Panel.PANEL_WIDTH;
    public static final int PANEL_HEIGHT = Swing.Panel.PANEL_HEIGHT;
    public float x, y;
    private int speedX, speedY;
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.speedX = 0;
        this.speedY = 0;
    }
    public void move() {
        float newX = x + speedX;
        float newY = y + speedY;
        if (!xCollision(newX)) x = newX;
        if (!yCollision(newY)) y = newY;
    }
    public boolean xCollision(float x) {
        if (!(x >= 0 && x + PLAYER_WIDTH <= PANEL_WIDTH)) {
            return true;
        }
        return false;
    }
    public boolean yCollision(float y) {
        if (!(y >= 0 && y + PLAYER_HEIGHT <= PANEL_HEIGHT)) {
            return true;
        }
        return false;
    }
    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }
    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
}
