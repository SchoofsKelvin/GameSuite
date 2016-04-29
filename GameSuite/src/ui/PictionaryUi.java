package ui;

import javax.swing.JOptionPane;

public class PictionaryUi {
	
	private void toonError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	private int vraagStraal() throws CancelledException {
		while (true) {
			String straal = JOptionPane.showInputDialog("Straal?");
			if (straal == null) {
				throw new CancelledException();
			}
			try {
				return Integer.parseUnsignedInt(straal);
			} catch (NumberFormatException e) {
				toonError("Geen geldig positief getal");
			}
		}
	}
}
