package tomb_es_fajlkezeles_feladatok_18_fejezet;

import extra.Console;

/*Mérjük meg 10 db alma súlyát, és a mért értékeket sorban vigyük be . Kérdés, melyik alma súlya tér el legjobban az átlagtól?
 * Írjuk ki a kérdéses alma sorszámát és az eltérést az átlagtól (ha több van, akkor csak az elsõt.)
 * 
 */
public class Sulyok_18_2 {

	public static void main(String[] args) {
		double[] almak = new double[11];
		double 	atlag,
					maxElteres;
				
		int
					maxAlma;
		for (int i=1;i<=10;i++)
			almak[i]=Console.readDouble("Kérem a(z) "+i+". alma súlyát grammban: ");
		atlag = 0;
		for (int i=1;i<=10;i++)
			atlag=atlag+almak[i];
		atlag=atlag/10;
		maxElteres=Math.abs(atlag-almak[1]);
		maxAlma=1;
		for (int i=1;i<=10;i++)
			if (Math.abs(atlag-almak[i])>maxElteres) {
				maxElteres=Math.abs(atlag-almak[i]);
				maxAlma=i;
			}
		System.out.printf("Az áltagos alma súly: %,4.2f gramm\n",atlag);
		System.out.printf("Ettõl a legjobban eltér a(z) %2d számú alma, %4.2f grammal.",maxAlma, almak[maxAlma]-atlag);
		
	}	
}


