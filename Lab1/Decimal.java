
/**
 * Class that transform a decimal number to binary and/or hexadecimal.
 *
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.2
 */


import java.io.*;
import java.util.Scanner;

public class Decimal
{
    private PrintWriter pw;

    /**
     * Constructor for objects of class Decimal
     * @param pw PrintWriter files
     */
    public Decimal(PrintWriter pw)
    {
        // initialise instance PrinWriter
        this.pw = pw;
    }

    /**
     * Method that transforms a decimal to binary
     * @param no parameters
     * @return returns void
     */
    public void decToBin()
    {
        //pw.write("Decimal To Binary:");
        System.out.println("Please enter a decimal number: ");
        Scanner keyboard = new Scanner(System.in);
        Long input = keyboard.nextLong();
        String binary="";
	    for ( Long decimal = input ; decimal > 0 ; decimal/=2 )
	       {
	           binary = decimal%2 + binary  ;
	        }
	    System.out.println("Decimal " + input + " = " + binary + " in binary");
        pw.write("Decimal " + input + " = " + binary + " in binary\n");
    }
    
    /**
     * Method that transforms a decimal to Hexadecimal
     * @param no parameters
     * @return returns void
     */
    public void decToHex()
    {
        System.out.println("Please enter a decimal number: ");
        Scanner keyboard = new Scanner(System.in);
        int decimal = keyboard.nextInt();
        int input = decimal;
        String hex="";
        while (input != 0) {
        		if (input%16 == 10) {
        			hex = hex.concat("A");
        		} else if (input%16 == 11) {
        			hex = hex.concat("B");
        		}  else if (input%16 == 12) {
        			hex = hex.concat("C");
        		}  else if (input%16 == 13) {
        			hex = hex.concat("D");
        		}  else if (input%16 == 14) {
        			hex = hex.concat("E");
        		}  else if (input%16 == 15) {
        			hex = hex.concat("F");
        		}  else if (input%16 == 16) {
        			hex = hex.concat("d");
        		} else {
        			hex = hex.concat(Integer.toString(input%16)); 
        		}
        		input = (int) input/16; 		
        }
        
        hex = new StringBuilder(hex).reverse().toString();
	    System.out.println("Decimal " + decimal + " = " + hex + " in hexadecimal");
        pw.write("Decimal " + decimal + " = " + hex + " in hexadecimal\n");
    }

}

