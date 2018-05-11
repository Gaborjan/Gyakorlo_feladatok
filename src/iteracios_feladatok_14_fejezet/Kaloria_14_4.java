package iteracios_feladatok_14_fejezet;

/*Kérjük be a héten mennyi kalóriát fogyasztottunk az egyes napokon! Ezután írjuk ki az összes
 * kalóriafogyasztásunkat, valamint a napi átlag fogyasztást! 
 */
import extra.*;
public class Kaloria_14_4 {
	public static void main(String[] args) {
		final int MINKAL=0;
		final int MAXKAL=5000;
		int napi=0, heti=0;
		double atlag=0;
		System.out.println("A program bekéri a napi kalóriafogyasztást, majd a végén kiírja a mennyi kalóriát");
		System.out.println("fogyasztottunk a héten összesen, és ez milyen napi kalóriabevitelt jelent átlagosan.");
		System.out.println("Csak egész értékû kalóriát vigyen be, min. 0, max. 5000 kcal/nap.");
		for (int i=1;i<=7;i++) { 
			do
				napi=Console.readInt("Kérem a "+i+". napi kalóriát: ");
			while (napi<MINKAL || napi>MAXKAL);
			heti+=napi;
		}
		atlag=heti/7;
		System.out.printf("Heti kalóriabevitel: %10d kcal \n",heti);
		System.out.printf("Napi átlag         : %,10.2f kcal \n",atlag);
		System.out.println("Program vége:");
		Console.pressEnter();
	}

}

