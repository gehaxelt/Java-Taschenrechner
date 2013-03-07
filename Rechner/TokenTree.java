package Rechner;

import Rechner.Token;

/* TokenTree:
 * 		 Head
 * 		[Token]
 * 	 	/     \
 *[Tokentree] [Tokentree]
 *  Left		 Right
 * */

public class TokenTree {

	private 
		Token head;
		TokenTree left, right;
		boolean leaf;
		
	public TokenTree(Token head, TokenTree left, TokenTree right) {
		this.head = head;
		this.left = left;
		this.right = right;
		
		//If left & right are null then the tree is a leaf
		if ((this.left == null) && (this.right == null)) {
				this.leaf = true;
		} else {
				this.leaf = false;
		}
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
	
	public boolean isLeaf() {
			return this.leaf;
	}
	
	/*Return the tree as a string.
	 * (LEFT)--(HEAD)--(RIGHT)
	 * Empty strings if object is null
	 * */
	public String toString() {
		
		String leftstr,rightstr,headstr;
		
		if (this.left == null) {
			leftstr = "";
		} else {
			leftstr = this.left.toString();
		}
		if(this.right == null) {
			rightstr = "";
		} else {
			rightstr = this.right.toString();
		}
		if(this.head == null) {
			headstr = "";
		} else {
			headstr = this.head.toString();
		}
		
		return "(" + leftstr + ")--(" + headstr+")--("+rightstr+")";
	}
	

}
