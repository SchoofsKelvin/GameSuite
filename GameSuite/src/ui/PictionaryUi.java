package ui;

import java.awt.Graphics;

import javax.swing.JOptionPane;

import domain.Cirkel;
import domain.LijnStuk;
import domain.Punt;
import domain.Rechthoek;
import domain.Speler;
import domain.Tekening;
import domain.Vorm;

public class PictionaryUi implements Drawable {

	private Speler		speler;
	private Tekening	tekening;

	public PictionaryUi(Speler speler) {
		this.speler = speler;
	}

	public void start() {
		tekening = getTekeningByDialog();

		boolean isRunning = true;
		while (isRunning) {
			int choice = getIntegerUsingDialog(
					"Wat wil je doen?\n\n1. Vorm maken\n2. Tekening tonen\n\n0. Stoppen");
			switch (choice) {
				case 0:
					isRunning = false;
					break;
				case 1:
					tekening.voegToe(getVormByDialog());
					break;
				case 2:
					toonTekening(tekening.getNaam(),tekening);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Geen juiste optie!");
			}
		}
		JOptionPane.showMessageDialog(null,
				"... heeft als score " + speler.getScore());
	}

	private Vorm getVormByDialog() {
		while (true) {
			try {
				Object[] shapes = { "Cirkel", "Rechthoek" };
				String vormKeuze = (String) JOptionPane.showInputDialog(null,
						"Wat wilt u tekenen", "input",
						JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
				if (vormKeuze == null) {
					continue;
				}

				Punt punt = getPuntByDialog("punt");

				switch (vormKeuze.toLowerCase()) {
					case "rechthoek":
						int breedte = getIntegerUsingDialog("Breedte");
						int hoogte = getIntegerUsingDialog("Hoogte");
						return new Rechthoek(punt, breedte, hoogte);
					case "cirkel":
						int radius = getIntegerUsingDialog("Radius");
						return new Cirkel(punt, radius);
				}
			} catch (Exception e) {
				toonError(e.getClass() + ": " + e.getMessage());
			}
		}

	}

	private Tekening getTekeningByDialog() {
		return new Tekening(getStringUsingDialog("Geef je tekening een naam:"));
	}

	private String getStringUsingDialog(String message) {
		while (true) {
			String input = JOptionPane.showInputDialog(null, message);
			if (input != null && !input.trim().isEmpty()) return input;
			JOptionPane.showMessageDialog(null, "Graag iets invullen, ok?");
		}
	}

	private Punt getPuntByDialog(String puntNaam) {
		int x = getIntegerUsingDialog("x coordinaat van het " + puntNaam + ":");
		int y = getIntegerUsingDialog("y coordinaat van het " + puntNaam + ":");
		Punt punt = new Punt(x, y);
		JOptionPane.showMessageDialog(null,
				"U heeft een " + puntNaam + " aangemaakt: " + punt.toString());
		return punt;
	}

	private int getIntegerUsingDialog(String message) {
		while (true) {
			try {
				String input = JOptionPane.showInputDialog(message);
				if (input == null) throw new CancelledException();
				return Integer.parseInt(input);
			} catch (Exception e) {
				toonError(e.getClass() + ": " + e.getMessage());
			}
		}
	}

	private void toonError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error",
				JOptionPane.ERROR_MESSAGE);
	}

	public void toonTekening(String naam, Tekening tekening) {
		//JOptionPane.showMessageDialog(null, tekening.toString());
		GameMainWindow window = new GameMainWindow("Pictionary", tekening);
		window.setVisible(true);
		window.teken();
	}

	@SuppressWarnings("unused")
	private LijnStuk maakLijnStuk() {
		Punt startPunt = getPuntByDialog("startpunt");
		Punt eindPunt = getPuntByDialog("eindpunt");
		LijnStuk lijnStuk = new LijnStuk(startPunt, eindPunt);
		return lijnStuk;
	}

	@Override
	public void draw(Graphics paramGraphics) {
		// TODO Auto-generated method stub

	}

}
