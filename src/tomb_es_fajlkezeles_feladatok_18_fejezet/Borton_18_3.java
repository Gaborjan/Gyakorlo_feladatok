package tomb_es_fajlkezeles_feladatok_18_fejezet;

/*Egy börtönben 1000 cella van, mindegyikben egy rab ül. Kezdetben minden cella zárva van. A börtönõrnek
 * játszani támad kedve: végigmegy az összes cella elõtt, és mindegyik ajtó zárján fordít egyet. Fordításkor
 * a nyitott cellát bezárja, illetve a zártat kinyítja. Ha végigment, elkezdni elõlrõl, és minden második cella
 * zárján fordít egyet.
 * Aztán minden harmadikon fordít és így tovább. Legvégül fordít egyet az ezrediken és kész. Ezután amelyik cella
 * ajtaja nincs bezárva, abból a rab elmehet. Kik a szerencsés rabok?
 */
import extra.*;

public class Borton_18_3 {
	
	static final int MAXAJTO=1000;
	
	public static void main(String[] args) {
		boolean borton[] = new boolean[MAXAJTO+1];
		int ajto;
		for (int i=1;i<=MAXAJTO;i++)
			borton[i]=false;
		ajto=1;
		for (int j=1;j<=MAXAJTO;j++) {
			for (int i=j;i<=MAXAJTO;i++)  
				if (i%ajto==0) borton[i]=!borton[i];
			ajto++;
		}
			/*System.out.println("AJTÓ: "+j);
			for (int z=1;z<=MAXAJTO;z++)
				System.out.println((borton[z]) ? z+" N":z+" "+ "Z");
			Console.pressEnter();
			ajto++;*/			
		
		for (int i=1;i<=MAXAJTO;i++)
			if (borton[i])				
				System.out.println(i);

	}
}

