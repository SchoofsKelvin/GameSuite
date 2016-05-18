package domain;

import java.awt.Graphics;

import ui.Drawable;

public class LijnStuk extends Vorm implements Drawable {

	private Punt	startPunt;
	private Punt	eindPunt;

	public LijnStuk(Punt startPunt, Punt eindPunt) {
		setEindPunt(eindPunt);
		setStartPunt(startPunt);
	}

	public Punt getStartPunt() {
		return startPunt;
	}

	public void setStartPunt(Punt startPunt) {
		if (startPunt == null)
			throw new DomainException("Startpunt mag niet null zijn");
		this.startPunt = startPunt;
	}

	public Punt getEindPunt() {
		return eindPunt;
	}

	public void setEindPunt(Punt eindPunt) {
		if (eindPunt == null)
			throw new DomainException("Eindpunt mag niet null zijn");
		this.eindPunt = eindPunt;
	}

	@Override
	public boolean equals(Object object) {
		if (object != null) {
			if (object instanceof LijnStuk) {
				LijnStuk l = (LijnStuk) object;
				return this.getStartPunt().equals(l.getStartPunt())
						&& this.getEindPunt().equals(l.getEindPunt());
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Punt X:" + this.getStartPunt().toString() + "Punt Y:"
				+ this.getEindPunt().toString();
	}

	@Override
	public Omhullende getOmhullende() {
		return new Omhullende(startPunt, eindPunt);
	}

	@Override
	public void draw(Graphics paramGraphics) {
		// TODO Auto-generated method stub

	}

}
