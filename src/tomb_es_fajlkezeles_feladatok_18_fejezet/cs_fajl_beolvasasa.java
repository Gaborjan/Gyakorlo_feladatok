package tomb_es_fajlkezeles_feladatok_18_fejezet;

/*Olvassunk be egy CS formátumú fájlt. Tudjuk, hogy 18 oszlopa van és max. 100 sorból áll.
 * Csak aokat a sorokat kell feldolgozni, ahol  3. oszlopban "IP Complex Plusz" szöveg, a 12. sorban pedig "Elõ" szerepel.
 * Ezeket a sorokat írjuk ki, 1. 15. 17. (Elsõ 30 karakter), 7. oszlop tartalommal.
 * A 7. oszlop Ft-ban értendõ, ezért írjuk mögé a "Ft" szöveget és egy következõ oszlopban írjuk ki az ÁFA összegét is.
 * Az utolsó sorba pedig írjuk ki a listázott végpontok össz. havidíját. ( 7. oszlop össszesítése)
 * Az oszlop fejléce: Ssz., SAP azon., Cím, Nettó havidíj, ÁFA
 *  FEJLESZTÉSI LEHETÕSÉG:
 *  Egy tömbben eltároljuk milyen lehetséges szolgáltatások vannak (szolgáltatástípus), majd mindegyiken végigmegyünk
 *  és kiírjuk a sorokat a .csv fájlba.
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
		//final String SZOLGALTATAS="Egyéb ÜKO szolg.";
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
			System.err.println("Hiba történt a fájlmûvelet közben!");
		}
		try {
   		fajl= new RandomAccessFile("C:/Angster_Java/Adatok/Allomasok_rovid_Eurest_IPC.csv","rw");
   		fajl.writeBytes("Sorszám;SAP szám;Áramkör;Szolgáltatás cím;Havi díj\n");
   		vegPontSSz=1;
   		osszHaviDij=0;
   		System.out.println("SSSZ  SAPSZÁM      ÁRAMKÖR    SZOLGÁLTATÁS CÍM                                               HAVI DÍJ         ÁFA");
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
   		System.out.printf("%s  %,80.2f Ft    %,8.2f Ft", "Havidíjak összesen: ",osszHaviDij, osszHaviDij*0.27);
		} //try
		catch (IOException e) {
			System.err.println("Hiba történt a fájlmûvelet közben! "+e.toString());
		}
		 	System.out.println();
		System.out.println("Program vége");
	}

}
