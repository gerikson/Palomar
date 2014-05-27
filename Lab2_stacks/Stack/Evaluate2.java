// Evaluate2.java - AutoBoxing

import java.io.*;
import java.util.Scanner;

public class Evaluate2 {
    public static void main(String[] args) throws IOException {
        ObjectStack operators = new ObjectStack();
        ObjectStack values = new ObjectStack();
        Scanner fileScan = new Scanner(new File("expressions.txt"));
        
        while (fileScan.hasNext()) {
            String exp = fileScan.nextLine();
            System.out.println(exp);
            for (int i = 0; i < exp.length(); i++) {
                char operand = exp.charAt(i);
                if (operand >= '0' && operand <= '9')
                    values.push(operand - 48);
                else if (operand == '+' || operand == '-' || operand == '*' || operand == '/' || operand == '^')
                    operators.push(operand);
                else if (operand == ')') {
                    int val2 = (Integer) values.pop();
                    int val1 = (Integer) values.pop();
                    char op =  (Character) operators.pop();
                    if (op == '+')
                        values.push(val1 + val2);
                    else if (op == '-')
                        values.push(val1 - val2);
                    else if (op == '*')
                        values.push(val1 * val2);
                    else if (op == '/')
                        values.push(val1 / val2);
                    else if (op == '^')
                        values.push((int) Math.pow(val1, val2));
                }
            }
            System.out.println((Integer) values.pop());
        }
         fileScan.close();
    }
}
