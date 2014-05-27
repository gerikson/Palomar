import java.io.PrintWriter;


/**
 * Class that transforms an infix expression into a postfix expression
 * 
 * @author gerikson
 * @version 1.2 - February 23, 2014
 */
public class InfixToPostfix {

	private String expression;
	private PrintWriter pw;
	private ObjectStack stack;
	
	public InfixToPostfix(String ex, PrintWriter pw) {
		this.expression = ex;
		this.pw = pw;
		this.stack = new ObjectStack();
	}
	
	public int priority(String temp) {
		char op = temp.charAt(0);
		switch (op) {
			case '^': return 3;
			case '*':
			case '/': return 2;
			case '+': 
			case '-': return 1;
			default: return 0;
		}
	}

	/**
	 * Method that transforms an infix expression to postfix
	 * 
	 * @return
	 */
	public String  transformToPostfix() {
		String postfix = "";
		System.out.println("Infix: " + expression);
		pw.write("Infix: " + expression + "\n");
		//go through each character of the input expresion
		for (int i =0; i < expression.length(); i++ ) {
			String temp = expression.substring(i, i+ 1);
			
			if (isNumeric(temp)){
				postfix = postfix + temp;
			} else if (temp.equals("(")) {
				stack.push("(");
			} else if (temp.equals( ")")) {
				
				while (!stack.isEmpty() && !stack.top().equals("(")) {
						postfix = postfix + stack.pop();
				}
				stack.pop();
					
			} else {
				if (!stack.isEmpty()) {
					Object top = stack.top();
					String top_temp = top.toString();
					/*remove the operators from the stack and place them in the postfix expression until
					 * either the stack is empty, a right paranteshis is encountered or the operator on top 
					 * of the stack has a lower priority then the operator encountered in the infix expression
					*/
					if (check_priority(temp, top_temp)) {
						while (!stack.isEmpty() && !top_temp.equals("(")) {
							postfix = postfix + stack.pop();
							if (!stack.isEmpty()) {
								Object top1 = stack.top();
								String top_temp1 = top1.toString();
								if (!check_priority(temp, top_temp1)) {
									stack.push(temp);
									break;
								}
							}
						}
					} else {
						stack.push(temp);
					}
				} else {
					stack.push(temp);	
				}
			}		
		}
		
		while (!stack.isEmpty()) {
			postfix = postfix + stack.pop();
		}
		System.out.println("Postfix: " + postfix);
		pw.write("Postfix: "+ postfix + "\n");
		return postfix;
	}
	
private boolean check_priority(String a, String b) {
	if (priority(a) < priority(b)) {
		return true;
	} else {
		return false;
	}
}
	/**
	 * Method that checks if a string is a numeric character
	 * @param str
	 * @return
	 */
	public boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    int d = Integer.parseInt(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	public String getExpresion() {
		return expression;
	}

	public void setExpresion(String expresion) {
		this.expression = expression;
	}

}
