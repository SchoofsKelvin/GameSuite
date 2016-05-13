package ui;

import javax.swing.JOptionPane;

import domain.Punt;
import domain.Speler;

public class PictionaryUi {

	private Speler speler;

	public PictionaryUi(Speler speler) {
		this.speler = speler;
	}

	public void showMenu() throws CancelledException {
		int x = getIntegerUsingDialog("x coordinaat van het punt:");
		int y = getIntegerUsingDialog("y coordinaat van het punt:");
		Punt punt = new Punt(x, y);
		JOptionPane.showMessageDialog(null,
				"U heeft een correct punt aangemaakt: " + punt.toString());
	}

	private int getIntegerUsingDialog(String message)
			throws CancelledException {
		while (true) {
			try {
				String input = JOptionPane.showInputDialog(message);
				if (input == null) throw new CancelledException();
				return Integer.parseUnsignedInt(input);
			} catch (NumberFormatException e) {
				toonError("Invalid number!");
			} catch (Exception e) {
				toonError("There was a problem!\n" + e.getClass() + ": "
						+ e.getMessage());
			}
		}
	}

	private void toonError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error",
				JOptionPane.ERROR_MESSAGE);
	}

	private int vraagStraal() throws CancelledException {
		while (true) {
			String straal = JOptionPane.showInputDialog("Straal?");
			if (straal == null) throw new CancelledException();
			try {
				return Integer.parseUnsignedInt(straal);
			} catch (NumberFormatException e) {
				toonError("Geen geldig positief getal");
			}
		}
	}

}
