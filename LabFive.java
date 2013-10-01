/*
 * Author: Galina Erikson
 * Lab Assignment #4
 * Class:CSCI 110 
 * Due date: 9/30/2013
 * StringStuff 
 */

import java.util.Locale;
import java.util.Scanner;

public class LabFive {

	public static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		//(1) Ask the user to type in a sentence or phrase with between 2 and 5 words 
		System.out.println("Please enter a sentence of 5 words");
		String[] sentence;
		String sentenceAsString = keyboard.nextLine();
		
		//(2) Display the user’s sentence or phrase.
		System.out.println("(1)The sentence entered is: ");
		System.out.println(sentenceAsString);
		
		//Spliting the sentence into an array
		sentence = sentenceAsString.split(" ");
		
		//(3) Reverse the wording by word.
		System.out.println("(2)Reversed sentence by word: ");
	    for (int i = sentence.length - 1; i >= 0; i--) {
			System.out.print(sentence[i] + " ");
		}
		
	    //(4) Reverse the entire sentence by characters.
	    System.out.println("\n (3)Characters in words reversed: ");
		for (int i = sentence.length - 1; i >= 0; i--) {
		   //String builder version
			//System.out.print(new StringBuilder(sentence[i]).reverse().toString());
		    String word = sentence[i];
			for (int j = word.length() -1; j>=0; j--) {
		    		System.out.print(word.charAt(j));
		    }
			System.out.print(" ");
		}
		
		//(5) Find a substring in the sentence or phrase and display it. (It need not be an actual word)
		System.out.println("\n (4)Substring: ");
		for(String part: sentence) {
			System.out.print(part.substring(1, part.length() -1) + " ");
		}
		
		//(6) Display only the first word of the user’s sentence or phrase all in upper case letters.
		System.out.println("\n (5)First word in uppercase: ");

		

	    System.out.print(sentence[0].toUpperCase()+ " ");
		for (int i = 1; i < sentence.length; i++) {
			System.out.print(sentence[i] + " ");
		}
		
		//(7) Display the length of the original sentence or phrase.
		System.out.println("\n (6)The lenght of the sentence is: " + sentenceAsString.length());
	}
}
