import java.io.*;
import java.util.Scanner;


/**
 * Computer Lab: Infix to Postfix Notation
 * Program that reads infix expression from a file, infix.txt, 
 * converts the infix expression to postfix notation, and evaluates the postfix expression.
 *   
 * Driver Class
 * 
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.2 - February 23, 2014
 */
public class Driver {

	/**
	 * Main method
	 * 
	 * @param args
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {
		Scanner fileScan = new Scanner(new File("/Users/gerikson/Documents/workspace/StackLab/src/infix.txt"));
		PrintWriter pw = new PrintWriter (new FileWriter("csis.txt"));
		
		while (fileScan.hasNext()) {
			String buf = fileScan.nextLine();
			//remove all of the white spaces
			buf = buf.replaceAll("\\s+", "");
			//verify that the input expression is valid
			ErrorCheck err = new ErrorCheck(buf);
			if (err.verifyError()) {
				InfixToPostfix infix = new InfixToPostfix(buf, pw);
				String postfix = infix.transformToPostfix();
				EvalPostfix eval = new EvalPostfix(postfix, pw);
				eval.calculate();
			} else {
				pw.write("Invalid expression: " + buf);
				System.out.println("Invalid Expression: " + buf);
			}
		}
		fileScan.close();
		pw.close();
		

	}

}
