package Editor;

import Swing.EditorPanel;

public class EditorEvent {
    EditorPanel editorPanel;
    public EditorEvent(EditorPanel editorPanel) {
        this.editorPanel = editorPanel;
    }
    public void actionPerformed() {
        editorPanel.repaint();
    }
}