package ui;

import db.WoordenLezer;
import domain.HangMan;
import domain.Speler;
import domain.WoordenLijst;

public class HangManUi extends Spel {

	private WoordenLijst lijst;

	public HangManUi(Speler speler) {
		super(speler);
		lijst = new WoordenLijst();
		WoordenLezer lezer = new WoordenLezer("hangman.txt");
		lijst = lezer.lees();
	}

	@Override
	public void start() {
		HangMan spel = new HangMan(speler, lijst);
		HangmanPaneel paneel = new HangmanPaneel(spel);
		HangManHoofdScherm scherm = new HangManHoofdScherm(spel, paneel);
		scherm.start();
	}

	public static String getSpelNaam() {
		return "Hangman";
	}
}
