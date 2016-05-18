package domain;

import java.util.ArrayList;
import java.util.List;

public class Tekening {
	private String				naam;
	private List<Vorm>		vormen	= new ArrayList<>();

	private final static int	MIN_X	= 0;
	private final static int	MIN_Y	= 0;
	private final static int	MAX_X	= 399;
	private final static int	MAX_Y	= 399;

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
		vormen.add(vorm);
	}

	public Vorm getVorm(int index) {
		return vormen.get(index);
	}

	public int getAantalVormen() {
		return vormen.size();
	}

	public void verwijder(Vorm vorm) {
		vormen.remove(vorm);
	}

	public boolean bevat(Vorm vorm) {
		return vormen.contains(vorm);
	}

	private Vorm[] getVormen() {
		return vormen.toArray(new Vorm[vormen.size()]);
	}

	@Override
	public String toString() {
		return "Tekening met " + vormen.size() + " vormen";
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null && obj.getClass().equals(getClass())
				&& ((Tekening) obj).getNaam().equals(naam)
				&& ((Tekening) obj).getVormen().equals(vormen);
	}
}
