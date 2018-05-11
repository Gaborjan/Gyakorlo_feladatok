package tomb_es_fajlkezeles_feladatok_18_fejezet;

/*Egy b�rt�nben 1000 cella van, mindegyikben egy rab �l. Kezdetben minden cella z�rva van. A b�rt�n�rnek
 * j�tszani t�mad kedve: v�gigmegy az �sszes cella el�tt, �s mindegyik ajt� z�rj�n ford�t egyet. Ford�t�skor
 * a nyitott cell�t bez�rja, illetve a z�rtat kiny�tja. Ha v�gigment, elkezdni el�lr�l, �s minden m�sodik cella
 * z�rj�n ford�t egyet.
 * Azt�n minden harmadikon ford�t �s �gy tov�bb. Legv�g�l ford�t egyet az ezrediken �s k�sz. Ezut�n amelyik cella
 * ajtaja nincs bez�rva, abb�l a rab elmehet. Kik a szerencs�s rabok?
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
			/*System.out.println("AJT�: "+j);
			for (int z=1;z<=MAXAJTO;z++)
				System.out.println((borton[z]) ? z+" N":z+" "+ "Z");
			Console.pressEnter();
			ajto++;*/			
		
		for (int i=1;i<=MAXAJTO;i++)
			if (borton[i])				
				System.out.println(i);

	}
}

