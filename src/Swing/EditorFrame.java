package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static Swing.GamePanel.PANEL_WIDTH;
import static Swing.GamePanel.PANEL_HEIGHT;

public class EditorFrame extends JFrame implements ActionListener {
    public static EditorPanel editorPanel = new EditorPanel();
    public EditorFrame() {
        setTitle("Editor");
        this.getContentPane().setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

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

        menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem menuItem;

        menuItem = new JMenuItem("New");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Save");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Load");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Clear");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        this.setJMenuBar(menuBar);

        menu = new JMenu("Move Notation");
        menuBar.add(menu);
    }
    public void actionPerformed(ActionEvent e) {
        String cmd=e.getActionCommand();
        switch (cmd) {
            case "New" -> System.out.println(0);
            case "Save" -> System.out.println(1);
            case "Load" -> System.out.println(2);
            case "Clear" -> System.out.println(3);
            default -> System.out.println("Invalid input");
        }
    }
}