package domain;

public class Cirkel {

	private Punt middelpunt;
	private int radius;
	
	public Cirkel(Punt middelpunt,int radius){
		setMiddelpunt(middelpunt);
		setRadius(radius);
	}

	public Punt getMiddelpunt() {
		return middelpunt;
	}

	public void setMiddelpunt(Punt middelpunt) {
		if(middelpunt==null){
			throw new DomainException("Ongeldige middelpunt");
		}
		this.middelpunt = middelpunt;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		if(radius<=0){
			throw new DomainException("Ongeldige radius moet groter zijn dan 0");
		}
		this.radius = radius;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj != null && obj.getClass().equals(getClass())
				&& ((Cirkel) obj).getMiddelpunt().equals(getMiddelpunt())
				&& ((Cirkel) obj).getRadius() == getRadius();
	}
	@Override
	public String toString() {
		return "Cirkel: " + middelpunt + " - straal: " + 20;
	}
}