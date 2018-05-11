package tomb_es_fajlkezeles_feladatok_18_fejezet;


/*Saj�t objektum pr�ba*/
import extra.*;

class Kutya {
	private String		nev;
	private String		fajta;
	private boolean	oltott;

	public Kutya(String nev, String fajta) {
		this.nev = nev;
		this.fajta = fajta;
		this.oltott = false;

	}

	public void ugat() {
		System.out.println(this.getNev() + ": VAU-VAU-VAU");
	}

	public String getNev() {
		return this.nev;
	}

	public String getFajta() {
		return this.fajta;
	}

	public boolean getOltott() {
		return this.oltott;
	}

	public void setOltott(boolean oltasAllapot) {
		this.oltott = oltasAllapot;
	}

	public String legjobbVagyok() {
		if (this.fajta.equals("Tacsk�"))
			return "a legjobb vad�sz kutya";
		else if (this.fajta.equals("Puli"))
			return "a legjobb terel� kutya";
		else if (this.fajta.equals("Husky"))
			return "a legjobb sz�nh�z� kutya";
		else
			return "a gazdi legjobb bar�tja";
	}

} // Kutya

public class Kutya_falka {

	static final int MAXKUTYA = 3;

	public static void main(String[] args) {
		Kutya[] falka = new Kutya[MAXKUTYA];
		falka[0] = new Kutya("Ravasz", "Tacsk�");
		falka[1] = new Kutya("Villam", "Husky");
		falka[2] = new Kutya("Maci", "Puli");
		//Kutya [] falka1 = falka.clone();
		Kutya[] falka1 = new Kutya[MAXKUTYA];
		falka1[0] = new Kutya("Ravasz", "Tacsk�");
		falka1[1] = new Kutya("Villam", "Husky");
		falka1[2] = new Kutya("Maci", "Puli");
		//falka[0].ugat();
		System.out.println("EREDETI FALKA:");
		falkaOltottE(falka);
		System.out.println("MASOLAT:");
		falkaOltottE(falka1);
		falkaOlt(falka);
		System.out.println("EREDETI FALKA:");
		falkaOltottE(falka);
		System.out.println("MASOLAT:");
		falkaOltottE(falka1);
		
		/*falkaOlt(falka);
		falkaOltottE(falka);
		for (int i = 0; i < falka.length; i++)
			System.out.println(falka[i].getNev() + " " + falka[i].legjobbVagyok());*/
	} //main

	public static void falkaKiir(Kutya falka[]) {
		System.out.println("A FALKA:");
		for (int i = 0; i < falka.length; i++)
			System.out.println(falka[i].getNev());
	}

	public static void falkaOlt(Kutya falka[]) {
		for (int i = 0; i < falka.length; i++)
			falka[i].setOltott(true);
	}

	public static void falkaOltottE(Kutya falka[]) {
		System.out.println("A FALKA OLT�SI �LLAPOTA:");
		for (int i = 0; i < falka.length; i++)
			if (falka[i].getOltott())
				System.out.println(falka[i].getNev() + " be van oltva! :) ");
			else
				System.out.println(falka[i].getNev() + " NINCS beoltva! :( ");
	}

} //Kutya_falka
