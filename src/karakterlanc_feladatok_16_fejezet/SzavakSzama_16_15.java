package karakterlanc_feladatok_16_fejezet;

/* �rjon f�ggv�nyt, mely megsz�molja, h�ny sz� van a param�terk�nt megadott sz�vegben! 
 * A szavakat egy vagy t�bb feh�r sz�k�z v�lasztja el egym�st�l.
 */
import extra.*;
import java.util.*;

public class SzavakSzama_16_15 {

	public static int szavakSzama(String szoveg) {
		StringTokenizer st = new StringTokenizer(szoveg);
		return st.countTokens();
	}
	public static void main(String[] args) {
		String szoveg;
		szoveg=Console.readLine("K�rem a sz�veget: ");
		System.out.println("Szavak sz�ma a sz�vegben: "+szavakSzama(szoveg));

	}

}
