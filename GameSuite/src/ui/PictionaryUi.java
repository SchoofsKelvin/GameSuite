package ui;

import java.awt.JobAttributes;

import javax.swing.JOptionPane;

import domain.DomainException;
import domain.LijnStuk;
import domain.Punt;
import domain.Speler;
import domain.*;

public class PictionaryUi {

	private Speler speler;

	public PictionaryUi(Speler speler) {
		this.speler = speler;
	}

	public Vorm getVormByDialog() {

		Object[] shapes = {"Cirkel", "Rechthoek"};
		String vormKeuze = (String) JOptionPane.showInputDialog(null, "Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);

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
	}

	private int getIntegerUsingDialog(String message) throws CancelledException {
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

	private LijnStuk maakLijnStuk() {
		Punt startPunt = null;
		Punt eindPunt = null;
		try {
			startPunt = new Punt(
					Integer.parseInt(JOptionPane.showInputDialog(null, "Geef de x waarde voor de startpunt:")),
					Integer.parseInt(JOptionPane.showInputDialog(null, "Geef de Y waarde van de startPunt:")));
			eindPunt = new Punt(
					Integer.parseInt(JOptionPane.showInputDialog(null, "Geef de x waarde voor de startpunt:")),
					Integer.parseInt(JOptionPane.showInputDialog(null, "Geef de Y waarde van de startPunt:")));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Er is iets fout gelopen Opnieuw proberen");
		}
		LijnStuk l = new LijnStuk(startPunt, eindPunt);
		return l;
	}

}
