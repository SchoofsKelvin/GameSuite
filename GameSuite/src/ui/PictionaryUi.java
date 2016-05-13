package ui;

import javax.swing.JOptionPane;

import domain.Cirkel;
import domain.LijnStuk;
import domain.Punt;
import domain.Rechthoek;
import domain.Speler;
import domain.Vorm;

public class PictionaryUi {

	private Speler speler;

	public PictionaryUi(Speler speler) {
		this.speler = speler;
	}

	public void start() {

		Vorm vorm = null;
		try {
			boolean vormMade = false;
			while (!vormMade) {
				vorm = getVormByDialog();
				JOptionPane.showMessageDialog(null, vorm.toString());
				vormMade = true;
			}
		} catch (Exception e) {
			toonError(e.getClass() + ": " + e.getMessage());
		}

		JOptionPane.showMessageDialog(null, "... heeft als score " + speler.getScore());

	}

	public Vorm getVormByDialog() {

		Object[] shapes = { "Cirkel", "Rechthoek" };
		String vormKeuze = (String) JOptionPane.showInputDialog(null, "Wat wilt u tekenen", "input",
				JOptionPane.INFORMATION_MESSAGE, null, shapes, null);

		Vorm vorm = null;
		Punt punt = getPuntByDialog();

		switch (vormKeuze) {
		case "Rechthoek":
			int breedte = getIntegerUsingDialog("Breedte");
			int hoogte = getIntegerUsingDialog("Hoogte");
			vorm = new Rechthoek(punt, breedte, hoogte);
			break;
		case "Cirkel":
			int radius = getIntegerUsingDialog("Radius");
			vorm = new Cirkel(punt, radius);
			break;
		}
		return vorm;

	}

	public Punt getPuntByDialog() {
		int x = getIntegerUsingDialog("x coordinaat van het punt:");
		int y = getIntegerUsingDialog("y coordinaat van het punt:");
		Punt punt = new Punt(x, y);
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString());
		return punt;
	}

	private int getIntegerUsingDialog(String message) {
		while (true) {
			try {
				String input = JOptionPane.showInputDialog(message);

				if (input == null)
					throw new CancelledException();
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				toonError("Invalid number!");
			} catch (Exception e) {
				toonError("There was a problem!\n" + e.getClass() + ": " + e.getMessage());
			}
		}
	}

	private void toonError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void maakLijnStuk() {
		Punt startPunt = null;
		Punt eindPunt = null;
		JOptionPane.showMessageDialog(null, "Klik OK om een lijnStuk te maken");
		try {
			startPunt = new Punt(
					Integer.parseInt(JOptionPane.showInputDialog(null, "Geef de x waarde voor de startpunt:")),
					Integer.parseInt(JOptionPane.showInputDialog(null, "Geef de Y waarde van de startPunt:")));
		} catch (NumberFormatException e) {
			toonError("Invalid number");
		} catch (Exception e) {
			toonError("There was a problem \n" + e.getClass() + ": " + e.getMessage());
		}
		JOptionPane.showMessageDialog(null,
				"U hebt een StartPunt gemaakt met volgende coordinaten:" + startPunt.getX() + " en " + startPunt.getY());
		try {
			eindPunt = new Punt(
					Integer.parseInt(JOptionPane.showInputDialog(null, "Geef de x waarde voor de EindPunt:")),
					Integer.parseInt(JOptionPane.showInputDialog(null, "Geef de Y waarde van de EindPunt:")));
		} catch (NumberFormatException e) {
			toonError("invalid Number");
		} catch (Exception e) {
			toonError("There was a problem \n" + e.getClass() + ": " + e.getMessage());
		}
		JOptionPane.showMessageDialog(null,
				"U hebt een StartPunt gemaakt met volgende coordinaten:" + eindPunt.getX() + " en " + eindPunt.getY());
		JOptionPane.showMessageDialog(null, "U hebt de lijnstuk gemaakt met volgende coordinaten:\n" + "BeginPunt: "
				+ startPunt.toString() + "\n EindPunt: " + eindPunt.toString());
	}

}
