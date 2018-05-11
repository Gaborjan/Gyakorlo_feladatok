package iteracios_feladatok_14_fejezet;

/*K�sz�tsen egy p�nzbedob� automat�t. El�sz�r k�rje be a bedoband� �sszeget. Az automat�ba csak 5, 10, 20, 50, 100 �s 200 Ft-ost
 * lehet bedobni, ha m�s p�nzt dobnak ble, azt visszaadja. Addig k�rje az automata a p�nzt, am�g a bedobott �sszeg el nem
 * �ri a k�v�nt �sszeget. K�zben folyamatosan t�j�koztassuk a bedob�t, hogy mennyit kell m�g bedobnia! V�g�l, ha a
 * bedob� t�bb p�nzt dobott be, akkor a visszaj�r� �sszeget az automata visszaadja.
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
		System.out.println("P � N Z B E D O B �   S Z I M U L � C I �");
		System.out.println("-----------------------------------------\n");
		do {
			termekAr=Console.readInt("K�rem a term�k �r�t ( "+MINAR+" Ft - "+MAXAR+" Ft ) : ");
			joAr=((termekAr%5)==0) && (termekAr>=MINAR && termekAr<=MAXAR);
			if (!joAr) System.out.println("�rv�nytelen �r! �ttel oszthat�nak kell lennie "+MINAR+" Ft �s "+MAXAR+ " Ft k�z�tt!");
		} while (!joAr);
		System.out.println("\n ---- A TERM�K �RA: "+termekAr+" Forint ----\n");
		while (bedobott<termekAr) {
			do {
				System.out.printf("M�g ennyit kell bedobnia: %,10d Ft -->>  ",(termekAr-bedobott));
				penz=Console.readInt("K�rem a p�nzt (5,10,20,100,200):");
				joErme = penz == 5 || penz == 10 || penz==20 || penz == 50 || penz == 100 || penz==200;
				System.out.println(" * * * �rmevizsg�lat * * * ");
				try        
				{
				    Thread.sleep(250);
				} 
				catch(InterruptedException ex) 
				{
				    Thread.currentThread().interrupt();
				}
				if (!joErme) System.out.println("NEM J� �RME! :( ");
			} while (!joErme);
			bedobott+=penz;
		}
		if (bedobott>termekAr) System.out.printf("\n\n K�sz�n�m! :) Visszaj�r� �sszeg: %,10d Ft\n",(bedobott-termekAr));
		else
			System.out.println("\n\n K�sz�n�m! :) Nincs visszaj�r�! \n");
		System.out.println("\nProgram v�ge:");
		Console.pressEnter();
	}
}
