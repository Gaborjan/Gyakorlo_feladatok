package karakterlanc_feladatok_16_fejezet;

/*�rjon olyan met�dust, amely k�dol egy sz�veget: ford�tsa meg minden karakter 3. �s 4. bitj�t: a 0-b�l legyen 1-es �s ford�tva! 
 * K�sz�tsen megejt� met�dust is!
 */
import extra.*;
public class Kodolas_16_10 {
	public static String kodol(String szoveg) {
		StringBuilder seged=new StringBuilder(szoveg);
		for (int i=0;i<seged.length();i++)
			//A 24 bin�risan 00011000, a kiz�r� vagy m�velet megford�tja a biteket, 0-b�l egyet csin�l, 1-b�l 0-t.
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
		szoveg=Console.readLine("K�rem a k�doland� sz�veget:");
		szoveg=jelszoKodol(szoveg,"A1%a");
		System.out.println("A k�dolt sz�veg: "+szoveg);
		szoveg=jelszoKodol(szoveg,"A1%a");
		System.out.println("A dek�dolt sz�veg: "+szoveg);
	}

}
