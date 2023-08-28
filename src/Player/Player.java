package Player;

import Terrain.Level;

public class Player {
    public static final int PLAYER_WIDTH = 50;
    public static final int PLAYER_HEIGHT = 100;
    public float x, y;
    private int speedX, speedY;
    Level level;
    public Player(int x, int y, Level level) {
        this.x = x;
        this.y = y;
        this.level = level;
        this.speedX = 0;
        this.speedY = 0;
    }
    public void move() {
        x += speedX;
        y += speedY;
    }
    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }
    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
}
