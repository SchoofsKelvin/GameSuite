package ui;

import java.awt.Graphics;

import domain.DomainException;
import domain.Tekening;

public class TekenVenster {
	
	@SuppressWarnings("unused")
	private Tekening tekening;

	public TekenVenster(Tekening tekening) {
		setTekening(tekening);
	}

	private void setTekening(Tekening teken) {
		if (teken == null) throw new DomainException();
		this.tekening = teken;
	}

	public void teken() {

	}

	public void print(Graphics graphics) {

	}
}
