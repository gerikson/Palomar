/*
 * Author: Galina Erikson
 * Lab Assignment #1
 * Class:CSCI 110 
 * Due date: 9/3
 * 
 * Program that has 5 output statements for each of the following arithmetic operators: '+', '-', '*', '/' and '%', given 2 user input numbers. 
 * Note, integer division was used.
 */

import java.util.Scanner;

public class MyFirstProgram {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter two numbers: ");
		int num1 = keyboard.nextInt();
		int num2 = keyboard.nextInt();
		Double d = (double) (num1/num2);
		int num3 = d.intValue();
		System.out.println("The sum of " + num1 + " and " +num2 + " is " + (num1+num2));
		System.out.println("The difference of " + num1 + " and " +num2 + " is " + (num1-num2));
		System.out.println("The multiplication of " + num1 + " and " +num2 + " is " + (num1*num2));
		System.out.println("The division of " + num1 + " and " +num2 + " is " + num3);
		System.out.println("The remaining of division of  " + num1 + " and " +num2 + " is " + (num1%num2));

	}

}
