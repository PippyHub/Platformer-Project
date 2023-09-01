package Levels;

import java.util.LinkedList;

public class LevelsTiles {
    LinkedList<LevelsTiles> tc;
    public int tX;
    public int tY;
    public LevelsTiles(int tX, int tY, LinkedList<LevelsTiles> tc) {
        this.tX = tX;
        this.tY = tY;
        this.tc = tc;
        tc.add(this);
    }
}
