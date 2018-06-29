package Lista_proba;

import java.util.*;

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
		
		//Tömbbõl Array list létrehozása
		String[] nevek = {"Tibor ", "Gábor ", "Péter "};
		ArrayList<String> nevlista = new ArrayList<String>(Arrays.asList(nevek));
		
		ArrayList<String> list = new ArrayList<String> ();
		ArrayList<String> filtered_list = new ArrayList<String> ();
		
		TreeSet<Integer> nyeroszamok = new TreeSet<Integer>();
		nyeroszamok.add(2);
		nyeroszamok.add(4);
		nyeroszamok.add(1);
		nyeroszamok.add(3);
		nyeroszamok.add(5);
		System.out.println("Nyerõszámok (TreeSet): "+nyeroszamok);
		ArrayList<Integer> szamoktomb = new ArrayList<Integer>(nyeroszamok);
		System.out.println("Nyerõszámok: (Tömb): "+Arrays.asList(szamoktomb));
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
		nevek[1]="Jónás";
		nevek[2]="Gizella";
		nevlista.addAll(0,Arrays.asList(nevek));
		System.out.println("Nevek tömbbõl létrehozott lista + új nevek beszúrva az elejére: "+nevlista);
		System.out.println("Ezt is megszûrjük, csak azokat hagyjuk meg, amiben szerepel az \"or\" szótag: "+szuro(nevlista,"or"));
		
		TreeMap<Integer, ArrayList<String>> filmek = new TreeMap<Integer, ArrayList<String>>();
		filmek.put(1,new ArrayList<String>());
		filmek.put(3,new ArrayList<String>());
		filmek.put(2,new ArrayList<String>());
		filmek.put(5,new ArrayList<String>());
		filmek.put(4,new ArrayList<String>());
		filmek.get(1).add("Vissza a jövõbe I.");
		filmek.get(2).add("Vissza a jövõbe II.");
		filmek.get(3).add("Vissza a jövõbe III.");
		filmek.get(4).add("Nyolcadik utas a halál");
		filmek.get(4).add("A bolygó neve : halál");
		filmek.get(5).add("Csillagok háborúja");
		filmek.get(5).add("A birodalom visszavág");
		filmek.get(5).add("A Jedi visszatér");
		for (Map.Entry<Integer, ArrayList<String>> egyfilm : filmek.entrySet()) {
			System.out.print(egyfilm.getKey()+" : ");
				System.out.println(egyfilm.getValue());
			
		}
		
		
	
} //main
	
	static ArrayList<String> szuro(ArrayList<String> belista, String filter) {
		ArrayList<String> seged = new ArrayList<String>(belista);
		for (Iterator<String> it=seged.iterator(); it.hasNext();) {
			if (!it.next().contains(filter))
				it.remove(); // NOTE: Iterator's remove method, not ArrayList's, is used.
			}	
		return seged;
	}
	
} //class Lista_proba1
