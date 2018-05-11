package karakterlanc_feladatok_16_fejezet;

/*A gyerekek körében jól ismert a "Tuvudsz ívígy beszévélnivi?" típusú beszélgetés. Tanítsa meg a számítógépet így
 * beszélni! A beolvasott mondatot alakítsa át úgy, hogy minden magánhangzó után szúrjon be egy v betût és az elõzõ
 * magánhangzót!
 * 
 */
import extra.*;

//A beolvasott mondatot alakítsa át úgy, hogy minden magánhangzó után szúrjon be egy v betût és az elõzõ magánhangzót!

public class Tuvudsz {
	//A metódus eldönti egy betûrõl, hogy magánhangzó-e?
	public static boolean maganHangzo(char betu) {
		final String MAGANHANGZOK="AÁaáEÉeéiIíÍuUúÚöÖõÕoOóÓûÛüÜ";
		return (MAGANHANGZOK.contains(Character.toString(betu))); 
	}
	//Ez az átalakító metódus
	public static String alakit(String szoveg) {
		StringBuffer seged = new StringBuffer(szoveg); 
		int maganHangzoDb=0; 
		int mutato=0;
		char vBetu=Character.MIN_VALUE;
		for (int i=0;i<seged.length();i++) //Kigyûjtjük hány magánhangzó van, ennyit kell cserélni. 
			if (maganHangzo(seged.charAt(i))) maganHangzoDb++;
		while (maganHangzoDb!=0) { //Amíg van cserélendõ magánhangzó
			if (maganHangzo(seged.charAt(mutato))) { 
				vBetu=(Character.isUpperCase(seged.charAt(mutato))) ? 'V' : 'v'; //Ha nagybetûs a magánhangzó, akkor a beszúrás is legyen az
				//Az aktuális magánhangzó cseréje magánhangzóra + V/v betû + magánhangzó
				seged.replace(mutato,mutato+1,seged.charAt(mutato)+Character.toString(vBetu)+seged.charAt(mutato)); 
				mutato=mutato+3; // Mivel bõvült a szöveg, a mutatót 3-mal hátrébb állítjuk
				maganHangzoDb--; // A cserélendõ magánhangzók számát eggyel csökkentjük
			}
			else mutato++; //Mivel csere nem volt, vizsgáljuk a következõ betût majd.
		}
		return seged.toString();
	}
	public static void main(String[] args) {
		String szoveg;
		szoveg=Console.readLine("Add meg a szöveget, amit átalakíthatok:");
		System.out.print(alakit(szoveg));
	}
}
