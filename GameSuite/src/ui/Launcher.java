package ui;

import domain.Cirkel;
import domain.Driehoek;
import domain.LijnStuk;
import domain.Punt;
import domain.Rechthoek;
import domain.Tekening;

public class Launcher {

	public static void main(String[] args) {
		// String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		// if (naam == null) {
		// System.exit(0);
		// }
		// Speler speler = new Speler(naam);
		// PictionaryUi ui = new PictionaryUi(speler);
		// ui.start();
		Tekening tekening = new Tekening("Test");
		tekening.voegToe(new Rechthoek(new Punt(10, 10), 70, 50));
		tekening.voegToe(new Cirkel(new Punt(200, 150), 100));
		tekening.voegToe(new Driehoek(new Punt(5, 10), new Punt(100, 150), new Punt(300, 50)));
		tekening.voegToe(new LijnStuk(new Punt(100, 200), new Punt(200, 300)));
		GameMainWindow window = new GameMainWindow("Pictionary", tekening);
		window.setVisible(true);
		window.teken();
	}
}
