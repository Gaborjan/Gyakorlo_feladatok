package karakterlanc_feladatok_16_fejezet;

/*Saját magam által kitalált gyakorló feladatok.*/
import extra.*;
public class Karakter_lanc_gyakorlo_sajat_feladatok {
/*1.) Írjunk metódust, amely egy paraméterként kapott karakterláncot megkeres egy másik, paraméterként kapott karakterláncban.
 * A függvény értéke a keresett karakterlánc kezdõpozicíója legyen. Ha nincs benne a keresett karakterlánc, akkor értéke -1 legyen.
 */
	public static int keres(String miben, String mit) {
		
		int hol=-1; //a végeredmény, kezdeti értéke -1, vagyis nem találtuk meg, amit kerestünk
		boolean egyezik=false; 
		int i=0;
				
		if (miben.length()==0 || mit.length()==0) return hol; //ha a paraméterek üresek, nincs értelme bármit csinálni
		while ((i<=miben.length()-mit.length()) && !egyezik) { //ciklus, amíg nem értünk a miben végére (-a keresett sztring hossza) és még nem találtuk meg a mit-et
			if (miben.charAt(i)==mit.charAt(0)) { //megnézzük az aktuális karakter egyenlõ-e a keresett sztring elsõ karakterével
				int j=1; //a mit sztring akutális elemére mutat
				egyezik=true; // az elsõ karakterek egyeztek, ezért eddig igaz, hogy megtaláltuk, amit kerestünk
				while (egyezik && j<mit.length()) {// sorban lépegetünk végig mit karakterein, amíg egyezeés van
					egyezik=miben.charAt(i+j)==mit.charAt(j); //egyezik igaz, ha miben aktuális karaktere egyezik-e mit aktuális karakterével egyébként hamis
					j++; // mit aktuális elemének növelése
				} //while
				if (egyezik) hol=i; // ha az elõzõ ciklusból úgy léptünk ki, hogy egyezik igaz maradt, az azt jelenti, hogy mit-en végig mentünk és megtaláltuk
				// az találati pozicíó i értéke a külsõ while ciklusból ki fogunk lépni, mivel egyezik már true
			} //if
			i++; // megyünk tovább miben eggyel
		} //whilw
		return hol; 
	} //keres függvény
	
/*2. Írjunk függvényt, amely egy paraméterként kapott karakterláncot kicserél egy másik, paraméterként kapott karakterláncra.	
 */
	public static String csere(String miben, String mit, String mire) {
		
		String eleje	="",vege="",eredmeny=""; //segedváltozók, eredményben lesz a végeredmény
		int holvan; //a cserélendõ rész pozicíója
		
		holvan=keres(miben,mit); //megkeressük mit-et
		vege=miben; // a vége kezdetben az egész szöveg, amiben cserélni kell, késõbb a fennmaradó szövegrész
		if (miben.length()==0 || mit.length()==0) return miben; //ha miben és mit is üres, nincs értelme csinálni semmit, de ha 
		//mire üres, akkor igen, hiszen az törlésnek számít
		while (holvan!=-1 && vege.length()!=0) { //ciklus, amíg találtunk mit-et és még van miben keresni
			eleje=miben.substring(0,holvan); // a megtalált szöveg elõtti rész 
			vege=miben.substring(holvan+mit.length()); //a megtalált szöveg utáni rész a 
			eredmeny=eredmeny+eleje+mire; // az eddigi szöveghez hozzáadjuk a cserélendõ elõttit és azt amire cserélünk
			miben=vege; // most már csak az eredeti szöveg cserélt része utáni részét kell néznünk
			holvan=keres(miben,mit); //van-e még mit sztring a szövegben?
		} //while
		eredmeny=eredmeny+vege; // az eredményhez még hozzá kell adnunk az aktuális vége részt, amiben már nem volt "mit"
		return eredmeny;
	} //csere függvény
	
/*3. Írjunk függvényt, amely egy paraméterként megkapott karakterláncot megfordít. Ne használjuk a reverse metódust!*/
	public static String fordit(String mit) {
		StringBuilder seged = new StringBuilder(mit); //segéd
		for (int i=0;i<seged.length()-1;i++) { //ciklus a sztring hossza mínusz egyig
			seged.insert(i, seged.charAt(seged.length()-1)); //a sztring legelejére beszurjuk a sztring utolsó karakterét
			seged.deleteCharAt(seged.length()-1); //a sztring utolsó karakterét törölhejtük, mert már az elejére tettük
		}
		return seged.toString(); 
	} //fordit függvény
	
	public static void main(String[] args) {
		//System.out.println(stringKeres("a","h"));
		String szoveg="";
		szoveg=csere("Szerintem $ És jól fõz!","$","Janvari Gabika Nagyon Okos!:)) Bizony!");
		System.out.println(szoveg);
		szoveg=csere(szoveg,"Janvari ","");
		System.out.println(szoveg);
		szoveg="aabbaabb";
		szoveg=csere(szoveg,"a","");
		System.out.println(szoveg);
		szoveg="ABCDEFGHIJKLMNOPQRSTUVXYZ";
		System.out.println(fordit(szoveg));
		
	}
}