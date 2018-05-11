package karakterlanc_feladatok_16_fejezet;

import extra.Console;

/*K�rjen be egy sz�veg! �rja ki, hogy a sz�vegben �sszesen h�ny darab bet�, h�ny sz�m, h�ny feh�r
 * sz�k�z, illetve h�ny egy�b karakter szerepel!
 */
public class KarEloszlas_16_12 {

	static public void szamol(String szoveg) {
		int betu=0, szam=0,fszokoz=0,egyeb=0;
		
		for (int i=0;i<szoveg.length();i++)
			if (Character.isLetter(szoveg.charAt(i))) betu++;
			else if (Character.isDigit(szoveg.charAt(i))) szam++;
				else if (Character.isWhitespace(szoveg.charAt(i))) fszokoz++;
					else egyeb++;
		System.out.println("Bet�:        "+betu);
		System.out.println("Sz�m:        "+szam);
		System.out.println("Feh�rsz�k�z: "+fszokoz);
		System.out.println("Egy�b:       "+egyeb);
	}
	static public void main(String[] args) {
		szamol(Console.readLine("K�rem a sz�veget: "));
	}
}
