package ui;

import javax.swing.JOptionPane;

public class Launcher {

	// Dit is een test - Levi
	// Een andere test - Kelvin Schoofs

	public static void main(String[] args) {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);

		JOptionPane.showMessageDialog(null, "... zal binnekort spelen",
				speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
	}

}
