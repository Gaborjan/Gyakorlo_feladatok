package tomb_es_fajlkezeles_feladatok_18_fejezet;

/*Olvassunk be egy CS form�tum� f�jlt. Tudjuk, hogy 18 oszlopa van �s max. 100 sorb�l �ll.
 * Csak aokat a sorokat kell feldolgozni, ahol  3. oszlopban "IP Complex Plusz" sz�veg, a 12. sorban pedig "El�" szerepel.
 * Ezeket a sorokat �rjuk ki, 1. 15. 17. (Els� 30 karakter), 7. oszlop tartalommal.
 * A 7. oszlop Ft-ban �rtend�, ez�rt �rjuk m�g� a "Ft" sz�veget �s egy k�vetkez� oszlopban �rjuk ki az �FA �sszeg�t is.
 * Az utols� sorba pedig �rjuk ki a list�zott v�gpontok �ssz. havid�j�t. ( 7. oszlop �ssszes�t�se)
 * Az oszlop fejl�ce: Ssz., SAP azon., C�m, Nett� havid�j, �FA
 *  FEJLESZT�SI LEHET�S�G:
 *  Egy t�mbben elt�roljuk milyen lehets�ges szolg�ltat�sok vannak (szolg�ltat�st�pus), majd mindegyiken v�gigmegy�nk
 *  �s ki�rjuk a sorokat a .csv f�jlba.
 *  
 */
import extra.*;
import java.io.*;
	
public class cs_fajl_beolvasasa {

	public static void main(String[] args) {
		final String SZOLGALTATAS="IP Complex Plusz";
		//final String SZOLGALTATAS="Multiflex";
		//final String SZOLGALTATAS="ADSL flotta";
		//final String SZOLGALTATAS="Szerverhoszting";
		//final String SZOLGALTATAS="Egy�b �KO szolg.";
		RandomAccessFile fajl;
		StringBuilder[] adatok = new StringBuilder[100];
		int db=0;
		int maxHossz=0;
		double havidij=0;
		int vegPontSSz=0;
		double osszHaviDij=0;
		double afa;
		try {
			fajl = new RandomAccessFile("C:/Angster_Java/Adatok/Eurest.csv","r");
			String egysor;
			egysor=fajl.readLine();
			while (egysor!=null) { 
				adatok[db]= new StringBuilder(egysor);
				egysor=fajl.readLine();
				db++;
			}	
			fajl.close();
		}
		catch (IOException e) {
			System.err.println("Hiba t�rt�nt a f�jlm�velet k�zben!");
		}
		try {
   		fajl= new RandomAccessFile("C:/Angster_Java/Adatok/Allomasok_rovid_Eurest_IPC.csv","rw");
   		fajl.writeBytes("Sorsz�m;SAP sz�m;�ramk�r;Szolg�ltat�s c�m;Havi d�j\n");
   		vegPontSSz=1;
   		osszHaviDij=0;
   		System.out.println("SSSZ  SAPSZ�M      �RAMK�R    SZOLG�LTAT�S C�M                                               HAVI D�J         �FA");
   		//System.out.println();
   		for (int i=1;i<=db-1;i++) {
   			String[] oszlopok;
   			String kiIrasra;
   			oszlopok=adatok[i].toString().split(";");
   			if (oszlopok[2].equals(SZOLGALTATAS) && oszlopok[11].substring(0,2).equals("El")) {
   				havidij=Double.parseDouble(oszlopok[6]);
   				afa=havidij*0.27;
   				maxHossz=oszlopok[16].length();
   				if (maxHossz>=60) maxHossz=60; 
   				System.out.printf("%3d.) %10s %10s   %-70s  %,10.2f Ft     %,8.2f Ft", vegPontSSz, oszlopok[0], oszlopok[14], oszlopok[16].substring(0, maxHossz), havidij, afa);
   				kiIrasra=String.format("%d;%s;%8s;%-70s;%.2f;\n", vegPontSSz, oszlopok[0], oszlopok[14], oszlopok[16].substring(0, maxHossz), havidij);
   				fajl.writeBytes(kiIrasra);
   				System.out.println();
   				vegPontSSz++;
   				osszHaviDij=osszHaviDij+havidij;
   			} //if
   		} //for 
   		fajl.close();
   		System.out.printf("%s  %,80.2f Ft    %,8.2f Ft", "Havid�jak �sszesen: ",osszHaviDij, osszHaviDij*0.27);
		} //try
		catch (IOException e) {
			System.err.println("Hiba t�rt�nt a f�jlm�velet k�zben! "+e.toString());
		}
		 	System.out.println();
		System.out.println("Program v�ge");
	}

}
