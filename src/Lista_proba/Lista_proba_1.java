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
		
		//T�mbb�l Array list l�trehoz�sa
		String[] nevek = {"Tibor ", "G�bor ", "P�ter "};
		ArrayList<String> nevlista = new ArrayList<String>(Arrays.asList(nevek));
		
		ArrayList<String> list = new ArrayList<String> ();
		ArrayList<String> filtered_list = new ArrayList<String> ();
		
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
