package domain;

public class HintWoord {

	private HintLetter[] letters;
	private String woord;

	public HintWoord(String woord) {
		if (woord == null) 
			throw new DomainException("Geldig woord verwacht");
		letters = new HintLetter[woord.length()];
		for (int i = 0; i < woord.length(); i++) {
			letters[i] = new HintLetter(woord.charAt(i));
		}
		this.woord = woord;
	}

	public boolean raad(char letter) {
		boolean geraden = false;
		for (HintLetter let : letters) {
			geraden = geraden || let.raad(letter);
		}
		return geraden;
	}

	public boolean isGeraden() {
		for (HintLetter let : letters) {
			if (!let.isGeraden()) return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder(letters.length*2);
		for (HintLetter letter : letters) {
			res.append(' ');
			res.append(letter.toChar());
		}
		return res.toString();
	}
	
	public String getWoord() {
		return woord;
	}
}
