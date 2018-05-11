package tomb_es_fajlkezeles_feladatok_18_fejezet;


/* 18.4. 1. p�lda
 * K�t ember, Jobs �s Gates dob�kock�val versenyez: saj�t kock�jukkal mindketten t�zszer dobnak, �s amelyik�knek
 * az �tlaga jobb, az nyer. A dob�sokat v�letlensz�m gener�torral szimul�ljuk! A verseny v�g�n �rjuk ki mindk�t
 * versenyz� nev�t, �s azt, hogy h�ny darab 1-es, 2-es ... 6-os dob�suk vot, valamint dob�saik �tlag�t!
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
		felul = (int) (Math.random() * n + 1); // 1 �s n k�z�tt
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
		str = str + String.format(" --> �tlag: %,2.3f", atlag());
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
			jatekosok[i] = new DoboKocka("J�t�kos_" + i + " ");
		for (int i = 1; i <= DOBASSZAM; i++)
			for (int j = 0; j < JATEKOSDB; j++)
				jatekosok[j].dobas();
		// Eredm�ny ki�r�sa:
		for (int i = 0; i < JATEKOSDB; i++)
			System.out.println(jatekosok[i].toString());
		System.out.println();
		System.out.println("A nyertes j�t�kos: " + jatekosok[nyero(jatekosok)].tulajNev());

	}
}
