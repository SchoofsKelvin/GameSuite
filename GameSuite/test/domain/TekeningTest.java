package domain;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TekeningTest {
	private String naam ="jef";
	private int MIN_X, MIN_Y, MAX_X, MAX_Y;
	
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
	public void als_de_index_negatief_is_gooit_exception(){
		List<Vorm>list = new ArrayList<>();
		Rechthoek r = new Rechthoek(new Punt(1, 2), 10, 10);
		Driehoek d = new Driehoek(new Punt(10, 20), new Punt(20, 30), new Punt(10, 10));
		list.add(r);
		list.add(d);
		Tekening t = new Tekening(naam);
		assertEquals(r, t.getVorm(0));
	}
	
	

}
