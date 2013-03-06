import Rechner.*;
import java.util.Vector;

public class Taschenrechner {
	
		public static void main(String[] args) {
			Scanner scanner = new Scanner();
			
			Vector<String> scanresult = scanner.scan(args[0]);
			
			System.out.println(scanresult);
			
			Parser parser = new Parser();
			TokenTree tokentree = parser.parse(scanresult);
			
			System.out.println(tokentree);
			
			Evaluator evaluator = new Evaluator();
			int result = evaluator.eval(tokentree);
			
			System.out.println("Result:" + String.valueOf(result));
			
		}
	
	
}
