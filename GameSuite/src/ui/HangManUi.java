package ui;

import javax.swing.JFrame;

import db.WoordenLezer;
import domain.HangMan;
import domain.Speler;

public class HangManUi extends Spel {

	@SuppressWarnings("unused")
	private Speler				speler;

	public HangManUi(Speler speler) {
		super(speler);
		WoordenLezer lezer = new WoordenLezer("hangman.txt");
	}

	@Override
	public void start() {
		HangMan hangman = new HangMan(speler, woordenlijst);
	}

	public static String getSpelNaam() {
		return "Hangman";
	}
}
