package domain;

import java.util.ArrayList;
import java.util.List;

public class Tekening extends Vorm {
private String naam;
private int MIN_X,MIN_Y,MAX_X,MAX_Y;
private List<Vorm>lijst;
	public Tekening(String naam){
		this.lijst= new ArrayList<>();
	}
	public String getNaam(){
		return naam;
	}
	public void voegToe(Vorm vorm){
		if(vorm==null){
			throw new DomainException("Vorm mag niet null zijn");
		}
		if(vorm instanceof Tekening){
			Vorm v = (Vorm)vorm;
			this.lijst.add(vorm);
		}
	}
}
