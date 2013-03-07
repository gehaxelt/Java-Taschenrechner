package Rechner;

import Rechner.Token;
import Rechner.TokenTree;


public class Evaluator {
	
	public double eval(TokenTree tree) {
		try {
			if(tree.isLeaf()) {
				return tree.getHead().getValue() ;
			}
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
