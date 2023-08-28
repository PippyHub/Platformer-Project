package Player;

import static Images.TileMapImage.SQUARE_SIZE;
import Terrain.Level;

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
    Level level;
    public Player(int x, int y, Level level) {
        this.x = x;
        this.y = y;
        this.level = level;
        this.speed = 30;
        this.targetX = x;
        this.smoothX = x;
    }
    public void move() {
        switch (direction) {
            case LEFT -> targetX = x - speed;
            case RIGHT -> targetX = x + speed;
        }

        // Calculate the range of tiles the player will pass through.
        int startX = Math.min(x / SQUARE_SIZE, (int) (targetX / SQUARE_SIZE));
        int endX = Math.max(x / SQUARE_SIZE, (int) (targetX / SQUARE_SIZE));
        int targetTileY = y / SQUARE_SIZE;

        // Check for collisions with all tiles in the range.
        boolean canMove = true;
        for (int tileX = startX; tileX <= endX; tileX++) {
            if (level.currentLevel[targetTileY][tileX] == 0) {
                canMove = false;
                break; // Exit the loop as soon as a collision is detected.
            }
        }

        if (!canMove) {
            targetX = x; // No collision detected, cancel the movement.
        }

        // Use linear interpolation for smooth movement without rounding.
        smoothX = lerp(x, targetX, lerpFactor);

        // Update the player's position.
        x = (int) (smoothX + 0.5f);
    }

    private float lerp(float start, float end, float t) {
        return start + t * (end - start);
    }
}
