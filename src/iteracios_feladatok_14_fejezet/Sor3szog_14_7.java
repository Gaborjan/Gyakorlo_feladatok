package iteracios_feladatok_14_fejezet;

import extra.*;
public class Sor3szog_14_7 {

	public static void main(String[] args) {
		int n;
		do 
			n=Console.readInt("Kérem n értékét (1-50): ");
		while (n<1 || n>50);
		for (int i=1;i<=n; i++) {
			for (int j=1;j<=i; j++) 
				System.out.print(" "+j);
			System.out.println();
		}
	}

}
