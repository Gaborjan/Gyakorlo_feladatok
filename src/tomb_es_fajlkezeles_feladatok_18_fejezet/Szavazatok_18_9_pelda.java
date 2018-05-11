package tomb_es_fajlkezeles_feladatok_18_fejezet;


/*Feladat: Egy sportversenyen k�z�ns�gszavaz�st tartanak. Minden n�z� egyetlen versenyz�re
 * szavazhat. A Versenyz�k k�l�nb�z� kateg�ri�kban indulnak, a kateg�ri�k sz�moz�sa 1-t�l 
 * indul. Minden kateg�ri�ban a versenyz�k sorsz�mot kapnak 0-t�l kezd�d�en. Hogy h�ny
 * kateg�ria van �sszesen, �s kateg�ri�nk�t h�ny versenyz� indul, azt a program param�-
 * tereik�nt adjuk meg. 5 kateg�ria eset�n p�ld�ul: 
 * 6 10 50 30 7
 * A k�z�ns�gben mindenki kap egy szavaz�c�dul�t, melyen kit�ltheti a kateg�ri�t �s a 
 * versenyz� sorsz�m�t. A c�dul�t egy l�dik�ba kell bedobni. A l�dik�ban l�v� c�dul�k
 * sz�ma tetsz�leges.
 * K�sz�ts�nk egy olyan programot, amely feldolgozza �s ki�rt�keli a szavaz�c�dul�kat!
 * -El�sz�r vigy�k be a szavaz�c�dul�k adatait (rossz adatokat tartalmaz� c�dul�k nem vesznek 
 * r�szt a szavaz�sban!
 * V�g�l k�sz�ts�nk kimutat�st:
 * - Kateg�ri�nk�nt �s versenyz�nk�nt �rjuk ki a szavazatok sz�m�t!
 * - �rjuk ki azon versenyz�k kateg�ri�j�t �s sorsz�m�t, akik a legt�bb szavazatot kapt�k a
 * teljes mez�nyben! (Egyforma eredm�ny eset�n mindegyiket �rjuk ki!)
 * - Mely kateg�ria kapta �sszesen a legt�bb szavazatot? (Egyforma eredm�ny eset�n mind-
 * egyiket �rjuk ki!)
 * 
 */
import extra.*;

class Szavazatok {
	private int			katSzam;
	private int[][]	szavazat;

	public Szavazatok(String[] versenyzokSzama) {
		System.out.println(versenyzokSzama.length);
		katSzam = versenyzokSzama.length;
		// Kateg�ri�k l�trehoz�sa:
		szavazat = new int[katSzam + 1][]; // 0. kateg�ria nincs
		// Kateg�ri�nk�nt r�szt�mb l�trehoz�sa:
		for (int k = 1; k <= katSzam; k++)
			szavazat[k] = new int[Integer.parseInt(versenyzokSzama[k - 1])];
	}

	public void feldolgozas() {
		int kat, vsz;
		int cedulaDb=0;
		do {
			//kat = Console.readInt("Kateg�ria : ");
			kat=(int) ((Math.random()*katSzam)+1);
			if (kat == 0)
				continue;
			if (kat < 1 || kat > katSzam) {
				System.out.println("Rossz kateg�ria!");
				continue;
			}
			//vsz = Console.readInt("Versenyz� : ");
			vsz=(int) (Math.random()*szavazat[kat].length);
			if (vsz < 0 || vsz >= szavazat[kat].length) {
				System.out.println("Rossz versenyz� sorsz�m!");
				continue;
			}
			szavazat[kat][vsz]++; // a megfelel� �rt�k n�vel�se
			cedulaDb++;
		} while (cedulaDb<200);
	}

	public void print() {
		for (int i = 1; i <= katSzam; i++) {
			System.out.println("\nSzavazatok az " + i + ". kateg�ri�ban");
			// A versenyz�k sorsz�mainak ki�r�sa
			System.out.print("Vers. sorsz�ma:  ");
			for (int j = 0; j < szavazat[i].length; j++)
				System.out.print(Format.right(j, 3));
			System.out.println();

			// A versenyz�k szavazatainak ki�r�sa:
			System.out.print("Szavazatok     : ");
			for (int j = 0; j < szavazat[i].length; j++)
				System.out.print(Format.right(szavazat[i][j], 3));
			System.out.println();
			System.out.println("�sszesen: " + kategoriaOssz(i) + " szav.");
		}
	}

	public void gyoztesVersenyzok() {
		// Maxim�lis �rt�k meghat�roz�sa
		int max = 0;
		for (int i = 1; i < szavazat.length; i++)
			for (int j = 0; j < szavazat[i].length; j++)
				if (szavazat[i][j] > max)
					max = szavazat[i][j];
		// A gy�ztesek ki�r�sa
		System.out.println("Gy�ztes versenyz�k:");
		for (int i = 1; i < szavazat.length; i++) {
			for (int j = 0; j < szavazat[i].length; j++)
				if (szavazat[i][j] == max)
					System.out.println(i + " . kat.ban a " + j + ". vers.");
		}
	}

	public int kategoriaOssz(int kat) {
		int sum = 0;
		for (int j = 0; j < szavazat[kat].length; j++)
			sum += szavazat[kat][j];
		return sum;
	}

	public void gyoztesKategoriak() {
		int max = 0;
		for (int i = 1; i < szavazat.length; i++)
			if (kategoriaOssz(i) > max)
				max = kategoriaOssz(i);
		System.out.println("Gy�ztes kateg�ri�k:");
		for (int i = 1; i < szavazat.length; i++)
			if (kategoriaOssz(i) == max)
				System.out.print(i + " ");
		System.out.println();
	}
}

public class Szavazatok_18_9_pelda {
	public static void main(String[] args) {
		Szavazatok szavazatok = new Szavazatok(args);
		szavazatok.feldolgozas();
		szavazatok.print();
		szavazatok.gyoztesVersenyzok();
		szavazatok.gyoztesKategoriak();

	}
}
