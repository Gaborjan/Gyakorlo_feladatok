package karakterlanc_feladatok_16_fejezet;

/*Kerek�t�s pr�ba*/
import extra.*;
public class Kerekites {
	
	/*Egy val�s sz�mot a megadott tizedesjegyre kerek�t.*/
	static double kerekit(double szam,int tizedes)
	{
		String seged, seged1;
		seged=Integer.toString(tizedes); // A tizedest sz�vegg� alak�tjuk, hogy sz�mform�tumot tudjunk k�sz�teni.
		seged1=String.format("%."+seged+"f", szam); // A megkapott sz�m param�tert a megadott form�tum szerint megform�zzuk, de az eredm�ny sztring.
		return Double.valueOf(seged1.replace(',','.')); // Visszaadjuk a megform�zott sz�mot sz�mm� alak�tva, de ki kell benne cser�lni a tizedesvessz�t pontra.
	}
	public static void main(String[] args) {
		double szam;
		String szamSztring;
		szam=Console.readDouble("K�rem a sz�mot:");
		//szam=Double.valueOf(kerekit(szam,2));
		System.out.println("�rt�k vagyok! :) "+(kerekit(szam,1)*10));
		szamSztring=Double.toString(kerekit(szam,1));
		System.out.println("String vagyok!"+szamSztring);
	}

}