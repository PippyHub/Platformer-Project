package Levels.csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LevelsWriter {
    public static void writeCSV(String filePath, int[][] levelData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int y = 0; y < levelData.length; y++) {
                for (int x = 0; x < levelData[y].length; x++) {
                    int value = levelData[y][x];
                    if (value != -1) {
                        writer.write(value + ", " + y + ", " + x);
                        writer.newLine();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
