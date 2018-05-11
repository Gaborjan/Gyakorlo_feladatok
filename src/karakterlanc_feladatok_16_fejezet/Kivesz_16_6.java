package karakterlanc_feladatok_16_fejezet;

/*�rjunk f�ggv�nyt, amely a param�terk�nt megadott karakterl�ncb�l kiveszi a m�sodik param�terk�nt megadott karakterl�ncot. 
 * A f�ggv�ny az eredeti sztringet hagyja �rtintetlen�l, a megv�ltoztatott sztringet adja vissza eredm�nyk�nt.  
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
