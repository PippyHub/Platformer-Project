package editor;

import java.awt.event.MouseEvent;
import javax.swing.*;

import levels.Levels;
import levels.LevelsTiles;
import swing.EditorPanel;
import static editor.picker.PickerInput.pickedTile;
import static levels.Levels.*;
import static swing.EditorPanel.EDITOR_PANEL_HEIGHT;
import static swing.EditorPanel.EDITOR_PANEL_WIDTH;

public class EditorInput {
    public enum BrushType {
        DELETE_BRUSH, PAINT_BRUSH
    }
    static BrushType brushType = BrushType.PAINT_BRUSH;
    final Levels level;
    final EditorPanel editorPanel;
    public EditorInput(EditorPanel editorPanel) {
        this.level = editorPanel.level;
        this.editorPanel = editorPanel;
    }
    public void deleteBrush(MouseEvent e) {
        LevelsTiles t = Levels.getTile(e.getX(), e.getY());
        if (t != null) {
            level.currentLevel[t.tY][t.tX] = -1;
        }
    }
    public void paintBrush(MouseEvent e) {
        LevelsTiles t = Levels.getTile(e.getX(), e.getY());
        tc.remove(t);
        int x = (e.getX() / TILE_WIDTH ) * TILE_WIDTH;
        int y = (e.getY() / TILE_HEIGHT) * TILE_HEIGHT;
        if (x >= 0 && y >= 0 && x < EDITOR_PANEL_WIDTH  && y < EDITOR_PANEL_HEIGHT) {
            level.currentLevel[y][x] = pickedTile;
        }
    }
    public static void setBrushType(BrushType brushType) {
        EditorInput.brushType = brushType;
    }
    private boolean isMousePressed = false;
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            isMousePressed = true;
            handleBrushType(e);
        }
    }
    public void mouseReleased(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            isMousePressed = false;
        }
    }
    public void mouseDragged(MouseEvent e) {
        if (isMousePressed && SwingUtilities.isLeftMouseButton(e)) {
            handleBrushType(e);
        }
    }
    private void handleBrushType(MouseEvent e) {
        switch (brushType) {
            case DELETE_BRUSH -> deleteBrush(e);
            case PAINT_BRUSH -> paintBrush(e);
        }
    }
}

