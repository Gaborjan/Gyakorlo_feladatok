package karakterlanc_feladatok_16_fejezet;

/*Kisebb gyakorló feladat, részfeladatokkal.
 * Az egyes részfeladatok leírása kommentben.*/
import extra.*;
public class Szoveg_alakit_16_1 {
	public static void main(String[] args) {
		String szoveg1,szoveg2,szoveg3;	
		double szam;
		szoveg1=Console.readLine("Kérem a szöveget: ");
		// Írjuk ki kisbetûvel
		System.out.println(szoveg1.toLowerCase());
		//Írjuk ki  5-ször egymásután a + jellel elválasztva
		System.out.print(szoveg1);
		for (int i=1;i<5;i++)
			System.out.print("+"+szoveg1);
		//Írjuk ki úgy, hogy az összes a betû helyett A betû szerepeljen
		System.out.println();
		for (int i=0;i<szoveg1.length();i++) {
			if (szoveg1.charAt(i)=='a') System.out.print('A');
			else System.out.print(szoveg1.charAt(i));
		}
		//Irjuk ki a string második felét elõre és az elsõ felét mögé: GABIKA->IKAGAB, HAROM->OMRHA
		System.out.println();
		if ((szoveg1.length()%2)==0) {
			System.out.print(szoveg1.substring(szoveg1.length()/2,szoveg1.length()));
			System.out.print(szoveg1.substring(0,szoveg1.length()/2));
		}
		else {
			System.out.print(szoveg1.substring((szoveg1.length()/2)+1,szoveg1.length()));
			System.out.print(szoveg1.substring(szoveg1.length()/2,(szoveg1.length()/2)+1));
			System.out.print(szoveg1.substring(0,szoveg1.length()/2));
			}
		//Az elsõ szóköz elõtti és utáni rész fel van cserélve
		System.out.println();
		szoveg2=szoveg1.substring(szoveg1.indexOf(' ')+1,szoveg1.length());
		szoveg2=szoveg2+' '+szoveg1.substring(0,szoveg1.indexOf(' '));
		System.out.println(szoveg2);
		szam=Console.readDouble("Kérem a számot:");
		szam*=Math.PI;
		System.out.println("A szam PI-vel szorozva:"+szam);
		System.out.println("A szam két tizedesre kerekítve:"+Menu.kerekit(szam,2));
		/*szoveg2=Console.readLine("Kérem a szöveget (2):");
		System.out.println((szoveg1==szoveg2) ? "Azonosak" : "Nem azonosak");
		System.out.println(szoveg1.equals(szoveg2)?"Egyenlõk":"Nem egyenlõk");
		szoveg1=szoveg2;
		System.out.println((szoveg1==szoveg2) ? "Azonosak" : "Nem azonosak");
		System.out.println(szoveg1);*/
	
	}

}
