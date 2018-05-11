package karakterlanc_feladatok_16_fejezet;

/*Írjob metódust, amely visszaadja egy tizes számrendszerbeli szám kettes számrendszerbeli megfelelõjét, 
 * karakterláncként.
 */
import extra.*;

public class Bitkep_16_8 {

	public static StringBuilder kiegeszit(StringBuilder szoveg, int hossz) {
		StringBuilder seged = new StringBuilder(szoveg.toString());
		int plussz=0;
		if (seged.length()>hossz)
			seged.setLength(hossz);
		else
		{
			plussz=hossz-seged.length();
			for (int i=1;i<=plussz;i++)
				seged.insert(0,'0');
		}
		return seged;
	}
	
	public static String tizbolKettoStr(int szam, int hossz, boolean bontas) {
		StringBuilder seged = new StringBuilder("");
		int szamjegy=0;
		if (szam==0) {
			seged=kiegeszit(seged,hossz);
			if (bontas) seged.insert(8,' ');
			return seged.toString();
		}
		else {
			while (szam>0) {
				szamjegy=szam%2;
				seged.insert(0,Integer.toString(szamjegy));
				szam=szam/2;
			}
			seged=kiegeszit(seged,hossz);
			if (bontas) seged.insert(8,' ');
			return seged.toString();
		}
	}
	public static String tizbolTizenhatStr(int szam, int hossz) {
		StringBuilder seged = new StringBuilder("");
		int szamjegy=0;
		char hexa=' ';
		if (szam==0) {
			seged=kiegeszit(seged,hossz);
			return seged.toString();
		}
		else {
			while (szam>0) {
				szamjegy=szam%16;
				if (szamjegy>=0 && szamjegy<=9) 
					hexa=Integer.toString(szamjegy).charAt(0);
				else
					switch (szamjegy) {
					case 10:hexa='A'; break;
					case 11:hexa='B'; break;
					case 12:hexa='C'; break;
					case 13:hexa='D'; break;
					case 14:hexa='E'; break;
					case 15:hexa='F'; break;
					}
				seged.insert(0,hexa);
				szam=szam/16;
			}
			seged=kiegeszit(seged,hossz);
			return seged.toString();
		}
	}	
	
	public static void main(String[] args) {
		int b=124;
		for (int i=0;i<=64;i++) {
			System.out.printf("%3d   %s  %s\n",i,tizbolTizenhatStr(i,6),tizbolKettoStr(i,16,true));
		}
		/*b=b|125;
		System.out.println(b+"     "+tizbolKettoStr(b,16,true))*/
	
	}
}
