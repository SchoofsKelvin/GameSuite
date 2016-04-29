package ui;

import javax.swing.JOptionPane;

import domain.DomainException;

public class PictionaryUi {
	
	private void toonError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	private int vraagStraal() {
		while (true) {
			String straal = JOptionPane.showInputDialog("Straal?");
			if (straal == null) {
				throw new DomainException("Geanuleerd");
			}
			try {
				return Integer.parseUnsignedInt(straal);
			} catch (NumberFormatException e) {
				toonError("Geen geldig positief getal");
			}
		}
	}
}
