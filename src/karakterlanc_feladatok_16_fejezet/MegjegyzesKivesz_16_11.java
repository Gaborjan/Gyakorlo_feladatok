package karakterlanc_feladatok_16_fejezet;

/*K�rjen be egy sz�veget, majd vegye ki bel�le a az �sszes z�r�jeles megjegyz�st!*/

public class MegjegyzesKivesz_16_11 {
	
	public static String szakaszTorol(String szoveg,char n, char z) {
   	StringBuilder seged=new StringBuilder(szoveg);
   	
   	int nyito=0,zaro=0; //nyit� �s z�r� jelek helyei
   	int i=0; //seg�dv�ltoz�
   	nyito=seged.indexOf(n+""); //Az els� nyit� z�r�jel helye
   	while (nyito>-1 && zaro!=-1) { //Am�g van ny�t�z�r�jel �s lehet hozz�tartoz� z�r�
   		//Ha z�r�==-1 azt jelenti, hogy m�r pr�b�ltunk keresni, de nem tal�ltunk t�bb z�r�t
   		i=nyito; //nyit� ut�ni helyeken keres�nk
   		zaro=-1; //feltessz�k, hogy m�r nincs z�r�, csak nyit�
   		while(seged.charAt(i)!=z && i<seged.length()-1) { //addig l�peget�nk, am�g z�r�t nem tal�ltunk vagy a v�g�re �rt�nk
   			i++;
   			if (seged.charAt(i)==z) zaro=i; //ha z�r�t tal�ltunk eltessz�k a hely�t
   			if (seged.charAt(i)==n) nyito=i; // a nyit� ut�n is lehet nyit�, akkor annak a hely�t tessz�k el (egym�sba �gyazott z�r�jelez�s)
   		}
   		if (zaro>-1) //Ha megvan a z�r�
   			seged.delete(nyito, zaro+1); //t�r�lj�k a nyit� �s z�r� k�z�tti r�szt
   		nyito=seged.indexOf(n+""); //ism�t az els� nyit�t keress�k meg
   	}
   	return seged.toString();
	}	

	public static void main(String[] args) {
		System.out.println(szakaszTorol("()1()2[()]3()()4()(5)",'[',']'));
	}
}
