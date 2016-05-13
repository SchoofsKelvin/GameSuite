package domain;

public class Driehoek {

	private Punt hoekpunt1, hoekpunt2, hoekpunt3;

	public Driehoek(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) {
		setHoekPunten(hoekPunt1, hoekPunt2, hoekPunt3);
	}

	private void setHoekPunten(Punt punt1, Punt punt2, Punt punt3) {
		if (punt1 == null || punt2 == null || punt3 == null) {
			throw new DomainException("Hoekpunten mogen niet null zijn");
		} else if ((punt2.getX()-punt1.getX())*(punt3.getY()-punt1.getY()) == ((punt3.getX()-punt1.getX())*(punt2.getY()-punt1.getY()))) {
			throw new DomainException("Hoekpunten mogen niet op 1 lijn liggen");
		}
		this.hoekpunt1 = punt1;
		this.hoekpunt2 = punt2;
		this.hoekpunt3 = punt3;
	}

	public Punt getHoekPunt1() {
		return hoekpunt1;
	}

	public Punt getHoekPunt2() {
		return hoekpunt2;
	}

	public Punt getHoekPunt3() {
		return hoekpunt3;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;

		Driehoek driehoek  = (Driehoek) obj;

		return hoekpunt1 == driehoek.getHoekPunt1()
			&& hoekpunt2 == driehoek.getHoekPunt2()
			&& hoekpunt3 == driehoek.getHoekPunt3();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return super.toString();
	}
}
