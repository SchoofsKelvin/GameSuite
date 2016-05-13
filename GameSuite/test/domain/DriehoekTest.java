package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DriehoekTest {

	private Punt	puntA	= new Punt(0, 0);
	private Punt	puntB	= new Punt(100, 0);
	private Punt	puntC	= new Punt(0, 100);
	private Punt	puntAB	= new Punt(50, 0);

	@Test
	public void Driehoek_general() {
		Driehoek hoek = new Driehoek(puntA, puntB, puntC);
		assertEquals(puntA, hoek.getHoekPunt1());
		assertEquals(puntB, hoek.getHoekPunt2());
		assertEquals(puntC, hoek.getHoekPunt3());
	}

	@Test(expected = DomainException.class)
	public void Driehoek_puntA_is_null() {
		new Driehoek(null, puntB, puntC);
	}

	@Test(expected = DomainException.class)
	public void Driehoek_puntB_is_null() {
		new Driehoek(puntA, null, puntC);
	}

	@Test(expected = DomainException.class)
	public void Driehoek_puntC_is_null() {
		new Driehoek(puntA, puntB, null);
	}

	@Test(expected = DomainException.class)
	public void Driehoek_punten_op_lijn() {
		new Driehoek(puntA, puntAB, puntB);
	}

	@Test
	public void Driehoek_equals() {
		Driehoek hoek1 = new Driehoek(puntA, puntB, puntC);
		Driehoek hoek2 = new Driehoek(puntA, puntB, puntC);
		Driehoek hoek3 = new Driehoek(puntAB, puntB, puntC);
		assertTrue(hoek1.equals(hoek2));
		assertFalse(hoek1.equals(hoek3));
		assertFalse(hoek3.equals(hoek2));
	}

}
