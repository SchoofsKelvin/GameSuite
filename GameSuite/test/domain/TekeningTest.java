package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static org.junit.Before.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TekeningTest {
	private String naam ="jef";
	private int MIN_X, MIN_Y, MAX_X, MAX_Y;
	
	
	
	@Before
	public void setUp(){
		Tekening t = new Tekening("tekeningNaam");
		Vorm v = new Rechthoek(new Punt(20, 10), 10, 10);
		Vorm c = new Cirkel(new Punt(50, 50), 10);
		t.voegToe(v);
		t.voegToe(c);
	}
	
	
	@Test(expected = DomainException.class)
	public void setNaam_gooit_exception_als_naam_null_is() {
		Tekening t = new Tekening(null);
	}

	@Test(expected = DomainException.class)
	public void setVoegToe_gooit_exception_als_type_null() {
		Rechthoek r = null;
		Tekening t = new Tekening(null);
		t.voegToe(r);
	}
	
	@Test(expected=DomainException.class)
	public void als_de_index_negatief_is_gooit_exception(){
		Tekening t = new Tekening(null);
		t.getVorm(-1);
	}
	
	@Test
	public void je_moet_met_de_voeg_toe_methode_de_vorm_kunnen_toevoegen(){
		Tekening t = new Tekening("tekeningNaam");
		Vorm v = new Rechthoek(new Punt(20, 10), 10, 10);
		Vorm c = new Cirkel(new Punt(50, 50), 10);
		t.voegToe(v);
		t.voegToe(c);
		System.out.println(t.getAantalVormen());
	}
	
	@Test(expected=DomainException.class)
	public void als_de_index_groter_dan_de_size_Van_lijst_gooit_exception(){
		Tekening t = new Tekening("tekeningNaam");
		Vorm v = new Rechthoek(new Punt(20, 10), 10, 10);
		assertEquals(v, t.getVorm(2));
	}
	@Test
	public void als_de_aantal_niet_gelijk_is_geeft_false_terug(){
		Tekening t= new Tekening("tekeningNaam");
		Vorm v = new Rechthoek(new Punt(20, 10), 10, 10);
		Vorm c = new Cirkel(new Punt(50, 50), 10);
			t.voegToe(v);
			t.voegToe(c);
			System.out.println(t.getAantalVormen());
		assertEquals(2, t.getAantalVormen());
	}
	@Test
	public void als_de_vorm_niet_in_de_lijst_returnt_false(){
		Tekening tekening = new Tekening("tekeningNaam");
		Vorm v = new Rechthoek(new Punt(20, 80), 10, 10);
		assertFalse(tekening.bevat(v));
	}
	@Test
	public void get_vorm_by_index(){
		Tekening t= new Tekening("tekeningNaam");
		Vorm v = new Rechthoek(new Punt(20, 10), 10, 10);
		Vorm c = new Cirkel(new Punt(50, 50), 10);
		t.voegToe(v);
		t.voegToe(c);
		assertEquals(v, t.getVorm(0));
	}
	
	@Test
	public void vorm_verwijderd_lijst_moet_verminderen(){
		Tekening t = new Tekening("tekeningNaam");
		Vorm v = new Rechthoek(new Punt(20, 10), 10, 10);
		t.voegToe(v);
		t.verwijder(v);
		assertEquals(0, t.getAantalVormen());
	}
	@Test
	public void Tekening_equals(){
		Tekening t = new Tekening("jef");
		Tekening a = new Tekening("Bart");
		Tekening b = new Tekening("john");
		Tekening c = new Tekening("Bart");
		assertTrue(c.equals(a));
		assertFalse(t.equals(b));
	}


	
	
	
	
	

}
