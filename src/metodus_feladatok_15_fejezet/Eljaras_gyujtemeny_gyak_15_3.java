package metodus_feladatok_15_fejezet;


/*Egyszerûbb fügvények - gyakorlás*/
import extra.*;

public class Eljaras_gyujtemeny_gyak_15_3 {

	static double ketszeres(double szam) {
		return szam*2;
	}
	
	static double gombTerfogat(double sugar) {
		return (4*(Math.pow(sugar,3)*Math.PI)/3);
	}
	
	static double korTerulet(double sugar) {
		return 2*sugar*Math.PI;
	}
	
	static boolean pozitiv(double szam) {
		return szam>0;
	}
	
	static boolean tartomany(char tol, char ig, char mi) {
		return (mi>=tol && mi<=ig);
	}
	
	static char karakterMin(char a, char b) {
		if (a>b) return b;
		else return a;
	}
	
	static long hatarOsszeg(long kezd, long veg) {
		long osszeg=0;
		for (long i=kezd;i<=veg;i++) osszeg+=i;
		return osszeg;
	}
	
	static double cmToInch(double cm) {
		return cm*2.54;
	}
	/*Egy számról eldönti, prím-e*/
	static boolean prime(long szam) {
		int oszto=2;
		boolean prim=false;
		if (szam<=0 || szam==1) return false;
		else if (szam==2) return true;
		else
		{
			do {
				prim=szam%oszto!=0;
				if (oszto>2) oszto+=2;
				else oszto++;
			} while (prim && oszto<=Math.sqrt(szam)); 
			return prim;
		}
		
	}
	/*A paraméterként megkapott számnál kisebb összes prímet kiírja. Minden
	 * prím szám elé kiírja hányadik prím.
	 */
	static void kisebbPrim(long szam) {
		int szamlalo=1;
		for (long i=2;i<=szam;i++) {
			if (prime(i)) {
				System.out.println(szamlalo+". prím: "+i);
				szamlalo++;
			}
		}
	}
	
	/*Kap egy számot és visszaadja hány nála kisebb prím van.*/
	static int hanyKisebbPrim(long szam){
		int szamlalo=0;
		for (long i=2;i<=szam;i++)
			if (prime(i)) szamlalo++;
		return szamlalo;
	}
	
	/*Kap egy számot és visszaadja az elsõ nála nagyobb prím számot.*/
	static long elsoNagyobbPrim(long szam) {
		long elsoNagyobb=szam;
		while (!prime(elsoNagyobb)) 
			elsoNagyobb++;
		return elsoNagyobb;
	}
	
	public static void main(String[] args) {
		System.out.println(ketszeres(100));
		System.out.println(gombTerfogat(1));
		System.out.println(korTerulet(1));
		System.out.println(pozitiv(6));
		System.out.println(tartomany('1','9','0'));
		System.out.println(karakterMin('a','g'));
		System.out.println(hatarOsszeg(1,500));
		System.out.println(cmToInch(6.5));
		kisebbPrim(100);
		System.out.println(hanyKisebbPrim(100)+" darab, 100-nál kisebb prímszám van.");
		System.out.println("Az elsõ 95-nál nagyobb prímszám:"+elsoNagyobbPrim(95));
				
	}
	
	

}
 