package karakterlanc_feladatok_16_fejezet;

/*Saj�t magam �ltal kital�lt gyakorl� feladatok.*/
import extra.*;
public class Karakter_lanc_gyakorlo_sajat_feladatok {
/*1.) �rjunk met�dust, amely egy param�terk�nt kapott karakterl�ncot megkeres egy m�sik, param�terk�nt kapott karakterl�ncban.
 * A f�ggv�ny �rt�ke a keresett karakterl�nc kezd�pozic��ja legyen. Ha nincs benne a keresett karakterl�nc, akkor �rt�ke -1 legyen.
 */
	public static int keres(String miben, String mit) {
		
		int hol=-1; //a v�geredm�ny, kezdeti �rt�ke -1, vagyis nem tal�ltuk meg, amit kerest�nk
		boolean egyezik=false; 
		int i=0;
				
		if (miben.length()==0 || mit.length()==0) return hol; //ha a param�terek �resek, nincs �rtelme b�rmit csin�lni
		while ((i<=miben.length()-mit.length()) && !egyezik) { //ciklus, am�g nem �rt�nk a miben v�g�re (-a keresett sztring hossza) �s m�g nem tal�ltuk meg a mit-et
			if (miben.charAt(i)==mit.charAt(0)) { //megn�zz�k az aktu�lis karakter egyenl�-e a keresett sztring els� karakter�vel
				int j=1; //a mit sztring akut�lis elem�re mutat
				egyezik=true; // az els� karakterek egyeztek, ez�rt eddig igaz, hogy megtal�ltuk, amit kerest�nk
				while (egyezik && j<mit.length()) {// sorban l�peget�nk v�gig mit karakterein, am�g egyeze�s van
					egyezik=miben.charAt(i+j)==mit.charAt(j); //egyezik igaz, ha miben aktu�lis karaktere egyezik-e mit aktu�lis karakter�vel egy�bk�nt hamis
					j++; // mit aktu�lis elem�nek n�vel�se
				} //while
				if (egyezik) hol=i; // ha az el�z� ciklusb�l �gy l�pt�nk ki, hogy egyezik igaz maradt, az azt jelenti, hogy mit-en v�gig ment�nk �s megtal�ltuk
				// az tal�lati pozic�� i �rt�ke a k�ls� while ciklusb�l ki fogunk l�pni, mivel egyezik m�r true
			} //if
			i++; // megy�nk tov�bb miben eggyel
		} //whilw
		return hol; 
	} //keres f�ggv�ny
	
/*2. �rjunk f�ggv�nyt, amely egy param�terk�nt kapott karakterl�ncot kicser�l egy m�sik, param�terk�nt kapott karakterl�ncra.	
 */
	public static String csere(String miben, String mit, String mire) {
		
		String eleje	="",vege="",eredmeny=""; //segedv�ltoz�k, eredm�nyben lesz a v�geredm�ny
		int holvan; //a cser�lend� r�sz pozic��ja
		
		holvan=keres(miben,mit); //megkeress�k mit-et
		vege=miben; // a v�ge kezdetben az eg�sz sz�veg, amiben cser�lni kell, k�s�bb a fennmarad� sz�vegr�sz
		if (miben.length()==0 || mit.length()==0) return miben; //ha miben �s mit is �res, nincs �rtelme csin�lni semmit, de ha 
		//mire �res, akkor igen, hiszen az t�rl�snek sz�m�t
		while (holvan!=-1 && vege.length()!=0) { //ciklus, am�g tal�ltunk mit-et �s m�g van miben keresni
			eleje=miben.substring(0,holvan); // a megtal�lt sz�veg el�tti r�sz 
			vege=miben.substring(holvan+mit.length()); //a megtal�lt sz�veg ut�ni r�sz a 
			eredmeny=eredmeny+eleje+mire; // az eddigi sz�veghez hozz�adjuk a cser�lend� el�ttit �s azt amire cser�l�nk
			miben=vege; // most m�r csak az eredeti sz�veg cser�lt r�sze ut�ni r�sz�t kell n�zn�nk
			holvan=keres(miben,mit); //van-e m�g mit sztring a sz�vegben?
		} //while
		eredmeny=eredmeny+vege; // az eredm�nyhez m�g hozz� kell adnunk az aktu�lis v�ge r�szt, amiben m�r nem volt "mit"
		return eredmeny;
	} //csere f�ggv�ny
	
/*3. �rjunk f�ggv�nyt, amely egy param�terk�nt megkapott karakterl�ncot megford�t. Ne haszn�ljuk a reverse met�dust!*/
	public static String fordit(String mit) {
		StringBuilder seged = new StringBuilder(mit); //seg�d
		for (int i=0;i<seged.length()-1;i++) { //ciklus a sztring hossza m�nusz egyig
			seged.insert(i, seged.charAt(seged.length()-1)); //a sztring legelej�re beszurjuk a sztring utols� karakter�t
			seged.deleteCharAt(seged.length()-1); //a sztring utols� karakter�t t�r�lhejt�k, mert m�r az elej�re tett�k
		}
		return seged.toString(); 
	} //fordit f�ggv�ny
	
	public static void main(String[] args) {
		//System.out.println(stringKeres("a","h"));
		String szoveg="";
		szoveg=csere("Szerintem $ �s j�l f�z!","$","Janvari Gabika Nagyon Okos!:)) Bizony!");
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