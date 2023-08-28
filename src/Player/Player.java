package Player;

import Terrain.Level;
public class Player {
    enum Direction {
        LEFT, RIGHT, UP, DOWN, IDLE
    }
    Direction direction = Direction.IDLE;
    public static final int PLAYER_WIDTH = 50;
    public static final int PLAYER_HEIGHT = 100;
    public int x, y;
    int speed;
    float targetX, targetY;
    float smoothX, smoothY;
    float lerpFactor = 0.2f;
    Level level;
    public Player(int x, int y, Level level) {
        this.x = x;
        this.y = y;
        this.level = level;
        this.speed = 30;
        this.targetX = x;
        this.targetY = y;
        this.smoothX = x;
        this.smoothY = y;
    }
    public void move() {
        switch (direction) {
            case LEFT -> targetX = x - speed;
            case RIGHT -> targetX = x + speed;
            case UP -> targetY = y - speed;
            case DOWN -> targetY = y + speed;
        }
        smoothX = lerp(x, targetX, lerpFactor);
        smoothY = lerp(y, targetY, lerpFactor);
        x = (int) smoothX;
        y = (int) smoothY;
    }
    private float lerp(float start, float end, float t) {
        return start + t * (end - start);
    }
}
