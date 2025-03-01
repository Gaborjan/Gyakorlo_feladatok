package iteracios_feladatok_14_fejezet;

/*Sheran hindu kir�ly meg akarta jutalmazni a sakkj�t�k feltal�l�j�t, �s r�b�zta, hogy � maga v�lassza meg a jutalm�t. A b�lcs
 * ember �gy v�laszolt: A sakkt�bla els� mez�j��rt csak egy b�zaszemet adj uram!  A m�sodik�rt 2-t, a harmadik�rt 4-et, stb.
 * minden mez��rt k�tszer annyit, mint az el�z��rt. Sz�moljunk ut�na, mennyi is volt pontosan a jutalom?
 * A sakkt�bla v�zszintes koordin�t�i: A..H, f�gg�leges koordin�t�i: 1..8.
 * Ciklusban k�rj�k be a felhaszn�l�t�l milyen koordin�t�ra k�v�ncsi, �s minden esetben �rjuk ki az eredm�nyt! A programnak
 * akkor legyen v�ge, ha a bevitel v�zszintes koordin�t�n�l a * karaktert �tik be!
 */
import extra.*;

public class Buzaszemek {
	public static void main(String[] args) {
		double buzaSzem;
		char oszlop=' ';
		int sor;
		while (oszlop!='*') {
			do 
				oszlop=Console.readChar("Melyik oszlop legyen A..H ( Kil�p�s--> * ):");
			while ((Character.toUpperCase(oszlop)<'A' || Character.toUpperCase(oszlop)>'H') && (oszlop!='*'));
			if (oszlop=='*') continue;
			else {
				do
					sor=Console.readInt("Melyik sor legyen (1..8)?");
				while (sor<1 || sor>8);
			buzaSzem=Math.pow(2, ((Character.toUpperCase(oszlop)-'A')*8)+sor-1);	
			System.out.print("A(z) "+Character.toUpperCase(oszlop)+" sor "+sor+". oszlop�ban l�v� b�zaszemek sz�ma: ");
			System.out.printf("%,20.0f\n",buzaSzem);
			}
		}
		
		System.out.println("Program v�ge!");
	
		
				
	}
} 
