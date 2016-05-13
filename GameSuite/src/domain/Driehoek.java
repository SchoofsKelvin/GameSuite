package domain;

public class Driehoek {

	private Punt hoekpunt1, hoekpunt2, hoekpunt3;

	public Driehoek(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) {
		setHoekPunten(hoekPunt1, hoekPunt2, hoekPunt3);
	}

	private void setHoekPunten(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) {
		this.hoekpunt1 = hoekPunt1;
		this.hoekpunt2 = hoekPunt2;
		this.hoekpunt3 = hoekPunt3;
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
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
