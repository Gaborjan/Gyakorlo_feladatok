package lottozzunk_feladat;
//Verzió: 2018.01.04. V2.0
import extra.Console;
import java.util.Scanner;
public class Lottozzunk { 

	public static void main(String[] args) {
		int[] tipp = {90,89,88,87,1,2};
		int[] sorsolas = new int [6];
		int[] talalat = new int [7]; // A nulla találatokat is jegyezzük, ezért 6 elemre van szükségünk
		int sorsolasdb = 0;
		int sorsoltszam =0;
		int seged = 0;
		boolean voltmar = false;
		long kezdido,vegido;
		char valasz=' ';
		char megjatek= ' ';
		int egytipp;
		boolean helyestipp=true;
		int jatektipus=0;
		Scanner beolvas = new Scanner(System.in);
		System.out.println("Ez a program az ötös lottó sorsolást szimulálja, véletlenszerű sorsolásokat");
		System.out.println("végez. Bekéri hány sorsolást végezzen, majd a tippeket, 1-90 közötti ");
		System.out.println("számokat. A végén kiírja hány nyeretlen sorsolás (0 vagy 1 eltalált szám),"); 
		System.out.println("illetve milyen találatok voltak.\n");
		valasz='9';
		while (valasz!='3') { //Ciklus, míg nem kilépés a programból
			do { //Ciklus, míg helyes funkciót nem választ.
				System.out.println("Válaszd ki melyik lottóval szeretnél játszani:");
				System.out.println("---------------------------------------------");
				System.out.println("1. Ötöslottó\n");
				System.out.println("2. Hatos lottó\n");
				System.out.println("3. Kilépés a programból\n");
				System.out.println("Válassz:");
				valasz=Console.readChar();
			} while (valasz!='1' && valasz!='2' && valasz!='3');
			if (valasz=='1' || valasz=='2') {
				do { //Ciklus, amíg kér újabb sorsolást.
					if (valasz=='1') {
						System.out.println("* * * Ö T Ö S L O T T Ó * * *");
						jatektipus=5;
					}
					else {
						System.out.println("* * * H A T O S L O T T Ó * * *");
						jatektipus=6;
					}
					for (int i=0; i<jatektipus;i++) //Tippek nullázása
						tipp[i]=0;
					for (int i=0;i<jatektipus+1;i++) // Találatok nullázása
						talalat[i]=0;
					System.out.print("Add meg hány sorsolást szeretnél (max.: 2 milliárd): ");
					do { //Ciklus, amíg helyes sorsolás darabszámot nem ad meg.
						sorsolasdb = beolvas.nextInt();
						if (sorsolasdb<1 || sorsolasdb>2000000000) 
						System.out.println("Legalább 1 db, maximum 2 milliárd db sorsolás lehet!");
					} while (sorsolasdb<1 || sorsolasdb>2000000000);
					System.out.println();
					for (int i=0; i<jatektipus; i++) { //Tippek bek�r�se
						do { //Ciklus, amíg olyan tippet nem kapunk, ami még nem volt 
							do { //Ciklus, amíg helyes tippet nem kapunk, 1-45/90 között 
								if (jatektipus==5) System.out.print("Kérem a(z) "+(i+1)+". tippet (1-90): ");
								else System.out.print("Kérem a(z) "+(i+1)+". tippet (1-45): ");
								egytipp = beolvas.nextInt();
								if (jatektipus==5) helyestipp=egytipp<=90 && egytipp>=1; 
								else helyestipp=egytipp<=45 && egytipp>=1; 
								if (!helyestipp && jatektipus==5) 
									System.out.println("1 és 90 közötti számot adj meg!");
								else if (!helyestipp && jatektipus==6) System.out.println("1 és 45 közötti számot adj meg!");
								} while (!helyestipp);
							if (jatektipus==5) voltmar=egytipp==tipp[0] || egytipp==tipp[1] || egytipp==tipp[2] || egytipp==tipp[3] || egytipp==tipp[4];
							else voltmar=egytipp==tipp[0] || egytipp==tipp[1] || egytipp==tipp[2] || egytipp==tipp[3] || egytipp==tipp[4] || egytipp==tipp[5];
							if (voltmar)
								System.out.println("Ilyen tipp már van, adj meg másik számot!");
							} while (voltmar) ;
							tipp[i] = egytipp;
						} //for ciklus vége, egy helyes tipp beolvasása
						System.out.println();
					if (jatektipus==5) System.out.println("A tippjeid: "+tipp[0]+ "  "+tipp[1]+"  "+tipp[2]+"  "+tipp[3]+"  "+tipp[4]+"\n");
					else System.out.println("A tippjeid: "+tipp[0]+ "  "+tipp[1]+"  "+tipp[2]+"  "+tipp[3]+"  "+tipp[4]+"  "+tipp[5]+"\n");
					System.out.println("Kis türelmet, dolgozom...\n");
					kezdido=System.currentTimeMillis();
					for (int i=1; i<=sorsolasdb; i++) { // Ciklus annyiszor, ahány sorsolast szeretnénk.
						for (int j=0; j<jatektipus; j++)  //Egy sorsolás számainak nullázása
								sorsolas[j]=0;
						for (int j=0; j<jatektipus; j++) {// Előállítjuk egy sorsol�s számait
							do {
								if (jatektipus==5) sorsoltszam = (int) (Math.random()*90)+1;
								else sorsoltszam = (int) (Math.random()*45)+1;
								//Megnézzük volt-e már ez a szám sorsolva?
								if (jatektipus==5) voltmar=((sorsoltszam==sorsolas[0]) || (sorsoltszam==sorsolas[1]) ||	(sorsoltszam==sorsolas[2]) || 
															(sorsoltszam==sorsolas[3]) || (sorsoltszam==sorsolas[4]));
								else voltmar=((sorsoltszam==sorsolas[0]) || (sorsoltszam==sorsolas[1]) || (sorsoltszam==sorsolas[2]) || (sorsoltszam==sorsolas[3]) ||
											(sorsoltszam==sorsolas[4]) || (sorsoltszam==sorsolas[5]));
							} while (voltmar); //Akkor lépünk KI a ciklusból, ha feltétel HAMISS�? válik!
							sorsolas[j]=sorsoltszam;
						} //for, egy sorsolás számainak előállítása
						// összehasonlítjuk a sorsolás eredményeit a tippekkel
						//for (int k=0;k<jatektipus;k++)
							//System.out.printf("%8d",sorsolas[k]);
						//System.out.println();
						for (int j=0; j<jatektipus; j++) //{ //Vegigmegyünk a sorsolt számokon
							for (int k=0; k<jatektipus; k++)  //Összehasonlítjuk a az adott sorsolt számot a tippekkel
								if (sorsolas[j]==tipp[k])  // Van-e találat?
									seged++; // Találatok számának növelése
							//}//for egy sorsolás találatszámlálásának vége
						talalat[seged]++;// A találatok számát megnöveljük eggyel.
						seged=0;
					}//sorsolásdb vége
					vegido=System.currentTimeMillis();
					System.out.printf("Nulla találat : %,12d db, ez az összes tipp %8.4f%%-a.\n", talalat[0], ((float) talalat[0]/sorsolasdb)*100);
					System.out.printf("Egyes találat : %,12d db, ez az összes tipp %8.4f%%-a.\n", talalat[1], ((float) talalat[1]/sorsolasdb)*100);
					System.out.printf("Kettes találat: %,12d db, ez az összes tipp %8.4f%%-a.\n", talalat[2], ((float) talalat[2]/sorsolasdb)*100);
					System.out.printf("Hármas találat: %,12d db, ez az összes tipp %8.4f%%-a.\n", talalat[3], ((float) talalat[3]/sorsolasdb)*100);
					System.out.printf("Négyes találat: %,12d db, ez az összes tipp %8.4f%%-a.\n", talalat[4], ((float) talalat[4]/sorsolasdb)*100);
					System.out.printf("Ötös találat  : %,12d db, ez az összes tipp %8.4f%%-a.\n", talalat[5], ((float) talalat[5]/sorsolasdb)*100);
					if (jatektipus==6) 
						System.out.printf("Hatos találat : %,12d db, ez az összes tipp %8.4f%%-a.\n", talalat[6],((float) talalat[6]/sorsolasdb)*100);
					System.out.println();
					System.out.printf("Sorsolások száma:%,12d darab\n",sorsolasdb);
					System.out.printf("A program futtatásához szükséges idő: %,8d ms\n",(vegido-kezdido));
					System.out.println();
					System.out.println("Szeretnél még sorsolást? <I>gen/<N>em");
					megjatek=Console.readChar();
				} while (Character.toUpperCase(megjatek)=='I'); 
		} //if Ha a valasz 1 vagy 2, vagyis választ az ötös és hatos lottó közül.
	} //while, amíg nem kilépést választ a menüből.
	System.out.println("Program vége.");
	beolvas.close();
	} //main
} //class
 