package editor.picker;

import swing.PickerPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;

import static image.TileMapImage.*;
import static swing.PickerPanel.*;

public class PickerInput {
    final PickerPanel pickerPanel;
    public static int pickedTile = 0;
    public final int[][] tilePicker;
    public PickerInput(PickerPanel pickerPanel) {
        this.pickerPanel = pickerPanel;
        this.tilePicker = new int[(int) PICKER_SUB_IMAGE_WIDTH][(int) PICKER_SUB_IMAGE_HEIGHT];
        tilePicker();
    }
    public void tilePicker() {
        int value = 0;
        for (int blockY = 0; blockY < tilePicker.length; blockY++) {
            for (int blockX = 0; blockX < tilePicker[0].length; blockX++) {
                if (value >= IMAGE_AMOUNT) value = -1;
                tilePicker[blockY][blockX] = value;
                value++;
            }
        }
    }
    public int getTile(int mouseX, int mouseY) {
        int blockX = (int) (mouseX / PICKER_SUB_IMAGE_WIDTH);
        int blockY = (int) (mouseY / PICKER_SUB_IMAGE_HEIGHT);

        if (blockX >= 0 && blockX < tilePicker[0].length && blockY >= 0 && blockY < tilePicker.length) {
            return tilePicker[blockY][blockX];
        } else {
            return -1;
        }
    }
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            pickedTile = getTile(e.getX(), e.getY());
        }
    }
}