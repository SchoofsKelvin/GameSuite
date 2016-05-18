package ui;

import java.awt.Graphics;

import javax.swing.JOptionPane;

import domain.Cirkel;
import domain.LijnStuk;
import domain.Punt;
import domain.Rechthoek;
import domain.Speler;
import domain.Vorm;

public class PictionaryUi implements Drawable {

	private Speler speler;

	public PictionaryUi(Speler speler) {
		this.speler = speler;
	}

	public void start() {

		Vorm vorm = getVormByDialog();
		JOptionPane.showMessageDialog(null, vorm.toString());

		LijnStuk lijnStuk = maakLijnStuk();
		JOptionPane.showMessageDialog(null, lijnStuk.toString());

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
