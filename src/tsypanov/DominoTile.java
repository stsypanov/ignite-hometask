package tsypanov;

public class DominoTile {
	private int left;
	private int right;
	private boolean used;

	public DominoTile(int left, int right) {
		this.left = left;
		this.right = right;
	}

	public int getLeft() {
		return left;
	}

	public int getRight() {
		return right;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public boolean notUsed() {
		return !used;
	}

	public void flip() {
		int temp = left;
		left = right;
		right = temp;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DominoTile that = (DominoTile) o;

		return left == that.left && right == that.right;

	}

	@Override
	public int hashCode() {
		int result = left;
		result = 31 * result + right;
		return result;
	}

	@Override
	public String toString() {
		return "[" + left + ' ' + right + ']';
	}
}
