package iteracios_feladatok_14_fejezet;

/* Kérjen be két karaktert, majd írja ki az összes olyan karaktert, amely az unikód táblában a megadott karakterek közé
 * esik. Figyeljünk a következõre: a felhasználó nem ismeri az unikód tábláat, ezért nem biztos, hogy elõször a kisebb karaktert üti
 * be!
 */
import extra.*;
public class Karakter_kiir_14_10 {
	public static void main(String[] args) {
		char
		egyik,masik,seged;
		
		System.out.println("Két megadott karakter között kiírom az unikód táblában elfoglalt helyük");
		System.out.println("szerint a közöttük lévõ karaktereket.");
		egyik=Console.readChar("Kérem az egyik karaktert: ");
		masik=Console.readChar("Kerem a második karaktert: ");
		if (masik<egyik) {
			seged=egyik;
			egyik=masik;
			masik=seged;
		}
		for (char i=egyik;i<=masik;i++)
			System.out.println(i);
		System.out.println("Program vége:");
		Console.pressEnter();
	}

}
