package egyeb_feladatok;
public class Feltetel_gyakorlas {
	public static void main(String[] args) {
		float a, b, c;
		int i;
		System.out.println("1. Az \"a\" értéke 0 és 1 közé esik");
		a=-1;
		if (a>=0 & a<=1) 
			System.out.println("A feltétel igaz. (a = "+a+")");
		else
			System.out.println("A feltétel hamis. (a = "+a+")");
		System.out.println("\n2. Az \"a\" értéke 5 és 10, \"b\" értéke pedig 15 és 20 közé esik, a határokat beleértjük.");
		a=5;
		b=16;
		if ( ((a>=5) && (a<=10)) && ((b>=15) && (b<=20)) ) 
			System.out.println("A feltétel igaz. (a = "+a+"; b = "+b+")");
		else
			System.out.println("A feltétel hamis. (a = "+a+"; b = "+b+")");
		System.out.println("\n3. Az \"a\" értéke nem esik 5 és 10 közé és \"b\" értéke sem esik 15 és 20 közé,  a határokat is beleértve.");
		a=4;
		b=18;
		if (!( ((a>=5) && (a<=10)) || ((b>=15) && (b<=20)) )) 
			System.out.println("A feltétel igaz. (a = "+a+"; b = "+b+")");
		else
			System.out.println("A feltétel hamis. (a = "+a+"; b = "+b+")");
		System.out.println("\n4. Sem \"a\" sem \"b\" sem \"c\" értéke nem 0.");
		a=4;
		b=18;
		c=5;
		if (a!=0 && b!=0 && c!=0) 
			System.out.println("A feltétel igaz. (a = "+a+"; b = "+b+"; c = "+c+")");
		else
			System.out.println("A feltétel hamis. (a = "+a+"; b = "+b+"; c = "+c+")");
		System.out.println("\n5. Az értke \"a\" egész szám.");
		a=3.14f;
		if (a%1==0) 
			System.out.println("A feltétel igaz. (a = "+a+")");
		else
			System.out.println("A feltétel hamis. (a = "+a+")");
		System.out.println("\n6. Az \"a\", \"b\", \"c\" közül legalább 2 szám egész.");
		a=3.0f;
		b=4.36f;
		c=35.0f;
		if (((a%1==0) && (b%1==0)) || ((b%1==0) && (c%1==0)) || ((a%1==0) && (c%1==0))) 
			System.out.println("A feltétel igaz. (a = "+a+"; b = "+b+"; c ="+c+")");
		else
			System.out.println("A feltétel hamis. (a = "+a+"; b = "+b+"; c = "+c+")");
		System.out.println("\n7. Az \"a\", és \"b\" közül az egyik pozitív a másik negatív.");
		a=2.0f;
		b=9.5f;
		if ((a>0 && b<0) || (a<0 && b>0)) 
			System.out.println("A feltétel igaz. (a = "+a+"; b = "+b+")");
		else
			System.out.println("A feltétel hamis. (a = "+a+"; b = "+b+")");
		System.out.println("\n8. Az \"a\", \"b\" és \"c\" közül legfeljebb kettõ pozitív.");
		a=3;
		b=8;
		c=7;
		//if ((((a>0) && (b>0)) ^ (c>0)) || (((b>0) && (c>0)) ^ (a>0)) || (((c>0) && (a>0)) ^ (b>0)) || (a<0 && b<0 && c<0))
		if (a<=0 || b<=0 || c<=0)
			System.out.println("A feltétel igaz. (a = "+a+"; b = "+b+"; c = "+c+")");
		else
			System.out.println("A feltétel hamis. (a = "+a+"; b = "+b+"; c= "+c+")");
		System.out.println("\n9. Az \"a\" és \"b\" közül legfeljebb az egyik páros.");
		a=9;
		b=3;
		//if ((a%2==0 ^ b%2==0) || (a%2!=0 || b%2!=0))
		//if (a%2==1 || b%2==1)
		if (!(a%2==0 && b%2==0))
			System.out.println("A feltétel igaz. (a = "+a+"; b = "+b+")");
		else
			System.out.println("A feltétel hamis. (a = "+a+"; b = "+b+")");
		System.out.println("\n10. Az \"a\" és \"b\" közül pontosan az egyik páros.");
		a=2;
		b=8;
		if ((a%2==0 ^ b%2==0)) 
			System.out.println("A feltétel igaz. (a = "+a+"; b = "+b+")");
		else
			System.out.println("A feltétel hamis. (a = "+a+"; b = "+b+")");
		
	}
}
