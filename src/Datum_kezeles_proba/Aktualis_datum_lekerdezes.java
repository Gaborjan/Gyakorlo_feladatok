package Datum_kezeles_proba;

import java.text.DateFormat;
import java.time.Instant;
import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Aktualis_datum_lekerdezes {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
	   DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG, Locale.getDefault());
	   String ev, honapSzoveg;
	   int honap=0,nap=0;
	   String h="",n="";
	   long elteltido;
	   long szulinap;
	   long ma;
	   long ev_,ho_, nap_;
	   System.out.println("Dátum és idõ formátum LONG, magyar: "+df.format(c.getTime()));
	   
	   df=DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM,Locale.getDefault());
	   System.out.println("Dátum és idõ formátum MEDIUM, magyar: "+df.format(c.getTime()));
	   
	   df=DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT,Locale.getDefault());
	   System.out.println("Dátum és idõ formátum SHORT, magyar: "+df.format(c.getTime()));
	   
	   df=DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT,Locale.ENGLISH);
	   System.out.println("Dátum és idõ formátum SHORT, angol: "+df.format(c.getTime())); 
	   
	   Calendar gszulinap = new GregorianCalendar(1975,Calendar.JUNE,23);
	   String s = String.format("Gábor's Birthday: %1$tm %1$te,%1$tY", gszulinap);
	   System.out.println(s);
	   szulinap=gszulinap.getTimeInMillis();
	   ma=c.getTimeInMillis();
	   elteltido=ma-szulinap;
	   Calendar k = Calendar.getInstance();
	   k.set(0,0,0,0,0,0);
	   //k.set(Calendar.MILLISECOND, 0);
	   ev_=k.getTimeInMillis();
	   System.out.println(Instant.ofEpochMilli(ev_).toString());
	   
	   
	   /*
   	ev=c.get(Calendar.YEAR)+"";
   	honap=c.get(Calendar.MONTH);
   	nap=c.get(Calendar.DAY_OF_MONTH);
   	honapSzoveg=c.getDisplayName(Calendar.MONTH,Calendar.LONG, Locale.getDefault());
   	honap++;
   	   if (honap<=9) 
   	   	h="0"+String.valueOf(honap);
   	   else
   	   	h=String.valueOf(honap);
   	   if (nap<=9) 
   	   	n="0"+String.valueOf(nap);
   	   else
   	   	n=String.valueOf(nap);*/
	}

}
