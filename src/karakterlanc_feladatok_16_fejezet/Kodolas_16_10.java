package karakterlanc_feladatok_16_fejezet;

/*Írjon olyan metódust, amely kódol egy szöveget: fordítsa meg minden karakter 3. és 4. bitjét: a 0-ból legyen 1-es és fordítva! 
 * Készítsen megejtõ metódust is!
 */
import extra.*;
public class Kodolas_16_10 {
	public static String kodol(String szoveg) {
		StringBuilder seged=new StringBuilder(szoveg);
		for (int i=0;i<seged.length();i++)
			//A 24 binárisan 00011000, a kizáró vagy mûvelet megfordítja a biteket, 0-ból egyet csinál, 1-bõl 0-t.
			seged.setCharAt(i, (char) (seged.charAt(i)^24));
		return seged.toString();
	}
	public static String jelszoKodol(String szoveg, String jelszo) {
		StringBuilder seged=new StringBuilder(szoveg);
		int i=0,j=0;
		while (i<seged.length()) {
			while (j<jelszo.length() && (i<seged.length())) {
				seged.setCharAt(i,(char) (seged.charAt(i)^jelszo.charAt(j)));
				j++;
				i++;
			}
			j=0;
			i++;
		}
		return seged.toString();
	}
	
	public static void main(String[] args) {
		String szoveg;
		szoveg=Console.readLine("Kérem a kódolandó szöveget:");
		szoveg=jelszoKodol(szoveg,"A1%a");
		System.out.println("A kódolt szöveg: "+szoveg);
		szoveg=jelszoKodol(szoveg,"A1%a");
		System.out.println("A dekódolt szöveg: "+szoveg);
	}

}
