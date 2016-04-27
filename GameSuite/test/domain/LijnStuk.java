package domain;

public class LijnStuk extends Vorm  {
	private Punt startPunt, eindPunt;

	public LijnStuk(Punt start, Punt eind) {
		setStartEnEindPunt(start, eind);
	}

	public Punt getStartPunt() {
		return startPunt;
	}

	public Punt getEindPunt() {
		return eindPunt;
	}

	private void setStartEnEindPunt(Punt startPunt, Punt eindPunt) {
		if(startPunt == null || eindPunt == null || startPunt.equals(eindPunt)){
			throw new DomainException("Ongeldig punt");
		}
		this.startPunt = startPunt;
		this.eindPunt = eindPunt;
	}
	

	@Override
	public boolean equals(Object object) {
		boolean gelijk = false;
		if (object instanceof LijnStuk) {
			LijnStuk other = (LijnStuk) (object);
			if (super.equals(other)
					&& ((other.getStartPunt().equals(this.getStartPunt())
					&& other.getEindPunt().equals(this.getEindPunt())) 
				|| (other.getStartPunt().equals(this.getEindPunt())
					&& other.getEindPunt().equals(this.getStartPunt()))) ) {
				gelijk = true;
			}
		}
		return gelijk;
	}

	@Override
	public String toString() {
		return "Lijn: startpunt: " + this.getStartPunt() + " - eindpunt: "
				+ this.getEindPunt();
	}

}
