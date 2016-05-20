package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import domain.WoordenLijst;

public class WoordenLezer {

	private File file;
	private WoordenLijst woordenLijst;
	private String[] woorden;
	
	public WoordenLezer(String bestandsNaam) {
		file = new File(bestandsNaam);
	}
	
	public WoordenLijst lees() {
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				woorden = line.split("\n");
			}
			
			for (int i = 0; i<woorden.length; i++) {
				woordenLijst.voegToe(woorden[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return woordenLijst;
	}
	
	
}
