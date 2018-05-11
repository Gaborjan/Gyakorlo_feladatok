package tomb_es_fajlkezeles_feladatok_18_fejezet;


/* 18.4. 1. példa
 * Két ember, Jobs és Gates dobókockával versenyez: saját kockájukkal mindketten tízszer dobnak, és amelyiküknek
 * az átlaga jobb, az nyer. A dobásokat véletlenszám generátorral szimuláljuk! A verseny végén írjuk ki mindkét
 * versenyzõ nevét, és azt, hogy hány darab 1-es, 2-es ... 6-os dobásuk vot, valamint dobásaik átlagát!
 * 
 */
import extra.*;

class DoboKocka {
	private static int n			= 6;
	private String		 tulaj;
	private int			 felul;
	private int[]		 dobasok	= new int[n + 1];	// 0. elem felesleges

	public DoboKocka(String tulaj) {
		this.tulaj = tulaj;
		felul = 1;
	}

	public int dobas() {
		felul = (int) (Math.random() * n + 1); // 1 és n között
		dobasok[felul]++; // gyujtes
		return felul;
	}

	public String tulajNev() {
		return this.tulaj;
	}

	public double atlag() {
		int osszeg = 0;
		int dobasSzam = 0;
		for (int i = 1; i <= n; i++) {
			dobasSzam = dobasSzam + dobasok[i];
			osszeg = osszeg + dobasok[i] * i;
		}
		return (osszeg + 0.0) / dobasSzam;
	}

	public String toString() {
		String str = String.format("%-15s", tulaj);
		for (int i = 1; i <= n; i++) {
			str = str + String.format("%,4d ", dobasok[i]);
		}
		str = str + String.format(" --> Átlag: %,2.3f", atlag());
		return str;
	}
}

public class Dobo_Kocka_18_4_pelda {
	static final int DOBASSZAM	= 100;
	static final int JATEKOSDB	= 100;

	public static int nyero(DoboKocka[] jatekosok) {
		double max;
		double pontszam;
		int nyertes;
		max = 0;
		nyertes = 0;
		for (int i = 1; i < JATEKOSDB; i++) {
			pontszam = jatekosok[i].atlag();
			if (pontszam > max) {
				max = pontszam;
				nyertes = i;
			}
		}
		return nyertes;
	}

	public static void main(String[] args) {

		// DoboKocka d1=new DoboKocka("Jobs ");
		// DoboKocka d2=new DoboKocka("Gates");
		DoboKocka[] jatekosok = new DoboKocka[JATEKOSDB];
		for (int i = 0; i < JATEKOSDB; i++)
			jatekosok[i] = new DoboKocka("Játékos_" + i + " ");
		for (int i = 1; i <= DOBASSZAM; i++)
			for (int j = 0; j < JATEKOSDB; j++)
				jatekosok[j].dobas();
		// Eredmény kiírása:
		for (int i = 0; i < JATEKOSDB; i++)
			System.out.println(jatekosok[i].toString());
		System.out.println();
		System.out.println("A nyertes játékos: " + jatekosok[nyero(jatekosok)].tulajNev());

	}
}
