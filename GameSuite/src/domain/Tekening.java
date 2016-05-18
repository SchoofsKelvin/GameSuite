package domain;

import java.util.ArrayList;
import java.util.List;

public class Tekening extends Vorm {

	private String naam;
	private static final int MIN_X = 0;
	private static final int MAX_X = 399;
	private static final int MIN_Y = 0;
	private static final int MAX_Y = 399;
	private List<Vorm> lijst = new ArrayList<>();

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
		if(	vorm.getOmhullende().getMinimumX()<MIN_X||
			vorm.getOmhullende().getMaximumX()>MAX_X ||
			vorm.getOmhullende().getMinimumY()<MIN_Y ||
			vorm.getOmhullende().getMaximumY()>MAX_Y) {
			throw new DomainException();
		}
		this.lijst.add(vorm);
	}

	public Vorm getVorm(int index) {
		if (index < 0 || index > this.lijst.size())
			throw new DomainException();
		return this.lijst.get(index);
	}

	public int getAantalVormen() {
		return this.lijst.size();
	}

	public void setNaam(String naam) {
		if (naam == null)
			throw new DomainException("naam mag niet null zijn");
		this.naam = naam;
	}

	public boolean verwijder(Vorm vorm) {
		if(vorm == null) throw new DomainException();
		return this.lijst.remove(vorm);
	}

	public boolean bevat(Vorm vorm) {
		if (vorm != null) {
			if (vorm instanceof Tekening) {
				Tekening tek = (Tekening) vorm;
				return this.lijst.contains(tek);
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (o != null) {
			if (o instanceof Tekening) {
				Tekening t = (Tekening) o;
				return this.getNaam().equals(t.getNaam());
			}
		}
		return false;
	}
	public String toString(){
		String out = "Tekening met naam " + this.naam + " bestaat uit " + this.lijst.size() + " vormen:";
		for (Vorm v : this.lijst) {
			out += "\n" + v.toString();
		}
		return out;
	}

	@Override
	public Omhullende getOmhullende() {
		return null;
	}
}
