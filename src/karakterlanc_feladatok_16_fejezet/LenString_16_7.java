package karakterlanc_feladatok_16_fejezet;

/*�rjon egy f�ggv�nyt, amely egy sz�veget a param�terk�nt megadott hossz�ss�g�r alak�t, ha kell kieg�sz�ti a megadott karakterekkel (balr�l), ha kell, lev�gja
 * a v�g�t adott hosszra.
 * 
 */
import extra.*;

public class LenString_16_7 {

	public static String LenBString(StringBuilder szoveg, int hossz, char mivel) {
		StringBuilder seged = new StringBuilder(szoveg.toString());
		int plussz=0;
		if (seged.length()>hossz)
			seged.setLength(hossz);
		else
		{
			plussz=hossz-seged.length();
			for (int i=1;i<=plussz;i++)
				seged.insert(0,mivel);
		}
		return seged.toString();
	}
	
	public static void main(String[] args) {
		StringBuilder szam;
		szam= new StringBuilder();
		szam.append("254.0345");
		System.out.println(szam.toString());
		System.out.println(LenBString(szam,15,' '));
		System.out.println(LenBString(szam,6, ' '));
		System.out.println(LenBString(szam,8,' '));				

	}

}
