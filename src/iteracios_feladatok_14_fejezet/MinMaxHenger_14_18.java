package iteracios_feladatok_14_fejezet;

/*K�rje be egym�s ut�n k�l�nb�z� henger alak� hord�k adatait (�tm�r�, magass�g)! Ha a hord� els� adat�n�l
 * 0-�t �tnek be, akkor v�ge a bevitelnek. �rja ki, h�nyadik hord�ba f�r bele a legkevesebb, illetve a 
 * legt�bb bor! �rja ki ezen hord�k adatait is!
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
		System.out.println("K�rem adja meg sorban a hord�k adatait."); 
		System.out.println("Adatbevitel v�ge: hord� �tm�r�j�nek 0-t adjon meg.");
		System.out.println("-----------------");
		System.out.println("Eredm�ny�l ki�rom a legkisebb �s a legnagyobb hord�k adatait.");
		System.out.println("Ha t�bb azonos hord� is van, akkor a legels� legkisebb/legnagyobb sorsz�m�t adom meg.");
		System.out.println("Kisz�molom azt is �sszesen h�ny liter bort tud t�rolni a hord�kban.\n");
		System.out.println();
		do {
			do {
				atmero=Console.readDouble("K�rem a(z) "+(szamlalo+1)+" . hord� atm�r�j�t ("+MINATMEROCM+"-"+MAXATMEROCM+" cm), Kil�p�s:\"0\": ");
				vege=atmero==0;
			} while ((atmero<MINATMEROCM || atmero>MAXATMEROCM) && !vege);
			if (vege) { 
				System.out.println("\n         * * * Adatbevitel v�ge * * *         \n");
				continue;
			}
			szamlalo++;
			do {
				magassag=Console.readDouble("K�rem a(z) "+szamlalo+" . hord� magass�g�t ("+MINMAGASSAGCM+"-"+MAXMAGASSAGCM+" cm):");
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
			System.out.println("L E G K I S E B B   H O R D �    A D A T A I");
			System.out.println("--------------------------------------------");
			System.out.printf("A legkisebb t�rfogat� hord� sorsz�ma: %3d\n",minHordoSsz);
			System.out.printf("�tm�r�je : %,10.2f cm\n", minAtmero);
			System.out.printf("Magass�ga: %,10.2f cm\n", minMagassag);
			System.out.printf("T�rfogata: %,10.2f liter\n",minTerfogat/1000);
			System.out.println();
			System.out.println("L E G N A G Y O B B   H O R D �    A D A T A I");
			System.out.println("----------------------------------------------");
			System.out.printf("A legnagyobb t�rfogat� hord� sorsz�ma: %3d\n",maxHordoSsz);
			System.out.printf("�tm�r�je : %,10.2f cm\n", maxAtmero);
			System.out.printf("Magass�ga: %,10.2f cm\n", maxMagassag);
			System.out.printf("T�rfogata: %,10.2f liter\n",maxTerfogat/1000);
			System.out.println();
			System.out.println("H O R D � K    � S S Z K A P A C I T � S A");
			System.out.println("------------------------------------------");
			System.out.printf("A hord�k �sszkapacit�sa: %,12.2f liter\n\n",osszKapacitas/1000);
		}
		else
			System.out.println("Nem kaptam egy adatot sem, nincsenek eredm�nyek!");
		System.out.println("Program v�ge:");
		Console.pressEnter();
	}

}
