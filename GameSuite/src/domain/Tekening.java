package domain;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import ui.Drawable;

public class Tekening implements Drawable {
	private String				naam;
	private final static int	MIN_X	= 0;
	private final static int	MIN_Y	= 0;
	private final static int	MAX_X	= 399;
	private final static int	MAX_Y	= 399;
	private List<Vorm>			vormen	= new ArrayList<>();

	public Tekening(String naam) {
		if (naam == null || naam.trim().isEmpty())
			throw new DomainException("Geldige naam verwacht");
		this.naam = naam;
	}

	public String getNaam() {
		return naam;
	}

	public void voegToe(Vorm vorm) {
		if (vorm == null) throw new DomainException("Vorm mag niet null zijn");
		if (vorm.getOmhullende().getMinimumX() < MIN_X ||
				vorm.getOmhullende().getMaximumX() > MAX_X ||
				vorm.getOmhullende().getMinimumY() < MIN_Y ||
				vorm.getOmhullende().getMaximumY() > MAX_Y)
			throw new DomainException();
		this.vormen.add(vorm);
	}

	public Vorm getVorm(int index) {
		if (index < 0 || index > this.vormen.size())
			throw new DomainException();
		return this.vormen.get(index);
	}

	public int getAantalVormen() {
		return this.vormen.size();
	}

	public void setNaam(String naam) {
		if (naam == null)
			throw new DomainException("naam mag niet null zijn");
		this.naam = naam;
	}

	public boolean verwijder(Vorm vorm) {
		if (vorm == null) throw new DomainException();
		return vormen.remove(vorm);
	}

	public boolean bevat(Vorm vorm) {
		if (vorm != null) return this.vormen.contains(vorm);
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null && obj.getClass().equals(getClass())
				&& ((Tekening) obj).getNaam().equals(naam)
				&& ((Tekening) obj).vormen.equals(vormen);
	}

	@Override
	public String toString() {
		String out = "Tekening met naam " + this.naam + " bestaat uit "
				+ vormen.size() + " vormen:";
		for (Vorm v : this.vormen) {
			out += "\n" + v.toString();
		}
		return out;
	}

	@Override
	public void draw(Graphics paramGraphics) {

	}
}
