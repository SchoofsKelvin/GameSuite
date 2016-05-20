package ui;

import javax.swing.JOptionPane;

import domain.Speler;

public class Launcher {

	public static void main(String[] args) throws Exception {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		if (naam == null) {
			System.exit(0);
		}
		Speler speler = new Speler(naam);
		/*
		 * PictionaryUi ui = new PictionaryUi(speler); ui.start(); Tekening
		 * tekening = new Tekening("Test"); tekening.voegToe(new Rechthoek(new
		 * Punt(10, 10), 70, 50)); tekening.voegToe(new Cirkel(new Punt(200,
		 * 150), 100)); tekening.voegToe(new Driehoek(new Punt(5, 10), new
		 * Punt(100, 150), new Punt(300, 50))); tekening.voegToe(new
		 * LijnStuk(new Punt(100, 200), new Punt(200, 300))); GameMainWindow
		 * window = new GameMainWindow("Pictionary", tekening);
		 * window.setVisible(true); window.teken();
		 */
		Class<? extends Spel> spel = getSpel();
		spel.getConstructor(Speler.class).newInstance(speler).start();
	}

	@SuppressWarnings("unchecked")
	private static Class<? extends Spel> getSpel() throws Exception {
		Class[] games = { PictionaryUi.class, HangManUi.class };
		String[] names = new String[games.length];
		for (int i = 0; i < games.length; i++) {
			names[i] = (String) games[i].getMethod("getSpelNaam").invoke(null);
		}
		String spel = (String) JOptionPane.showInputDialog(null,
				"Welk spel wil je spelen?", "input",
				JOptionPane.INFORMATION_MESSAGE, null, names, null);
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(spel)) return games[i];
		}
		return null;
	}
}
