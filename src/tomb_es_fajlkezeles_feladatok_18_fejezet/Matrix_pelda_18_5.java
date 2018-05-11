package tomb_es_fajlkezeles_feladatok_18_fejezet;

/* K�t dimenzi�s t�mb manipul�l�sa, p�lda*/

import extra.*;

public class Matrix_pelda_18_5 {
	static int printN=0;
	static int[][] matrix = new int[5][3];
	
	//A m�trix ki�r�sa soronk�nt:
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
		System.out.println("Sorok sz�ma:    ="+matrix.length);
		System.out.println("Oszlopok sz�ma: ="+matrix[0].length);
		
		int ertek=0;
		for (int i=0; i<5; i++) 
			for (int j=0; j<3; j++)
				matrix[i][j] = ++ertek;
		printMatrix();
		//2. sor m�sol�sa 1. sorba
		System.arraycopy(matrix[2], 0, matrix[1], 0, matrix[1].length);
		printMatrix();
		//2. sor 1. oszlopa ==999
		matrix[2][1]=999;
		printMatrix();
		//a 2. oszlop felt�lt�se 0 �rt�kekkel
		for (int i=0;i<5;i++)
			matrix[i][2] =0;
		//Ezen �rt�kad�s ut�n a 0. sor ugyanaz, mint a 4.! A k�t referencia ugyanarra a t�mbre mutat.
		printMatrix();
		matrix[0]=matrix[4]; //A 4. sor elv�sz!
		printMatrix();
		//�rt�kad�s a 4. sor 1. elem�nek. �S a 0. sor 1. elem�nek is!!!
		matrix[4][1]=888;
		printMatrix();
	}

}
