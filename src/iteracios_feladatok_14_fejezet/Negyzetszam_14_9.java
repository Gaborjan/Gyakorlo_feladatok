package iteracios_feladatok_14_fejezet;

/*Kérjen be egy számot és mondja meg hány darab négyzetszám van eddig a számig és írja is ki õket.
 * a) sorban egymás után
 * b) úgy hogy egy sorban csak 5 szám szerepeljen és a számok 6 hosszon legyenek kiírva, jobbra igazítva.
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
			n=Console.readInt("Kérem a számot: (1-"+MAXBE+")");
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
