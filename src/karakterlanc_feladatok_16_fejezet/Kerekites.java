package karakterlanc_feladatok_16_fejezet;

/*Kerekítés próba*/
import extra.*;
public class Kerekites {
	
	/*Egy valós számot a megadott tizedesjegyre kerekít.*/
	static double kerekit(double szam,int tizedes)
	{
		String seged, seged1;
		seged=Integer.toString(tizedes); // A tizedest szöveggé alakítjuk, hogy számformátumot tudjunk készíteni.
		seged1=String.format("%."+seged+"f", szam); // A megkapott szám paramétert a megadott formátum szerint megformázzuk, de az eredmény sztring.
		return Double.valueOf(seged1.replace(',','.')); // Visszaadjuk a megformázott számot számmá alakítva, de ki kell benne cserélni a tizedesvesszõt pontra.
	}
	public static void main(String[] args) {
		double szam;
		String szamSztring;
		szam=Console.readDouble("Kérem a számot:");
		//szam=Double.valueOf(kerekit(szam,2));
		System.out.println("Érték vagyok! :) "+(kerekit(szam,1)*10));
		szamSztring=Double.toString(kerekit(szam,1));
		System.out.println("String vagyok!"+szamSztring);
	}

}