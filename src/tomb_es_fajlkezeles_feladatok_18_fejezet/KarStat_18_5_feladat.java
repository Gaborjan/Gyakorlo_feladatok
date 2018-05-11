package tomb_es_fajlkezeles_feladatok_18_fejezet;


/*Read a text from the console and count
 * a) A,B,...Z characters (non case sensitive) 
 * b) a,b,...z characters (case sensitive)
 * c) 0,1,2...9 characters
 * d) az ASCII characters
 */

import extra.*;

public class KarStat_18_5_feladat {

	public static void main(String[] args) {
		int[] charStat;
		charStat = new int[256]; // to store how many pieces of character are in the text
		String text; // the text  
		// szoveg=Console.readLine("Kérem a szöveget: ");
		text = "[z]ABAaa0s6s9g123gt5t4A78BfZwwwZZZ?!%&&";
		//from 'A' to 'Z', case sensitive, so we do not count 'a','b',...'z'
		charStat = charCount(text, 'A', 'Z', true);
		arrayPrint(charStat);
		Console.pressEnter();
		//all letters, we are not intrested in if capital or not, 'a' and 'A' counted
		charStat = charCount(text, 'A', 'Z', false);
		arrayPrint(charStat);
		Console.pressEnter();
		//all numbers, case sensitive can be true or false
		charStat = charCount(text, '0', '9', true);
		arrayPrint(charStat);
		Console.pressEnter();
		
	}

	public static void arrayPrint(int tomb[]) {
		for (int i = 0; i < tomb.length; i++) {
			if (tomb[i] != 0) {
				System.out.println((char) i + "  :" + tomb[i]);
			}
		}
	}
	/*This method count the characters
	 * text: where we have to count
	 * fromChar: the lower limit of character
	 * toChar: the upper limit of character
	 * caseSens: true: case sensitive, false: not case sensitive - just for aphabetical limits:'a'-'z', 'A'-'Z' 
	*/
	public static int[] charCount(String text, int fromChar, int toChar, boolean caseSens) {
		int[] temp = new int[256]; //working array
		for (int i = 0; i < text.length(); i++) { 
			if (caseSens) { //if caseSens is true, we just count the characters
				if (text.charAt(i) >= fromChar && text.charAt(i) <= toChar) // checking the lower anf upper limit
					temp[text.charAt(i)]++; //increase the number at the ASCII code of character at tha array, 'A'=65, etc. 
			} else {
				//if no case sensitive we have to uppercase the character in the text and limits too
				//since 'a' AND 'A' we have to count
				if (Character.toUpperCase(text.charAt(i)) >= Character.toUpperCase((char) fromChar)
				      && Character.toUpperCase(text.charAt(i)) <= Character.toUpperCase((char) toChar))
					temp[Character.toUpperCase(text.charAt(i))]++;
			}
		}
		return temp;
	}

}
