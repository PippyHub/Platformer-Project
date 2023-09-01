package levels.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static swing.GamePanel.GAME_PANEL_WIDTH;
import static swing.GamePanel.GAME_PANEL_HEIGHT;

public class LevelsReader {
    public static int[][] readCSV(String filePath) {
        int[][] levelData = new int[GAME_PANEL_HEIGHT][GAME_PANEL_WIDTH];
        for (int y = 0; y < GAME_PANEL_HEIGHT; y++) {
            for (int x = 0; x < GAME_PANEL_WIDTH; x++) {
                levelData[y][x] = -1;
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 3) {
                    int value = Integer.parseInt(values[0].trim());
                    int y = Integer.parseInt(values[1].trim());
                    int x = Integer.parseInt(values[2].trim());
                    levelData[y][x] = value;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return levelData;
    }
}