package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CirkelTest {

	private Punt middelPunt;
	private int straal;
	private Cirkel cirkel;

	@Before
	public void setUp() {
		middelPunt = new Punt(200, 200);
		straal = 20;
		cirkel = new Cirkel(middelPunt,straal);
	}

	@Test
	public void Cirkel_moet_cirkel_aanmaken_met_gegeven_middelpunt_en_straal() {
		Cirkel cirkel = new Cirkel(middelPunt,straal);
		assertEquals(middelPunt, cirkel.getMiddelPunt());
		assertEquals(20, cirkel.getRadius());

	}
	
	@Test (expected = DomainException.class)
	public void Cirkel_Moet_exception_gooien_als_middelpunt_null()  {
		new Cirkel(null, straal);
	}
	
	@Test (expected = DomainException.class)
	public void Cirkel_Moet_exception_gooien_als_straal_kleiner_dan_0()  {
		new Cirkel(middelPunt, -1);
	}
	
	@Test (expected = DomainException.class)
	public void Cirkel_Moet_exception_gooien_als_straal_gelijk_aan_0()  {
		new Cirkel(middelPunt, 0);
	}
	
	@Test
	public void equals_moet_true_teruggeven_als_middelpunt_en_radius_gelijk_zijn(){
		Cirkel tweedecirkel = new Cirkel(middelPunt,straal);
		assertTrue(tweedecirkel.equals(cirkel));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_middelpunt_verschilt(){
		Punt anderMiddelPunt = new Punt(100,100);
		Cirkel tweedecirkel = new Cirkel(anderMiddelPunt, straal);
		assertFalse(tweedecirkel.equals(cirkel));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_straal_verschilt(){
		Cirkel tweedecirkel = new Cirkel(middelPunt, 21);
		assertFalse(tweedecirkel.equals(cirkel));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_parameter_null(){
		assertFalse(cirkel.equals(null));
	}
}
