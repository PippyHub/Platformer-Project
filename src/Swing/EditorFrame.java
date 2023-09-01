package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Editor.EditorInput;

import static Swing.EditorPanel.EDITOR_PANEL_WIDTH;
import static Swing.EditorPanel.EDITOR_PANEL_HEIGHT;
public class EditorFrame extends JFrame implements ActionListener {
    public static EditorPanel editorPanel;
    public static PickerFrame pickerFrame;
    public EditorFrame() {
        editorPanel = new EditorPanel();
        setTitle("Editor");
        this.getContentPane().setPreferredSize(new Dimension(EDITOR_PANEL_WIDTH, EDITOR_PANEL_HEIGHT));

        contents();
        this.add(editorPanel);
        editorPanel.setFocusable(true);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void contents() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu;
        JMenuItem menuItem;

        menu = new JMenu("File");
        menuBar.add(menu);

        menuItem = new JMenuItem("New");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Save");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Load");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menu = new JMenu("Edit");
        menuBar.add(menu);

        menuItem = new JMenuItem("Delete");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Paint");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menu = new JMenu("Objects");
        menuBar.add(menu);

        menuItem = new JMenuItem("Levels");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        this.setJMenuBar(menuBar);
    }
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "New" -> System.out.println(0);
            case "Save" -> System.out.println(1);
            case "Load" -> System.out.println(2);
            case "Delete" -> EditorInput.setBrushType(EditorInput.BrushType.DELETE_BRUSH);
            case "Paint" -> EditorInput.setBrushType(EditorInput.BrushType.PAINT_BRUSH);
            case "Levels" -> openPickerFrame();
        }
    }
    private void openPickerFrame() {
        if (pickerFrame == null) pickerFrame = new PickerFrame();
        Dimension editorFrameSize = getSize();
        Point editorFrameLocation = getLocationOnScreen();
        int pickerX = (int) (editorFrameLocation.getX() + editorFrameSize.getWidth());
        int pickerY = (int) editorFrameLocation.getY();
        pickerFrame.setLocation(pickerX, pickerY);
    }
}