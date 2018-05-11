package tomb_es_fajlkezeles_feladatok_18_fejezet;


/* K�rjen be egy sz�mot, majd �rja ki eddig a sz�mig az �sszes pr�msz�mot! Minden pr�m el� �rja ki, hogy h�nyadik pr�m.
 * Oldjuk meg a feladatot az Eratoszthen�szi szita seg�ts�g�vel. Vegy�nk fel 
 *  egy t�mb�t, ahol minden sz�mhoz (indexhez) egy logikai �rt�k tartozik, jelezv�n, hogy a sz�m pr�m-e. Kezdetben
 *  minden elemet true-ra kell �ll�tani. Menj�nk v�gig a t�mb�n, �s �ll�tsuk be a 2 t�bbsz�r�seihez tartoz� �rt�keket
 *  false-ra. Ugyanezt v�gezz�k el a 3 t�bbsz�r�seire �s �gy tov�bb. Csak a m�g pr�m �rt�kek t�bbsz�r�seit n�zz�k! V�g�l
 *  a true rekeszek indexei lesznek a pr�msz�mok.
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
			darab = Console.readInt("Add meg meddig keressek pr�msz�mokat (0-" + MAXDARAB + "): ");
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
					System.out.printf("%,6d. pr�msz�m: %,6d\n",szamlalo,i);
					szamlalo++;
				}
		}
		else if (darab==1 || darab==2)
			System.out.println("A 2 a legkisebb pr�msz�m. Az 1 nem pr�m.");
	}

}
