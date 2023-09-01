package Editor;

import java.awt.event.MouseEvent;
import javax.swing.*;

import Levels.Levels;
import Levels.LevelsTiles;
import Swing.EditorPanel;

public class EditorInput {
    public enum BrushType {
        SELECT_BRUSH, DELETE_BRUSH, PAINT_BRUSH
    }
    static BrushType brushType = BrushType.SELECT_BRUSH;
    Levels levels;
    EditorPanel editorPanel;
    public EditorInput(EditorPanel editorPanel) {
        this.levels = editorPanel.levels;
        this.editorPanel = editorPanel;
    }
    public void deleteBrush(MouseEvent e) {
        LevelsTiles t = Levels.getTile(e.getX(), e.getY());
        if (t != null) {
            levels.currentLevel[t.tY][t.tX] = -1;
        }
    }
    public void paintBrush() {

    }
    public static void setBrushType(BrushType brushType) {
        EditorInput.brushType = brushType;
    }
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            switch (brushType) {
                case DELETE_BRUSH -> deleteBrush(e);
                case PAINT_BRUSH -> paintBrush();
            }
        }
    }
}

