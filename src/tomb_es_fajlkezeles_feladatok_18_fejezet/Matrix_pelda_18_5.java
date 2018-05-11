package tomb_es_fajlkezeles_feladatok_18_fejezet;

/* Két dimenziós tömb manipulálása, példa*/

import extra.*;

public class Matrix_pelda_18_5 {
	static int printN=0;
	static int[][] matrix = new int[5][3];
	
	//A mátrix kiírása soronként:
	static void printMatrix() {
		printN++;
		System.out.println("----"+printN+"----");
		for (int i=0; i<5; i++) {
			for (int j=0; j<3; j++)
				System.out.printf("%3s  ", matrix[i][j]);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println("Sorok száma:    ="+matrix.length);
		System.out.println("Oszlopok száma: ="+matrix[0].length);
		
		int ertek=0;
		for (int i=0; i<5; i++) 
			for (int j=0; j<3; j++)
				matrix[i][j] = ++ertek;
		printMatrix();
		//2. sor másolása 1. sorba
		System.arraycopy(matrix[2], 0, matrix[1], 0, matrix[1].length);
		printMatrix();
		//2. sor 1. oszlopa ==999
		matrix[2][1]=999;
		printMatrix();
		//a 2. oszlop feltöltése 0 értékekkel
		for (int i=0;i<5;i++)
			matrix[i][2] =0;
		//Ezen értékadás után a 0. sor ugyanaz, mint a 4.! A két referencia ugyanarra a tömbre mutat.
		printMatrix();
		matrix[0]=matrix[4]; //A 4. sor elvész!
		printMatrix();
		//Értékadás a 4. sor 1. elemének. ÉS a 0. sor 1. elemének is!!!
		matrix[4][1]=888;
		printMatrix();
	}

}
