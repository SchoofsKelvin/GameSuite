package ui;

import domain.Speler;

public abstract class Spel {
	
	public final Speler speler;

	public Spel(Speler speler) {
		this.speler = speler;
	}
	
	public abstract void start();
	
	public static String getSpelNaam;
}
