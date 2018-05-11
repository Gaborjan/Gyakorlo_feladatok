package tomb_es_fajlkezeles_feladatok_18_fejezet;


/* Kérjen be egy számot, majd írja ki eddig a számig az összes prímszámot! Minden prím elé írja ki, hogy hányadik prím.
 * Oldjuk meg a feladatot az Eratoszthenészi szita segítségével. Vegyünk fel 
 *  egy tömböt, ahol minden számhoz (indexhez) egy logikai érték tartozik, jelezvén, hogy a szám prím-e. Kezdetben
 *  minden elemet true-ra kell állítani. Menjünk végig a tömbön, és állítsuk be a 2 többszöröseihez tartozó értékeket
 *  false-ra. Ugyanezt végezzük el a 3 többszöröseire és így tovább. Csak a még prím értékek többszöröseit nézzük! Végül
 *  a true rekeszek indexei lesznek a prímszámok.
 */
import extra.*;

public class Primek_18_6_feladat {

	public static void main(String[] args) {
		final int MAXDARAB = 1000000;
		boolean primtomb[];
		int darab;
		int oszto;
		int szamlalo;
		do
			darab = Console.readInt("Add meg meddig keressek prímszámokat (0-" + MAXDARAB + "): ");
		while (darab < 0 || darab > MAXDARAB);
		if (darab>2) {
			primtomb = new boolean[darab+1];
			for (int i = 1; i <= darab; i++)
				primtomb[i] = true;
			oszto = 2;
			do {
				for (int i=oszto+1;i<=darab;i++)
					if (primtomb[i]) 
						primtomb[i]=!((i%oszto)==0);
				oszto++;
			} while (oszto < Math.sqrt(darab));
			primtomb[2]=true;
			szamlalo=1;
			for (int i=2;i<=darab;i++)
				if (primtomb[i]) { 
					System.out.printf("%,6d. prímszám: %,6d\n",szamlalo,i);
					szamlalo++;
				}
		}
		else if (darab==1 || darab==2)
			System.out.println("A 2 a legkisebb prímszám. Az 1 nem prím.");
	}

}
