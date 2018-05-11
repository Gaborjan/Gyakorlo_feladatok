package karakterlanc_feladatok_16_fejezet;

/*Írjon metódust, amely meszámolja hogy a paraméterben megadott szövegben
 * - hány szóköz van
 * - hány, a második paraméterként megadott szó szerepel!
 */
import extra.*;

public class Megszamol_16_3 {

	static int szokozDb(String szoveg) {
		int db=0;
		for (int i=0;i<szoveg.length();i++)
			if (szoveg.charAt(i)==' ') db++;
		return db;
	}
	
	static int szovegKeres(String miben, String mit) {
		int db=0;
		int i=0;
		if ((miben.length()==0) || (mit.length()==0)) return db;
		while (i<=miben.length()-mit.length()) {
			if (miben.charAt(i)==mit.charAt(0)) {
				int j=0;
				boolean egyezik=true;
				do {
					egyezik=miben.charAt(i+j)==mit.charAt(j);
					j++;
				} while (egyezik && j<mit.length());
				if (egyezik) {
					db++;
					i=i+mit.length()-1;
				}
			}
			i++;
		}
		return db;
	}
	
	public static void main(String[] args) {
		System.out.println(szokozDb("Ez egy egyszerû mondat, amiben vannak szóközök is!"));
		System.out.println(szovegKeres("aaaaaa","aaa"));
	}

}
