package metodus_feladatok_15_fejezet;

/*Írjon metódust, amelynek
 * a) nincs paramétere, és 10-szer leírja, hogy "Ezentúl mindig szépen struktúrálom a programomat"
 * b) egy paramétere van, és 10-szer leírja, a paraméterben megadott szoveget
 * c) két paramétere van és a paraméterben megadott számszor kiírja a paraméterben megkapott szöveget
 * A három eljárásnak ugyanaz legyen a neve!
 */
import extra.*;


public class Metodus_feladat_15_1 {
	static int sajatValtozom=0;
	
	public static void kiIromAmitKapok() {
		for (int i=1;i<=10;i++)
			System.out.println("Ezentúl minidig szépen struktúrálom a programomat!");
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
		szoveg=Console.readLine("Add meg mit írjak ki 10-szer:");
		kiIromAmitKapok(szoveg);
		darab=Console.readInt("Most már azt is add meg, hányszor írjam ki:");
		kiIromAmitKapok(szoveg,darab);
		ir("Program vége:"+getSzamlalo());
		Console.pressEnter();
	}

}
