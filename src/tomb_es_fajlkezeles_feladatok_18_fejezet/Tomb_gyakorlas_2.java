package tomb_es_fajlkezeles_feladatok_18_fejezet;


public class Tomb_gyakorlas_2 {
private static final int oszlopdb = 10;
private static final int sordb = 3;
public static void main(String[] args) {
	/* Adott egy n x m méretû, egész számokból álló tömb. Adjuk össze a sorokban és oszlopokban 
	 * lévõ számokat, és írjuk ki a sorok/oszlopok végére.
	 */
	int [][] tomb = {{1,2,3,4,5,6,7,8,9,10},{2,4,6,8,10,12,14,16,18,20},{10,9,8,7,6,5,4,3,2,1}};
	int [] sorosszeg = new int [sordb];
	int [] oszloposszeg = new int [oszlopdb];
	int szumma;
	int o, s;
	for ( s=0; s<tomb.length; s++ ) {
		for (o=0; o<tomb[s].length; o++) {
			sorosszeg[s]+=tomb[s][o];
		}
	}
	for (s=0; s<tomb.length;s++) {
		for (o=0; o<tomb[s].length; o++) {
			System.out.printf("%4d",tomb[s][o]);
		}
		System.out.printf("%4d\n",sorosszeg[s]);
	}
	for (s=0; s<tomb.length; s++) {
		for (o=0; o<tomb[s].length; o++) {
			oszloposszeg[o]+=tomb[s][o];
		}
	}
	Vonal();	
	for (o=0; o<oszloposszeg.length; o++) {
		System.out.printf("%4d",oszloposszeg[o]);
	}
	szumma=0;
	for (s=0; s<tomb.length; s++) {
		szumma+=sorosszeg[s];
	}
	System.out.printf("%4d", szumma);
}
public static void Vonal() {
	for (int v=0; v<((oszlopdb+1)*4); v++) {
		System.out.print("-");
	}
	System.out.print("\n");
}
}
