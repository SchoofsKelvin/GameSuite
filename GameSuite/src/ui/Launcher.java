package ui;

import javax.swing.JOptionPane;

import domain.*;

public class Launcher {

	public static void main(String[] args) {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);
		PictionaryUi ui = new PictionaryUi(speler);

		ui.getVormByDialog(); //Demo

		JOptionPane.showMessageDialog(null,
				"... heeft als score " + speler.getScore());
	}

}
