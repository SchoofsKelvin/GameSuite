package domain;

public class Omhullende {

	private Punt min, max;

	public Omhullende(Punt punt1, Punt punt2) {
		setPunten(punt1, punt2);
	}

	private void setPunten(Punt punt1, Punt punt2) {
		int x1 = punt1.getX(), x2 = punt2.getX();
		int y1 = punt1.getY(), y2 = punt2.getY();
		int minX = x1 < x2 ? x1 : x2;
		int minY = y1 < y2 ? y1 : y2;
		int maxX = x1 < x2 ? x2 : x1;
		int maxY = y1 < y2 ? y2 : y1;
		min = new Punt(minX, minY);
		max = new Punt(maxX, maxY);
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
}
