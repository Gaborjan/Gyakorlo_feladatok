package tomb_es_fajlkezeles_feladatok_18_fejezet;

/* K�rj�nk be egy sz�veget, majd �rjuk ki, hogy A-t�l Z-ig melyik bet�b�l h�ny van a sz�vegben! A kis- �s nagybet�ket ne
 * k�l�nb�ztess�k meg, �s a nem ebbe a tartom�nyba es� karaktereket ne sz�moljuk!
 */
import extra.*;

public class Betugyujtes_18_4_2_pelda {

	public static void main(String[] args) {
		String szoveg=Console.readLine("K�rem a sz�veget: ");
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
