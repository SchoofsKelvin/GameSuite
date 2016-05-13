package ui;

import javax.swing.JOptionPane;

import domain.Speler;
import domain.Vorm;

public class Launcher {

	public static void main(String[] args) {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);
		PictionaryUi ui = new PictionaryUi(speler);

		Vorm vorm = ui.getVormByDialog();
		JOptionPane.showMessageDialog(null, vorm.toString());
		//TODO: try/catch
		
		JOptionPane.showMessageDialog(null,
				"... heeft als score " + speler.getScore());
	}
	
	

}
