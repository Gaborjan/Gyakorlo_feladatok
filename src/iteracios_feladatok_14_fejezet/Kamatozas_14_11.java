package iteracios_feladatok_14_fejezet;

/*K�rdezze meg a felhaszn�l�t�l, hogy mennyi p�nze van, �s milyen �vi kamatoz�ssal tette azt be a 
 * bankba! Ezut�n a program ism�telten tegye lehet�v�, hogy az illet� t�bbsz�r megk�rdezhesse, melyik �vben
 * mennyi p�nze lesz?
 */
import extra.*;
public class Kamatozas_14_11 {
	public static void main(String[] args) {
		double osszeg,kamat,kivetelkor;
		int ev;
		System.out.println("A program bek�ri a bankba tett �sszeget �s az �ves kamatl�bat.");
		System.out.println("Ez ut�n megadhatja h�ny �vig tartja bent a p�nz�t, a program pedig");
		System.out.println("kisz�molja mennyi p�nze lesz.");
		osszeg=Console.readDouble("Adja be az �sszeget: ");
		kamat=Console.readDouble("Adja meg a kamatot: ");
		do {
			do 
				ev=Console.readInt("Adja meg h�ny �vre teszi be a p�nzt (kil�p�s:0): ");
			while (ev<0);
			if (ev>0) {
				kivetelkor=osszeg*Math.pow((100+kamat)/100,ev);
				System.out.printf("A(z) %,4d �v. v�g�n a kamattal n�velt �sszeg: %,12.2f Forint \n",ev,kivetelkor);
			}
		} while (ev!=0);			
	}

}
