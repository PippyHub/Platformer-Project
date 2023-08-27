package Player;

import Swing.Panel;
public class Event {
    Panel panel;
    Player player;
    public Event(Panel panel) {
        this.panel = panel;
        this.player = panel.player;
    }
    public void actionPerformed() {
        player.move();
        panel.repaint();
    }
}
