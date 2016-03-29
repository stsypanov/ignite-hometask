package tsypanov;

import java.util.*;

public class Game {

    private int tilesCount;

    private List<DominoTile> bestSequence = new ArrayList<>();
    private LinkedList<DominoTile> currentSequence;
    private List<DominoTile> randomItems;

    public Game(int tilesCount) {
        this.tilesCount = tilesCount;
    }

    public void go() {
        List<DominoTile> dominoTiles = createDominoTiles();

        randomItems = getRandomItems(dominoTiles);
//        randomItems = getMockItems();

        System.out.println("Initial tiles: ");
        printSequence(randomItems);

        findLongestPossibleSequence(randomItems);

        printResult();
    }

    private void findLongestPossibleSequence(List<DominoTile> dominoTiles) {

        for (DominoTile dominoTile : dominoTiles) {

            dominoTile.setUsed(true);
            initCurrentSequence(dominoTile);

            putNext(dominoTile.getLeft(), dominoTile.getRight());

            checkResultAndStoreIfNecessary();

            dominoTile.setUsed(false);
        }
    }

    private void putNext(int left, int right) {

        for (DominoTile tile : randomItems) {
            if (tile.notUsed()) {
                tile.setUsed(true);

                if (left == tile.getLeft()) {
                    if (!currentSequence.contains(tile)) {
                        currentSequence.addFirst(tile);
                    }
                    int _left = tile.getRight();
                    int _right = right;
                    putNext(_left, _right);
                }
                else if (right == tile.getLeft()) {
                    if (!currentSequence.contains(tile)) {
                        currentSequence.add(tile);
                    }
                    int _right = tile.getRight();
                    int _left = left;
                    putNext(_left, _right);
                }
                else if (left == tile.getRight()) {
                    if (!currentSequence.contains(tile)) {
                        currentSequence.addFirst(tile);
                    }
                    int _left = tile.getLeft();
                    int _right = right;
                    putNext(_left, _right);
                }
                else if (right == tile.getRight()) {
                    if (!currentSequence.contains(tile)) {
                        currentSequence.add(tile);
                    }
                    int _right = tile.getLeft();
                    int _left = left;
                    putNext(_left, _right);
                }

                if (!currentSequence.contains(tile)) {
                    tile.setUsed(false);
                } else {
                    tile.setUsed(true);
                }
            }
        }
    }


    private void checkResultAndStoreIfNecessary() {
        if (currentSequence.size() > bestSequence.size()) {
            bestSequence.clear();
            bestSequence.addAll(currentSequence);
        }
        currentSequence.clear();
    }

    private void initCurrentSequence(DominoTile dominoTile) {
        if (currentSequence == null) currentSequence = new LinkedList<>();
        currentSequence.add(dominoTile);
    }

    private List<DominoTile> getRandomItems(List<DominoTile> dominoTiles) {
        Collections.shuffle(dominoTiles);

        Random random = new Random(System.currentTimeMillis());
        List<DominoTile> randomTiles = new ArrayList<>(tilesCount);

        for (int i = 0; i < tilesCount; i++) {
            final int randomIndex = random.nextInt(dominoTiles.size() - 1);
            DominoTile remove = dominoTiles.remove(randomIndex);
            randomTiles.add(remove);
        }

        return randomTiles;
    }

    private List<DominoTile> createDominoTiles() {
        List<DominoTile> dominoTiles = Arrays.asList(
                new DominoTile(0, 0), new DominoTile(0, 1), new DominoTile(0, 2), new DominoTile(0, 3), new DominoTile(0, 4),
                new DominoTile(0, 5), new DominoTile(0, 6),

                new DominoTile(1, 1), new DominoTile(1, 2), new DominoTile(1, 3), new DominoTile(1, 4), new DominoTile(1, 5),
                new DominoTile(1, 6), new DominoTile(2, 2),

                new DominoTile(2, 3), new DominoTile(2, 4), new DominoTile(2, 5), new DominoTile(2, 6), new DominoTile(3, 3),
                new DominoTile(3, 4), new DominoTile(3, 5),

                new DominoTile(3, 6), new DominoTile(4, 4), new DominoTile(4, 5), new DominoTile(4, 6), new DominoTile(5, 5),
                new DominoTile(5, 6), new DominoTile(6, 6)
        );
        return new ArrayList<>(dominoTiles);
    }

    private void printResult() {
        System.out.println("Possible sequences starting from the longest: ");
        printSequence(bestSequence);
    }

    private void printSequence(List<DominoTile> randomItems) {
        randomItems.forEach(System.out::print);
        System.out.println();
    }

    private List<DominoTile> getMockItems() {
        List<DominoTile> tiles = Arrays.asList(new DominoTile(0, 1), new DominoTile(3, 6), new DominoTile(3, 5),
                new DominoTile(0, 3), new DominoTile(0, 5), new DominoTile(5, 5));
        return new ArrayList<>(tiles);
    }

}
