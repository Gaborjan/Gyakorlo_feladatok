package metodus_feladatok_15_fejezet;

/*�rjon met�dust, amelynek
 * a) nincs param�tere, �s 10-szer le�rja, hogy "Ezent�l mindig sz�pen strukt�r�lom a programomat"
 * b) egy param�tere van, �s 10-szer le�rja, a param�terben megadott szoveget
 * c) k�t param�tere van �s a param�terben megadott sz�mszor ki�rja a param�terben megkapott sz�veget
 * A h�rom elj�r�snak ugyanaz legyen a neve!
 */
import extra.*;


public class Metodus_feladat_15_1 {
	static int sajatValtozom=0;
	
	public static void kiIromAmitKapok() {
		for (int i=1;i<=10;i++)
			System.out.println("Ezent�l minidig sz�pen strukt�r�lom a programomat!");
		szamlalo();
	}
	
	public static void kiIromAmitKapok(String mitIrjakKi) {
		for (int i=1;i<=10;i++)
			System.out.println(mitIrjakKi);
		szamlalo();
	}
	
	public static void kiIromAmitKapok(String mitIrjakKi, int hanyszor) {
		for (int i=1;i<=hanyszor;i++)
			System.out.println(mitIrjakKi);
		szamlalo();
	}
	
	public static void ir(String mit) {
		System.out.println(mit);
	}
	
	static void szamlalo() {
		sajatValtozom++;
	}
	
	public static int getSzamlalo() {
		return sajatValtozom;
	}
	
	public static void main(String[] args) {
		String szoveg;
		int darab;
		kiIromAmitKapok();
		szoveg=Console.readLine("Add meg mit �rjak ki 10-szer:");
		kiIromAmitKapok(szoveg);
		darab=Console.readInt("Most m�r azt is add meg, h�nyszor �rjam ki:");
		kiIromAmitKapok(szoveg,darab);
		ir("Program v�ge:"+getSzamlalo());
		Console.pressEnter();
	}

}
