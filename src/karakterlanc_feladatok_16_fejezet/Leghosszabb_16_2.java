package karakterlanc_feladatok_16_fejezet;

import extra.Console;

/*K�rjen be konzolr�l sz�vegeket egy adott v�gjelig, majd �rja ki k�z�l�k a leghosszabbat!
 * T�bb egyenl� hossz�s�g� sz�veg eset�n �rja ki mindegyiket!
 */
public class Leghosszabb_16_2 {

	public static void main(String[] args) {
		String szovegbe,
		leghosszabb, leghosszabbGyujto;
		leghosszabb="";
		leghosszabbGyujto="";
		int db;
		System.out.println("�rjon be karakterl�ncokat. Megmondom melyik volt a leghosszabb.");
		System.out.println("Ha t�bb egyenl� hossz�s�g� volt, akkor ki�rom mindegyiket.");
		do {
			szovegbe=Console.readLine("K�rem a sz�veget (bevitel v�ge:'*'):");
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
