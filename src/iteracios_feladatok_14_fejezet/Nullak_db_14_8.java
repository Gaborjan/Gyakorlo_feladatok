package iteracios_feladatok_14_fejezet;

//K�rjen be egy eg�sz sz�mot �s �llap�tsa meg h�ny 0 szerepel benne!
import extra.*;
public class Nullak_db_14_8 {

	public static void main(String[] args) {
		int n,db=0;
		do
			n=Console.readInt("K�rem a sz�mot: (1-999999999)");
		while (n<1 || n>999999999);
		while (n>9) {
			if ((n%10)==0) db++;
			else
				n=n-(n%10);
			n=n/10;
		}
		System.out.println("A megadott sz�mban "+db+" db nulla szerepel.");
		Console.pressEnter();
	}

}
