package iteracios_feladatok_14_fejezet;

/*K�rj�k be a h�ten mennyi kal�ri�t fogyasztottunk az egyes napokon! Ezut�n �rjuk ki az �sszes
 * kal�riafogyaszt�sunkat, valamint a napi �tlag fogyaszt�st! 
 */
import extra.*;

public class Kaloria_14_4 {
	public static void main(String[] args) {
		final int MINKAL=0;
		final int MAXKAL=5000;
		int napi=0, heti=0;
		double atlag=0;
		System.out.println("A program bek�ri a napi kal�riafogyaszt�st, majd a v�g�n ki�rja a mennyi kal�ri�t");
		System.out.println("fogyasztottunk a h�ten �sszesen, �s ez milyen napi kal�riabevitelt jelent �tlagosan.");
		System.out.println("Csak eg�sz �rt�k� kal�ri�t vigyen be, min. 0, max. 5000 kcal/nap.");
		for (int i=1;i<=7;i++) { 
			do
				napi=Console.readInt("K�rem a "+i+". napi kal�ri�t: ");
			while (napi<MINKAL || napi>MAXKAL);
			heti+=napi;
		}
		atlag=heti/7;
		System.out.printf("Heti kal�riabevitel: %10d kcal \n",heti);
		System.out.printf("Napi �tlag         : %,10.2f kcal \n",atlag);
		System.out.println("Program v�ge:");
		Console.pressEnter();
	}

}

