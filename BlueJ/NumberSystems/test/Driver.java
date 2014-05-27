
/**
 * Computer Lab: Number Systems
 * Converts a decimal, binary or haxadecimal number to either binary, decimal or haxadecimal numbers
 * To start the program type, cd to the project folder and type "java Driver"; 
 * Follow the menu instructions
 *   
 * Driver Class
 * 
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.2 - February 2, 2014
 */

import java.io.*;

public class Driver
{
	/**
	 * Main method
	 * 
	 * @param args
	 * @throws IOException
	 */
    public static void main(String[] args) throws IOException{
        int choice;
        
        PrintWriter pw = new PrintWriter (new FileWriter("csis.txt"));
        Decimal dec = new Decimal (pw);
        Binary bin = new Binary (pw);
        Hexadecimal hex = new Hexadecimal (pw);
        Menu menu = new Menu(pw);
        
        do {
            menu.display();
            choice = menu.getSelection();
            switch (choice) {
                case 1 : dec.decToBin(); break;
                case 2 : dec.decToHex(); break;
                case 3 : bin.binToDec(); break;
                case 4 : bin.binToHex(); break;
                case 5 : hex.hexToDec(); break;
                case 6 : hex.hexToBin(); break;
            }
        } while (choice != 7);
        pw.close();
    }
}
