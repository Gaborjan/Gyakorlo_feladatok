package karakterlanc_feladatok_16_fejezet;


/*Egy sz�vegsor egy hallgat� nev�t �s Programoz�s �rdemjegyeit tartalmazza. A hallgat� neve ut�n
 * egy kett�spont �ll, majd sz�k�zzel elv�lasztva j�n ak�rh�ny darab 1 �s 5 k�z�tti �rdemjegy. Az utols�
 * �rdemjegy v�g�n * �ll, majd j�n a k�vetkez� hallgat�. Feltehetj�k, hogy az elv�laszt� karakterek helyesen
 * vannak megadva, de a programnak kezelnie kell, ha a n�v teljesen �res �s/vagy egyetlen �rdemjegy sem 
 * szerepel. (Ilyenkor legyen utal�s arra, hogy nem tal�ltunk adatot.
 * (K�rj�k be ezt a sort), majd �rjuk ki a hallgat� nev�t �s jegyeinek �tlag�t!
 * T�bbf�le megold�s
 * 
 */
import extra.*;
import java.util.*;

public class JegyekAtlaga_16_17 {

	static String allomany = "Kis Istv�n Mikl�s:*:*:2 5 1 1 1 3*Horv�th P�ter J�nos:4 5 3 2 4 5 5 2*J�nv�ri Gabika:4 5 5 5 5 4"; // Adatok,
	                                                                                                                                // amit
	                                                                                                                                // minden
	                                                                                                                                // met�dus
	                                                                                                                                // haszn�l

	/*
	 * Ez a met�dus a StringTokenizert haszn�lja, de azt is ellen�rzi van-e n�v �s
	 * van-e �rdemjegy.
	 */
	static void atlag_Szamol_Vegyes(String szoveg) {

		int osszeg = 0, // jegyek �sszege, �tlagsz�m�t�shoz
		      darab = 0, // egy tanul� jegyeinek sz�ma
		      sorsz = 0, // ennyi tanul� van
		      atlagdb = 0; // ennyi tanul�nak van �tlaga

		double osztaly = 0, // oszt�ly�tlaghoz
		      atlag = 0; // egy tanul� �tlaga

		StringBuilder seged = new StringBuilder(); // seged, egy tanul� adatait tessz�k bele (n�v �s �rdemjegyek)
		StringBuilder nev = new StringBuilder(); // seged, egy tanul� nev�t tessz�k bele

		StringTokenizer adatok = new StringTokenizer(szoveg, "*"); // az �sszes adat olvas�sa, elv�laszt� a tanul�k
		                                                           // adatait elv�laszt� '*'

		while (adatok.hasMoreTokens()) { // am�g van tanul� adat
			sorsz++; // Volt m�g tanul� adat, ez�rt n�velj�k a tanul�k sorsz�m�t.
			seged.append(adatok.nextToken()); // Egy tanul� adatai (n�v �s �rdemjegyek)
			StringTokenizer jegyek = new StringTokenizer(seged.substring(seged.indexOf(":") + 1), " "); // a n�v ut�ni
			                                                                                            // r�szt �tadjuk
			                                                                                            // tov�bbi
			                                                                                            // bontogat�sra
			nev.append(seged.substring(0, seged.indexOf(":"))); // eltesszuk tanul� nev�t
			if (nev.length() == 0)
				nev.append("n.a.");
			darab = jegyek.countTokens(); // A jegyek sz�m�nak beolvas�sa
			osszeg = 0;
			for (int i = 1; i <= darab; i++) // A jegyek �sszead�sa
				osszeg = osszeg + Integer.parseInt(jegyek.nextToken());
			if (osszeg == 0) // Ha nem volt egyetlen �rdemjegy sem
				System.out.printf("%2d.) %-40s %s", sorsz, nev, "n.a.");
			else {// N�v �s �tlag ki�r�sa
				atlag = (osszeg + 0.0) / darab; // Egy tanul� �tlaga
				atlagdb++; // A tanul� �tlaga az oszt�ly�tlagn�l fiygelembe vehet�
				System.out.printf("%2d.) %-40s %3.2f", sorsz, nev, atlag);
			} // else
			seged.delete(0, seged.length()); // seged t�rl�se
			nev.delete(0, nev.length()); // n�v t�rl�se
			osztaly = osztaly + atlag; // oszt�ly �tlaghoz az �tlagok �sszeg�t n�velj�k az aktu�lis tanul� �tlag�val
			System.out.println();
		} // while
		if (osztaly > 0)
			System.out.printf("%-45s %3.2f", "Oszt�ly�tlag:", (osztaly / atlagdb));
		System.out.println();
	} // atlag_Szamol_Vegyes

