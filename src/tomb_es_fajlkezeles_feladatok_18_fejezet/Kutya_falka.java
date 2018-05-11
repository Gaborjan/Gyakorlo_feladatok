package tomb_es_fajlkezeles_feladatok_18_fejezet;


/*Saját objektum próba*/
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
		if (this.fajta.equals("Tacskó"))
			return "a legjobb vadász kutya";
		else if (this.fajta.equals("Puli"))
			return "a legjobb terelõ kutya";
		else if (this.fajta.equals("Husky"))
			return "a legjobb szánhúzó kutya";
		else
			return "a gazdi legjobb barátja";
	}

} // Kutya

public class Kutya_falka {

	static final int MAXKUTYA = 3;

	public static void main(String[] args) {
		Kutya[] falka = new Kutya[MAXKUTYA];
		falka[0] = new Kutya("Ravasz", "Tacskó");
		falka[1] = new Kutya("Villam", "Husky");
		falka[2] = new Kutya("Maci", "Puli");
		//Kutya [] falka1 = falka.clone();
		Kutya[] falka1 = new Kutya[MAXKUTYA];
		falka1[0] = new Kutya("Ravasz", "Tacskó");
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
		System.out.println("A FALKA OLTÁSI ÁLLAPOTA:");
		for (int i = 0; i < falka.length; i++)
			if (falka[i].getOltott())
				System.out.println(falka[i].getNev() + " be van oltva! :) ");
			else
				System.out.println(falka[i].getNev() + " NINCS beoltva! :( ");
	}

} //Kutya_falka
