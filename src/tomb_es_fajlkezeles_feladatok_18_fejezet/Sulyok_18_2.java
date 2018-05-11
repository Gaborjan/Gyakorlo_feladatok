package tomb_es_fajlkezeles_feladatok_18_fejezet;

import extra.Console;

/*M�rj�k meg 10 db alma s�ly�t, �s a m�rt �rt�keket sorban vigy�k be . K�rd�s, melyik alma s�lya t�r el legjobban az �tlagt�l?
 * �rjuk ki a k�rd�ses alma sorsz�m�t �s az elt�r�st az �tlagt�l (ha t�bb van, akkor csak az els�t.)
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
			almak[i]=Console.readDouble("K�rem a(z) "+i+". alma s�ly�t grammban: ");
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
		System.out.printf("Az �ltagos alma s�ly: %,4.2f gramm\n",atlag);
		System.out.printf("Ett�l a legjobban elt�r a(z) %2d sz�m� alma, %4.2f grammal.",maxAlma, almak[maxAlma]-atlag);
		
	}	
}


