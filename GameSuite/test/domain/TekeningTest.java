package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TekeningTest {
	
	// TODO: verwijderVorm(null) exception
	// TODO: deftige namen

	private Tekening t;

	@Before
	public void setUp() {
		t = new Tekening("test");
	}

	@Test(expected = DomainException.class)
	public void Tekening_gooit_exception_als_naam_null_is() {
		new Tekening(null);
	}

	@Test(expected = DomainException.class)
	public void VoegToe_gooit_exception_als_type_null() {
		t.voegToe(null);
	}

	@Test(expected = DomainException.class)
	public void getVorm_gooit_exception_als_index_negatief_is() {
		t.getVorm(-1);
	}

	@Test
	public void je_moet_met_de_voeg_toe_methode_de_vorm_kunnen_toevoegen() {
		Tekening t = new Tekening("test");
		Vorm v = new Rechthoek(new Punt(20, 10), 10, 10);
		Vorm c = new Cirkel(new Punt(50, 50), 10);
		t.voegToe(v);
		t.voegToe(c);
		assertEquals(2,t.getAantalVormen());
		assertEquals(t.getVorm(0), v);
		assertEquals(t.getVorm(1), c);
	}

	@Test(expected = DomainException.class)
	public void getVorm_gooit_exception_als_index_groter_dan_size_is() {
		t.getVorm(t.getAantalVormen()+2);
	}

	@Test
	public void getAantalVormen_geeft_juiste_waarde_terug() {
		Tekening t = new Tekening("test");
		Vorm v = new Rechthoek(new Punt(20, 10), 10, 10);
		Vorm c = new Cirkel(new Punt(50, 50), 10);
		t.voegToe(v);
		t.voegToe(c);
		assertEquals(2, t.getAantalVormen());
	}

	@Test
	public void bevat_geeft_vals_als_vorm_niet_in_tekening_zit() {
		Tekening tekening = new Tekening("test");
		Vorm v = new Rechthoek(new Punt(20, 80), 10, 10);
		assertFalse(tekening.bevat(v));
	}

	@Test
	public void getVorm_werkt() {
		Tekening t = new Tekening("tekeningNaam");
		Vorm v = new Rechthoek(new Punt(20, 10), 10, 10);
		Vorm c = new Cirkel(new Punt(50, 50), 10);
		t.voegToe(v);
		t.voegToe(c);
		assertEquals(v, t.getVorm(0));
	}

	@Test
	public void verwijderd_moet_vorm_verwijderen() {
		Tekening tekening = new Tekening("test");

		Vorm driehoek = new Driehoek(new Punt(10, 5), new Punt(5, 10), new Punt(3, 8));
		Vorm rechthoek = new Rechthoek(new Punt(20, 10), 10, 10);
		tekening.voegToe(driehoek);
		tekening.voegToe(rechthoek);

		tekening.verwijder(rechthoek);
		assertEquals(1, tekening.getAantalVormen());
		assertTrue(tekening.bevat(driehoek));
		assertFalse(tekening.bevat(rechthoek));
	}

	@Test
	public void Tekening_equals() {
		Tekening t = new Tekening("jef");
		Tekening a = new Tekening("Bart");
		Tekening b = new Tekening("john");
		Tekening c = new Tekening("Bart");
		assertTrue(c.equals(a));
		assertFalse(t.equals(b));
	}

	@Test (expected = DomainException.class)
	public void Tekening_vorm_binnen_bounds_left(){
		Tekening t = new Tekening("");
		Vorm rechthoek = new Rechthoek(new Punt(-2,2), 50, 50);
		t.voegToe(rechthoek);
	}

	@Test (expected = DomainException.class)
	public void Tekening_vorm_binnen_bounds_right(){
		Tekening t = new Tekening("");
		Vorm rechthoek = new Rechthoek(new Punt(2,2), 500000, 50);
		t.voegToe(rechthoek);
	}

	@Test (expected = DomainException.class)
	public void Tekening_vorm_binnen_bounds_up(){
		Tekening t = new Tekening("");
		Vorm rechthoek = new Rechthoek(new Punt(2,-2), 50, 50);
		t.voegToe(rechthoek);
	}

	@Test (expected = DomainException.class)
	public void Tekening_vorm_binnen_bounds_down(){
		Tekening t = new Tekening("");
		Vorm rechthoek = new Rechthoek(new Punt(2,2), 50, 500000);
		t.voegToe(rechthoek);
	}
	
	
	
	
	

}
