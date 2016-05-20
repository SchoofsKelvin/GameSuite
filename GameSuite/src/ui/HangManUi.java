package ui;

import domain.Speler;

public class HangManUi extends Spel {

	@SuppressWarnings("unused")
	private Speler				speler;

	public HangManUi(Speler speler) {
		super(speler);
	}

	@Override
	public void start() {

	}

	public static String getSpelNaam() {
		return "Hangman";
	}
}
