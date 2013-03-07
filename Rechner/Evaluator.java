package Rechner;

import Rechner.Token;
import Rechner.TokenTree;

/* Evaluates a TokenTree recursively
 * 
 * 
 * */
public class Evaluator {
	
	public double eval(TokenTree tree) {
		try {
			//If it''s a leaf, return its value 
			if(tree.isLeaf()) {
				return tree.getHead().getValue() ;
			}
			
			//else recursively evaluate it
			switch(tree.getHead().getType()) {
					case Token.PLUS:
						return eval(tree.getLeft()) + eval(tree.getRight());
					case Token.MINUS:
						return eval(tree.getLeft()) - eval(tree.getRight());
					case Token.MULT:
						return eval(tree.getLeft()) * eval(tree.getRight());
					case Token.DIV:
						return eval(tree.getLeft()) / eval(tree.getRight());
			}
		
		} catch(Exception e) {
				System.out.println("An Error orcurred: " + e.toString());
				return 0;
		}
		return 0;		
	}
	
	
}
