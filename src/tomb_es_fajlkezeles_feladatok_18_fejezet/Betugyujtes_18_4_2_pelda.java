package tomb_es_fajlkezeles_feladatok_18_fejezet;

/* Kérjünk be egy szöveget, majd írjuk ki, hogy A-tól Z-ig melyik betûbõl hány van a szövegben! A kis- és nagybetûket ne
 * különböztessük meg, és a nem ebbe a tartományba esõ karaktereket ne számoljuk!
 */
import extra.*;

public class Betugyujtes_18_4_2_pelda {

	public static void main(String[] args) {
		String szoveg=Console.readLine("Kérem a szöveget: ");
		int[] karakterek = new int['Z'-'A'];
		char karakter;
		for (int i=0;i<karakterek.length;i++)
			System.out.println(karakterek[i]);
		for (int i=0; i<szoveg.length();i++) {
			karakter=Character.toUpperCase(szoveg.charAt(i));
			if (karakter>='A' && karakter<='Z')
				karakterek[karakter-'A']++;
		}
		for (int i=0;i<karakterek.length;i++)
			if (karakterek[i]!=0)
				System.out.println((char) ('A'+i) +": "+karakterek[i]);
	}

}
