package domain;

public class Punt {

	private int	x;
	private int	y;

	public Punt(int x, int y) {
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	private void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	private void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Punt punt = (Punt) o;

		if (x != punt.x) return false;
		return y == punt.y;

	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}
