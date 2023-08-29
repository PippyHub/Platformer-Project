package Player;

import Terrain.Levels;
public class Player {
    public static final int PLAYER_WIDTH = 25;
    public static final int PLAYER_HEIGHT = 50;
    Collision collision;
    Levels levels;
    public float x, y;
    private int speedX, speedY;
    public Player(int x, int y, Levels levels) {
        this.x = x;
        this.y = y;
        this.levels = levels;
        this.collision = new Collision(this);
        this.speedX = 0;
        this.speedY = 0;
    }
    public void move() {
        float newX = x + speedX;
        float newY = y + speedY;
        if (!collision.xCollision(newX, levels.currentLevel)) x = newX;
        if (!collision.yCollision(newY, levels.currentLevel)) y = newY;
    }
    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }
    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
}