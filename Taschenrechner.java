import Rechner.*;
import java.util.Vector;

public class Taschenrechner {
	
		public static void main(String[] args) {
			Scanner scanner = new Scanner();
			
			Vector<String> scanresult = scanner.scan(args[0]);
			
			/*System.out.println("Scanner:");
			for(int i=0; i < scanresult.size(); i++)
				System.out.println(scanresult.elementAt(i));*/
			
			System.out.println(scanresult);
			
			Parser parser = new Parser();
			Vector<Token> tokens = parser.parse(scanresult);
			
			System.out.println(tokens);
			
			/*System.out.println("Parser:");
			for(int i=0; i < tokens.size(); i++) {
					System.out.println(tokens.elementAt(i).toString());
			}*/
			
		}
	
	
}
