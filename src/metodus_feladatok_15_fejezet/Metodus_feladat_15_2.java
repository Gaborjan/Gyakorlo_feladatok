package metodus_feladatok_15_fejezet;

/*ĂŤrja meg a kĂ¶vetkezĹ‘ eljarasokat.
 * a) Konzolra kiĂ­rja a megadott Ă©rtĂ©khatĂˇrok kĂ¶zĂ¶tti pĂˇros szĂˇmokat
 * b) KiĂ­r egy adott hosszĂşssĂˇgĂş, adott karakterekbĹ‘l ĂˇllĂł sort
 * c) Egy adott szĂ©lessĂ©gĹ± Ă©s magassĂˇgĂş tĂ¶mĂ¶r tĂ©glalapot rajzol a konzolra a megadott karakerrel. Az egyes 
 *    sorokat a b)-ben kĂ©szĂ­tett metĂłdus Ă­rja! 
 */
//import extra.*;

public class Metodus_feladat_15_2 {
	static void parosak(int tol, int ig) {
		for (int i=tol;i<=ig;i++) {
			if (i%2==0) 
				System.out.println(i);
		}
	}
	
	/*SoremelĂ©s*/
	static void ujSor() {
		System.out.println();
	}
	
	/*Megrajzol egy adott hosszĂşsĂˇgĂş sort, adott karakterbĹ‘l*/
	static void sorRajzol(char mibol, int hossz) {
		for (int i=1;i<=hossz;i++)
			System.out.print(mibol);
	}
	
	/*Teglalapot rajzol, adott karakterbĹ‘l, adott sorral Ă©s oszloppal*/
	static void teglalapRajzol(char mibol,int sor, int oszlop) {
		for (int i=1;i<=sor;i++) {
			sorRajzol(mibol,oszlop);
			ujSor();
		}
	}
	
	/*Keretet rajzol, adott karakterbĹ‘l adott sorral Ă©s oszloppal*/
	static void keretRajzol(int sor, int oszlop, char mibol) {
		sorRajzol(mibol,oszlop); //ElsĹ‘ sor megrajzolĂˇsa
		ujSor();
		for (int i=2;i<sor;i++) { //mĂˇsodiktĂłl utolsĂł elĹ‘tti sorig sorok kirajzolĂˇsa
			sorRajzol(mibol,1); //elsĹ‘ oszlop
			sorRajzol(' ',oszlop-2); //elsĹ‘ Ă©s utolĂł oszlop kĂ¶zĂ¶tti rĂ©sz 
			sorRajzol(mibol,1); //utolsĂł oszlop
			ujSor();
			
		}
		sorRajzol(mibol,oszlop);
	}
	/*Keretet rajzol, adott sor Ă©s oszlop nagysĂˇggal, tĂ­pus: 's'- egyszeres vonal, 'd'dupla vonal.
	 * Ha arnyĂ©kot akarunk, akkor true, ha nem false.
	 */
	static void keretRajzol(int sor,int oszlop,char tipus, boolean arnyek) {
		//RajzolĂł karakterek definiĂˇlĂˇsa
		final char BFS='\u250c';
		final char JFS='\u2510';
		final char VS='\u2500';
		final char FS='\u2502';
		final char BAS='\u2514';
		final char JAS='\u2518';
		final char BFD='\u2554';
		final char JFD='\u2557';
		final char VD='\u2550';
		final char FD='\u2551';
		final char BAD='\u255A';
		final char JAD='\u255D';
		final char ARNY='\u2591';
		//AktuĂˇlis rajzolĂł karakterek, 'tĂ­pus' paramĂ©tertĹ‘l fĂĽggĹ‘en.
		char bfA=' ',jfA=' ',vA=' ',fA=' ',jaA=' ',baA=' ';
		//RajzolĂł karakterek beĂˇllĂ­tĂˇsa
		if (Character.toUpperCase(tipus)=='S') {
			bfA=BFS;
			jfA=JFS;
			vA=VS;
			fA=FS;
			baA=BAS;
			jaA=JAS;
		}
		else if (Character.toUpperCase(tipus)=='D') {
			bfA=BFD;
			jfA=JFD;
			vA=VD;
			fA=FD;
			baA=BAD;
			jaA=JAD;
		}
		sorRajzol(bfA,1); //Bal felsĹ‘ sarok
		sorRajzol(vA,oszlop-2); // ElsĹ‘ sor, keret teteje
		sorRajzol(jfA,1); //Jobb felsĹ‘ sarok
		ujSor();  //MĂˇsodik sorra lĂ©pĂĽnk
		for (int i=2;i<=sor-1;i++) { //Sorok megrajzolĂˇsa mĂˇsodiktĂłl, utolsĂł elĹ‘ttiig
			sorRajzol(fA,1); //keret bal oldala
			sorRajzol(' ',oszlop-2); //sor kĂ¶zepe
			sorRajzol(fA,1); //keret jobb oldala
			if (arnyek) sorRajzol(ARNY,1); //Sor vĂ©gĂ©re ĂˇrnyĂ©k
			ujSor(); //KĂ¶vetkezĹ‘ sorra lĂ©pĂĽnk
		}
		sorRajzol(baA,1); // bal alsĂł sarok
		sorRajzol(vA,oszlop-2); // utolsĂł sor, keret alja
		if (arnyek) {//jobb alsĂł sarok
			sorRajzol(jaA,1); //Sarok
			sorRajzol(ARNY,1); //MĂ¶gĂ© az ĂˇrnyĂ©k
		}
		else
			sorRajzol(jaA,1); 
		if (arnyek) { //Ha kell, ĂˇrnyĂ©k rajzolĂˇs
			ujSor(); //Ă�rnyĂ©k sorĂˇra ugrĂˇs
			sorRajzol(' ',2); //Ă�rnyĂ©kot 2 oszloppal eltoljuk
			sorRajzol(ARNY,oszlop-1); //Ă�nryĂ©k megrajzolĂˇsa
		}
	}
	
	public static void main(String[] args ) {
		//parosak(1,100);
		//sorRajzol('*',30);
		//System.out.println();
		//teglalapRajzol('@',10,20);
		keretRajzol(7,70,'d',true);
		System.out.println();
		keretRajzol(5,25,'*');
		//keretRajzol(5,50,'s',true);
		//System.out.println();
		//keretRajzol(20,60,'s',true);
	}

	
}
