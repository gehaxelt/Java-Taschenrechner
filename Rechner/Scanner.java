package Rechner;

import java.util.Vector;

/** Grammar:
 * Expr -> (Expr Op Expr) | Zahl | (- Zahl)
 * Op	-> + | - | * | / 
 * Zahl -> [0-9]*
 **/

public class Scanner {

	public Vector<String> scan(String input) {
		
		Vector<String> result = new Vector<String>();
		
		char[] replacements = {'(',')','+','-','*','/'};
		
		for(int i = 0; i < replacements.length;i++)
			input = input.replace(String.valueOf(replacements[i])," "+String.valueOf(replacements[i])+" ");

		String[] parts = input.split(" ");
		
		for(int i=0; i < parts.length; i++)
			if (parts[i].compareTo("") != 0)
				result.addElement(parts[i].trim());

		return result;
	}

}
