package egyeb_feladatok;
public class Feltetel_gyakorlas {
	public static void main(String[] args) {
		float a, b, c;
		int i;
		System.out.println("1. Az \"a\" �rt�ke 0 �s 1 k�z� esik");
		a=-1;
		if (a>=0 & a<=1) 
			System.out.println("A felt�tel igaz. (a = "+a+")");
		else
			System.out.println("A felt�tel hamis. (a = "+a+")");
		System.out.println("\n2. Az \"a\" �rt�ke 5 �s 10, \"b\" �rt�ke pedig 15 �s 20 k�z� esik, a hat�rokat bele�rtj�k.");
		a=5;
		b=16;
		if ( ((a>=5) && (a<=10)) && ((b>=15) && (b<=20)) ) 
			System.out.println("A felt�tel igaz. (a = "+a+"; b = "+b+")");
		else
			System.out.println("A felt�tel hamis. (a = "+a+"; b = "+b+")");
		System.out.println("\n3. Az \"a\" �rt�ke nem esik 5 �s 10 k�z� �s \"b\" �rt�ke sem esik 15 �s 20 k�z�,  a hat�rokat is bele�rtve.");
		a=4;
		b=18;
		if (!( ((a>=5) && (a<=10)) || ((b>=15) && (b<=20)) )) 
			System.out.println("A felt�tel igaz. (a = "+a+"; b = "+b+")");
		else
			System.out.println("A felt�tel hamis. (a = "+a+"; b = "+b+")");
		System.out.println("\n4. Sem \"a\" sem \"b\" sem \"c\" �rt�ke nem 0.");
		a=4;
		b=18;
		c=5;
		if (a!=0 && b!=0 && c!=0) 
			System.out.println("A felt�tel igaz. (a = "+a+"; b = "+b+"; c = "+c+")");
		else
			System.out.println("A felt�tel hamis. (a = "+a+"; b = "+b+"; c = "+c+")");
		System.out.println("\n5. Az �rtke \"a\" eg�sz sz�m.");
		a=3.14f;
		if (a%1==0) 
			System.out.println("A felt�tel igaz. (a = "+a+")");
		else
			System.out.println("A felt�tel hamis. (a = "+a+")");
		System.out.println("\n6. Az \"a\", \"b\", \"c\" k�z�l legal�bb 2 sz�m eg�sz.");
		a=3.0f;
		b=4.36f;
		c=35.0f;
		if (((a%1==0) && (b%1==0)) || ((b%1==0) && (c%1==0)) || ((a%1==0) && (c%1==0))) 
			System.out.println("A felt�tel igaz. (a = "+a+"; b = "+b+"; c ="+c+")");
		else
			System.out.println("A felt�tel hamis. (a = "+a+"; b = "+b+"; c = "+c+")");
		System.out.println("\n7. Az \"a\", �s \"b\" k�z�l az egyik pozit�v a m�sik negat�v.");
		a=2.0f;
		b=9.5f;
		if ((a>0 && b<0) || (a<0 && b>0)) 
			System.out.println("A felt�tel igaz. (a = "+a+"; b = "+b+")");
		else
			System.out.println("A felt�tel hamis. (a = "+a+"; b = "+b+")");
		System.out.println("\n8. Az \"a\", \"b\" �s \"c\" k�z�l legfeljebb kett� pozit�v.");
		a=3;
		b=8;
		c=7;
		//if ((((a>0) && (b>0)) ^ (c>0)) || (((b>0) && (c>0)) ^ (a>0)) || (((c>0) && (a>0)) ^ (b>0)) || (a<0 && b<0 && c<0))
		if (a<=0 || b<=0 || c<=0)
			System.out.println("A felt�tel igaz. (a = "+a+"; b = "+b+"; c = "+c+")");
		else
			System.out.println("A felt�tel hamis. (a = "+a+"; b = "+b+"; c= "+c+")");
		System.out.println("\n9. Az \"a\" �s \"b\" k�z�l legfeljebb az egyik p�ros.");
		a=9;
		b=3;
		//if ((a%2==0 ^ b%2==0) || (a%2!=0 || b%2!=0))
		//if (a%2==1 || b%2==1)
		if (!(a%2==0 && b%2==0))
			System.out.println("A felt�tel igaz. (a = "+a+"; b = "+b+")");
		else
			System.out.println("A felt�tel hamis. (a = "+a+"; b = "+b+")");
		System.out.println("\n10. Az \"a\" �s \"b\" k�z�l pontosan az egyik p�ros.");
		a=2;
		b=8;
		if ((a%2==0 ^ b%2==0)) 
			System.out.println("A felt�tel igaz. (a = "+a+"; b = "+b+")");
		else
			System.out.println("A felt�tel hamis. (a = "+a+"; b = "+b+")");
		
	}
}
