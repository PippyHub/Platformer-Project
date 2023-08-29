package Terrain;

import java.util.LinkedList;
public class Tile {
    LinkedList<Tile> tc;
    public int tX;
    public int tY;
    public Tile(int tX, int tY, LinkedList<Tile> tc) {
        this.tX = tX;
        this.tY = tY;
        this.tc = tc;
        tc.add(this);
    }
}
