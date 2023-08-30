import javax.swing.*;

import Swing.GameFrame;
import Swing.EditorFrame;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JDialog loadingDialog = createLoadingDialog();
            loadingDialog.setVisible(true);
            JProgressBar progressBar = new JProgressBar(0, 100);
            SwingWorker<Void, Integer> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                    for (int progress = 0; progress <= 100; progress++) {
                        Thread.sleep(20); // Simulate some loading process
                        publish(progress); // Publish progress to update the bar
                    }
                    return null;
                }

                @Override
                protected void process(java.util.List<Integer> chunks) {
                    for (int progress : chunks) {
                        progressBar.setValue(progress);
                    }
                }

                @Override
                protected void done() {
                    loadingDialog.dispose();
                    showMainDialog();
                }
            };
            worker.execute();
        });
    }
    private static JDialog createLoadingDialog() {
        JDialog loadingDialog = new JDialog();
        loadingDialog.setTitle("Loading...");
        loadingDialog.setSize(200, 100);
        loadingDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        loadingDialog.setResizable(false);

        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setIndeterminate(true); // Use an indeterminate style

        loadingDialog.add(progressBar);
        loadingDialog.setLocationRelativeTo(null);

        return loadingDialog;
    }
    private static void showMainDialog() {
        final int DIALOGUE_WIDTH = 100;
        final int DIALOGUE_HEIGHT = 140;

        JDialog mainDialog = new JDialog();
        mainDialog.setSize(DIALOGUE_WIDTH, DIALOGUE_HEIGHT);
        mainDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        JButton openGameButton = new JButton("Play");
        JButton openEditorButton = new JButton("Level Editor");
        JButton closeButton = new JButton("Close");

        openGameButton.addActionListener(e -> {
            mainDialog.dispose();
            new GameFrame();
        });
        openEditorButton.addActionListener(e -> {
            mainDialog.dispose();
            new EditorFrame();
        });
        closeButton.addActionListener(e -> mainDialog.dispose());

        JPanel panel = new JPanel();
        panel.setLayout(null);


        openGameButton.setBounds(0, 10, 100, 30);
        openEditorButton.setBounds(0, 40, 100, 30);
        closeButton.setBounds(0, 70, 100, 30);

        panel.add(closeButton);
        panel.add(openGameButton);
        panel.add(openEditorButton);
        mainDialog.add(panel);

        mainDialog.setLocationRelativeTo(null);
        mainDialog.setResizable(false);
        mainDialog.setVisible(true);
    }
}