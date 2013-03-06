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

	private TokenTree tokens;

	public TokenTree parse(Vector<String> input) {

		this.tokens = this.parseExpr(input);
		
		
		
		return tokens;
	}
	
	private TokenTree parseExpr(Vector<String> List) {
		
			String first = List.elementAt(0);
			List.removeElementAt(0);
			
			//Negative Zahl
			if((first.compareTo("-") == 0) && (this.isInteger(List.elementAt(0)))) {
				Token number = new Token(Token.isNUM);
				number.setValue(-1*Integer.parseInt(List.elementAt(0)));
				List.removeElementAt(0);
				return new TokenTree(number,null,null);
			
			} else if(this.isInteger(first)) {
				Token number = new Token(Token.isNUM);
				number.setValue(Integer.parseInt(first));
				return new TokenTree(number,null,null);
			
			} else if(first.compareTo("(") == 0 ) {
				
				TokenTree leftexpr = new TokenTree(null,null,null);
				TokenTree rightexpr = new TokenTree(null,null,null);
				//Es folgt keine weitere Tiefe
				if (List.elementAt(0).compareTo("(") != 0) {
					Vector<String> subvec = new Vector<String>();
					subvec.addElement(List.elementAt(0));
					leftexpr = this.parseExpr(subvec);
					List.removeElementAt(0);
				}
				
				Token operator = this.parseOperator(List);
				List.removeElementAt(0);
				
				if(List.elementAt(0).compareTo("(") != 0) {
					Vector<String> subvec = new Vector<String>();
					subvec.addElement(List.elementAt(0));
					rightexpr= this.parseExpr(subvec);
					List.removeElementAt(0);
				}
				
				if(List.elementAt(0).compareTo(")") == 0) {
					return new TokenTree(operator, leftexpr, rightexpr);
				} else {
						System.out.println("Error!");
						return new TokenTree(null,null,null);
				}
			}
			
			return new TokenTree(null,null,null);
	}
	
	private Token parseOperator(Vector<String> sList) {
			String s = sList.elementAt(0);
			switch(s) {
					case "+":
						return new Token(Token.PLUS);
					case "-":
						return new Token(Token.MINUS);
					case "*":
						return new Token(Token.MULT);
					case "/":
						return new Token(Token.DIV);
					default:
						System.out.println("Error - wrong Operator");
						return new Token(Token.PLUS);
			}
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
