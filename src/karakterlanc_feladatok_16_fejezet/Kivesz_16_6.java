package karakterlanc_feladatok_16_fejezet;

/*Írjunk függvényt, amely a paraméterként megadott karakterláncból kiveszi a második paraméterként megadott karakterláncot. 
 * A függvény az eredeti sztringet hagyja értintetlenül, a megváltoztatott sztringet adja vissza eredményként.  
 */
import extra.*;
public class Kivesz_16_6 {
	public static String torol(StringBuilder szoveg, String torlendo) {
		StringBuilder seged = new StringBuilder(szoveg.toString());
		int poz;
		poz=seged.indexOf(torlendo);
		while (poz!=-1) {
			seged.delete(poz, poz+torlendo.length());
			poz=seged.indexOf(torlendo);
		}
		
		return seged.toString();
	}
	public static void main(String[] args) {
		StringBuilder szoveg;
		szoveg = new StringBuilder("");
		szoveg.append("Hello Gabika Tibike Gabika!");
		System.out.println(torol(szoveg," Gabika"));
		System.out.println(szoveg.toString());
	}

}
