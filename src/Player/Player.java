package Player;
public class Player {
    public static final int PLAYER_WIDTH = 50;
    public static final int PLAYER_HEIGHT = 100;
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
        if (!Collision.xCollision(newX)) x = newX;
        if (!Collision.yCollision(newY)) y = newY;
    }
    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }
    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
}