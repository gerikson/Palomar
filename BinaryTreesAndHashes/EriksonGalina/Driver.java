import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
/**
 * Binary Trees and Hashing Lab
 * Program that displays the number of times each word appears in a document, 
 * the line numbers in which each word appears and the position of each word in the line
 * 
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.1 - May 4th, 2014
 */


  

public class Driver {
	
	/**
	 * Main method
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
		Scanner omitedFile = new Scanner(new File("omited.txt"));
		Scanner textFile = new Scanner(new File("getty.txt"));
		Hash omited_words = new Hash(omitedFile);
		omited_words.ReadInputFile();
		omited_words.display_hash_table();
		Word new_word = new Word(pw);
		new_word.readFile(textFile, omited_words);
		//new_word.queryTree("perish");
		new_word.printData();
		String ex = "1";
		while (ex.equals("1")) {
			System.out.println("Please enter a word for query, enter 0 to exit: ");
			pw.append("Please enter a word for query, enter 0 to exit: ");
			Scanner keyboard = new Scanner(System.in);
			String input = keyboard.next();
			pw.append(input + "\n");
			if (input.equals("0")) {
				ex = "0";
			}
			new_word.queryTree(input);
		}
		pw.close();
		omitedFile.close();
		textFile.close();
	}
	
}
