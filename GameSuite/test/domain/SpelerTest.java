package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SpelerTest {
	
	private String naam;
	private String anderenaam;
	private int scoreToAdd;
	private int wrongScoreToAdd;
	private Speler speler;

	@Before
	public void setUp() throws Exception {
		naam = "Lars";
		anderenaam = "Lies";
		//TODO Remove? scoreToAdd = 5;
		//TODO Remove? wrongScoreToAdd = -5;
		speler = new Speler(naam);
	}

	@Test
	public void test_Speler_wordt_aangemaakt_met_gegeven_naam() {
		speler = new Speler(naam);
		assertEquals(naam, speler.getNaam());
		assertEquals(0, speler.getScore());
	}
	
	@Test (expected = DomainException.class)
	public void test_Speler_Gooit_exception_als_naam_null() {
		speler = new Speler(null);
	}
	
	@Test (expected = DomainException.class)
	public void test_Speler_Gooit_exception_als_naam_lege_string() {
		speler = new Speler("");
	}
	
	@Test
	public void test_equals_geeft_true_als_naam_gelijk_is(){
		Speler andereSpeler = new Speler(naam);
		
		assertTrue(speler.equals(andereSpeler));
	}
	
	@Test
	public void test_equals_geeft_false_voor_parameter_null(){
		assertFalse(speler.equals(null));
	}
	
	@Test
	public void test_equals_geeft_false_voor_speler_met_andere_naam(){
		Speler andereSpeler = new Speler(anderenaam);
		assertFalse(speler.equals(andereSpeler));
	}
	
	@Test
	public void test_equals_geeft_true_als_naam_en_score_gelijk_zijn(){
		speler.addToScore(scoreToAdd);
		Speler andereSpeler = new Speler(naam);
		andereSpeler.addToScore(scoreToAdd);
		
		assertTrue(speler.equals(andereSpeler));
	}
	
	@Test
	public void test_equals_geeft_false_voor_speler_met_andere_score(){
		Speler andereSpeler = new Speler(naam);
		andereSpeler.addToScore(scoreToAdd);
		assertFalse(speler.equals(andereSpeler));
	}
	
	@Test
	public void test_addToScore_voegt_positieve_score_toe_aan_bestaande_score(){
		speler.addToScore(scoreToAdd);
		assertEquals(scoreToAdd, speler.getScore());
	}
	
	@Test
	public void test_addtoScore_voegt_score_correct_toe_voor_negatieve_score_kleiner_dan_huidige_score(){
		speler.addToScore(scoreToAdd);
		speler.addToScore(scoreToAdd);
		speler.addToScore(wrongScoreToAdd);
		assertEquals(scoreToAdd, speler.getScore());
	}
	
	@Test (expected = DomainException.class)
	public void test_addToScore_Gooit_exception_als_resulterende_score_negatief(){
		speler.addToScore(wrongScoreToAdd);
	}
}
