package domain;

import ui.TekeningHangMan;

public class HangMan {
	
	private Speler speler;
	private WoordenLijst woordenlijst;
	
	private TekeningHangMan tekening = new TekeningHangMan();
	private HintWoord woord; // TODO
	
	public HangMan(Speler speler, WoordenLijst woordenlijst) {
		this.speler = speler;
		this.woordenlijst = woordenlijst;
	}
	
    public String getHint() {
        return "";
    }

    public Speler getSpeler() {
        return speler;
    }

    public TekeningHangMan getTekening() {
        return tekening;
    }
    
    public void raad(char letter) {
    	woord.raad(letter); // TODO ?
    }
    
    public boolean isGameOver() {
    	return woord.isGeraden() || tekening.getAantalOntzichtbaar() == 0;
    }
    
    public boolean isGewonnen() {
    	return woord.isGeraden();
    }
}
