package domain;

import java.util.ArrayList;
import java.util.List;

public class Tekening extends Vorm {
	private String naam;
	private int MIN_X, MIN_Y, MAX_X, MAX_Y;
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
		return "Tekening:"+this.getClass()+" "+this.getNaam();
	}

	@Override
	public Omhullende getOmhullende() {
		// TODO Auto-generated method stub
		return null;
	}
}
