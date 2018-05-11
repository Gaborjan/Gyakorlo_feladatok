package iteracios_feladatok_14_fejezet;

/*Kérje be egymás után különbözõ henger alakú hordók adatait (átmérõ, magasság)! Ha a hordó elsõ adatánál
 * 0-át ütnek be, akkor vége a bevitelnek. Írja ki, hányadik hordóba fér bele a legkevesebb, illetve a 
 * legtöbb bor! Írja ki ezen hordók adatait is!
 */
import extra.*;
public class MinMaxHenger_14_18 {

	public static void main(String[] args) {
		final int MINATMEROCM=10;
		final int MAXATMEROCM=300;
		final int MINMAGASSAGCM=10;
		final int MAXMAGASSAGCM=400;
		double atmero,magassag,terfogat;
		double minAtmero=MAXATMEROCM,minMagassag=MAXMAGASSAGCM;
		double maxAtmero=MINATMEROCM,maxMagassag=MINMAGASSAGCM;
		double minTerfogat,maxTerfogat;
		int minHordoSsz=0,maxHordoSsz=0;
		boolean vege=false;
		int szamlalo=0;
		double osszKapacitas=0;
		minTerfogat=Math.pow((MAXATMEROCM/2),2)*Math.PI*MAXMAGASSAGCM;;
		maxTerfogat=0;
		System.out.println("Kérem adja meg sorban a hordók adatait."); 
		System.out.println("Adatbevitel vége: hordó átmérõjének 0-t adjon meg.");
		System.out.println("-----------------");
		System.out.println("Eredményül kiírom a legkisebb és a legnagyobb hordók adatait.");
		System.out.println("Ha több azonos hordó is van, akkor a legelsõ legkisebb/legnagyobb sorszámát adom meg.");
		System.out.println("Kiszámolom azt is összesen hány liter bort tud tárolni a hordókban.\n");
		System.out.println();
		do {
			do {
				atmero=Console.readDouble("Kérem a(z) "+(szamlalo+1)+" . hordó atmérõjét ("+MINATMEROCM+"-"+MAXATMEROCM+" cm), Kilépés:\"0\": ");
				vege=atmero==0;
			} while ((atmero<MINATMEROCM || atmero>MAXATMEROCM) && !vege);
			if (vege) { 
				System.out.println("\n         * * * Adatbevitel vége * * *         \n");
				continue;
			}
			szamlalo++;
			do {
				magassag=Console.readDouble("Kérem a(z) "+szamlalo+" . hordó magasságát ("+MINMAGASSAGCM+"-"+MAXMAGASSAGCM+" cm):");
			} while (magassag<MINMAGASSAGCM || magassag>MAXMAGASSAGCM);
			terfogat=Math.pow((atmero/2),2)*Math.PI*magassag;
			osszKapacitas+=terfogat;
			if (terfogat<minTerfogat) {
				minAtmero=atmero;
				minMagassag=magassag;
				minTerfogat=terfogat;
				minHordoSsz=szamlalo;
			}
			if (terfogat>maxTerfogat) {
				maxAtmero=atmero;
				maxMagassag=magassag;
				maxTerfogat=terfogat;
				maxHordoSsz=szamlalo;
			}
		} while (!vege);
		if (szamlalo>0) {
			System.out.println();
			System.out.println("L E G K I S E B B   H O R D Ó    A D A T A I");
			System.out.println("--------------------------------------------");
			System.out.printf("A legkisebb térfogatú hordó sorszáma: %3d\n",minHordoSsz);
			System.out.printf("Átmérõje : %,10.2f cm\n", minAtmero);
			System.out.printf("Magassága: %,10.2f cm\n", minMagassag);
			System.out.printf("Térfogata: %,10.2f liter\n",minTerfogat/1000);
			System.out.println();
			System.out.println("L E G N A G Y O B B   H O R D Ó    A D A T A I");
			System.out.println("----------------------------------------------");
			System.out.printf("A legnagyobb térfogatú hordó sorszáma: %3d\n",maxHordoSsz);
			System.out.printf("Átmérõje : %,10.2f cm\n", maxAtmero);
			System.out.printf("Magassága: %,10.2f cm\n", maxMagassag);
			System.out.printf("Térfogata: %,10.2f liter\n",maxTerfogat/1000);
			System.out.println();
			System.out.println("H O R D Ó K    Ö S S Z K A P A C I T Á S A");
			System.out.println("------------------------------------------");
			System.out.printf("A hordók összkapacitása: %,12.2f liter\n\n",osszKapacitas/1000);
		}
		else
			System.out.println("Nem kaptam egy adatot sem, nincsenek eredmények!");
		System.out.println("Program vége:");
		Console.pressEnter();
	}

}
