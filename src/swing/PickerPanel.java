package swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import editor.picker.PickerInput;
import static image.TileMapImage.*;

public class PickerPanel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {
    public static final float PICKER_PANEL_WIDTH = 400;
    public static final float PICKER_PANEL_HEIGHT = 400;
    public static final float PICKER_WIDTH_RESIZE = TILE_MAP_PNG_WIDTH / PICKER_PANEL_WIDTH;
    public static final float PICKER_HEIGHT_RESIZE = TILE_MAP_PNG_HEIGHT / PICKER_PANEL_HEIGHT;
    public static final float PICKER_SUB_IMAGE_WIDTH = SUB_IMAGE_WIDTH / PICKER_WIDTH_RESIZE;
    public static final float PICKER_SUB_IMAGE_HEIGHT = SUB_IMAGE_HEIGHT / PICKER_HEIGHT_RESIZE;
    PickerInput pickerInput;
    public PickerPanel() {
        loadGame();
        addMouseListener(this);
    }
    public void loadGame() {
        loadListeners();
    }
    public void loadListeners() {
        pickerInput = new PickerInput(this);
    }
    public void paint(Graphics g) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/Image/TileMap.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (image != null) {
            g.drawImage(image, 0, 0, (int)PICKER_PANEL_WIDTH, (int)PICKER_PANEL_HEIGHT,null);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) { pickerInput.mouseClicked(e); }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
}