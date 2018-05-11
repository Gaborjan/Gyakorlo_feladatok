package karakterlanc_feladatok_16_fejezet;

/*Bonstsuk mondatokra egy bekezdés tartalmát! Egy mondatot a pont, a felkiáltójel, vagy a kérdõjel zárja le (együtt nem
 * alkalmazható). Írjuk ki egyenként a mondatokat és utána zárójelben a benne lévõ szavak számát!
 * És a végére egy kérdés?
 * 
 */
import extra.*;
import java.util.*;

public class Paragrafus_16_16 {

	public static void main(String[] args) {
		String bekezdes =
			"Bonstsuk mondatokra egy bekezdés tartalmát! Egy mondatot a pont, a felkiáltójel, vagy a kérdõjel zárja le (együtt nem " + 
			"alkalmazható). Írjuk ki egyenként a mondatokat és utána zárójelben a benne lévõ szavak számát!" + 
			"És a végére egy kérdés?";	
	
		StringTokenizer szoveg = new StringTokenizer(bekezdes,".?!",true);
		int szavakSzama=0;
		String mondat;
		while (szoveg.hasMoreTokens()) {
			mondat = szoveg.nextToken();
			if (szoveg.hasMoreTokens())
		        mondat = (mondat+szoveg.nextToken()).trim();
			System.out.println(mondat);
		}
	}

}