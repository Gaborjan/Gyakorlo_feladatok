package karakterlanc_feladatok_16_fejezet;

/*Kisebb gyakorl� feladat, r�szfeladatokkal.
 * Az egyes r�szfeladatok le�r�sa kommentben.*/
import extra.*;
public class Szoveg_alakit_16_1 {
	public static void main(String[] args) {
		String szoveg1,szoveg2,szoveg3;	
		double szam;
		szoveg1=Console.readLine("K�rem a sz�veget: ");
		// �rjuk ki kisbet�vel
		System.out.println(szoveg1.toLowerCase());
		//�rjuk ki  5-sz�r egym�sut�n a + jellel elv�lasztva
		System.out.print(szoveg1);
		for (int i=1;i<5;i++)
			System.out.print("+"+szoveg1);
		//�rjuk ki �gy, hogy az �sszes a bet� helyett A bet� szerepeljen
		System.out.println();
		for (int i=0;i<szoveg1.length();i++) {
			if (szoveg1.charAt(i)=='a') System.out.print('A');
			else System.out.print(szoveg1.charAt(i));
		}
		//Irjuk ki a string m�sodik fel�t el�re �s az els� fel�t m�g�: GABIKA->IKAGAB, HAROM->OMRHA
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
		//Az els� sz�k�z el�tti �s ut�ni r�sz fel van cser�lve
		System.out.println();
		szoveg2=szoveg1.substring(szoveg1.indexOf(' ')+1,szoveg1.length());
		szoveg2=szoveg2+' '+szoveg1.substring(0,szoveg1.indexOf(' '));
		System.out.println(szoveg2);
		szam=Console.readDouble("K�rem a sz�mot:");
		szam*=Math.PI;
		System.out.println("A szam PI-vel szorozva:"+szam);
		System.out.println("A szam k�t tizedesre kerek�tve:"+Menu.kerekit(szam,2));
		/*szoveg2=Console.readLine("K�rem a sz�veget (2):");
		System.out.println((szoveg1==szoveg2) ? "Azonosak" : "Nem azonosak");
		System.out.println(szoveg1.equals(szoveg2)?"Egyenl�k":"Nem egyenl�k");
		szoveg1=szoveg2;
		System.out.println((szoveg1==szoveg2) ? "Azonosak" : "Nem azonosak");
		System.out.println(szoveg1);*/
	
	}

}
