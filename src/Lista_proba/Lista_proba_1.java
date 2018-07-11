package Lista_proba;

import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Lista_proba_1 {

	public static void main(String[] args) {
		
	// need to construct a new ArrayList otherwise remove operation will not be supported
		/*List<String> list = new ArrayList<String>(Arrays.asList(new String[] 
		                                  {"How are you?", "How you doing?","Joe", "Mike"}));
		System.out.println("List Before: " + list);
		for (Iterator<String> it=list.iterator(); it.hasNext();) {
		    if (!it.next().contains("How"))
		        it.remove(); // NOTE: Iterator's remove method, not ArrayList's, is used.
		}
		System.out.println("List After: " + list);*/
		/*List<String> list = new ArrayList<String>(Arrays.asList(new String[] 
      {"How are you?", "How you doing?","Joe", "Mike"}));*/
		
		//T�mbb�l Array list l�trehoz�sa
	   RuleBasedCollator myCollator = (RuleBasedCollator) Collator.getInstance(new Locale("hu", "HU"));
	   String[] nevek = {"Tibor ", "G�bor ", "P�ter ","�d�m","M�ty�s","Gabriella","G�sp�r","�va","�kos","�bel","�d�n","�rs"};
		ArrayList<String> nevlista = new ArrayList<String>(Arrays.asList(nevek));
		
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> filtered_list = new ArrayList<String> ();
		
		for (String e : nevek)
		   list.add(e);
		
		Collections.sort(list,myCollator);
		for (String e : list)
		   System.out.println(e.toString());
		
		
		TreeSet<Integer> nyeroszamok = new TreeSet<Integer>();
		nyeroszamok.add(2);
		nyeroszamok.add(4);
		nyeroszamok.add(1);
		nyeroszamok.add(3);
		nyeroszamok.add(5);
		System.out.println("Nyer�sz�mok (TreeSet): "+nyeroszamok);
		ArrayList<Integer> szamoktomb = new ArrayList<Integer>(nyeroszamok);
		System.out.println("Nyer�sz�mok: (T�mb): "+Arrays.asList(szamoktomb));
		System.out.println();
		
		list.add("How are you?");
		list.add("How you doing?");
		list.add("Joe");
		list.add("Mike");
		System.out.println("List Before: " + list);
		filtered_list=szuro(list, "How");
		System.out.println("Original list: " + list);
		System.out.println("Filtered list: " + filtered_list);
		nevek[0]="Hunor";
		nevek[1]="J�n�s";
		nevek[2]="Gizella";
		nevlista.addAll(0,Arrays.asList(nevek));
		System.out.println("Nevek t�mbb�l l�trehozott lista + �j nevek besz�rva az elej�re: "+nevlista);
		System.out.println("Ezt is megsz�rj�k, csak azokat hagyjuk meg, amiben szerepel az \"or\" sz�tag: "+szuro(nevlista,"or"));
		
		TreeMap<Integer, ArrayList<String>> filmek = new TreeMap<Integer, ArrayList<String>>();
		filmek.put(1,new ArrayList<String>());
		filmek.put(3,new ArrayList<String>());
		filmek.put(2,new ArrayList<String>());
		filmek.put(5,new ArrayList<String>());
		filmek.put(4,new ArrayList<String>());
		filmek.get(1).add("Vissza a j�v�be I.");
		filmek.get(2).add("Vissza a j�v�be II.");
		filmek.get(3).add("Vissza a j�v�be III.");
		filmek.get(4).add("Nyolcadik utas a hal�l");
		filmek.get(4).add("A bolyg� neve : hal�l");
		filmek.get(5).add("Csillagok h�bor�ja");
		filmek.get(5).add("A birodalom visszav�g");
		filmek.get(5).add("A Jedi visszat�r");
		for (Map.Entry<Integer, ArrayList<String>> egyfilm : filmek.entrySet()) {
			System.out.print(egyfilm.getKey()+" : ");
				System.out.println(egyfilm.getValue());
		} //for
		runAlgorithm();
} //main
	
	static ArrayList<String> szuro(ArrayList<String> belista, String filter) {
		ArrayList<String> seged = new ArrayList<String>(belista);
		for (Iterator<String> it=seged.iterator(); it.hasNext();) {
			if (!it.next().contains(filter))
				it.remove(); // NOTE: Iterator's remove method, not ArrayList's, is used.
			}	
		return seged;
	}
	
	public static void runAlgorithm()
	       {
	          int size = 100;
	          List<Integer> list = new Random().ints().map(i -> Math.abs((i % 90)+1)).limit(size)
	                .boxed().collect(Collectors.toList());
	          Collections.sort(list);
	          System.out.println(list);
	        
	       }

	
} //class Lista_proba1
