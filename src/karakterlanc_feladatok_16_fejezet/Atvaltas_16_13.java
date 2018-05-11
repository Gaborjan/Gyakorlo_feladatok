package karakterlanc_feladatok_16_fejezet;

import extra.Console;

/*K�rjen be egy sz�veget. A sz�vegben szerepl� �sszes �tv�ltand� deviz�t v�ltsa �t egy m�sikra Pl. ha a 1$=280 Ft, akkor 21 USD helyett
 * 5880 HUF szerepeljen a sz�vegben. Tegy�k fel, hogy a  deviz�k form�ja: egy eg�sz sz�m, egy sz�k�z �s a deviza 3 nagybet�s
 * k�dja (pl. USD,HUF,EUR. �rja ki az �talak�tott sz�veget! 
 */
public class Atvaltas_16_13 {
	static final String MIROLDEVIZAJEL="Ft"; //Mir�l v�ltunk �t
	static final double ARFOLYAM=0.004;  
	static final String CSEREDEVIZAJEL="$"; //Mire v�ltjuk?
	
	/*Egy NNNN MIROLDEVIZA form�tum� sztring-et v�r param�terk�nt. �tv�ltja a CSEREDEVIZA �rfolyam�ra, 2 tizedesre kerek�tve,
	 * kicser�li a deviza k�dot CSEREDEVIZAJEL-re. Az eredm�nyt stringk�nt visszaadja.
	 */
	public static String atvalt(String szoveg) {
		double forint;
		forint=Double.parseDouble(szoveg.substring(0,szoveg.length()-1)); // �rt�k �talak�t�sa sz�mm�
		forint=forint*ARFOLYAM; //�rfolyamv�lt�s
		return String.format("%.2f "+CSEREDEVIZAJEL,forint); // 2 tizedesre form�zva, devizajellel kieg�sz�tve adjuk vissza forint �rt�k�t
				
	}
	
	/*Megkeresi a feladatban megadott sz�vegr�szeket �s mindet kicser�li a feladat szerint*/
	public static String devizaKeres(String szoveg) {
		StringBuilder seged = new StringBuilder(szoveg); //seged, amiben csereber�l�nk 
		int 
		dollarJel=0, // itt van a cser�lend� devizak�d eleje (Pl.: USD->U) 
		dollarElso=0; //itt kezd�dik a cser�lend� �sszeg
		dollarJel=seged.indexOf(MIROLDEVIZAJEL);// A cser�lend� deviza helye 
		while (dollarJel!=-1) { //Am�g van mit cser�lni
			//Ha a keresett deviza el� f�r legal�bb egy sz�mjegy �s a sz�k�z �s a deviza el�tti hely sz�k�z, el�tte pedig sz�mjegy van
			if ( (dollarJel>=2 ) && (Character.isSpaceChar(seged.charAt(dollarJel-1))) && (Character.isDigit(seged.charAt(dollarJel-2))) ) {
				dollarElso=dollarJel-2; //az �sszeg kezdete
				//Am�g nem �rt�k el a string elej�t �s az eggyel el�bbi is sz�m
				// Fontos a felt�telek sorrendje, le ne l�pj�nk a sztringr�l! 
				while ((dollarElso>0) && Character.isDigit(seged.charAt(dollarElso-1))) 
					dollarElso--; // N�zz�k az eggyel el�bbi karaktert, sz�mjegy-e?
				//A deviza �rt�k els� sz�mjegy�t�l a devizak�d v�g�ig l�v� sz�veget kicser�lj�k az �tv�ltott deviz�ra
				seged.replace(dollarElso, dollarJel+MIROLDEVIZAJEL.length(), atvalt(seged.substring(dollarElso, dollarJel)));
				//Megkeress�k a k�vetkez� �tv�ltand� devizajel hely�t
				dollarJel=seged.indexOf(MIROLDEVIZAJEL);
			}
			else
				//Ha tal�ltunk ugyan devizajelet, de el�tte nincs legal�bb 1 sz�mjegy� deviza�rt�k, tov�bb l�p�nk 
				dollarJel=seged.indexOf(MIROLDEVIZAJEL, dollarJel+MIROLDEVIZAJEL.length());
		}
		return seged.toString();
	}
	
	public static void main(String[] args) {
	/*String szoveg;
	szoveg=Console.readLine("K�rem a sz�veget: ");*/
	System.out.println(devizaKeres("250 Ft �sszeg 125 Ft 500 Ft M�sik �sszeg Ft 5000 Ft"));
	System.out.println("Program v�ge");
	}

}
