package karakterlanc_feladatok_16_fejezet;

import extra.Console;

/*Kérjen be egy szöveg! Írja ki, hogy a szövegben összesen hány darab betû, hány szám, hány fehér
 * szóköz, illetve hány egyéb karakter szerepel!
 */
public class KarEloszlas_16_12 {

	static public void szamol(String szoveg) {
		int betu=0, szam=0,fszokoz=0,egyeb=0;
		
		for (int i=0;i<szoveg.length();i++)
			if (Character.isLetter(szoveg.charAt(i))) betu++;
			else if (Character.isDigit(szoveg.charAt(i))) szam++;
				else if (Character.isWhitespace(szoveg.charAt(i))) fszokoz++;
					else egyeb++;
		System.out.println("Betû:        "+betu);
		System.out.println("Szám:        "+szam);
		System.out.println("Fehérszóköz: "+fszokoz);
		System.out.println("Egyéb:       "+egyeb);
	}
	static public void main(String[] args) {
		szamol(Console.readLine("Kérem a szöveget: "));
	}
}
