package karakterlanc_feladatok_16_fejezet;

/*A gyerekek k�r�ben j�l ismert a "Tuvudsz �v�gy besz�v�lnivi?" t�pus� besz�lget�s. Tan�tsa meg a sz�m�t�g�pet �gy
 * besz�lni! A beolvasott mondatot alak�tsa �t �gy, hogy minden mag�nhangz� ut�n sz�rjon be egy v bet�t �s az el�z�
 * mag�nhangz�t!
 * 
 */
import extra.*;

//A beolvasott mondatot alak�tsa �t �gy, hogy minden mag�nhangz� ut�n sz�rjon be egy v bet�t �s az el�z� mag�nhangz�t!

public class Tuvudsz {
	//A met�dus eld�nti egy bet�r�l, hogy mag�nhangz�-e?
	public static boolean maganHangzo(char betu) {
		final String MAGANHANGZOK="A�a�E�e�iI��uU������oO������";
		return (MAGANHANGZOK.contains(Character.toString(betu))); 
	}
	//Ez az �talak�t� met�dus
	public static String alakit(String szoveg) {
		StringBuffer seged = new StringBuffer(szoveg); 
		int maganHangzoDb=0; 
		int mutato=0;
		char vBetu=Character.MIN_VALUE;
		for (int i=0;i<seged.length();i++) //Kigy�jtj�k h�ny mag�nhangz� van, ennyit kell cser�lni. 
			if (maganHangzo(seged.charAt(i))) maganHangzoDb++;
		while (maganHangzoDb!=0) { //Am�g van cser�lend� mag�nhangz�
			if (maganHangzo(seged.charAt(mutato))) { 
				vBetu=(Character.isUpperCase(seged.charAt(mutato))) ? 'V' : 'v'; //Ha nagybet�s a mag�nhangz�, akkor a besz�r�s is legyen az
				//Az aktu�lis mag�nhangz� cser�je mag�nhangz�ra + V/v bet� + mag�nhangz�
				seged.replace(mutato,mutato+1,seged.charAt(mutato)+Character.toString(vBetu)+seged.charAt(mutato)); 
				mutato=mutato+3; // Mivel b�v�lt a sz�veg, a mutat�t 3-mal h�tr�bb �ll�tjuk
				maganHangzoDb--; // A cser�lend� mag�nhangz�k sz�m�t eggyel cs�kkentj�k
			}
			else mutato++; //Mivel csere nem volt, vizsg�ljuk a k�vetkez� bet�t majd.
		}
		return seged.toString();
	}
	public static void main(String[] args) {
		String szoveg;
		szoveg=Console.readLine("Add meg a sz�veget, amit �talak�thatok:");
		System.out.print(alakit(szoveg));
	}
}
