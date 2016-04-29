package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CirkelTest {
	private final static Punt middelPunt = new Punt(200, 200);
	private final static int radius = 20;

	@Test
	public void geldige_Cirkel_aanmaken() {
		Cirkel cirkel = new Cirkel(middelPunt, radius);
	}

	@Test(expected = DomainException.class)
	public void Cirkel_met_middelpunt_null_gooit_exception() {
		Cirkel cirkel = new Cirkel(null, radius);
	}

	@Test(expected = DomainException.class)
	public void Cirke_met_negatieve_radius_gooit_exception() {
		Cirkel cirkel = new Cirkel(middelPunt, -5);
	}

	@Test(expected = DomainException.class)
	public void Cirke_met_radius_0_gooit_exception() {
		Cirkel cirkel = new Cirkel(middelPunt, 0);
	}

	@Test
	public void Cirkels_zijn_gelijk_als_ze_alle_instantie_variabelen_gelijk_hebben()

	{
		Cirkel cirkelA = new Cirkel(middelPunt, radius);
		Cirkel cirkelB = new Cirkel(middelPunt, radius);
		assertEquals(cirkelA, cirkelB);
	}
	@Test
	public void Cirkels_zijn_verschillend_als_tweede_cirkel_null_is(){
		Cirkel cirkelA = new Cirkel(middelPunt, radius);
		assertFalse(cirkelA.equals(null));
	}
	@Test
	public void Cirkels_zijn_verschillend_met_verschillend_middelpunt(){
		Cirkel cirkelA = new Cirkel(middelPunt, radius);
		Cirkel cirkelB = new Cirkel(new Punt(100,100), radius);
		assertFalse(cirkelA.equals(cirkelB));
	}
	@Test
	public void Cirkels_zijn_verschillend_met_verschillende_straal(){
		Cirkel cirkelA = new Cirkel(middelPunt, radius);
		Cirkel cirkelB = new Cirkel(middelPunt, radius+1);
		assertFalse(cirkelA.equals(cirkelB));
	}
	
	
	
}
