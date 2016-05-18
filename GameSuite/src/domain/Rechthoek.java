package domain;

import java.awt.Graphics;

import ui.Drawable;

public class Rechthoek extends Vorm implements Drawable {

	private Punt	linkerBovenhoek;
	private int		breedte;
	private int		hoogte;

	public Rechthoek(Punt linkerBovenhoek, int breedte, int hoogte) {
		setLinkerBovenhoek(linkerBovenhoek);
		setBreedte(breedte);
		setHoogte(hoogte);
	}

	public Punt getLinkerBovenhoek() {
		return linkerBovenhoek;
	}

	private void setLinkerBovenhoek(Punt linkerBovenhoek) {
		if (linkerBovenhoek == null) throw new DomainException();
		this.linkerBovenhoek = linkerBovenhoek;
	}

	public int getBreedte() {
		return breedte;
	}

	private void setBreedte(int breedte) {
		if (breedte <= 0) throw new DomainException();
		this.breedte = breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	private void setHoogte(int hoogte) {
		if (hoogte <= 0) throw new DomainException();
		this.hoogte = hoogte;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Rechthoek rechthoek = (Rechthoek) o;

		if (breedte != rechthoek.breedte) return false;
		if (hoogte != rechthoek.hoogte) return false;
		return linkerBovenhoek.equals(rechthoek.linkerBovenhoek);

	}

	@Override
	public int hashCode() {
		int result = linkerBovenhoek.hashCode();
		result = 31 * result + breedte;
		result = 31 * result + hoogte;
		return result;
	}

	@Override
	public String toString() {
		return "Rechthoek: linkerBovenhoek: " + linkerBovenhoek.toString()
				+ " - breedte: " + breedte + " - hoogte: " + hoogte;
	}

	@Override
	public Omhullende getOmhullende() {
		return new Omhullende(linkerBovenhoek, breedte, hoogte);
	}

	@Override
	public void draw(Graphics paramGraphics) {
		// TODO Auto-generated method stub

	}

}
