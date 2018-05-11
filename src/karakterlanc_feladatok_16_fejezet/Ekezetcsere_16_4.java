package karakterlanc_feladatok_16_fejezet;

/*K�rjen be egy sz�veget, majd cser�lje le benne az �sszes �kezetes bet�t �kezet n�lk�lire*/
import extra.*;
public class Ekezetcsere_16_4 {

	static char betuCsere(char betu) {
		char eredmeny=' ';
		switch (betu) {
			case '�':eredmeny='a'; break;
			case '�':eredmeny='e'; break;
			case '�':eredmeny='i'; break;
			case '�':eredmeny='o'; break;
			case '�':eredmeny='o'; break;
			case '�':eredmeny='o'; break;
			case '�':eredmeny='u'; break;
			case '�':eredmeny='u'; break;
			case '�':eredmeny='u'; break;
			case '�':eredmeny='A'; break;
			case '�':eredmeny='E'; break;
			case '�':eredmeny='I'; break;
			case '�':eredmeny='O'; break;
			case '�':eredmeny='O'; break;
			case '�':eredmeny='O'; break;
			case '�':eredmeny='U'; break;
			case '�':eredmeny='U'; break;
			case '�':eredmeny='U'; break;
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
		System.out.println("Egy megadott magyar nyelv� sz�vegben minden �kezetes karaktert �kezet n�lk�lire cser�lek!");
		atalakintando=Console.readLine("�rja be az �talak�tand� sz�veget:");
		System.out.println(ekezetekCsere(atalakintando));
	}

}
