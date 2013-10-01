/*
 * Author: Galina Erikson
 * Lab Assignment #4
 * Class:CSCI 110 
 * Due date: 9/23/2013
 * Monte Carlo algorithm
 */

import java.util.Random;

public class LabFour {

	
	public static void main(String[] args) {
		final int TOSSES = 5000000;
		Random rand_generator = new Random();
		Random rand_generator_two = new Random();
		
		int result1, result2;
		int total2, total3, total4, total5, total6, total7, total8, total9, total10, total11, total12;
		
		total2 = total3 = total4 =  total5 = total6 = total7 = total8 = total9 = total10 = total11 = total12 = 0;
		result1 = result2 = 0;

		for(int toss = 1; toss <= TOSSES; toss++)

		{
		
		//generate two random number from 1-6
		result1 = rand_generator.nextInt(6) + 1;
		result2 = rand_generator.nextInt(6) + 1;
		switch (result1)
		{
			case 1:
				switch (result2)
				{
					case 1:
						total2++;
						break;
					case 2:
						total3++;
						break;
					case 3:
						total4++;
						break;
					case 4:
						total5++;
						break;
					case 5:
						total6++;
						break;
					case 6:
						total7++;
						break;
					default:
					    System.out.println("Exception! Only numbers between 1to 6 should be selected!");
						break;
				}
				break;
			case 2:
				switch (result2)
				{
					case 1:
						total3++;
						break;
					case 2:
						total4++;
						break;
					case 3:
						total5++;
						break;
					case 4:
						total6++;
						break;
					case 5:
						total7++;
						break;
					case 6:
						total8++;
						break;
					default:
					    System.out.println("Exception! Only numbers between 1to 6 should be selected!");
						break;
				}
				break;
			case 3:
				switch (result2)
				{
					case 1:
						total4++;
						break;
					case 2:
						total5++;
						break;
					case 3:
						total6++;
						break;
					case 4:
						total7++;
						break;
					case 5:
						total8++;
						break;
					case 6:
						total9++;
						break;
					default:
					    System.out.println("Exception! Only numbers between 1to 6 should be selected!");
						break;
				}
				break;
			case 4:
				switch (result2)
				{
					case 1:
						total5++;
						break;
					case 2:
						total6++;
						break;
					case 3:
						total7++;
						break;
					case 4:
						total8++;
						break;
					case 5:
						total9++;
						break;
					case 6:
						total10++;
						break;
					default:
					    System.out.println("Exception! Only numbers between 1to 6 should be selected!");
						break;
				}
				break;
			case 5:
				switch (result2)
				{
					case 1:
						total6++;
						break;
					case 2:
						total7++;
						break;
					case 3:
						total8++;
						break;
					case 4:
						total9++;
						break;
					case 5:
						total10++;
						break;
					case 6:
						total11++;
						break;
					default:
						System.out.println("Exception! Only numbers between 1to 6 should be selected!");
						break;
				}
				break;
			case 6:
				switch (result2)
				{
					case 1:
						total7++;
						break;
					case 2:
						total8++;
						break;
					case 3:
						total9++;
						break;
					case 4:
						total10++;
						break;
					case 5:
						total11++;
						break;
					case 6:
						total12++;
						break;
					default:
						System.out.println("Exception! Only numbers between 1to 6 should be selected!");
						break;
				}
				break;
				default:
					System.out.println("Exception! Only numbers between 1to 6 should be selected!");
					break;
		}
		}
		
		System.out.println("The probability of getting a sum of 2 is: " + (float) total2/5000000);
		System.out.println("The probability of getting a sum of 3 is: " + (float) total3/5000000);
		System.out.println("The probability of getting a sum of 4 is: " + (float) total4/5000000);
		System.out.println("The probability of getting a sum of 5 is: " + (float) total5/5000000);
		System.out.println("The probability of getting a sum of 6 is: " + (float) total6/5000000);
		System.out.println("The probability of getting a sum of 7 is: " + (float) total7/5000000);
		System.out.println("The probability of getting a sum of 8 is: " + (float) total8/5000000);
		System.out.println("The probability of getting a sum of 9 is: " + (float) total9/5000000);
		System.out.println("The probability of getting a sum of 10 is: " + (float) total10/5000000);
		System.out.println("The probability of getting a sum of 11 is: " + (float) total11/5000000);
		System.out.println("The probability of getting a sum of 12 is: " + (float) total12/5000000);

	
	}
}

