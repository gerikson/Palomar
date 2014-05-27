/**
 * Class that evaluates a postfix expresion
 * 
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.2 - February 23, 2014
 */

import java.io.PrintWriter;


public class EvalPostfix {

	private String expression;
	private ObjectStack stack;
	private PrintWriter pw;
	
	/**
	 * Class constructor
	 * @param ex
	 * @param pw
	 */
	public EvalPostfix(String ex, PrintWriter pw) {
		this.expression = ex;
		this.pw = pw;
		this.stack = new ObjectStack();
	}
	
	/**
	 * Algorithm to evaluate a postfix expression
	 */
	public void calculate() {
		int result = 0;		
		//go through each character of the input expresion
		for (int i =0; i < expression.length(); i++ ) {
			String temp = expression.substring(i, i+ 1);
			if (isNumeric(temp)){
				stack.push(temp);
			} else {
				int num2 = Integer.parseInt((String) stack.pop());
				int num1 = Integer.parseInt((String) stack.pop());
				int num3 = calculateOperation(num1, num2, temp);
				stack.push(String.valueOf(num3));
			}
		}
		System.out.println("Evaluated postfix =  " + stack.top());
		pw.write("Evaluated postfix =  " + stack.pop() + "\n");

	}
	
	/**
	 * Evaluates a operation given 2 integers and a sting operator
	 * @param num1
	 * @param num2
	 * @param operator
	 * @return
	 */
	private int calculateOperation (int num1, int num2, String operator) {
		int num3 = 0;
		if (operator.equals("+")) {
			num3 = num1 +num2;
		}else if (operator.equals("-")) {
			num3 = num1 -num2;
		}else if (operator.equals("*")) {
			num3 = num1 * num2;
		}else if (operator.equals("/")) {
			num3 = num1/num2;
		}else if (operator.equals("^")) {
			num3 = exponential(num1, num2);
		}
		return num3;
		
	}
	
	/**
	 * Recursive method that calculations the exponential of a number
	 * 
	 * @param num1
	 * @param num2
	 * @return exponential
	 */
	private int exponential(int num1, int num2) {
		
		if (num2 == 0) {
			return 1;
		} else if (num2 == 1) {
			return num1;
		} else {
			return num1* exponential(num1, num2-1);
		}
	}
	
	/**
	 * Method that verifies is a String is numeric
	 * 
	 * @param str
	 * @return
	 */
	private boolean isNumeric(String str)  
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
}
