package Rechner;


public class Token {
	
		private 
			double value; //value of the number
			int type;
			
		public
			static final int PLUS = 0; /* + */
			static final int MINUS =  1;/* - */
			static final int MULT = 2;/* * */
			static final int DIV = 3;/* / */
			static final int isNUM = 4;/* is the token a number? */
			static final int OPEN = 5; /* ( */
			static final int CLOSE = 6; /* ) */
			
		public Token(int type) {
				this.type = type;
				this.value = 0;
		}
		
		public void setValue(double val) {
				this.value = val;
		}
		
		public double getValue() {
				return this.value;
		}
		
		public int getType() {
				return this.type;
		}
		
		
		public String toString() {

			if (this.type == Token.PLUS) {
				return "+";
			} else if (this.type == Token.MINUS) {
				return "-";
			} else if (this.type == Token.MULT) {
				return "*";
			} else if (this.type == Token.DIV) {
				return "/";
			} else if (this.type == Token.isNUM) {
				return String.valueOf(this.value);
			} else if (this.type == Token.OPEN) {
				return "(";
			} else if (this.type == Token.CLOSE) {
				return ")";
			} else {
					return "";
			}
			
		}

}
