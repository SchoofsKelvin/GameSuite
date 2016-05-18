package ui;

import javax.swing.JOptionPane;

import domain.Speler;
import domain.Vorm;

public class Launcher {

	public static void main(String[] args) {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		if(naam == null) System.exit(0);
		Speler speler = new Speler(naam);
		PictionaryUi ui = new PictionaryUi(speler);
		ui.start();
	}

}
