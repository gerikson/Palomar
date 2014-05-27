/*
 * Author: Galina Erikson
 * Lab Assignment #2
 * Class:CSCI 110 
 * Due date: 9/9/2013
 * 
 * Program that asks a  person for a random number, multiply that by 2, add 5, multiply that by 50, add either 1762 or 1761 after it's been augmented by 1 using the ++ operator, 
 * then subtract the year they're born in, you will get their age.
 */


import java.util.Scanner;


public class LabTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int running_total = 0; 
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many times do you like eating ice cream a week? Please enter a number: ");
		int input = keyboard.nextInt();
		running_total = input;
		System.out.println("I need to multiply this number by 2, please enter 2: ");
		input = keyboard.nextInt();
		/*
		 * check that the user entered 2 and not another number
		 */
		if (input != 2) {
			System.out.println("You entered " + input + ", please enter the number 2: ");
			input = keyboard.nextInt();
			System.out.println(running_total + "*" + input + "="+(running_total*input) );
			running_total = running_total*input;
		} else {
			System.out.println(running_total + "*" + input + "="+(running_total*input) );
			running_total = running_total*input;
		}
		System.out.println("I need to add 5, please enter 5: ");
		input = keyboard.nextInt();
		if (input != 5) {
			System.out.println("You entered " + input + ", please enter the number 5: ");
			input = keyboard.nextInt();
			System.out.println(running_total + "+" + input + "="+(running_total+input) );
			running_total = running_total + input;
		} else {
			System.out.println(running_total + "+" + input + "="+(running_total+input) );
			running_total = running_total + input;
		}
		System.out.println("I need to multiply by 50, please enter 50: ");
		input = keyboard.nextInt();
		if (input != 50) {
			System.out.println("You entered " + input + ", please enter the number 50: ");
			input = keyboard.nextInt();
			System.out.println(running_total + "*" + input + "="+(running_total*input) );
			running_total = running_total*input;
		} else {
			System.out.println(running_total + "*" + input + "="+(running_total*input) );
			running_total = running_total*input;
		}
		System.out.println("Please enter 1762 if your birthday already passed this year, otherwise enter 1761: ");
		input = keyboard.nextInt();
		/*
		 * make sure 1762 or 1761 was entered, no other numbers
		 */
		if (input == 1762 || input == 1761) {
			input++;
			System.out.println("input++="+ (input));
			System.out.println(running_total + "*" + input + "="+(running_total+input) );
			running_total = running_total+input;
		} else {			
			System.out.println("You entered " + input + ", please enter the number 1762 if your birthday already passed this year, otherwise enter 1761: ");
			input = keyboard.nextInt();
			input++;
			System.out.println("input++="+ (input));
			System.out.println(running_total + "*" + input + "="+(running_total+input) );
			running_total = running_total+input;
		}
		System.out.println("Please enter the year you were born: ");
		input = keyboard.nextInt();
		System.out.println(running_total + "-" + input + "="+(running_total-input) );
		running_total = running_total - input;
		System.out.println("Age is " + running_total + "%" + 100 + "=" + (running_total%100));
		System.out.println("Congratulations you are " + (running_total%100) + " years old!");
	}

}
