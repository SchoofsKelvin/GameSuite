package ui;

import javax.swing.JOptionPane;

public class PictionaryUi {
	
	private void toonError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	private int vraagStraal() {
		while (true) {
			String straal = JOptionPane.showInputDialog("Straal?");
			try {
				return Integer.parseUnsignedInt(straal);
			} catch (NumberFormatException e) {
				toonError("Geen geldig positief getal");
			}
		}
	}
}
