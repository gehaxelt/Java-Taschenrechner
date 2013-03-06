package Rechner;

import Rechner.Token;

class TokenTree {

	private 
		Token head;
		TokenTree left, right;
		
	public TokenTree(Token head, TokenTree left, TokenTree right) {
		this.head = head;
		this.left = left;
		this.right = right;
	}
	
	public Token getHead() {
			return this.head;
	}
	public TokenTree getLeft() {
			return this.left;
	}
	public TokenTree getRight() {
			return this.right;
	}
	public void setHead(Token head) {
			this.head = head;
	}
	public void setLeft(TokenTree left) {
			this.left = left;
	}
	public void setRight(TokenTree right) {
			this.right = right;
	}
	
	public String toString() {
			return "( " + this.left.toString() + ")--(" + this.head.toString()+")--("+this.right.toString()+")";
	}
	

}
