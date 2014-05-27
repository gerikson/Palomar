// Evaluate1.java

import java.io.*;
import java.util.Scanner;

public class Evaluate1 {
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
                    values.push(new Integer(operand - 48));
                else if (operand == '+' || operand == '-' || operand == '*' || operand == '/' || operand == '^')
                    operators.push(new Character(operand));
                else if (operand == ')') {
                    int val2 = ((Integer) values.pop()).intValue();
                    int val1 = ((Integer) values.pop()).intValue();
                    char op = ((Character) operators.pop()).charValue();
                    if (op == '+')
                        values.push(new Integer(val1 + val2));
                   else if (op == '-')
                        values.push(new Integer(val1 - val2));
                   else if (op == '*')
                        values.push(new Integer(val1 * val2));
                   else if (op == '/')
                        values.push(new Integer(val1 / val2));
                    else if (op == '^')
                        values.push(new Integer((int) Math.pow(val1, val2)));
                }
            }
            System.out.println(((Integer) values.pop()).intValue());
        }
         fileScan.close();
    }
}
