package levels;

import java.util.LinkedList;

public class LevelsTiles {
    final LinkedList<LevelsTiles> tc;
    public final int tX;
    public final int tY;
    public LevelsTiles(int tX, int tY, LinkedList<LevelsTiles> tc) {
        this.tX = tX;
        this.tY = tY;
        this.tc = tc;
        tc.add(this);
    }
}