	// Ez a met�dus csak a tokenizert haszn�lja, nem t�k�letes, mert �rz�keny arra,
	// ha nincs n�v vagy �rdemjegy megadva Ez nem
	// sz�mol oszt�ly�tlagot
	static void atlag_Szamol_Tokenes(String szoveg) {

		StringTokenizer adatok = new StringTokenizer(szoveg, "*"); // Egy tanul� neve �s �rdemjegyeit bontjuk sz�t a
		                                                           // sz�vegen bel�l
		int jegydb = 0, // egy tanul� jegyeinek sz�ma
		      sorsz = 0, // tanul� sorsz�ma
		      osszeg = 0, // jegyek �sszege �tlaghoz
		      jegy = 0; // egy jegy

		double atlag = 0; // egy tanul� �tlaga

		while (adatok.hasMoreTokens()) { // Am�g van tanul�
			StringTokenizer tanulo = new StringTokenizer(adatok.nextToken(), ":"); // Egy tanul� adatait bontogatjuk
			                                                                       // tov�bb, elv�laszt� a :
			while (tanulo.hasMoreTokens()) { // Feltessz�k, hogy van n�v megadva
				sorsz++; // Tanul� sorsz�m�t n�velj�k
				System.out.printf("%2d.)  %-40s", sorsz, tanulo.nextToken()); // N�v ki�r�sa
				osszeg = 0; // Jegyek �sszege
				StringTokenizer jegyek = new StringTokenizer(tanulo.nextToken(), " "); // Feltessz�k, hogy van legal�bb egy
				                                                                       // jegy �s neki�llunk bontogatni
				jegydb = jegyek.countTokens();
				while (jegyek.hasMoreTokens()) { // Am�g van �rdemjegy
					jegy = Integer.parseInt(jegyek.nextToken()); // Egy �rdemjegy
					osszeg = osszeg + jegy;
				} // while
				atlag = (osszeg + 0.0) / jegydb;
				System.out.printf("%3.2f", atlag);
			}
			System.out.println();
		} // while
	}// atlag_Szamol_Tokenes

	// Ez a met�dus a string t�pus split met�dus�t haszn�lja, nem a tokenizert

	static void atlag_Szamol_Splites(String szoveg) {
		int atlagdb = 0, // sz�moljuk h�ny tanul�nak volt �tlaga
		      jegydb = 0, // egy tanul� jegyeinek sz�ma
		      sorsz = 0, // tanul� sorsz�ma
		      osszeg = 0, // jegyek �sszege �tlaghoz
		      jegy = 0; // egy jegy

		double osztaly = 0, // oszt�ly�tlaghoz az egyes �tlagok �sszege
		      atlag = 0; // egy tanul� �tlaga

		StringBuilder jegyek = new StringBuilder(); // Jegyek t�rol�s�ra szolg�l� seg�d
		StringBuilder nev = new StringBuilder(); // Tanul� nv�nek t�rol�s�ra szolg�l� seged

		String[] tanulok; // Seged t�mb, amibe majd tanul�k adatai ker�lnek

		tanulok = szoveg.split("\\*"); // A * karakterrel sz�tv�lasztjuk az adatsort tanul�kra. \ dupl�n kell, hogy
		                               // csillag karakternek vegye!
		if (tanulok[0].equals(""))
			return; // Ha teljesen �res az adatsor, akkor nincs mit vizsg�lni
		for (int i = 0; i < tanulok.length; i++) { // Ciklus tanul� darabszor
			jegyek.append(tanulok[i].substring(tanulok[i].indexOf(":") + 1)); // jegyek lev�laszt�sa tanul� adatokb�l
			nev.append(tanulok[i].substring(0, tanulok[i].indexOf(":"))); // n�v lev�laszt�sa a tanul� adatokb�l
			if (nev.length() == 0)
				nev.append("n.a.");
			if (jegyek.length() > 0) { // Csak akkor dolgozzuk fel a jegyeket, ha van benne valami
				String[] jegyTomb; // jegyek t�rol�s�ra szolg�l� t�mb
				jegyTomb = jegyek.toString().split("\\s"); // A jegyek sz�tbont�sa sz�k�zzel
				osszeg = 0;
				atlag = 0;
				for (int j = 0; j < jegyTomb.length; j++) // Ah�ny �rdemjegy van
					osszeg = osszeg + Integer.parseInt(jegyTomb[j]);
				atlag = (osszeg + 0.0) / jegyTomb.length;
			} // if
			  // Kell egy felt�tel arra, hogy volt-e �rdemjegy, azaz az �tlagba ker�lt valami
			if (atlag > 0) {
				System.out.printf("%2d.) %-40s %3.2f", i + 1, nev, atlag);
				osztaly = osztaly + atlag;
				atlagdb++;
			} else
				System.out.printf("%2d.) %-40s %s", (i + 1), nev, "n.a.");
			// seged sztringek null�z�sa
			jegyek.setLength(0);
			nev.setLength(0);
			System.out.println();
		} // for
		if (osztaly > 0)
			System.out.printf("%-45s %3.2f", "Oszt�ly�tlag:", (osztaly / atlagdb));
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
		 * String szoveg="Kett�spont1:Kett�spont2:*Csillag1*Csillag2"; StringTokenizer
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
		System.out.println("Program v�ge");
	}
}
