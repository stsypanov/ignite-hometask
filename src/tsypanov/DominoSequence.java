package tsypanov;

public class DominoSequence {

    private Item first;

    public DominoSequence() {
    }

    public void add(DominoTile tile) {
        if (first == null) {
            first = new Item();
            first.setNext(tile);
        }
    }


    private static class Item {
        private DominoTile next;
        private DominoTile previous;

        public DominoTile getNext() {
            return next;
        }

        public void setNext(DominoTile next) {
            this.next = next;
        }

        public DominoTile getPrevious() {
            return previous;
        }

        public void setPrevious(DominoTile previous) {
            this.previous = previous;
        }
    }
}
