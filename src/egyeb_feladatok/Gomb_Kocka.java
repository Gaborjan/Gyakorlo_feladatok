package egyeb_feladatok;

public class Gomb_Kocka {
	/*Ez a program kisz�molja egys�gnyi oldal�/sugar� g�mb �s kocka t�rfogat�t,
	 *felsz�n�t illetve a kett� arany�t.
	 */
	public static void main(String[] args) {
		double[] adatok = {1,2,5,10,100,1000};
		int i=0;
		double kockafelszin,kockaterfogat,gombfelszin,gombterfogat;
		System.out.println("Ez a program kisz�molja egys�gnyi oldal�/sugar� g�mb �s kocka t�rfogat�t, felsz�n�t illetve a kett� arany�t.\n");
		/*Kocka*/
		while (i<=5) {
			kockaterfogat=Math.pow(adatok[i], 3);
			kockafelszin=6*Math.pow(adatok[i], 2);
			System.out.printf("Oldal: %,5.0f"+"  Kocka F:  %,20.3f"+"  Kocka V:  %,20.3f"+"  Ar�ny:  %,8.2f%%%n",adatok[i],kockafelszin,
			kockaterfogat,(kockafelszin/kockaterfogat)*100);
			i=i+1;
		}
		/*Gomb*/
		i=0;
		while (i<=5) {  
			gombfelszin=4*Math.PI*Math.pow(adatok[i]/2, 2);
			gombterfogat=(gombfelszin*adatok[i]/2)/3;
			System.out.printf("Sug�r: %,5.2f"+"  Gomb F:  %,20.3f"+"  G�mb V:  %,20.3f"+"  Ar�ny:  %,8.2f%%%n",adatok[i]/2,gombfelszin,
			gombterfogat,(gombfelszin/gombterfogat)*100);
			i=i+1;
		}
	}
}
 