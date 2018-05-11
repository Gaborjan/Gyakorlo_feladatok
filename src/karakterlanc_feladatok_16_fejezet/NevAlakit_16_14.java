package karakterlanc_feladatok_16_fejezet;

import extra.*;

/*K�rjen be egy nevet, mely ak�rh�n� r�szn�vb�l �llhat. Csak akkor fogadja el a nevet, ha az legal�bb
 * k�t r�szn�vb�l �ll (a r�szneveeket legal�bb egy sz�k�z v�lasztja el)!
 * Vegye le a sz�k�z�ket a n�v elej�r�l �s v�g�r�l, a r�sznevek k�zt pedig csak egy sz�k�zt hagyjon!
 * A nevet alak�tsa �t �gy, hogy minden r�szn�v nagybet�vel kezd�dj�n, a t�bbi pedig kisbet� legyen!
 * 
 */
public class NevAlakit_16_14 {
	static public StringBuilder szokozTorol(StringBuilder szoveg) {
		int elsoSzokoz=0;
		int mutato=0;
		//Bevezet� sz�k�z�k t�rl�se
		/*while (szoveg.length()>0 && szoveg.charAt(0)==' ') 
			szoveg.deleteCharAt(0);
		//V�g�n l�v� sz�k�z�k t�rl�se
		while (szoveg.length()>0 && szoveg.charAt(szoveg.length()-1)==' ')
			szoveg.deleteCharAt(szoveg.length()-1);
		if (szoveg.length()<3) return szoveg;*/
		//K�z�pen l�v� sz�k�z�k t�rl�se
		mutato=1;
		while (mutato<szoveg.length()) {
			if (szoveg.charAt(mutato)==' ' && szoveg.charAt(mutato+1)==' ')
				while (szoveg.charAt(mutato)==' ' && szoveg.charAt(mutato+1)==' ')
					szoveg.deleteCharAt(mutato);
			mutato++;
		}
		//Nevek els� bet�j�nek nagybet�ss�, t�bbinek kisbet�ss� alak�t�sa
		szoveg.setCharAt(0,Character.toUpperCase(szoveg.charAt(0)));
		for (int i=1;i<szoveg.length();i++) {
			if (szoveg.charAt(i)== ' ') { 
				szoveg.setCharAt(i+1, Character.toUpperCase(szoveg.charAt(i+1)));
				i++;
			}
			else szoveg.setCharAt(i, Character.toLowerCase(szoveg.charAt(i)));
		}
		return szoveg;
	}
	static public int reszNev(String szoveg) {
	
		int db=0;
		int szokoz=szoveg.indexOf(' ');
		if ((szokoz)>0) db++;
		while (szoveg.indexOf(' ', szokoz+1)!=-1) {
			db++;
			szokoz=szoveg.indexOf (' ', szokoz+1);
		}
		return db+1;
	}
	
	static public void main(String[] args) {
		StringBuilder nev;
		while (reszNev(szokozTorol(nev = new StringBuilder(Console.readLine("K�rem a nevet: ").trim())).toString())<2)
			//System.out.println("*"); Ha a felt�tel igaz, ugyan�gy v�grehajt�dik a ciklusmag, ide j�hetne hiba�zenet.
		System.out.println(nev);
		System.out.println("Program v�ge         "+reszNev(nev.toString()));
	}
}
