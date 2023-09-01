package editor;

import swing.EditorPanel;

import static levels.Levels.tc;

public class EditorEvent {
    final EditorPanel editorPanel;
    public EditorEvent(EditorPanel editorPanel) {
        this.editorPanel = editorPanel;
    }
    public void actionPerformed() {
        tc.clear();
        editorPanel.level.levelsCollision.addHitBox(tc);
        editorPanel.repaint();
    }
}