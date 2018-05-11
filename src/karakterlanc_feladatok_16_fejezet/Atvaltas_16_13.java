package karakterlanc_feladatok_16_fejezet;

import extra.Console;

/*Kérjen be egy szöveget. A szövegben szereplõ összes átváltandó devizát váltsa át egy másikra Pl. ha a 1$=280 Ft, akkor 21 USD helyett
 * 5880 HUF szerepeljen a szövegben. Tegyük fel, hogy a  devizák formája: egy egész szám, egy szóköz és a deviza 3 nagybetûs
 * kódja (pl. USD,HUF,EUR. Írja ki az átalakított szöveget! 
 */
public class Atvaltas_16_13 {
	static final String MIROLDEVIZAJEL="Ft"; //Mirõl váltunk át
	static final double ARFOLYAM=0.004;  
	static final String CSEREDEVIZAJEL="$"; //Mire váltjuk?
	
	/*Egy NNNN MIROLDEVIZA formátumú sztring-et vár paraméterként. Átváltja a CSEREDEVIZA árfolyamára, 2 tizedesre kerekítve,
	 * kicseréli a deviza kódot CSEREDEVIZAJEL-re. Az eredményt stringként visszaadja.
	 */
	public static String atvalt(String szoveg) {
		double forint;
		forint=Double.parseDouble(szoveg.substring(0,szoveg.length()-1)); // érték átalakítása számmá
		forint=forint*ARFOLYAM; //árfolyamváltás
		return String.format("%.2f "+CSEREDEVIZAJEL,forint); // 2 tizedesre formázva, devizajellel kiegészítve adjuk vissza forint értékét
				
	}
	
	/*Megkeresi a feladatban megadott szövegrészeket és mindet kicseréli a feladat szerint*/
	public static String devizaKeres(String szoveg) {
		StringBuilder seged = new StringBuilder(szoveg); //seged, amiben csereberélünk 
		int 
		dollarJel=0, // itt van a cserélendõ devizakód eleje (Pl.: USD->U) 
		dollarElso=0; //itt kezdõdik a cserélendõ összeg
		dollarJel=seged.indexOf(MIROLDEVIZAJEL);// A cserélendõ deviza helye 
		while (dollarJel!=-1) { //Amíg van mit cserélni
			//Ha a keresett deviza elé fér legalább egy számjegy és a szóköz és a deviza elõtti hely szóköz, elõtte pedig számjegy van
			if ( (dollarJel>=2 ) && (Character.isSpaceChar(seged.charAt(dollarJel-1))) && (Character.isDigit(seged.charAt(dollarJel-2))) ) {
				dollarElso=dollarJel-2; //az összeg kezdete
				//Amíg nem értük el a string elejét és az eggyel elõbbi is szám
				// Fontos a feltételek sorrendje, le ne lépjünk a sztringrõl! 
				while ((dollarElso>0) && Character.isDigit(seged.charAt(dollarElso-1))) 
					dollarElso--; // Nézzük az eggyel elõbbi karaktert, számjegy-e?
				//A deviza érték elsõ számjegyétõl a devizakód végéig lévõ szöveget kicseréljük az átváltott devizára
				seged.replace(dollarElso, dollarJel+MIROLDEVIZAJEL.length(), atvalt(seged.substring(dollarElso, dollarJel)));
				//Megkeressük a következõ átváltandó devizajel helyét
				dollarJel=seged.indexOf(MIROLDEVIZAJEL);
			}
			else
				//Ha találtunk ugyan devizajelet, de elõtte nincs legalább 1 számjegyû devizaérték, tovább lépünk 
				dollarJel=seged.indexOf(MIROLDEVIZAJEL, dollarJel+MIROLDEVIZAJEL.length());
		}
		return seged.toString();
	}
	
	public static void main(String[] args) {
	/*String szoveg;
	szoveg=Console.readLine("Kérem a szöveget: ");*/
	System.out.println(devizaKeres("250 Ft Összeg 125 Ft 500 Ft Másik összeg Ft 5000 Ft"));
	System.out.println("Program vége");
	}

}
