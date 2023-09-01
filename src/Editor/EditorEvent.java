package Editor;

import Levels.LevelsCollision;
import Swing.EditorPanel;

import static Levels.Levels.tc;

public class EditorEvent {
    EditorPanel editorPanel;
    public EditorEvent(EditorPanel editorPanel) {
        this.editorPanel = editorPanel;
    }
    public void actionPerformed() {
        tc.clear();
        LevelsCollision.addHitBox(tc);
        editorPanel.repaint();
    }
}