package karakterlanc_feladatok_16_fejezet;

import extra.*;

/*Kérjen be egy nevet, mely akárhání résznévbõl állhat. Csak akkor fogadja el a nevet, ha az legalább
 * két résznévbõl áll (a részneveeket legalább egy szóköz választja el)!
 * Vegye le a szóközöket a név elejérõl és végérõl, a résznevek közt pedig csak egy szóközt hagyjon!
 * A nevet alakítsa át úgy, hogy minden résznév nagybetûvel kezdõdjön, a többi pedig kisbetû legyen!
 * 
 */
public class NevAlakit_16_14 {
	static public StringBuilder szokozTorol(StringBuilder szoveg) {
		int elsoSzokoz=0;
		int mutato=0;
		//Bevezetõ szóközök törlése
		/*while (szoveg.length()>0 && szoveg.charAt(0)==' ') 
			szoveg.deleteCharAt(0);
		//Végén lévõ szóközök törlése
		while (szoveg.length()>0 && szoveg.charAt(szoveg.length()-1)==' ')
			szoveg.deleteCharAt(szoveg.length()-1);
		if (szoveg.length()<3) return szoveg;*/
		//Középen lévõ szóközök törlése
		mutato=1;
		while (mutato<szoveg.length()) {
			if (szoveg.charAt(mutato)==' ' && szoveg.charAt(mutato+1)==' ')
				while (szoveg.charAt(mutato)==' ' && szoveg.charAt(mutato+1)==' ')
					szoveg.deleteCharAt(mutato);
			mutato++;
		}
		//Nevek elsõ betûjének nagybetûssé, többinek kisbetûssé alakítása
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
		while (reszNev(szokozTorol(nev = new StringBuilder(Console.readLine("Kérem a nevet: ").trim())).toString())<2)
			//System.out.println("*"); Ha a feltétel igaz, ugyanúgy végrehajtódik a ciklusmag, ide jöhetne hibaüzenet.
		System.out.println(nev);
		System.out.println("Program vége         "+reszNev(nev.toString()));
	}
}
