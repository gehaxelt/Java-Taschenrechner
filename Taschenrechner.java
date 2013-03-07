import Rechner.*;
import java.util.Vector;

/* Simple calculator which will parse the term and evaluate it.
 * 
 **/
 
 /** Grammar:
 * Expr -> (Expr Op Expr) | Zahl | (- Zahl)
 * Op	-> + | - | * | / 
 * Zahl -> [0-9]*
 **/
 
public class Taschenrechner {
	
		public static void main(String[] args) {
			
			/* Separate the input string into a Vector of Tokens*/
			Scanner scanner = new Scanner();
			Vector<String> scanresult = scanner.scan(args[0]);
			
			/*System.out.println(scanresult);*/
			
			/* Parse the Tokens into a syntaxtree*/
			Parser parser = new Parser();
			TokenTree tokentree = parser.parse(scanresult);
			
			System.out.println(tokentree);
			
			/*Evaluate the syntaxtree */
			Evaluator evaluator = new Evaluator();
			double result = evaluator.eval(tokentree);
			
			/*print the result */
			System.out.println("Result:" + String.valueOf(result));
			
		}
	
	
}
