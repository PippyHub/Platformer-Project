package Images;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import static Terrain.Levels.TILE_SIZE;
public class TileMapImage {
    static final int SUB_IMAGE_SIZE = 100;
    static final int TILE_AMOUNT_HORIZONTAL = 2;
    static final int TILE_AMOUNT_VERTICAL = 1;
    static final int IMAGE_AMOUNT = TILE_AMOUNT_HORIZONTAL * TILE_AMOUNT_VERTICAL;
    static final int IMAGE_WIDTH = SUB_IMAGE_SIZE * TILE_AMOUNT_HORIZONTAL;
    static final int IMAGE_HEIGHT = SUB_IMAGE_SIZE * TILE_AMOUNT_VERTICAL;
    private final Image[] images;
    public TileMapImage() {
        images = new Image[IMAGE_AMOUNT];
    }
    public Image[] loadImages() {
        try {
            BufferedImage all = ImageIO.read(new File("src/Images/TileMap.png"));
            int index = 0;
            for (int y = 0; y < IMAGE_HEIGHT; y += SUB_IMAGE_SIZE){
                for (int x = 0; x < IMAGE_WIDTH; x += SUB_IMAGE_SIZE) {
                    images[index] = all.getSubimage(x, y, SUB_IMAGE_SIZE, SUB_IMAGE_SIZE)
                            .getScaledInstance(TILE_SIZE, TILE_SIZE, BufferedImage.SCALE_SMOOTH);
                    index++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return images;
    }
}