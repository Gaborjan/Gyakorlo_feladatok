package Lista_proba;

import java.util.*;

public class Lista_proba_1 {

	public static void main(String[] args) {
		
	// need to construct a new ArrayList otherwise remove operation will not be supported
		List<String> list = new ArrayList<String>(Arrays.asList(new String[] 
		                                  {"How are you?", "How you doing?","Joe", "Mike"}));
		System.out.println("List Before: " + list);
		for (Iterator<String> it=list.iterator(); it.hasNext();) {
		    if (!it.next().contains("How"))
		        it.remove(); // NOTE: Iterator's remove method, not ArrayList's, is used.
		}
		System.out.println("List After: " + list);

	}

}
