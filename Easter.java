/*
 * Author: Galina Erikson
 * Lab Assignment #3
 * Class:CSCI 110 
 * Due date: 9/16/2013
 * 
 * Program that determines the date for Easter for any year in the 21st Century.
 */

import java.util.Scanner;

public class Easter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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

}
