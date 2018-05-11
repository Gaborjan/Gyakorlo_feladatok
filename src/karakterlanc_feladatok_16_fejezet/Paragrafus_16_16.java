package karakterlanc_feladatok_16_fejezet;

/*Bonstsuk mondatokra egy bekezd�s tartalm�t! Egy mondatot a pont, a felki�lt�jel, vagy a k�rd�jel z�rja le (egy�tt nem
 * alkalmazhat�). �rjuk ki egyenk�nt a mondatokat �s ut�na z�r�jelben a benne l�v� szavak sz�m�t!
 * �s a v�g�re egy k�rd�s?
 * 
 */
import extra.*;
import java.util.*;

public class Paragrafus_16_16 {

	public static void main(String[] args) {
		String bekezdes =
			"Bonstsuk mondatokra egy bekezd�s tartalm�t! Egy mondatot a pont, a felki�lt�jel, vagy a k�rd�jel z�rja le (egy�tt nem " + 
			"alkalmazhat�). �rjuk ki egyenk�nt a mondatokat �s ut�na z�r�jelben a benne l�v� szavak sz�m�t!" + 
			"�s a v�g�re egy k�rd�s?";	
	
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