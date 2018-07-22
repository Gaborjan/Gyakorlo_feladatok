package Lista_proba;


import java.io.File;
import java.io.IOException;
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
     if (darab < ((Szodb) obj).getDarab()) 
        return -1;
     if (darab > ((Szodb) obj).getDarab()) 
        return 1;
     return this.szo.compareTo(((Szodb) obj).getSzo());
  }

  public String toString() {
     return String.format("[%-40s] szó %,6d alkalommal szerepel. \n",this.szo,this.darab);
  }

}


public class Alice_Wonderland_szoszamlalas 
{
   
   public static void main(String[] args) 
   {
     Set<String> words = new  TreeSet<>();
     Map<String, Integer> darabszam = new TreeMap<>();
     ArrayList<Szodb> statisztika = new ArrayList<>();
     
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
        System.out.println(words.size()+ " darab különbözõ szó.");
     }*/
     {
        while (in.hasNext()) {
           String word=in.next();
           darabszam.put(word, darabszam.getOrDefault(word, 0) +1);
        }
       darabszam.forEach((String szo,Integer darab) -> {
           //System.out.printf("%,5d-szor: %-20s \n",darab,szo);
           statisztika.add(new Szodb(szo,darab));
        });
       Collections.sort(statisztika);
       statisztika.forEach((Szodb e) -> {
          System.out.print(e);
       });
 
     }
     catch (IOException e) {
        System.out.println("Hiba történt fájlmûvelet közben!");
     }
   }
}
