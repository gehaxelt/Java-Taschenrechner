package Rechner;

import Rechner.Token;
import Rechner.TokenTree;
import java.util.Vector;

/** Grammar:
 * Expr -> (Expr Op Expr) | Zahl | (- Zahl)
 * Op	-> + | - | * | / 
 * Zahl -> [0-9]*
 **/

public class Parser {

	private Vector<Token> tokens;

	public Vector<Token> parse(Vector<String> input) {

		this.tokens = new Vector<Token>();
		
		return tokens;
	}
	
	private boolean isOperator(String s) {
			switch(s) {
					case "+":
						return true;
					case "-":
						return true;
					case "*":
						return true;
					case "/":
						return true;
					default:
						return false;
			}
		
	}
	
	//Dirty trick to check wheter a string is numeric
	private boolean isInteger(String s) {
			try {
					Integer.parseInt(s);
					return true;
			} catch(Exception e) {
					return false;
			}
	}


}
