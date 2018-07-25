package Lista_proba;


import java.io.File;
import java.io.IOException;
import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.*;


class Szodb implements Comparable<Object> {
   private String szo;
   private int darab;
   
   public Szodb(String szo, int darab) {
      this.szo=szo;
      this.darab=darab;
   }
   
  public String getSzo() {
     return this.szo;
  }
  
  public int getDarab() {
     return this.darab;
  }
  
  public boolean equals(Object obj) {
     return (szo.equals( ((Szodb) obj).getSzo()) && (this.darab==((Szodb) obj).getDarab()));
  }
  
  public int compareTo(Object obj ) {
	  RuleBasedCollator myCollator = (RuleBasedCollator) Collator.getInstance(new Locale("hu", "HU"));
	  if (darab < ((Szodb) obj).getDarab()) 
        return -1;
     if (darab > ((Szodb) obj).getDarab()) 
        return 1;
     return myCollator.compare(((Szodb) obj).getSzo(), this.szo);
     //return this.szo.compareTo(((Szodb) obj).getSzo());
  }

  public String toString() {
     return String.format("[%-40s] sz� %,6d alkalommal szerepel. \n",this.szo,this.darab);
  }

}


public class Regeny_szoszamlalas 
{
	final static int elsoN = 200; 
	final static int minHossz =10; // Az enn�l r�videbb szavakat nem vessz�k figyelembe 
   
   public static void main(String[] args) 
   {
   	RuleBasedCollator myCollator = (RuleBasedCollator) Collator.getInstance(new Locale("hu", "HU"));
   	Set<String> words = new  TreeSet<>();
   	Map<String, Integer> darabszam = new TreeMap<>();
   	ArrayList<Szodb> statisztika = new ArrayList<>();
   	ArrayList<Szodb> elso10 = new ArrayList<>();
   	int listaHossz=0; 
   	  	   	
 
   	try (Scanner in = new Scanner(new File(args[0])))
   	/* {
        while (in.hasNext()) 
        {
           String word = in.next();
           words.add(word);
        }
        Iterator<String> iter = words.iterator();
        for  (int i=1; i<=200 && iter.hasNext(); i++)
           System.out.println(iter.next());
        System.out.println(words.size()+ " darab k�l�nb�z� sz�.");
     	}*/
   	{
      while (in.hasNext()) {
           String word=in.next();
           word=word.replaceAll("[?!-.:,\"']", "");
           if (word.length()>=minHossz) darabszam.put(word, darabszam.getOrDefault(word, 0) +1);
        }
       darabszam.forEach((String szo,Integer darab) -> {
           //System.out.printf("%,5d-szor: %-20s \n",darab,szo);
           statisztika.add(new Szodb(szo,darab));
        });
       
       Collections.sort(statisztika);
       Collections.reverse(statisztika);
       if ((statisztika.size())>elsoN) {
      	 elso10.addAll(statisztika.subList(0, elsoN-1));
      	 listaHossz=elsoN;
       }
       	else if (statisztika.size()>0) {
       		elso10.addAll(statisztika.subList(0, statisztika.size()));
       		listaHossz=statisztika.size();
       	}
       System.out.println("Az els� "+listaHossz+" leggyakoribb sz� el�fordul�s szerint rendezve, mellette az el�fordul�sok sz�ma. ");
       System.out.println("A(z) " + minHossz + " bet�n�l r�videbb szavakat nem vett�k figyelembe.");
       System.out.println();
       elso10.forEach((Szodb e) -> {
          System.out.print(e);
       });
       
       
       Comparator<Szodb> hosszSorrend = (Szodb elso, Szodb masodik) ->
       {
      	 if ((elso.getSzo().length()-masodik.getSzo().length())!=0) 
      		 return elso.getSzo().length()-masodik.getSzo().length();
      	 else 
      		  return 0; /*myCollator.compare(elso.getSzo(), masodik.getSzo());*/
       };
       
       Collections.sort(elso10, hosszSorrend);
       System.out.println();
       System.out.println("Az els� "+listaHossz+" leggyakoribb sz� hossz szerint rendezve, mellette az el�fordul�sok sz�ma.");
       System.out.println("A(z) " + minHossz + " bet�n�l r�videbb szavakat nem vett�k figyelembe.");
       System.out.println();
       elso10.forEach((Szodb e) -> {
          System.out.print(e);
       });
       System.out.printf("%,6d f�le k�l�nb�z� sz�.",statisztika.size());
     }
     catch (IOException e) {
        System.out.println("Hiba t�rt�nt f�jlm�velet k�zben!");
     }
   }
}
