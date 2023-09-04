package image;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import static player.Player.PLAYER_WIDTH;
import static player.Player.PLAYER_HEIGHT;

public class PlayerImage {
    final int IMAGE_WIDTH = 100;
    final int IMAGE_HEIGHT = 200;
    final int IMAGE_AMOUNT = 1;
    final int SUB_IMAGE_WIDTH = IMAGE_WIDTH * IMAGE_AMOUNT;
    final int SUB_IMAGE_HEIGHT = IMAGE_HEIGHT * IMAGE_AMOUNT;
    private final Image[] images;
    public PlayerImage() {
        images = new Image[IMAGE_AMOUNT];
    }
    public Image[] loadImages() {
        try {
            BufferedImage all = ImageIO.read(new File("src/image/Player.png"));
            int index = 0;
            for (int x = 0; x < IMAGE_WIDTH; x += SUB_IMAGE_WIDTH) {
                images[index] = all.getSubimage(x, 0, SUB_IMAGE_WIDTH, SUB_IMAGE_HEIGHT)
                        .getScaledInstance(PLAYER_WIDTH, PLAYER_HEIGHT, BufferedImage.SCALE_SMOOTH);
                index++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return images;
    }
}