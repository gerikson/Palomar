
/**
 * Class that transform a binary number to decimal and/or hexadecimal.
 *
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.2
 */

import java.io.*;
import java.util.Scanner;

public class Binary
{
    private PrintWriter pw;

    /**
     * Constructor for objects of class Binary
     * @param pw PrintWriter files
     */
    public Binary(PrintWriter pw)
    {
        // initialise instance PrinWriter
        this.pw = pw;
    }

    /**
     * Method that transforms a binary number to decimal
     * @param no parameters
     * @return returns void
     */
    public void binToDec()
    {
        System.out.println("Please enter a binary number:");
        Scanner keyboard = new Scanner(System.in);
        String bin = keyboard.nextLine();
        String oldbin = bin;
        bin = bin.replace(" ", "");
        bin = new StringBuilder(bin).reverse().toString();
        int decimal = 0;
        for (int i = 0; i<bin.length(); i++) {
        	    //int power = bin.length() - 1- i;
        		int temp = (int)Math.pow(2, i);
        		decimal = decimal +  Character.getNumericValue(bin.charAt(i)) * temp;
        }
	    System.out.println("Binary " + oldbin + " = " + decimal + " in decimal");
        pw.write("Binary " + oldbin + " = " + decimal + " in decimal\n");

    }
    
    /**
     * Method that transforms a binary to hexadecimal
     * 
     * @param no parameters
     * @return returns void
     */
    
    public void binToHex()
    {
        System.out.println("Please enter a binary number");
        Scanner keyboard = new Scanner(System.in);
        String bin = keyboard.nextLine();
        String oldbin = bin;
        bin = bin.replace(" ", "").trim();
        StringBuffer hex = new StringBuffer("00000000");
        //String hex1 = "";
        int j = 0; 
        for (int i = 0; i < bin.length();) {
        		if (bin.substring(i, i+4).equals("0000")) {
        			hex.setCharAt(j, '0');
        		} else if (bin.substring(i, i+4).equals("0001")) {
        			hex.setCharAt(j, '1');
        		}  else if (bin.substring(i, i+4).equals("0010")) {
        			hex.setCharAt(j, '2');
        		}  else if (bin.substring(i, i+4).equals("0011")) {
        			hex.setCharAt(j, '3');
        		} else if (bin.substring(i, i+4).equals("0100")) {
        			hex.setCharAt(j, '4');
        		} else if (bin.substring(i, i+4).equals("0101")) {
        			hex.setCharAt(j, '5');
        		} else if (bin.substring(i, i+4).equals("0110")) {
        			hex.setCharAt(j, '6');
        		} else if (bin.substring(i, i+4).equals("0111")) {
        			hex.setCharAt(j, '7');
        		} else if (bin.substring(i, i+4).equals("1000")) {
        			hex.setCharAt(j, '8');
        		} else if (bin.substring(i, i+4).equals("1001")) {
        			hex.setCharAt(j, '9');
        		} else if (bin.substring(i, i+4).equals("1010")) {
        			hex.setCharAt(j, 'A');
        		} else if (bin.substring(i, i+4).equals("1011")) {
        			hex.setCharAt(j, 'B');
        		} else if (bin.substring(i, i+4).equals("1100")) {
        			hex.setCharAt(j, 'C');
        		} else if (bin.substring(i, i+4).equals("1101")) {
        			hex.setCharAt(j, 'D');
        		} else if (bin.substring(i, i+4).equals("1110")) {
        			hex.setCharAt(j, 'E');
        		} else if (bin.substring(i, i+4).equals("1111")) {
        			hex.setCharAt(j, 'F');
        		}
        		i = i+4;
        		j = j + 1;
        }
	    System.out.println("Binay " + oldbin + " = " + hex + " in hexadecimal");
        pw.write("Binary " + oldbin + " = " + hex + " in hexadecimal\n");
    }
}
