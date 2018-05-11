package karakterlanc_feladatok_16_fejezet;


/*Egy szövegsor egy hallgató nevét és Programozás érdemjegyeit tartalmazza. A hallgató neve után
 * egy kettõspont áll, majd szóközzel elválasztva jön akárhány darab 1 és 5 közötti érdemjegy. Az utolsó
 * érdemjegy végén * áll, majd jön a következõ hallgató. Feltehetjük, hogy az elválasztó karakterek helyesen
 * vannak megadva, de a programnak kezelnie kell, ha a név teljesen üres és/vagy egyetlen érdemjegy sem 
 * szerepel. (Ilyenkor legyen utalás arra, hogy nem találtunk adatot.
 * (Kérjük be ezt a sort), majd írjuk ki a hallgató nevét és jegyeinek átlagát!
 * Többféle megoldás
 * 
 */
import extra.*;
import java.util.*;

public class JegyekAtlaga_16_17 {

	static String allomany = "Kis István Miklós:*:*:2 5 1 1 1 3*Horváth Péter János:4 5 3 2 4 5 5 2*Jánvári Gabika:4 5 5 5 5 4"; // Adatok,
	                                                                                                                                // amit
	                                                                                                                                // minden
	                                                                                                                                // metódus
	                                                                                                                                // használ

	/*
	 * Ez a metódus a StringTokenizert használja, de azt is ellenõrzi van-e név és
	 * van-e érdemjegy.
	 */
	static void atlag_Szamol_Vegyes(String szoveg) {

		int osszeg = 0, // jegyek összege, átlagszámításhoz
		      darab = 0, // egy tanuló jegyeinek száma
		      sorsz = 0, // ennyi tanuló van
		      atlagdb = 0; // ennyi tanulónak van átlaga

		double osztaly = 0, // osztályátlaghoz
		      atlag = 0; // egy tanuló átlaga

		StringBuilder seged = new StringBuilder(); // seged, egy tanuló adatait tesszük bele (név és érdemjegyek)
		StringBuilder nev = new StringBuilder(); // seged, egy tanuló nevét tesszük bele

		StringTokenizer adatok = new StringTokenizer(szoveg, "*"); // az összes adat olvasása, elválasztó a tanulók
		                                                           // adatait elválasztó '*'

		while (adatok.hasMoreTokens()) { // amíg van tanuló adat
			sorsz++; // Volt még tanuló adat, ezért növeljük a tanulók sorszámát.
			seged.append(adatok.nextToken()); // Egy tanuló adatai (név és érdemjegyek)
			StringTokenizer jegyek = new StringTokenizer(seged.substring(seged.indexOf(":") + 1), " "); // a név utáni
			                                                                                            // részt átadjuk
			                                                                                            // további
			                                                                                            // bontogatásra
			nev.append(seged.substring(0, seged.indexOf(":"))); // eltesszuk tanuló nevét
			if (nev.length() == 0)
				nev.append("n.a.");
			darab = jegyek.countTokens(); // A jegyek számának beolvasása
			osszeg = 0;
			for (int i = 1; i <= darab; i++) // A jegyek összeadása
				osszeg = osszeg + Integer.parseInt(jegyek.nextToken());
			if (osszeg == 0) // Ha nem volt egyetlen érdemjegy sem
				System.out.printf("%2d.) %-40s %s", sorsz, nev, "n.a.");
			else {// Név és átlag kiírása
				atlag = (osszeg + 0.0) / darab; // Egy tanuló átlaga
				atlagdb++; // A tanuló átlaga az osztályátlagnál fiygelembe vehetõ
				System.out.printf("%2d.) %-40s %3.2f", sorsz, nev, atlag);
			} // else
			seged.delete(0, seged.length()); // seged törlése
			nev.delete(0, nev.length()); // név törlése
			osztaly = osztaly + atlag; // osztály átlaghoz az átlagok összegét növeljük az aktuális tanuló átlagával
			System.out.println();
		} // while
		if (osztaly > 0)
			System.out.printf("%-45s %3.2f", "Osztályátlag:", (osztaly / atlagdb));
		System.out.println();
	} // atlag_Szamol_Vegyes

