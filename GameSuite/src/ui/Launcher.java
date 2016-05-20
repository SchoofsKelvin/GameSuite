package ui;

import javax.swing.JOptionPane;

import db.WoordenLezer;
import domain.Speler;

public class Launcher {

	public static void main(String[] args) throws Exception {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		
		WoordenLezer lezer = new WoordenLezer("hangman.txt");

		if (naam == null) {
			System.exit(0);
		}
		Speler speler = new Speler(naam);
		Class<? extends Spel> spel = getSpel();
		spel.getConstructor(Speler.class).newInstance(speler).start();
	}

	@SuppressWarnings("unchecked")
	private static Class<? extends Spel> getSpel() throws Exception {
		@SuppressWarnings("rawtypes")
		Class[] games = { PictionaryUi.class, HangManUi.class };
		String[] names = new String[games.length];
		for (int i = 0; i < games.length; i++) {
			names[i] = (String) games[i].getMethod("getSpelNaam").invoke(null);
		}
		String spel = (String) JOptionPane.showInputDialog(null,
				"Welk spel wil je spelen?", "input",
				JOptionPane.INFORMATION_MESSAGE, null, names, null);
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(spel))
				return games[i];
		}
		return null;
	}
}
