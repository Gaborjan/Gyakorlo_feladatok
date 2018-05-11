package iteracios_feladatok_14_fejezet;

/*Van egy bizonyos �sszeg�nk, amelyb�l sz�ml�kat szeretn�nk kifizetni de maximum t�zet. K�rje be a rendelkez�sre �ll� �sszeget, majd sorban a 
 * sz�mla�sszegeket! Ha a sz�ml�k sz�ma el�ri a t�zet, vagy az adott sz�ml�ra m�r nincs p�nz, adjon a program egy figyelmeztet�st.
 * V�g�l �rja ki, h�ny sz�ml�t siker�lt kifizetni �s mennyi a t�nylegesen kifizetend� �sszeg.
 */
import extra.*;

public class Szamla_Kifizetes_14_13 {
	public static void main(String[] args) {
		final int MAXDB=10; // ennyi lehet a sz�ml�k darabsz�ma
		final double MINPENZ=1; // P�nz �s sz�mla�sszeg legkisebb �sszege
		final double MAXPENZ=100000000; // P�nz �s sz�mla�sszeg legnagyobb �sszege
		double penz, // rendelkez�sre �ll� �sszeg
		szamlaOsszeg=0, //egy sz�mla �sszege
		kifSzamlaOsszeg=0; //kifizetett sz�mlak osszege
		int szamlaDb=0; //ennyi sz�ml�t tudtunk kifizetni
		boolean vanPenz=false; // Van m�g p�nz a sz�ml�ra
		System.out.println("A program bek�ri a sz�ml�k kifizet�s�re rendelkez�sre �ll� �sszeget.");
		System.out.println("Majd egyes�vel bek�ri a sz�ml�k �sszeg�t, maximum "+MAXDB+" darab sz�mla lehet.");
		System.out.println("Ha az adott sz�mla kifizet�s�re m�r nincs p�nz, vagy a sz�ml�k darabsz�ma el�ri a ");
		System.out.println(MAXDB+"-t a program ki�rja h�ny sz�ml�t siker�lt kifizetni, mekkora �sszegben.");
		do {
			penz=Console.readDouble("K�rem a rendelkez�sre �ll� �sszeget ("+ (long) MINPENZ+"-"+(long) MAXPENZ+"): ");
		} while (penz<MINPENZ || penz>MAXPENZ);
		do {
			do 
				szamlaOsszeg=Console.readDouble("K�rem a(z) "+(szamlaDb+1)+". sz�mla �sszeg�t ("+(long) MINPENZ+"-"+(long) MAXPENZ+") :");
			while (szamlaOsszeg<MINPENZ || szamlaOsszeg>MAXPENZ);
			vanPenz=kifSzamlaOsszeg+szamlaOsszeg<=penz;
			if (szamlaDb<MAXDB && vanPenz) {
				szamlaDb++;
				kifSzamlaOsszeg+=szamlaOsszeg;
				vanPenz=kifSzamlaOsszeg<penz;
			}
		} while (szamlaDb<MAXDB && vanPenz);
		System.out.printf("Rendelkez�sre �ll� �sszeg: %,10.2f Forint \n",penz);
		System.out.printf("Kifizetett sz�ml�k sz�ma : %10d Darab \n", szamlaDb);
		System.out.printf("Felhaszn�lt �sszeg       : %,10.2f Forint\n", kifSzamlaOsszeg);
		System.out.println("Program v�ge:");
		Console.pressEnter();
	}
}
