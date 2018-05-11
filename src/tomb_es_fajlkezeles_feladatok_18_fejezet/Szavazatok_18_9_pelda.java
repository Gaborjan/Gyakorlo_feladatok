package tomb_es_fajlkezeles_feladatok_18_fejezet;


/*Feladat: Egy sportversenyen közönségszavazást tartanak. Minden nézõ egyetlen versenyzõre
 * szavazhat. A Versenyzõk különbözõ kategóriákban indulnak, a kategóriák számozása 1-tõl 
 * indul. Minden kategóriában a versenyzõk sorszámot kapnak 0-tól kezdõdõen. Hogy hány
 * kategória van összesen, és kategóriánkét hány versenyzõ indul, azt a program paramé-
 * tereiként adjuk meg. 5 kategória esetén például: 
 * 6 10 50 30 7
 * A közönségben mindenki kap egy szavazócédulát, melyen kitöltheti a kategóriát és a 
 * versenyzõ sorszámát. A cédulát egy ládikába kell bedobni. A ládikában lévõ cédulák
 * száma tetszõleges.
 * Készítsünk egy olyan programot, amely feldolgozza és kiértékeli a szavazócédulákat!
 * -Elõször vigyük be a szavazócédulák adatait (rossz adatokat tartalmazó cédulák nem vesznek 
 * részt a szavazásban!
 * Végül készítsünk kimutatást:
 * - Kategóriánként és versenyzõnként írjuk ki a szavazatok számát!
 * - Írjuk ki azon versenyzõk kategóriáját és sorszámát, akik a legtöbb szavazatot kapták a
 * teljes mezõnyben! (Egyforma eredmény esetén mindegyiket írjuk ki!)
 * - Mely kategória kapta összesen a legtöbb szavazatot? (Egyforma eredmény esetén mind-
 * egyiket írjuk ki!)
 * 
 */
import extra.*;

class Szavazatok {
	private int			katSzam;
	private int[][]	szavazat;

	public Szavazatok(String[] versenyzokSzama) {
		System.out.println(versenyzokSzama.length);
		katSzam = versenyzokSzama.length;
		// Kategóriák létrehozása:
		szavazat = new int[katSzam + 1][]; // 0. kategória nincs
		// Kategóriánként résztömb létrehozása:
		for (int k = 1; k <= katSzam; k++)
			szavazat[k] = new int[Integer.parseInt(versenyzokSzama[k - 1])];
	}

	public void feldolgozas() {
		int kat, vsz;
		int cedulaDb=0;
		do {
			//kat = Console.readInt("Kategória : ");
			kat=(int) ((Math.random()*katSzam)+1);
			if (kat == 0)
				continue;
			if (kat < 1 || kat > katSzam) {
				System.out.println("Rossz kategória!");
				continue;
			}
			//vsz = Console.readInt("Versenyzõ : ");
			vsz=(int) (Math.random()*szavazat[kat].length);
			if (vsz < 0 || vsz >= szavazat[kat].length) {
				System.out.println("Rossz versenyzõ sorszám!");
				continue;
			}
			szavazat[kat][vsz]++; // a megfelelõ érték növelése
			cedulaDb++;
		} while (cedulaDb<200);
	}

	public void print() {
		for (int i = 1; i <= katSzam; i++) {
			System.out.println("\nSzavazatok az " + i + ". kategóriában");
			// A versenyzõk sorszámainak kiírása
			System.out.print("Vers. sorszáma:  ");
			for (int j = 0; j < szavazat[i].length; j++)
				System.out.print(Format.right(j, 3));
			System.out.println();

			// A versenyzõk szavazatainak kiírása:
			System.out.print("Szavazatok     : ");
			for (int j = 0; j < szavazat[i].length; j++)
				System.out.print(Format.right(szavazat[i][j], 3));
			System.out.println();
			System.out.println("Összesen: " + kategoriaOssz(i) + " szav.");
		}
	}

	public void gyoztesVersenyzok() {
		// Maximális érték meghatározása
		int max = 0;
		for (int i = 1; i < szavazat.length; i++)
			for (int j = 0; j < szavazat[i].length; j++)
				if (szavazat[i][j] > max)
					max = szavazat[i][j];
		// A gyõztesek kiírása
		System.out.println("Gyõztes versenyzõk:");
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
		System.out.println("Gyõztes kategóriák:");
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
