package karakterlanc_feladatok_16_fejezet;

/* Írjon föggvényt, mely megszámolja, hány szó van a paraméterként megadott szövegben! 
 * A szavakat egy vagy több fehér szóköz választja el egymástól.
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
		szoveg=Console.readLine("Kérem a szöveget: ");
		System.out.println("Szavak száma a szövegben: "+szavakSzama(szoveg));

	}

}
