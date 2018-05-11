package iteracios_feladatok_14_fejezet;

/*Készítsen egy pénzbedobó automatát. Elõször kérje be a bedobandó összeget. Az automatába csak 5, 10, 20, 50, 100 és 200 Ft-ost
 * lehet bedobni, ha más pénzt dobnak ble, azt visszaadja. Addig kérje az automata a pénzt, amíg a bedobott összeg el nem
 * éri a kívánt összeget. Közben folyamatosan tájékoztassuk a bedobót, hogy mennyit kell még bedobnia! Végül, ha a
 * bedobó több pénzt dobott be, akkor a visszajáró összeget az automata visszaadja.
 */
import extra.*;
public class Penzautomata {

	public static void main(String[] args) {
		final  int MINAR=5, MAXAR=2000;
		int termekAr=0;
		int bedobott=0;
		int penz;
		boolean joErme=false;
		boolean joAr=false;
		System.out.println("P É N Z B E D O B Ó   S Z I M U L Á C I Ó");
		System.out.println("-----------------------------------------\n");
		do {
			termekAr=Console.readInt("Kérem a termék árát ( "+MINAR+" Ft - "+MAXAR+" Ft ) : ");
			joAr=((termekAr%5)==0) && (termekAr>=MINAR && termekAr<=MAXAR);
			if (!joAr) System.out.println("Érvénytelen ár! Öttel oszthatónak kell lennie "+MINAR+" Ft és "+MAXAR+ " Ft között!");
		} while (!joAr);
		System.out.println("\n ---- A TERMÉK ÁRA: "+termekAr+" Forint ----\n");
		while (bedobott<termekAr) {
			do {
				System.out.printf("Még ennyit kell bedobnia: %,10d Ft -->>  ",(termekAr-bedobott));
				penz=Console.readInt("Kérem a pénzt (5,10,20,100,200):");
				joErme = penz == 5 || penz == 10 || penz==20 || penz == 50 || penz == 100 || penz==200;
				System.out.println(" * * * Érmevizsgálat * * * ");
				try        
				{
				    Thread.sleep(250);
				} 
				catch(InterruptedException ex) 
				{
				    Thread.currentThread().interrupt();
				}
				if (!joErme) System.out.println("NEM JÓ ÉRME! :( ");
			} while (!joErme);
			bedobott+=penz;
		}
		if (bedobott>termekAr) System.out.printf("\n\n Köszönöm! :) Visszajáró összeg: %,10d Ft\n",(bedobott-termekAr));
		else
			System.out.println("\n\n Köszönöm! :) Nincs visszajáró! \n");
		System.out.println("\nProgram vége:");
		Console.pressEnter();
	}
}
