import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Swing.GameFrame;
import Swing.EditorFrame;

public class Main {
    static JFrame splashFrame;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            splashFrame = createSplashScreen();
            splashFrame.setVisible(true);
        });
    }
    private static JFrame createSplashScreen() {
        JFrame splashFrame = new JFrame("Splash Screen");
        splashFrame.setSize(400, 200);
        splashFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        splashFrame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel splashLabel = new JLabel("Welcome to Your Game!");
        splashLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(splashLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton playButton = new JButton("Play");
        JButton editorButton = new JButton("Level Editor");
        JButton closeButton = new JButton("Close");

        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        editorButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        playButton.setMaximumSize(new Dimension(200, 40));
        editorButton.setMaximumSize(new Dimension(200, 40));
        closeButton.setMaximumSize(new Dimension(200, 40));

        playButton.addActionListener(e -> {
            startGame();
            splashFrame.dispose();
        });

        editorButton.addActionListener(e -> {
            startEditor();
            splashFrame.dispose();
        });

        closeButton.addActionListener(e -> {
            splashFrame.dispose();
            System.exit(0);
        });

        buttonPanel.add(playButton);
        buttonPanel.add(editorButton);
        buttonPanel.add(closeButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        splashFrame.add(panel);
        splashFrame.setLocationRelativeTo(null);

        return splashFrame;
    }
    private static void startGame() {
        GameFrame gameFrame = new GameFrame();
        gameFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                gameFrame.dispose();
                splashFrame = createSplashScreen();
                splashFrame.setVisible(true);
            }
        });
    }
    private static void startEditor() {
        EditorFrame editorFrame = new EditorFrame();
        editorFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                editorFrame.dispose();
                if (EditorFrame.pickerFrame != null) {
                    EditorFrame.pickerFrame.dispose();
                    EditorFrame.pickerFrame = null;
                }
                splashFrame = createSplashScreen();
                splashFrame.setVisible(true);
            }
        });
    }
}