package ui;

import java.awt.Graphics;

import javax.swing.JOptionPane;

import domain.*;

public class PictionaryUi implements Drawable {

	private Speler speler;
	private Tekening tekening;

	public PictionaryUi(Speler speler) {
		this.speler = speler;
	}

	public void start() {

		tekening = getTekeningByDialog();

		boolean isRunning = true;
		while (isRunning) {
			int choice = getIntegerUsingDialog("Wat wil je doen?\n\n1. Vorm maken\n2. Tekening tonen\n\n0. Stoppen");
			switch (choice) {
				case 0:
					isRunning = false;
					break;
				case 1:
					tekening.voegToe(getVormByDialog());
					break;
				case 2:
					toonTekening();
					break;
				default:
					JOptionPane.showMessageDialog(null, "Geen juiste optie!");
			}
		}

		JOptionPane.showMessageDialog(null, "... heeft als score " + speler.getScore());

	}

	private Vorm getVormByDialog() {

		while(true) {
			try {

				Object[] shapes = {"Cirkel", "Rechthoek"};
				String vormKeuze = (String) JOptionPane.showInputDialog(null, "Wat wilt u tekenen", "input",
						JOptionPane.INFORMATION_MESSAGE, null, shapes, null);

				Vorm vorm = null;
				Punt punt = getPuntByDialog("punt");

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

			} catch (Exception e) {
				toonError(e.getClass() + ": " + e.getMessage());
			}
		}

	}

	private Tekening getTekeningByDialog() {
		return new Tekening(getStringUsingDialog("Geef je tekening een naam:"));
	}

	private String getStringUsingDialog(String message) {
		String input = null;
		while(true) {
			input = JOptionPane.showInputDialog(null, message);
			if(input != null) {
				return input;
			} else {
				JOptionPane.showMessageDialog(null, "Enter a valid string!");
			}
		}
	}

	private Punt getPuntByDialog(String puntNaam) {
		int x = getIntegerUsingDialog("x coordinaat van het " + puntNaam + ":");
		int y = getIntegerUsingDialog("y coordinaat van het " + puntNaam + ":");
		Punt punt = new Punt(x, y);
		JOptionPane.showMessageDialog(null, "U heeft een " + puntNaam + " aangemaakt: " + punt.toString());
		return punt;
	}

	private int getIntegerUsingDialog(String message) {
		while (true) {
			try {
				String input = JOptionPane.showInputDialog(message);
				if (input == null) throw new CancelledException(); //Throwing an exception within a try/catch?
				return Integer.parseInt(input);
			} catch (Exception e) {
				toonError(e.getClass() + ": " + e.getMessage());
			}
		}
	}

	private void toonError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	private void toonTekening() {
		JOptionPane.showMessageDialog(null, tekening.toString());
	}

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
