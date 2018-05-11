package karakterlanc_feladatok_16_fejezet;

/*�rjunk met�dust, amely a param�terk�nt megadott karakterl�ncban bizonyos karakterl�ncot m�sikra cser�l.*/
import extra.*;
public class SzoCsere_16_5 {

	public static void csere(StringBuilder miben, String mit, String mire) { // void, mivel az eredeti sztringet m�dos�tjuk
		int poz=miben.indexOf(mit); // Megkeress�k az mit els� el�fordul�s�t
		while (poz!=-1) { //am�g van m�g keresend� sz�
			miben.replace(poz, poz+mit.length(), mire); //a megtal�lt sz� pozic��j�t�l "mit" hosszban csere mire sz�vegre
			poz=miben.indexOf(mit, poz+mire.length()); // Megn�zz�k a kicser�lt sz�vegr�sz ut�n van-e m�g "mit", sz�vegr�sz, amit cser�lni kell 
		}
		
	}
	public static void main(String[] args) {
		StringBuilder nev = new StringBuilder("");
		nev.append("AAAAA");
		csere(nev,"A","AB");
		System.out.println(nev.toString());
	}
}
