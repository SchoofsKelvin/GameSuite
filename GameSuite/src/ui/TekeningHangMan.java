package ui;

import java.util.ArrayList;

import domain.Cirkel;
import domain.LijnStuk;
import domain.Punt;
import domain.Rechthoek;
import domain.Tekening;
import domain.Vorm;

public class TekeningHangMan extends Tekening {

	private final ArrayList<Vorm> vormen = new ArrayList<>();

	public TekeningHangMan() {
		super("HangMan");
		vormen.add(new Rechthoek(new Punt(10, 350), 300, 40));
		vormen.add(new LijnStuk(new Punt(160, 350), new Punt(160, 50)));
		vormen.add(new LijnStuk(new Punt(160, 50), new Punt(280, 50)));
		vormen.add(new LijnStuk(new Punt(280, 50), new Punt(280, 100)));
		vormen.add(new Cirkel(new Punt(280, 125), 25));// zichtbaar na 1 fout
		vormen.add(new Cirkel(new Punt(270, 118), 2));
		vormen.add(new Cirkel(new Punt(290, 118), 2));// …
		vormen.add(new Cirkel(new Punt(280, 128), 2));
		vormen.add(new LijnStuk(new Punt(270, 138), new Punt(290, 138)));
		vormen.add(new LijnStuk(new Punt(280, 150), new Punt(280, 250)));
		vormen.add(new LijnStuk(new Punt(280, 250), new Punt(240, 310)));
		vormen.add(new LijnStuk(new Punt(280, 250), new Punt(320, 310)));
		vormen.add(new Cirkel(new Punt(240, 310), 5));
		vormen.add(new Cirkel(new Punt(320, 310), 5));
		vormen.add(new LijnStuk(new Punt(280, 200), new Punt(230, 170)));
		vormen.add(new LijnStuk(new Punt(280, 200), new Punt(330, 170)));
		vormen.add(new Cirkel(new Punt(230, 170), 5));
		vormen.add(new Cirkel(new Punt(330, 170), 5));
		for (Vorm vorm : vormen) {
			super.voegToe(vorm);
		}
		reset();
	}

	public void reset() {
		for (int i = 0; i < vormen.size(); i++) {
			vormen.get(i).setZichtbaar(i < 4);
		}
	}

	public int getAantalOntzichtbaar() {
		int res = 0;
		for (Vorm vorm : vormen) {
			if (!vorm.isZichtbaar()) {
				res++;
			}
		}
		return res;
	}

	public void zetVolgendeZichtbaar() {
		for (Vorm vorm : vormen) {
			if (!vorm.isZichtbaar()) {
				vorm.setZichtbaar(true);
				return;
			}
		}
		throw new IllegalStateException("Er kan geen vorm meer zichtbaar gemaakt worden");
	}

	@Override
	public boolean verwijder(Vorm vorm) {
		throw new IllegalStateException("Kan geen vorm aan TekeningHangMan toevoegen");
	}

	@Override
	public void voegToe(Vorm vorm) {
		throw new IllegalStateException("Kan geen vorm van TekeningHangMan verwijderen");
	}

}
