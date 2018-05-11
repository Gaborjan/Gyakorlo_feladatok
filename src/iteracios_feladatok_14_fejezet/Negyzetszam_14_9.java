package iteracios_feladatok_14_fejezet;

/*K�rjen be egy sz�mot �s mondja meg h�ny darab n�gyzetsz�m van eddig a sz�mig �s �rja is ki �ket.
 * a) sorban egym�s ut�n
 * b) �gy hogy egy sorban csak 5 sz�m szerepeljen �s a sz�mok 6 hosszon legyenek ki�rva, jobbra igaz�tva.
 * 
 */
import extra.*;

public class Negyzetszam_14_9 {
	public static void main(String[] args) {
		final int MAXBE=9999;
		final int OSZLOPDB=15;
		int n,db=0;
		int sordb=0;
		do 
			n=Console.readInt("K�rem a sz�mot: (1-"+MAXBE+")");
		while (n<1 || n>MAXBE);
		for (int i=1;i<=n;i++) {
			if ((Math.sqrt(i)%1)==0) 
				System.out.println(i);
		}
		Console.pressEnter();
		db=0;
		for (int i=1;i<=n;i++) {
			if ((Math.sqrt(i)%1)==0) {
				System.out.printf("%6d",i);
				sordb++;
			}
			if (sordb==OSZLOPDB) {
				sordb=0;
				System.out.println();
			}
		}
		System.out.println();
		Console.pressEnter();
	}

}
