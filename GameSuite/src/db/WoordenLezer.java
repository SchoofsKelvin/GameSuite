package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import domain.WoordenLijst;

public class WoordenLezer {

	private File file;
	
	public WoordenLezer(String bestandsNaam) {
		file = new File(bestandsNaam);
	}
	
	public WoordenLijst lees() {
		WoordenLijst woordenLijst = new WoordenLijst();
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				woordenLijst.voegToe(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return woordenLijst;
	}
	
	
}
