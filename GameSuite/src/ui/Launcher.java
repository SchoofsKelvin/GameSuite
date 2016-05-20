package ui;

import javax.swing.JOptionPane;

import domain.Punt;
import domain.Rechthoek;
import domain.Speler;
import domain.Tekening;

public class Launcher {

	public static void main(String[] args) {
//		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
//		if (naam == null) {
//			System.exit(0);
//		}
//		Speler speler = new Speler(naam);
//		PictionaryUi ui = new PictionaryUi(speler);
//		ui.start();
        Tekening tekening = new Tekening("Test");
        tekening.voegToe(new Rechthoek(new Punt(10, 10), 70, 50));
        GameMainWindow window = new GameMainWindow("Pictionary", new Tekening("Test"));
        window.setVisible(true);
		window.teken();
	}

}
