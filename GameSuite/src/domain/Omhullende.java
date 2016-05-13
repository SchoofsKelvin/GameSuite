package domain;

public class Omhullende {

	private Punt min, max;

	public Omhullende(Punt punt1, Punt punt2) {
		setPunten(punt1, punt2);
	}

	public Omhullende(Punt punt1, int breedte, int hoogte) {
		setPunten(punt1,
				new Punt(punt1.getX() + breedte, punt1.getY() + hoogte));
	}

	private void setPunten(Punt punt1, Punt punt2) {
		min = getMinimumPunt(punt1, punt2);
		max = getMaximumPunt(punt1, punt2);
	}

	public int getMinimumX() {
		return min.getX();
	}

	public int getMinimumY() {
		return min.getY();
	}

	public int getMaximumX() {
		return max.getX();
	}

	public int getMaximumY() {
		return max.getY();
	}

	private static Punt getMinimumPunt(Punt... punten) {
		Punt eerste = punten[0];
		int minX = eerste.getX(), minY = eerste.getY();
		for (Punt punt : punten) {
			int x = punt.getX(), y = punt.getY();
			minX = x < minX ? x : minX;
			minY = y < minY ? y : minY;
		}
		return new Punt(minX, minY);
	}

	private static Punt getMaximumPunt(Punt... punten) {
		Punt eerste = punten[0];
		int maxX = eerste.getX(), maxY = eerste.getY();
		for (Punt punt : punten) {
			int x = punt.getX(), y = punt.getY();
			maxX = x > maxX ? x : maxX;
			maxY = y > maxY ? y : maxY;
		}
		return new Punt(maxX, maxY);
	}

	public static Omhullende vanPunten(Punt... punten) {
		return new Omhullende(getMinimumPunt(punten), getMaximumPunt(punten));
	}
}
