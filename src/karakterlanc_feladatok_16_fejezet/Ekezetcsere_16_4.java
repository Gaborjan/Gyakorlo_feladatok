package karakterlanc_feladatok_16_fejezet;

/*Kérjen be egy szöveget, majd cserélje le benne az összes ékezetes betűt ékezet nélkülire*/
import extra.*;
public class Ekezetcsere_16_4 {

	static char betuCsere(char betu) {
		char eredmeny=' ';
		switch (betu) {
			case 'á':eredmeny='a'; break;
			case 'é':eredmeny='e'; break;
			case 'í':eredmeny='i'; break;
			case 'ó':eredmeny='o'; break;
			case 'ö':eredmeny='o'; break;
			case 'ő':eredmeny='o'; break;
			case 'ú':eredmeny='u'; break;
			case 'ü':eredmeny='u'; break;
			case 'ű':eredmeny='u'; break;
			case 'Á':eredmeny='A'; break;
			case 'É':eredmeny='E'; break;
			case 'Í':eredmeny='I'; break;
			case 'Ó':eredmeny='O'; break;
			case 'Ö':eredmeny='O'; break;
			case 'Ő':eredmeny='O'; break;
			case 'Ú':eredmeny='U'; break;
			case 'Ü':eredmeny='U'; break;
			case 'Ű':eredmeny='U'; break;
			default: eredmeny=betu;
		}
		return eredmeny;
	}
	
	static String ekezetekCsere(String szoveg) {
		String eredmeny="";
		for (int i=0;i<szoveg.length();i++)
			eredmeny=eredmeny+betuCsere(szoveg.charAt(i));
		return eredmeny;
	}
	public static void main(String[] args) {
		String atalakintando;
		System.out.println("Egy megadott magyar nyelvű szövegben minden ékezetes karaktert ékezet nélkülire cserélek!");
		atalakintando=Console.readLine("Írja be az átalakítandó szöveget:");
		System.out.println(ekezetekCsere(atalakintando));
	}

}
