package karakterlanc_feladatok_16_fejezet;

/*Kérjen be egy szöveget, majd vegye ki belõle a az összes zárójeles megjegyzést!*/

public class MegjegyzesKivesz_16_11 {
	
	public static String szakaszTorol(String szoveg,char n, char z) {
   	StringBuilder seged=new StringBuilder(szoveg);
   	
   	int nyito=0,zaro=0; //nyitó és záró jelek helyei
   	int i=0; //segédváltozó
   	nyito=seged.indexOf(n+""); //Az elsõ nyitó zárójel helye
   	while (nyito>-1 && zaro!=-1) { //Amíg van nyítózárójel és lehet hozzátartozó záró
   		//Ha záró==-1 azt jelenti, hogy már próbáltunk keresni, de nem találtunk több zárót
   		i=nyito; //nyitó utáni helyeken keresünk
   		zaro=-1; //feltesszük, hogy már nincs záró, csak nyitó
   		while(seged.charAt(i)!=z && i<seged.length()-1) { //addig lépegetünk, amíg zárót nem találtunk vagy a végére értünk
   			i++;
   			if (seged.charAt(i)==z) zaro=i; //ha zárót találtunk eltesszük a helyét
   			if (seged.charAt(i)==n) nyito=i; // a nyitó után is lehet nyitó, akkor annak a helyét tesszük el (egymásba ágyazott zárójelezés)
   		}
   		if (zaro>-1) //Ha megvan a záró
   			seged.delete(nyito, zaro+1); //töröljük a nyitó és záró közötti részt
   		nyito=seged.indexOf(n+""); //ismét az elsõ nyitót keressük meg
   	}
   	return seged.toString();
	}	

	public static void main(String[] args) {
		System.out.println(szakaszTorol("()1()2[()]3()()4()(5)",'[',']'));
	}
}
