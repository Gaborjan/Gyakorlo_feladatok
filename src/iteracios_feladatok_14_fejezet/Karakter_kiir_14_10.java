package iteracios_feladatok_14_fejezet;

/* K�rjen be k�t karaktert, majd �rja ki az �sszes olyan karaktert, amely az unik�d t�bl�ban a megadott karakterek k�z�
 * esik. Figyelj�nk a k�vetkez�re: a felhaszn�l� nem ismeri az unik�d t�bl�at, ez�rt nem biztos, hogy el�sz�r a kisebb karaktert �ti
 * be!
 */
import extra.*;
public class Karakter_kiir_14_10 {
	public static void main(String[] args) {
		char
		egyik,masik,seged;
		
		System.out.println("K�t megadott karakter k�z�tt ki�rom az unik�d t�bl�ban elfoglalt hely�k");
		System.out.println("szerint a k�z�tt�k l�v� karaktereket.");
		egyik=Console.readChar("K�rem az egyik karaktert: ");
		masik=Console.readChar("Kerem a m�sodik karaktert: ");
		if (masik<egyik) {
			seged=egyik;
			egyik=masik;
			masik=seged;
		}
		for (char i=egyik;i<=masik;i++)
			System.out.println(i);
		System.out.println("Program v�ge:");
		Console.pressEnter();
	}

}
