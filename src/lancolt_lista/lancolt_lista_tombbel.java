package lancolt_lista;

import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.Arrays;
import java.util.Locale;

public class lancolt_lista_tombbel {
	static final String NEVEK[] = {  "Kocsis Bernadett", "Ádám Tamás", "Dóka Lajos",     "Erős Pista",  "Bús Balázs", "Liszkai Péter", "Zelenák Zita"}; // Teszt adatok
	static final String LAKHELY[] = {"Budapest",         "Gyál",       "Pilisszentiván", "Győr",        "Zalakaros",  "Szeged",        "Miskolc"};
	static final int NULL=9999;
	static RuleBasedCollator myCollator = (RuleBasedCollator) Collator.getInstance(new Locale("hu", "HU"));
	
	static String info_nev[] = new String[10]; // A tárolandó neveket tartalmazó tömb
	static String info_cim[] = new String[10]; // A tárolandó címeket tartalmazó tömb
	static Integer link[] = new Integer[10]; // A mutatókat tároló tömb
	static int kezd; // a lista első elemére mutató mutató
	static int ures; //Az első ures helyet mutatja

	
	public static void main(String[] args) {
		kezd=NULL; // A lista üresre állítása
		ures=0; // Az első üres hely
		for (int i=0; i<link.length-1;i++) { //Üres helyek listájának előállítása
			link[i]=(i+1);
		}
		link[link.length-1]=NULL; //Az üres helyek utolsó elemének állítása
		for (int i=0;i<NEVEK.length;i++) {
			beszur(NEVEK[i], LAKHELY[i]);
			lista_adat();
			extra.Console.pressEnter();
			System.out.println();
		}
		torol("Ádám Tamás");
		lista_adat();
		extra.Console.pressEnter();		
		torol("Liszkai Péter");
		lista_adat();
		extra.Console.pressEnter();
		beszur("Molnár Gergely","New York");
		lista_adat();
		extra.Console.pressEnter();
		
	} //main
	
	public static boolean beszur(String nev,String cim) {
		int hely; // Annak az elemnek a helye, amely után be kell szúrni az új nevet
		int akt; // Az aktuális elem mutatója
		int elozo; // Az aktuálist megelőző elem mutatója
		int uj; //Az új elem mutatója
		
		hely=NULL;
		if (kezd==NULL) hely=NULL; //Ha üres a lista
		else {// A lista min. 1 elemet tartalmaz
			if (myCollator.compare(nev, info_nev[kezd])<0) hely=NULL;
			//if (mit.compareTo(info_nev[kezd])<0) hely=NULL; //Az első helyre kell beszúrni az új elemet
			else {
				elozo=kezd;
				akt=link[kezd]; //Az aktuális hely beállítása
				while ((akt!=NULL) && (hely==NULL)) { // ciklus, amíg nem lista vége és nincs meg a keresett hely
					if (myCollator.compare(nev, info_nev[akt])<0) //Megvan a hely ?
						hely=elozo; //A hely az aktuális előtti legyen e mögé fogunk beszúrni
					elozo=akt; //Előző legyen az aktuális
					akt=link[akt]; // Aktuális legyen a következő
				}
				if ((hely==NULL) && (akt==NULL)) // Az utolsó helyre kell beszúrni
					hely=elozo; //A hely a lista utolsó eleme, az új elem lesz meajd a legutolsó
			}
		}
		//Itt jön a beszúrás a megkeresett helyre 
		if (ures==NULL) return false; // nincs több üres hely a listán
		else {
			uj=ures; // az uj helyre tesszuk a beszurandó elemet
			ures=link[ures]; // A következő szabad hely állítása
			info_nev[uj]=nev;
			info_cim[uj]=cim;
			if (hely==NULL) { // Ha az elso helyre történt a beszúrás
				link[uj]=kezd; // az új elem az első
				kezd=uj; // az új elem az list eleje
			}
			else {
				link[uj]=link[hely]; //Az új elem követője
				link[hely]=uj; // Ami mögé beszúrtunk az után jöjjön az új elem
			}
			return true;
		}
	} //beszúr metótus
	
	public static boolean torol(String mit) {
		int hely; //Az a hely, ahonnan törölni kell
		int elozo=0; // Annak a helynek az elozoje, amit torolni kell
		int akt; // aktuális hely
		int koveto; // aktualis kovetoje
		
		hely=NULL;
		if (kezd==NULL) {// Ha a lista üres
			hely=NULL;
			elozo=NULL;
			return false;
		}
		else { // A lista min. egy elemet tartalmaz
			if (myCollator.compare(mit, info_nev[kezd])==0) { // A törlendő éppen az első
				hely=kezd; //Az első helyről kell törölni
				elozo=NULL; // Az első előtt nincs semmi
			}
			else { //Nem az első helyen van a törlendő elem
				akt=kezd; // Aktuális legyen az első
				koveto=link[kezd]; // Aktuális követője
				while ((koveto!=NULL) && (hely==NULL)) {
					if (myCollator.compare(mit, info_nev[koveto])==0) { // megvan a keresett elem?
						hely=koveto; // Innen kell rörölni
						elozo=akt; // a törlendő hely előzője
					}
					akt=koveto; // aktuális állítása
					koveto=link[koveto]; // következő legyen a kovetkező utáni
				} //while
				if ((koveto==NULL) && (hely==NULL)) hely=NULL; //nincs meg a keresett elem
			}
			//Itt kezdődik maga a törlés
			if (hely==NULL) //Ha nincs meg a törlendő elem
				return false;
			else 
			{
				if (elozo==NULL) // az első a törlendő elem
					kezd=link[kezd];
				else
					link[elozo]=link[hely]; //törlés
				link[hely]=ures;
				ures=hely;
				return true;
			}
		}
	} //torol metódus 
	
	
	public static void lista_nevszerint() {
		int akt; //Aktuális elem mutatója
		int i=0;
		
		akt=kezd;
		System.out.println("START: "+kezd);
		System.out.println("ÜRES :"+ures);
		System.out.println();
		while (akt!=NULL) { //Amíg nem a lista végén vagyunk
			System.out.print(String.format("%2d",i));
			System.out.print(String.format("  %-20s",info_nev[akt]));
			System.out.print(String.format("  %-20s",info_cim[akt]));
			System.out.print(String.format("  %2d", link[akt]));
			System.out.println();
			i++;
			akt=link[akt]; // Lépés a követő elemre
		} 
		
	} // lista_nevszerint metódus
	
	public static void lista_adat() { //Az eredeti adat tömböt listázza, ahogy az elemek bekerültek
		int i=0;
		
		System.out.println();
		System.out.println("START: "+kezd);
		System.out.println("ÜRES :"+ures);
		System.out.println();
		while (i<=info_nev.length-1) {
			System.out.print(String.format("%2d",i));
			System.out.print(String.format("  %-20s",info_nev[i]));
			System.out.print(String.format("  %-20s",info_cim[i]));
			System.out.print(String.format("  %4d", link[i]));
			System.out.println();
			i++;
		}
		
	} // lista_adat metódus
	
	public int lista_db() { //visszaadja hány eleme van a listának
		int db=0;
		int akt;
		
		akt=kezd;
		while (akt!=NULL ) { //Amíg nem a lista végén vagyunk
			db++;
			akt=link[akt];
		}
		return db;
	}
	
} //lancolt_lista_tombbel class


