package iteracios_feladatok_14_fejezet;

/*Kérdezze meg a felhasználótól, hogy mennyi pénze van, és milyen évi kamatozással tette azt be a 
 * bankba! Ezután a program ismételten tegye lehetõvé, hogy az illetõ többször megkérdezhesse, melyik évben
 * mennyi pénze lesz?
 */
import extra.*;
public class Kamatozas_14_11 {
	public static void main(String[] args) {
		double osszeg,kamat,kivetelkor;
		int ev;
		System.out.println("A program bekéri a bankba tett összeget és az éves kamatlábat.");
		System.out.println("Ez után megadhatja hány évig tartja bent a pénzét, a program pedig");
		System.out.println("kiszámolja mennyi pénze lesz.");
		osszeg=Console.readDouble("Adja be az összeget: ");
		kamat=Console.readDouble("Adja meg a kamatot: ");
		do {
			do 
				ev=Console.readInt("Adja meg hány évre teszi be a pénzt (kilépés:0): ");
			while (ev<0);
			if (ev>0) {
				kivetelkor=osszeg*Math.pow((100+kamat)/100,ev);
				System.out.printf("A(z) %,4d év. végén a kamattal növelt összeg: %,12.2f Forint \n",ev,kivetelkor);
			}
		} while (ev!=0);			
	}

}
