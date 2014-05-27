/**
 * Menu class, let the user choose the number transformation.
 *
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.2
 */

import java.io.*;
import java.util.Scanner;

public class Menu
{
    private PrintWriter pw;


    /**
     *  Class constructor
     * @param pw PrintWriter files
     */
    public Menu(PrintWriter pw)
    {
        // initialize instance PrinWriter
        this.pw = pw;
    }

    /**
     * Displays the menu options
     */
    public void display()
    {
        System.out.println(" MENU ");
        System.out.println("1. Press 1 for decimal to binary transformation. ");
        System.out.println("2. Press 2 for decimal to hexadecimal transformation. ");
        System.out.println("3. Press 3 for binary to decimal transformation. ");
        System.out.println("4. Press 4 for binary to hexadecimal transformation. ");
        System.out.println("5. Press 5 for hexadecimal to decimal transformation. ");
        System.out.println("6. Press 6 for hexadecimal to binary transformation. ");
        System.out.println("7. Press 7 to exit the program. ");
    }
    
    /**
     * Extracts the user inserted option
     * @return the selection the user inserted
     */
    public int getSelection() {
        Scanner keyboard = new Scanner(System.in);
        int input = keyboard.nextInt();
        boolean check_quality = qualityCheck(input);
        if (!check_quality) {
        		System.out.println("Please enter a value between 1 and 7: ");
        		keyboard = new Scanner(System.in);
        		input = keyboard.nextInt();
        		check_quality = qualityCheck(input);
        }
        return input;
    }
    
    /**
     * Method that check that the user inserts a correct value
     * 
     * @param input - the menu selection
     * @return true if the user inserted a number from 1 to 7, otherwise false
     */
    public boolean qualityCheck(int input) {
    		if (input != 1 || input != 2 ||input != 3 ||input != 4 ||input != 5 ||input != 6 ||input != 7) {
    			return true;
    		} else {
    			return false;
    		}
    }
}
