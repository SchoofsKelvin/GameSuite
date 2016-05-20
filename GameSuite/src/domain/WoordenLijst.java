package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WoordenLijst {

	private List<String> woorden;
	
	public WoordenLijst() {
		woorden = new ArrayList();
	}

	public int getAantalWoorden() {
		return woorden.size();
	}
	
	public void voegToe(String woord) {
		if (woord == null || woord.equals("") || woorden.contains(woord)) {
			throw new DomainException("Geef een geldig woord op");
		}
		woorden.add(woord);
	}
	
	public String getRandomWoord() {
		Random randomGenerator = new Random();
		int randomIndex = randomGenerator.nextInt(woorden.size());
		return woorden.get(randomIndex);
	}
}
