package tsypanov;

import java.util.LinkedList;

public class DominoSequence {

    private int left;
    private int right;

    private LinkedList<DominoTile> tiles = new LinkedList<>();

    public DominoSequence() {
    }

    public void add(DominoTile tile) {
        if (tiles.size() == 0) {
            left = tile.getLeft();
            right = tile.getRight();
        }
        tiles.addLast(tile);
    }

    public void addFirst(DominoTile tile) {
        tiles.addFirst(tile);
    }

    public LinkedList<DominoTile> getTiles() {
        return tiles;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public void clear() {
        tiles.clear();
    }

    public boolean contains(DominoTile tile) {
        return tiles.contains(tile);
    }

    public int size() {
        return tiles.size();
    }
}
