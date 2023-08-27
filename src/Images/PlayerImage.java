package Images;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class PlayerImage {
    final int IMAGE_WIDTH = 100;
    final int IMAGE_HEIGHT = 200;
    final int SUB_IMAGE_WIDTH = IMAGE_WIDTH;
    final int SUB_IMAGE_HEIGHT = IMAGE_HEIGHT;
    private final Image[] images;
    public PlayerImage() {
        images = new Image[1];
    }
    public Image[] loadImages() {
        try {
            BufferedImage all = ImageIO.read(new File("src/Images/Player.png"));
            int index = 0;
            for (int x = 0; x < IMAGE_WIDTH; x += SUB_IMAGE_WIDTH) {
                images[index] = all.getSubimage(x, 0, SUB_IMAGE_WIDTH, SUB_IMAGE_HEIGHT)
                        .getScaledInstance(64, 128, BufferedImage.SCALE_SMOOTH);
                index++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return images;
    }
}