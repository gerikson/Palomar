/*
 * Author: Galina Erikson
 * Lab Assignment #3
 * Class:CSCI 110 
 * Due date: 9/16/2013
 * 
 * Zeller's Congruence
 */

import java.util.Scanner;

public class zellerCongruence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int adjusted_month, adjusted_year, month_correction, century, century_remainder, year_correction, weekday;
		
		Scanner keyboard = new Scanner(System.in);
		//1. Allow the user to enter a month. For calculation purposes, January = 1, February = 2, ... December = 12.
		System.out.println("Please enter a month. For calculation purposes, January = 1, February = 2, ... December = 12. ");
		int month = keyboard.nextInt();
		System.out.println("1. " + month);
		if (month >12 || month <1) {
			System.out.println("Please enter a posible month. On Earth we have only 12 months so please enter a number between 1 and 31. " + month + " is not a posible month.");
			month = keyboard.nextInt();
			System.out.println("1. " + month);
		}
		//2. Enter a day of the month(1..31) Error checking is not necessary at this point, but would be helpful.
		System.out.println("Please enter a day of the month. Ex: a number between 1 and 31:");
		int day = keyboard.nextInt();
		System.out.println("2. " + day);
		if (day >31 || day < 1 ) {
			System.out.println("Please enter a valid day of the month. Ex: a number between 1 and 31: " + day + " is not a valid day of the month:");
			day = keyboard.nextInt();
			System.out.println("2. " + day);
		}
		//3. Enter a year using 4 digits (e.g., 1776, 1994, 2001)
		System.out.println("Enter a year using 4 digits (e.g., 1776, 1994, 2001)");
		int year = keyboard.nextInt();
		System.out.println("3. " + year);
		//4. Find the adjusted month and adjusted year. If the month entered is less than or equal to 2 Add 10 to it Subtract 1 from the year entered
		if (month <= 2) {
			 adjusted_month = month +10;
		     adjusted_year = year -1;
		} //Otherwise Subtract 2 from the month.Leave the year alone
		else {
			 adjusted_month = month -2;
			 adjusted_year= year;
		}
		System.out.println("4. Adjusted month =  " + adjusted_month + " Adjusted year = " + adjusted_year);
		//5. Find the month correction by: Multiplying the adjusted month by 26; Subtract 2 from the above Integer divide the above by 10
		month_correction = (adjusted_month*26 -2)/10;
		System.out.println("5. Month correction = " + month_correction);
		//6. Determine the century by integer dividing the adjusted year by 100
		century = adjusted_year/100;
		System.out.println("6. Century = " + century);
		//7. Determine the century remainder by finding the modulus 100 of the adjusted year
		century_remainder = adjusted_year%100;
		System.out.println("7. Century remainder= " + century_remainder);
		/*8. Determine the year correction by:
	    Multiplying the century by five then
	    Adding the following to it
	        The century remainder
	        The century remainder integer divided by 4
	        The century integer divided by 4
		*/
		year_correction = century*5 +century_remainder + century_remainder/4 +century/4;
		System.out.println("8. Year correction = " + year_correction);
		/*
		 * Determine which weekday by
		 * Adding the day, month correction, and year correction
    		 * Finding the above sum's modulus 7
		 */
		weekday = (day + month_correction+ year_correction)%7;
		if (weekday == 0) {
			System.out.println("Weekday is Sunday");
		} 	else	if (weekday == 1) {
			System.out.println("Weekday is Monday");
		}	else	if (weekday == 2) {
			System.out.println("Weekday is Tuesday");
		}	else	if (weekday == 3) {
			System.out.println("Weekday is Wednesday");
		}	else	if (weekday == 4) {
			System.out.println("Weekday is Thursday");
		}	else	if (weekday == 5) {
			System.out.println("Weekday is Friday");
		}	else	if (weekday == 6) {
			System.out.println("Weekday is Saturday");
		}
	}

}
