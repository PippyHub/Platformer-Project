package Images;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class TileMapImage {
    final int SUB_IMAGE_WIDTH = 100;
    final int SUB_IMAGE_HEIGHT = 100;
    final int TILE_AMOUNT_HORIZONTAL = 2;
    final int TILE_AMOUNT_VERTICAL = 1;
    final int IMAGE_WIDTH = SUB_IMAGE_WIDTH * TILE_AMOUNT_HORIZONTAL;
    final int IMAGE_HEIGHT = SUB_IMAGE_HEIGHT * TILE_AMOUNT_VERTICAL;
    private final Image[] images;
    public TileMapImage() {
        images = new Image[1];
    }
    public Image[] loadImages() {
        try {
            BufferedImage all = ImageIO.read(new File("src/Images/Player.png"));
            int index = 0;
            for (int y = 0; y < IMAGE_HEIGHT; y += SUB_IMAGE_HEIGHT){
                for (int x = 0; x < IMAGE_WIDTH; x += SUB_IMAGE_WIDTH) {
                    images[index] = all.getSubimage(x, y, SUB_IMAGE_WIDTH, SUB_IMAGE_HEIGHT)
                            .getScaledInstance(64, 128, BufferedImage.SCALE_SMOOTH);
                    index++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return images;
    }
}