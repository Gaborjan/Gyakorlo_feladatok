package iteracios_feladatok_14_fejezet;

/*Sheran hindu király meg akarta jutalmazni a sakkjáték feltalálóját, és rábízta, hogy õ maga válassza meg a jutalmát. A bölcs
 * ember így válaszolt: A sakktábla elsõ mezõjéért csak egy búzaszemet adj uram!  A másodikért 2-t, a harmadikért 4-et, stb.
 * minden mezõért kétszer annyit, mint az elõzõért. Számoljunk utána, mennyi is volt pontosan a jutalom?
 * A sakktábla vízszintes koordinátái: A..H, függõleges koordinátái: 1..8.
 * Ciklusban kérjük be a felhasználótól milyen koordinátára kíváncsi, és minden esetben írjuk ki az eredményt! A programnak
 * akkor legyen vége, ha a bevitel vízszintes koordinátánál a * karaktert ütik be!
 */
import extra.*;

public class Buzaszemek {
	public static void main(String[] args) {
		double buzaSzem;
		char oszlop=' ';
		int sor;
		while (oszlop!='*') {
			do 
				oszlop=Console.readChar("Melyik oszlop legyen A..H ( Kilépés--> * ):");
			while ((Character.toUpperCase(oszlop)<'A' || Character.toUpperCase(oszlop)>'H') && (oszlop!='*'));
			if (oszlop=='*') continue;
			else {
				do
					sor=Console.readInt("Melyik sor legyen (1..8)?");
				while (sor<1 || sor>8);
			buzaSzem=Math.pow(2, ((Character.toUpperCase(oszlop)-'A')*8)+sor-1);	
			System.out.print("A(z) "+Character.toUpperCase(oszlop)+" sor "+sor+". oszlopában lévõ búzaszemek száma: ");
			System.out.printf("%,20.0f\n",buzaSzem);
			}
		}
		System.out.println("Program vége!");
	}
}
