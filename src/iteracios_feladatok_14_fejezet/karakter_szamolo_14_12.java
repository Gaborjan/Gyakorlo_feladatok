package iteracios_feladatok_14_fejezet;

/*K�rj�nk be termin�lr�l karaktereket a '-' v�gjelig. V�g�l �rjuk ki h�ny karaktert �t�ttek be 'A' �s 'Z', 'a' �s 'z'
 * '0' �s '9' k�z�tt! �rjuk ki azt is, h�ny ezekt�l elt�r� karaktert �t�ttek!
 */
import extra.*;
public class karakter_szamolo_14_12 {

	public static void main(String[] args) {
		int kisbetu=0, 
			nagybetu=0, 
			szam=0, 
			egyeb=0;
		char
			be;
		System.out.println("Karaktereket olvasok be '-' v�gjelig. A v�g�n ki�rom h�ny kisbet�, nagybet�");
		System.out.println("sz�mjegy �s egy�b karakter volt a sorban. (Angol ABC bet�it sz�molom csak.)");
		do {
			be=Console.readChar("K�rem a k�vetkez� karaktert (v�ge:'-'): ");
			if (be>='A' && be<='Z') nagybetu++;
				else if (be>='a' && be<='z') kisbetu++;
					else if (be>='0' && be<='9') szam++;
						else if (be!='-') egyeb++;
		} while (be!='-');
		System.out.printf("Nagybet�: %,3d darab\n",nagybetu);
		System.out.printf("Kisbet� : %,3d darab\n",kisbetu);
		System.out.printf("Sz�mjegy: %,3d darab\n",szam);
		System.out.printf("Egy�b   : %,3d darab\n",egyeb);
		System.out.println("Program v�ge:");
		Console.pressEnter();
	}

}
