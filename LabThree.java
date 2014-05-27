/*
 * Author: Galina Erikson
 * Lab Assignment #3
 * Class:CSCI 110 
 * Due date: 9/16/2013
 * Two algorithms Easter and Zeller's congruence
 */

import java.util.Scanner;

public class LabThree {

	public static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Please ender a number depending of which algorithm you want to run. For Easter enter 1, for Zeller's Congruence enter 2  ");
		int input = keyboard.nextInt();
		if (input == 1) {
			easter();
		} else if (input ==2) {
			zeller();
		} else {
			System.out.println("Please ender a number depending of which algorithm you want to run. For Easter enter 1, for Zeller's Congruence enter 2.  The number you entered " + input + " is neither 1 0r 2!");
			 input = keyboard.nextInt();
			if (input == 1) {
				easter();
			} else if (input ==2) {
				zeller();
			}  else {
				System.out.println("This program is designed for literate human beings, aparently you don't know how to count to 2 so I can't help you. Learn how to read/count and try again! ");
			}
		}
	}
	
	/* 
	 * Program that determines the date for Easter for any year in the 21st Century.
	 */

	public static void easter() {
		Scanner keyboard = new Scanner(System.in);
		//1. Ask the user to choose a year in the 21st Century, divide it by 19, and find the remainder.
		System.out.println("Please enter a year in the 21st century: ");
		int input = keyboard.nextInt();
		int running_total = input%19;
		System.out.println("1. " + running_total);
		//2. Add 1 to the remainder
		int running_total_step2 = running_total +1;
		System.out.println("2." + running_total_step2);
		//3. Multiply the original year by 5, divide that product by 4, and discard the remainder. Subtract 13 from this answer.
		int temp_running_total = (input*5)/4 -13;
		System.out.println("3. " + temp_running_total);
		//4. Multiply the answer in step 2 by 11 and add 18 to it
		running_total = running_total_step2*11 + 18;
		System.out.println("4. " + running_total);
		//5. Divide the answer in step 4 by 30 and find the remainder. Let's call this number E here.
		int E = running_total%30;
		System.out.println("5. " + E);
		//6. If the answer in step 5 equals 25 and the answer in step 2 is greater than 11, then add 1 to it. Call this number E
		if (E == 25 && running_total_step2 > 11) {
			E=E+1;
			System.out.println("6. " + E);
		} else {
			System.out.println("6. skip");
		}
		//7. If the answer in step 5 equals 24, then add one to it. Call this number E
		if (E==24) {
			E=E+1;
			System.out.println("7. " + E);
		}  else {
			System.out.println("7. skip");
		}
		//8. Subtract E from 44. If this number is less than 21,add 30 to it
		 int temp_E = 44-E;
		if (temp_E <21) {
			temp_E = temp_E +30;
			System.out.println("8. " + temp_E);
		} else {
			System.out.println("8. skip");
		}
		//9. Add 7 to the answer in step 8
		temp_E = temp_E +7;
		System.out.println("9. " + temp_E);
		//10. Add the answer in step 9 to the answer in step 3. Divide this answer by 7 and find the remainder
		int step_10 = (temp_E + temp_running_total)%7;
		System.out.println("10. " + step_10);
		//11. Subtract the answer in step 10 from the answer in step 9. Let's call this number D
		int D = temp_E - step_10;
		System.out.println("11. " + D);
		//12. If D is less than or equal to 31, then Easter is March D, otherwise, Easter is April D-31
		if (D<=31) {
			System.out.println("12. March " + D);
		} else {
			System.out.println("12. April " + (D-31));
		}
	
	}
	
	/*
	 * Zeller's Congruence
	 */
	public static void zeller() {
		int adjusted_month, adjusted_year, month_correction, century, century_remainder, year_correction, weekday;
		
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
