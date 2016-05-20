package ui;

import java.awt.*;

import domain.DomainException;
import domain.Tekening;
import domain.Vorm;

public class TekenVenster extends Canvas {

	private Tekening tekening;

	public TekenVenster(Tekening tekening) {
		setTekening(tekening);
	}

	private void setTekening(Tekening teken) {
		if (teken == null) throw new DomainException();
		this.tekening = teken;
	}

	public void teken() {
		this.validate();
		this.repaint();
    }

	@Override
	public void paint(Graphics graphics) {
		for(Vorm vorm : tekening.getVormen()) {
            if (vorm.isZichtbaar()) {
                vorm.draw(graphics);
            }
		}
	}

}