	// Ez a metódus csak a tokenizert használja, nem tökéletes, mert érzékeny arra,
	// ha nincs név vagy érdemjegy megadva Ez nem
	// számol osztályátlagot
	static void atlag_Szamol_Tokenes(String szoveg) {

		StringTokenizer adatok = new StringTokenizer(szoveg, "*"); // Egy tanuló neve és érdemjegyeit bontjuk szét a
		                                                           // szövegen belül
		int jegydb = 0, // egy tanuló jegyeinek száma
		      sorsz = 0, // tanuló sorszáma
		      osszeg = 0, // jegyek összege átlaghoz
		      jegy = 0; // egy jegy

		double atlag = 0; // egy tanuló átlaga

		while (adatok.hasMoreTokens()) { // Amíg van tanuló
			StringTokenizer tanulo = new StringTokenizer(adatok.nextToken(), ":"); // Egy tanuló adatait bontogatjuk
			                                                                       // tovább, elválasztó a :
			while (tanulo.hasMoreTokens()) { // Feltesszük, hogy van név megadva
				sorsz++; // Tanuló sorszámát növeljük
				System.out.printf("%2d.)  %-40s", sorsz, tanulo.nextToken()); // Név kiírása
				osszeg = 0; // Jegyek összege
				StringTokenizer jegyek = new StringTokenizer(tanulo.nextToken(), " "); // Feltesszük, hogy van legalább egy
				                                                                       // jegy és nekiállunk bontogatni
				jegydb = jegyek.countTokens();
				while (jegyek.hasMoreTokens()) { // Amíg van érdemjegy
					jegy = Integer.parseInt(jegyek.nextToken()); // Egy érdemjegy
					osszeg = osszeg + jegy;
				} // while
				atlag = (osszeg + 0.0) / jegydb;
				System.out.printf("%3.2f", atlag);
			}
			System.out.println();
		} // while
	}// atlag_Szamol_Tokenes

	// Ez a metódus a string típus split metódusát használja, nem a tokenizert

	static void atlag_Szamol_Splites(String szoveg) {
		int atlagdb = 0, // számoljuk hány tanulónak volt átlaga
		      jegydb = 0, // egy tanuló jegyeinek száma
		      sorsz = 0, // tanuló sorszáma
		      osszeg = 0, // jegyek összege átlaghoz
		      jegy = 0; // egy jegy

		double osztaly = 0, // osztályátlaghoz az egyes átlagok összege
		      atlag = 0; // egy tanuló átlaga

		StringBuilder jegyek = new StringBuilder(); // Jegyek tárolására szolgáló segéd
		StringBuilder nev = new StringBuilder(); // Tanuló nvének tárolására szolgáló seged

		String[] tanulok; // Seged tömb, amibe majd tanulók adatai kerülnek

		tanulok = szoveg.split("\\*"); // A * karakterrel szétválasztjuk az adatsort tanulókra. \ duplán kell, hogy
		                               // csillag karakternek vegye!
		if (tanulok[0].equals(""))
			return; // Ha teljesen üres az adatsor, akkor nincs mit vizsgálni
		for (int i = 0; i < tanulok.length; i++) { // Ciklus tanuló darabszor
			jegyek.append(tanulok[i].substring(tanulok[i].indexOf(":") + 1)); // jegyek leválasztása tanuló adatokból
			nev.append(tanulok[i].substring(0, tanulok[i].indexOf(":"))); // név leválasztása a tanuló adatokból
			if (nev.length() == 0)
				nev.append("n.a.");
			if (jegyek.length() > 0) { // Csak akkor dolgozzuk fel a jegyeket, ha van benne valami
				String[] jegyTomb; // jegyek tárolására szolgáló tömb
				jegyTomb = jegyek.toString().split("\\s"); // A jegyek szétbontása szóközzel
				osszeg = 0;
				atlag = 0;
				for (int j = 0; j < jegyTomb.length; j++) // Ahány érdemjegy van
					osszeg = osszeg + Integer.parseInt(jegyTomb[j]);
				atlag = (osszeg + 0.0) / jegyTomb.length;
			} // if
			  // Kell egy feltétel arra, hogy volt-e érdemjegy, azaz az átlagba került valami
			if (atlag > 0) {
				System.out.printf("%2d.) %-40s %3.2f", i + 1, nev, atlag);
				osztaly = osztaly + atlag;
				atlagdb++;
			} else
				System.out.printf("%2d.) %-40s %s", (i + 1), nev, "n.a.");
			// seged sztringek nullázása
			jegyek.setLength(0);
			nev.setLength(0);
			System.out.println();
		} // for
		if (osztaly > 0)
			System.out.printf("%-45s %3.2f", "Osztályátlag:", (osztaly / atlagdb));
		System.out.println();
	} // atlag_Szamol_Splites

	public static void main(String[] args) {
		atlag_Szamol_Vegyes(allomany);
		System.out.println("--------------------------------------------------");
		// atlag_Szamol_Tokenes(allomany);
		System.out.println("--------------------------------------------------");
		atlag_Szamol_Splites(allomany);

		/*
		 * int osszeg=0; int jegy=0;
		 * 
		 * String szoveg="Kettõspont1:Kettõspont2:*Csillag1*Csillag2"; StringTokenizer
		 * proba = new StringTokenizer(szoveg); if (proba.hasMoreTokens())
		 * System.out.println("1."+proba.nextToken());
		 */
		/*
		 * System.out.println("2."+proba.nextToken());
		 * System.out.println("3."+proba.nextToken());
		 * System.out.println("4."+proba.nextToken());
		 * System.out.println("5."+proba.nextToken("*"));
		 * System.out.println("6."+proba.nextToken());
		 */
		// szoveg.split("\*");
		// System.out.println(szoveg);
		System.out.println("Program vége");
	}
}
