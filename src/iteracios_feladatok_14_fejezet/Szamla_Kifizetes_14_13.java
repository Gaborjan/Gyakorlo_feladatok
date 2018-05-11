package iteracios_feladatok_14_fejezet;

/*Van egy bizonyos összegünk, amelybõl számlákat szeretnénk kifizetni de maximum tízet. Kérje be a rendelkezésre álló összeget, majd sorban a 
 * számlaösszegeket! Ha a számlák száma eléri a tízet, vagy az adott számlára már nincs pénz, adjon a program egy figyelmeztetést.
 * Végül írja ki, hány számlát sikerült kifizetni és mennyi a ténylegesen kifizetendõ összeg.
 */
import extra.*;

public class Szamla_Kifizetes_14_13 {
	public static void main(String[] args) {
		final int MAXDB=10; // ennyi lehet a számlák darabszáma
		final double MINPENZ=1; // Pénz és számlaösszeg legkisebb összege
		final double MAXPENZ=100000000; // Pénz és számlaösszeg legnagyobb összege
		double penz, // rendelkezésre álló összeg
		szamlaOsszeg=0, //egy számla összege
		kifSzamlaOsszeg=0; //kifizetett számlak osszege
		int szamlaDb=0; //ennyi számlát tudtunk kifizetni
		boolean vanPenz=false; // Van még pénz a számlára
		System.out.println("A program bekéri a számlák kifizetésére rendelkezésre álló összeget.");
		System.out.println("Majd egyesével bekéri a számlák összegét, maximum "+MAXDB+" darab számla lehet.");
		System.out.println("Ha az adott számla kifizetésére már nincs pénz, vagy a számlák darabszáma eléri a ");
		System.out.println(MAXDB+"-t a program kiírja hány számlát sikerült kifizetni, mekkora összegben.");
		do {
			penz=Console.readDouble("Kérem a rendelkezésre álló összeget ("+ (long) MINPENZ+"-"+(long) MAXPENZ+"): ");
		} while (penz<MINPENZ || penz>MAXPENZ);
		do {
			do 
				szamlaOsszeg=Console.readDouble("Kérem a(z) "+(szamlaDb+1)+". számla összegét ("+(long) MINPENZ+"-"+(long) MAXPENZ+") :");
			while (szamlaOsszeg<MINPENZ || szamlaOsszeg>MAXPENZ);
			vanPenz=kifSzamlaOsszeg+szamlaOsszeg<=penz;
			if (szamlaDb<MAXDB && vanPenz) {
				szamlaDb++;
				kifSzamlaOsszeg+=szamlaOsszeg;
				vanPenz=kifSzamlaOsszeg<penz;
			}
		} while (szamlaDb<MAXDB && vanPenz);
		System.out.printf("Rendelkezésre álló összeg: %,10.2f Forint \n",penz);
		System.out.printf("Kifizetett számlák száma : %10d Darab \n", szamlaDb);
		System.out.printf("Felhasznált összeg       : %,10.2f Forint\n", kifSzamlaOsszeg);
		System.out.println("Program vége:");
		Console.pressEnter();
	}
}
