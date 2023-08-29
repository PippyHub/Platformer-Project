package Player;

import Swing.Panel;
public class Event {
    Player player;
    Panel panel;
    public Event(Panel panel) {
        this.player = panel.player;
        this.panel = panel;
    }
    public void actionPerformed() {
        player.move();
        panel.repaint();
    }
}
