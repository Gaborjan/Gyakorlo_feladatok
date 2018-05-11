package metodus_feladatok_15_fejezet;


/*Egyszer�bb f�gv�nyek - gyakorl�s*/
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
	/*Egy sz�mr�l eld�nti, pr�m-e*/
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
	/*A param�terk�nt megkapott sz�mn�l kisebb �sszes pr�met ki�rja. Minden
	 * pr�m sz�m el� ki�rja h�nyadik pr�m.
	 */
	static void kisebbPrim(long szam) {
		int szamlalo=1;
		for (long i=2;i<=szam;i++) {
			if (prime(i)) {
				System.out.println(szamlalo+". pr�m: "+i);
				szamlalo++;
			}
		}
	}
	
	/*Kap egy sz�mot �s visszaadja h�ny n�la kisebb pr�m van.*/
	static int hanyKisebbPrim(long szam){
		int szamlalo=0;
		for (long i=2;i<=szam;i++)
			if (prime(i)) szamlalo++;
		return szamlalo;
	}
	
	/*Kap egy sz�mot �s visszaadja az els� n�la nagyobb pr�m sz�mot.*/
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
		System.out.println(hanyKisebbPrim(100)+" darab, 100-n�l kisebb pr�msz�m van.");
		System.out.println("Az els� 95-n�l nagyobb pr�msz�m:"+elsoNagyobbPrim(95));
				
	}
	
	

}
 