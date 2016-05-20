package ui;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JOptionPane;

import domain.Punt;
import domain.Rechthoek;
import domain.Speler;
import domain.Tekening;

public class Launcher {

	public static void main(String[] args) throws Exception {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		if (naam == null) {
			System.exit(0);
		}
		Speler speler = new Speler(naam);
		/*PictionaryUi ui = new PictionaryUi(speler);
		ui.start();
		Tekening tekening = new Tekening("Test");
		tekening.voegToe(new Rechthoek(new Punt(10, 10), 70, 50));
		GameMainWindow window = new GameMainWindow(
				"Pictionary", new Tekening("Test"));
		window.setVisible(true);
		window.teken();*/
		Class<? extends Spel> spel = getSpel();
		spel.getConstructor(Speler.class).newInstance(speler).start();
	}

	@SuppressWarnings("unchecked")
	private static Class<? extends Spel> getSpel() throws Exception {
		Class[] games = { PictionaryUi.class, HangManUi.class };
		String[] names = new String[games.length];
		for (int i=0; i<games.length; i++) {
			names[i] = (String) games[i].getMethod("getSpelNaam").invoke(null);
		}
		String spel = (String) JOptionPane.showInputDialog(null,
				"Welk spel wil je spelen?", "input",
				JOptionPane.INFORMATION_MESSAGE, null, names, null);
		for (int i=0; i<names.length; i++) {
			if (names[i].equals(spel)) {
				return games[i];
			}
		}
		return null;
	}

}
