package Player;

import Levels.Levels;
public class Player {
    public static final int PLAYER_WIDTH = 40;
    public static final int PLAYER_HEIGHT = 60;
    final int TERMINAL_VELOCITY = 30;
    final float GRAVITY = 0.5f;
    PlayerCollision playerCollision;
    Levels levels;
    private boolean isJumping = false;
    float x, y;
    private float speedX, speedY;
    public Player(int x, int y, Levels levels) {
        this.x = x;
        this.y = y;
        this.levels = levels;
        this.playerCollision = new PlayerCollision(this);
        this.speedX = 0;
        this.speedY = 0;
    }
    public void move() {
        float newX = x + speedX;
        if (!playerCollision.xCollision(newX)) x = newX;
    }
    public void jump() {
        if (!isJumping && playerCollision.yCollision(y + 1)) {
            float jumpStrength = -10f;
            speedY = (int) jumpStrength;
            isJumping = true;
        }
    }
    public void gravity() {
        speedY += GRAVITY;
        if (speedY > TERMINAL_VELOCITY) {
            speedY = TERMINAL_VELOCITY;
        }
        if (!playerCollision.yCollision(y + speedY)) {
            y += speedY;
        } else {
            float distanceToCollision = 0;
            if (speedY > 0) {
                for (float i = speedY; i > 0; i--) {
                    if (!playerCollision.yCollision(y + i)) {
                        distanceToCollision = i;
                        break;
                    }
                }
            } else {
                for (float i = speedY; i < 0; i++) {
                    if (!playerCollision.yCollision(y + i)) {
                        distanceToCollision = i;
                        break;
                    }
                }
            }
            y += distanceToCollision;
            speedY = 0;
            isJumping = false;
        }
    }
    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }
}