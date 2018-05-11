package iteracios_feladatok_14_fejezet;

/*Kérjünk be terminálról karaktereket a '-' végjelig. Végül írjuk ki hány karaktert ütöttek be 'A' és 'Z', 'a' és 'z'
 * '0' és '9' között! Írjuk ki azt is, hány ezektõl eltérõ karaktert ütöttek!
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
		System.out.println("Karaktereket olvasok be '-' végjelig. A végén kiírom hány kisbetû, nagybetû");
		System.out.println("számjegy és egyéb karakter volt a sorban. (Angol ABC betûit számolom csak.)");
		do {
			be=Console.readChar("Kérem a következõ karaktert (vége:'-'): ");
			if (be>='A' && be<='Z') nagybetu++;
				else if (be>='a' && be<='z') kisbetu++;
					else if (be>='0' && be<='9') szam++;
						else if (be!='-') egyeb++;
		} while (be!='-');
		System.out.printf("Nagybetû: %,3d darab\n",nagybetu);
		System.out.printf("Kisbetû : %,3d darab\n",kisbetu);
		System.out.printf("Számjegy: %,3d darab\n",szam);
		System.out.printf("Egyéb   : %,3d darab\n",egyeb);
		System.out.println("Program vége:");
		Console.pressEnter();
	}

}
