package Player;
public class Player {
    enum Direction {
        LEFT, RIGHT, IDLE
    }

    Direction direction = Direction.IDLE;
    public int x;
    public int y;
    int speed;
    float targetX;
    float smoothX;
    float lerpFactor = 0.2f;
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.speed = 30;
        this.targetX = x;
        this.smoothX = x;
    }
    public void move() {
        switch (direction) {
            case LEFT -> targetX = x - speed;
            case RIGHT -> targetX = x + speed;
        }
        smoothX = lerp(smoothX, targetX, lerpFactor);
        x = (int) (smoothX + 0.5f);
    }
    private float lerp(float start, float end, float t) {
        return start + t * (end - start);
    }
}
