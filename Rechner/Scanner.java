package Rechner;

import java.util.Vector;

/** Grammar:
 * Expr -> (Expr Op Expr) | Zahl | (- Zahl)
 * Op	-> + | - | * | / 
 * Zahl -> [0-9]*
 **/

public class Scanner {

	/*Scan the string and separate it into pieces */
	public Vector<String> scan(String input) {
		
		Vector<String> result = new Vector<String>();
		
		/*Extend these characters with spaces, which will be removed later for simplier scanning*/
		char[] replacements = {'(',')','+','-','*','/'};
		
		for(int i = 0; i < replacements.length;i++)
			input = input.replace(String.valueOf(replacements[i])," "+String.valueOf(replacements[i])+" ");

		/*Splitt string into pieces*/
		String[] parts = input.split(" ");
		
		/*Put the data into the vector*/
		for(int i=0; i < parts.length; i++)
			if (parts[i].compareTo("") != 0)
				result.addElement(parts[i].trim());

		return result;
	}

}
