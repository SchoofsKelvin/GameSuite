package domain;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import ui.Drawable;

public class Tekening implements Drawable {
	private String naam;
	private final static int	MIN_X	= 0;
	private final static int	MIN_Y	= 0;
	private final static int	MAX_X	= 399;
	private final static int	MAX_Y	= 399;
		private List<Vorm> vormen = new ArrayList<>();

	public Tekening() {

	}

	public Tekening(String naam) {
		setNaam(naam);
	}

	public String getNaam() {
		return naam;
	}

	public void voegToe(Vorm vorm) {
		if (vorm == null) {
			throw new DomainException("Vorm mag niet null zijn");
		}
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

	public void verwijder(Vorm vorm) {
		vormen.remove(vorm);
	}

	public boolean bevat(Vorm vorm) {
		if (vorm != null) {
				return this.vormen.contains(vorm);
			}
		return false;
	}
	private Vorm[] getVormen() {
		return vormen.toArray(new Vorm[vormen.size()]);
	}

@Override
	public boolean equals(Object obj) {
		return obj != null && obj.getClass().equals(getClass())
				&& ((Tekening) obj).getNaam().equals(naam)
				&& ((Tekening) obj).getVormen().equals(vormen);
	}

	@Override
	public String toString() {
		return "Tekening met " + vormen.size() + " vormen";
	}

	

	@Override
	public void draw(Graphics paramGraphics) {
		// TODO Auto-generated method stub

	}
}
