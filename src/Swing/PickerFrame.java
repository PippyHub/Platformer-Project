package Swing;

import javax.swing.*;
import java.awt.*;

import static Swing.EditorFrame.editorPanel;
import static Swing.PickerPanel.PICKER_PANEL_WIDTH;
import static Swing.PickerPanel.PICKER_PANEL_HEIGHT;
public class PickerFrame extends JFrame {
    public static PickerPanel pickerPanel = new PickerPanel();
    public PickerFrame() {
        setTitle("Picker");
        this.getContentPane().setPreferredSize(new Dimension((int) PICKER_PANEL_WIDTH, (int) PICKER_PANEL_HEIGHT));

        this.add(pickerPanel);
        pickerPanel.setFocusable(true);

        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }
}