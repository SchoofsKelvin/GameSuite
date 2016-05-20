package ui;

import domain.DomainException;
import domain.Tekening;

import javax.swing.*;

public class GameMainWindow extends JFrame {
	
	private TekenVenster tekenVenster;
	private String naam;

	public GameMainWindow(String naam, Tekening tekening) {
		setNaam(naam);
		this.tekenVenster = new TekenVenster(tekening);
		this.setSize(400, 400);
		this.setName(this.naam);
        this.add(this.tekenVenster);
        this.tekenVenster.setVisible(true);
	}

	public void setNaam(String naam) {
		if (naam == null)
			throw new DomainException();
		this.naam = naam;
	}

	public void teken() {
        tekenVenster.teken();
	}

}
