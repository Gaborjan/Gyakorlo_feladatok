package karakterlanc_feladatok_16_fejezet;

import extra.Console;

/*Kérjen be konzolról szövegeket egy adott végjelig, majd írja ki közülük a leghosszabbat!
 * Több egyenlõ hosszúságú szöveg esetén írja ki mindegyiket!
 */
public class Leghosszabb_16_2 {

	public static void main(String[] args) {
		String szovegbe,
		leghosszabb, leghosszabbGyujto;
		leghosszabb="";
		leghosszabbGyujto="";
		int db;
		System.out.println("Írjon be karakterláncokat. Megmondom melyik volt a leghosszabb.");
		System.out.println("Ha több egyenlõ hosszúságú volt, akkor kiírom mindegyiket.");
		do {
			szovegbe=Console.readLine("Kérem a szöveget (bevitel vége:'*'):");
			if (!szovegbe.equals("*")) {
				if (szovegbe.length()>leghosszabb.length()) {
					leghosszabb=szovegbe;
					leghosszabbGyujto=szovegbe;
				}
				else if (szovegbe.length()==leghosszabb.length()) 
					leghosszabbGyujto=leghosszabbGyujto.concat(szovegbe);
			}
			
		} while (!szovegbe.equals("*"));
		db=leghosszabbGyujto.length()/leghosszabb.length();
		for (int i=0;i<db;i++)
			System.out.println(leghosszabbGyujto.substring(i*leghosszabb.length(), ((i*leghosszabb.length())+leghosszabb.length())));
		
	}

}
