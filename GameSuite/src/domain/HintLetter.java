package domain;

public class HintLetter {
	
	private char letter;
	private boolean geraden = false;

	public HintLetter(char letter) {
		this.letter = letter;
	}
	
	public boolean raad(char letter) {
		if (geraden) return false;
		if (letter == this.letter) {
			geraden = true;
			return true;
		}
		return false;
	}
	
	public boolean isGeraden() {
		return geraden;
	}
	
	public char toChar() {
		return geraden ? letter : '_';
	}
	
	public char getLetter() {
		return letter;
	}
}
