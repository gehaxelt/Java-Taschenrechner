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

	private TokenTree tokens; /* final tokentree */
	
	/*Parse the tokens into a syntaxtree */
	public TokenTree parse(Vector<String> input) {

		this.tokens = this.parseExpr(input);
		return tokens;
	}
	
	/* parse a given Expression */
	private TokenTree parseExpr(Vector<String> List) {
			
			//negative number (-5)
			if((this.comp(List,0,"(")) && (this.comp(List,1,"-")) && (this.isInteger(List.elementAt(2))) && (this.comp(List,3,")"))) {
				Token number = new Token(Token.isNUM);
				number.setValue(-1*Double.parseDouble(List.elementAt(2)));
				List.subList(0,3).clear();
				return new TokenTree(number,null,null);
			
			//normal numbers 5
			} else if(this.isInteger(List.elementAt(0))) {
				Token number = new Token(Token.isNUM);
				number.setValue(Double.parseDouble(List.elementAt(0)));
				return new TokenTree(number,null,null);
			
			//Operators and nested terms
			} else if(this.comp(List,0,"(")) {
				
				//Just defined, because the compiler sucks
				TokenTree leftexpr = new TokenTree(null,null,null);
				TokenTree rightexpr = new TokenTree(null,null,null);
				Vector<String> subvec = new Vector<String>();
				
				//No more nesting
				if (! this.comp(List,0,"(")) {
					subvec.addElement(List.elementAt(0));
					leftexpr = this.parseExpr(subvec);
					List.removeElementAt(0);
					
				//nesting
				} else if (this.comp(List,0,"(")) {
					List.removeElementAt(0);
					subvec.clear();
					int NestingEnd = this.findLeftNestingEnd(List);				
					if (NestingEnd>0) {
						subvec.addAll(List.subList(0,NestingEnd));
						leftexpr = this.parseExpr(subvec);
						List.subList(0,NestingEnd).clear();
					} else {
						subvec.clear();
						subvec.addElement(List.elementAt(0));
						leftexpr = this.parseExpr(subvec);
						List.removeElementAt(0);
					}
				}
				
				Token operator = this.parseOperator(List);
				List.removeElementAt(0);
				
				//no nesting
				if(List.elementAt(0).compareTo("(") != 0) {
					subvec.clear();
					subvec.addElement(List.elementAt(0));
					rightexpr= this.parseExpr(subvec);
					List.removeElementAt(0);
					
				//more nesting
				} else if (this.comp(List,0,"(")){
					//List.removeElementAt(0);
					subvec.clear();
					int NestingEnd = this.findLeftNestingEnd(List);
					if (NestingEnd>0) {
						subvec.addAll(List.subList(0,NestingEnd));
						rightexpr = this.parseExpr(subvec);
						List.subList(0,NestingEnd-1).clear();

					} else {
						subvec.clear();
						subvec.addElement(List.elementAt(0));
						rightexpr = this.parseExpr(subvec);
						List.removeElementAt(0);
					}
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
	
	private int findLeftNestingEnd(Vector<String> List) {
			int braceCount = 0;
			int pos = 0;
			do {
					if(comp(List,pos,"(")) {
						braceCount++;
					}
					else if(comp(List,pos,")")) {
						braceCount--;
					} else if(braceCount==0)
						break;
						
					pos++;
			} while (List.size() != pos);
			return pos;
	}
	
	private int findRightNestingEnd(Vector<String> List) {
			int braceCount = 0;
			int pos = List.size()-1;
			do {
					if(comp(List,pos,"(")) {
						braceCount++;
					}
					else if(comp(List,pos,")")) {
						braceCount--;
					} else if(braceCount==0)
						break;
						
					pos--;
			} while (1 != pos);
			return List.size()-pos;
	}
	
	//Parse an operator into an operator-token
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
	
	private boolean comp(Vector<String> List,int pos,String str) {
			return (List.elementAt(pos).compareTo(str)==0);
	}
	
	//Check operators
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
