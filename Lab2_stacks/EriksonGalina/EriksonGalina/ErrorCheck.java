import java.io.PrintWriter;

/**
 * Class that checks that the expessions are not erroneus
 * Examples of erroneus expressions:
 * a+*b		adjacent operators
 * ab*c^d	adjacent operands
 * (a+b		missing parantheses
 * (a+b)*c)	extra paranthesis
 * 
 * @author gerikson
 * @version 1.2
 */
public class ErrorCheck {
	
	private String error = "";
	private PrintWriter pw;
	
	public ErrorCheck(String err, PrintWriter pw) {
		this.error = err;
		this.pw = pw;
	}
	
	/**
	 * method that verifies the validity of a expresion
	 * 
	 * @return boolean
	 */
	public boolean verifyError() {

		int count_open_paranthesis = 0;
		int count_close_parenthesis = 0;		
		//go through each character of the input expresion
		for (int i =0; i < error.length(); i++ ) {
			String temp = error.substring(i, i+1);
			//check if we have two consecutive operators
			if (check_operator(temp)) {
				if (i !=  error.length() - 1) {
					String temp2 = error.substring(i+1, i+2);
					if (check_operator(temp2)) {
						System.out.println("Two adjacent operators");
						pw.write("Two adjacent operators\n");
						return false;
					}
				}
			}
			//count the right and/or left parathesis
			else if (temp.equals("(")) {
				count_open_paranthesis++;
			}
			else if (temp.equals(")")){
				count_close_parenthesis++;
			}
			
			//verify for two consecutive operands
			else {
				isNumeric num = new isNumeric(temp);
				if (num.isNum()) {
					if (i !=  error.length() - 1) {
						String temp2 = error.substring(i+1, i+2);
						isNumeric num2 = new isNumeric(temp2);
						if (num2.isNum()) {
							System.out.println("Two adjacent operands");
							pw.write("Two adjacent operands\n");
							return false;
						}
					}	
				} 
			} 
			
		}
		
		if (count_open_paranthesis == count_close_parenthesis) {
			return true;
		} else {
			System.out.println("Missing or extra parathesis");
			pw.write("Missing or extra parathesis\n");
			return false;
		}

	}

/**
 * Method that verifies that a string is an operator
 * @param operator
 * @return
 */
private boolean check_operator(String operator) {
	if (operator.equals( "-") || operator.equals( "+") || operator.equals("^") || operator.equals("*") || operator.equals("/")) {
		return true;
	} else {
		return false;
	}
	}
}