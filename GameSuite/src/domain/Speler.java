package domain;

public class Speler {

	private String	naam	= "";
	private int		score	= 0;

	public Speler(String naam) {
		setNaam(naam);

	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		if (naam == null || naam.trim().isEmpty())
			throw new DomainException("Naam mag niet null zijn");
		this.naam = naam;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		if (score < 0) throw new DomainException("Score moet boven 0 zijn");
		this.score = score;
	}

	public void addToScore(int score) {
		if (this.score + score < 0)
			throw new DomainException("Score kan niet onder 0 zijn");
		this.score += score;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Speler) {
			Speler speler = (Speler) o;
			if (speler.getNaam().equals(this.getNaam())
					&& speler.getScore() == this.getScore())
				return true;

		}
		return false;
	}

	@Override
	public String toString() {
		return "Speler met naam : " + getNaam() + " en met score:" + getScore()
				+ ".";
	}

}
