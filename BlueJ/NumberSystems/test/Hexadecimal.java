/**
 * Class that transform a hexadecimal number to decimal and/or binary.
 *
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.2
 */

import java.io.*;
import java.util.Scanner;

public class Hexadecimal
{
    private PrintWriter pw;

    /**
     * Constructor for objects of class Binary
     * @param pw PrintWriter files
     */
    public Hexadecimal(PrintWriter pw)
    {
        // initialise instance PrinWriter
        this.pw = pw;
    }

    /**
     * Method that transforms a binary number to decimal
     * @param no parameters
     * @return returns void
     */
    public void hexToDec()
    {
        System.out.println("Please enter a hexadecimal number:");
        Scanner keyboard = new Scanner(System.in);
        String bin = keyboard.nextLine();
        String oldbin = bin;
        bin = bin.toLowerCase().trim();
        int decimal = 0;
        for (int i = bin.length()-1; i >= 0; i--) {
        	    int power = bin.length() - 1- i;
        		int temp = (int)Math.pow(16, power);
        		int value = 0;
        		if (bin.charAt(i) == 'a') {
        			value = 10;
        		} else if (bin.charAt(i) == 'b') {
        			value = 11;
        		} else if (bin.charAt(i) == 'c') {
        			value = 12;
        		} else if (bin.charAt(i) == 'd') {
        			value = 13;
        		} else if ((bin.charAt(i) == 'e')) {
        			value = 14;
        		} else if (bin.charAt(i) == 'f') {
        			value = 15;
        		} else {
        			value = Character.getNumericValue(bin.charAt(i));
        		}
        		decimal = decimal +  value * temp;
        }
	    System.out.println("Hexadecimal " + oldbin + " = " + decimal + " in decimal");
        pw.write("Hexadecimal " + oldbin + " = " + decimal + " in decimal\n");


    }
    
    /**
     * Method that transforms a binary to hexadecimal
     * @param no parameters
     * @return returns void
     */
    
    public void hexToBin()
    {
        System.out.println("Please enter a hexadecimal number:");
        Scanner keyboard = new Scanner(System.in);
        String bin = keyboard.nextLine();
        bin = bin.trim();
        String binary = "";
        for (int i = 0; i < bin.length(); i++) {
    			if (bin.charAt(i) == '0') {
    				binary = binary.concat("0000 ");
    			} else if (bin.charAt(i) == '1') {
    				binary = binary.concat("0001 ");
    			}  else if (bin.charAt(i) == '2') {
    				binary = binary.concat("0010 ");
    			}  else if (bin.charAt(i) == '3') {
    				binary = binary.concat("0011 ");
    			}  else if (bin.charAt(i) == '4') {
    				binary = binary.concat("0100 ");
    			}   else if (bin.charAt(i) == '5') {
    				binary = binary.concat("0101 ");
    			}   else if (bin.charAt(i) == '6') {
    				binary = binary.concat("0110 ");
    			}   else if (bin.charAt(i) == '7') {
    				binary = binary.concat("0111 ");
    			}   else if (bin.charAt(i) == '8') {
    				binary = binary.concat("1000 ");
    			}   else if (bin.charAt(i) == '9') {
    				binary = binary.concat("1001 ");
    			}   else if (bin.charAt(i) == 'A') {
    				binary = binary.concat("1010 ");
    			}   else if (bin.charAt(i) == 'B') {
    				binary = binary.concat("1011 ");
    			}   else if (bin.charAt(i) == 'C') {
    				binary = binary.concat("1100 ");
    			}   else if (bin.charAt(i) == 'D') {
    				binary = binary.concat("1101 ");
    			}   else if (bin.charAt(i) == 'E') {
    				binary = binary.concat("1110 ");
    			}   else if (bin.charAt(i) == 'F') {
    				binary = binary.concat("1111 ");
    			} 
        }
	    System.out.println("Hexadecimal " + bin + " = " + binary + " in binary");
        pw.write("Hexadecimal " + bin + " = " + binary + " in binary\n");
    }
}
