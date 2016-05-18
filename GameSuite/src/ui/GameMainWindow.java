package ui;

import domain.DomainException;
import domain.Tekening;

public class GameMainWindow {
	private TekenVenster tekenvenster;
	private String naam;

	public GameMainWindow(String naam, Tekening tekening) {
		setNaam(naam);
		this.tekenvenster = new TekenVenster(tekening);
	}

	public void setNaam(String naam) {
		if (naam == null)
			throw new DomainException();
		this.naam = naam;
	}

	public void teken() {
		tekenvenster.teken();
	}
}
