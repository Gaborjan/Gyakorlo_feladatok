package karakterlanc_feladatok_16_fejezet;

/*Írjunk metódust, amely a paraméterként megadott karakterláncban bizonyos karakterláncot másikra cserél.*/
import extra.*;
public class SzoCsere_16_5 {

	public static void csere(StringBuilder miben, String mit, String mire) { // void, mivel az eredeti sztringet módosítjuk
		int poz=miben.indexOf(mit); // Megkeressük az mit elsõ elõfordulását
		while (poz!=-1) { //amíg van még keresendõ szó
			miben.replace(poz, poz+mit.length(), mire); //a megtalált szó pozicíójától "mit" hosszban csere mire szövegre
			poz=miben.indexOf(mit, poz+mire.length()); // Megnézzük a kicserélt szövegrész után van-e még "mit", szövegrész, amit cserélni kell 
		}
		
	}
	public static void main(String[] args) {
		StringBuilder nev = new StringBuilder("");
		nev.append("AAAAA");
		csere(nev,"A","AB");
		System.out.println(nev.toString());
	}
}
