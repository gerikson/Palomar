/**
 * Word class 
 * 
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.1 - May 4th, 2014
 */

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Word implements TreeComparable {
	private String word_stored;
	private int number_of_times;
	private ObjectList list = new ObjectList();
	 private PrintWriter pw;
	 
	private ObjectBinaryTree tree  = new ObjectBinaryTree();
	private Map <String, Word>map = new HashMap<String, Word>();	

	
	public Word(PrintWriter pw){
		this.pw = pw;
		this.word_stored = null;
		this.number_of_times = 0;
		this.list = new ObjectList();
	}
	
	public Word(String word, int line_number, int position) {
		this.word_stored = word;
		this.number_of_times = 1;
		Xref reference = new Xref(line_number, position);
		ObjectListNode node = new ObjectListNode(reference);
		this.list.addLast(node);
	}
	
	/**
	 * Adds a new node to the LinkedList with new line number and word count
	 * @param ref
	 */
	public void addNodelist(Xref ref) {
		this.number_of_times++;
		ObjectListNode node = new ObjectListNode(ref);
		this.list.addLast(node);
	}
	/**
	 * Method that read the file line by line and inserts the words into the tree
	 * @param input
	 */
	public void readFile(Scanner input, Hash omited_words) {
		int line_number = 0;
		while (input.hasNext()) {
			line_number++;
			//System.out.println("Line number = " + String.valueOf(line_number));
			String buf = input.nextLine();
			String[] tokens = buf.split("\\s+");
			for (int i = 0; i < tokens.length; i++) {
				//Omit the "-"s
				if (!tokens[i].equals("-")) {
					String word = tokens[i].toLowerCase();
					//Remove the dots, colons and semicolons from the end of the word
					if (tokens[i].contains(".") || tokens[i].contains(",") || tokens[i].contains(";")) {					
						word = word.substring(0, word.length()-1);
					}
					//See if this word is in the list of words to be omited
					if (!omited_words.findElement(word)) {
						if (!map.containsKey(word)) {
							//Create new word object
							Word new_word = new Word(word, line_number, i+1);						
							//tree.insertBST(word);
							//ObjectTreeNode o = new ObjectTreeNode(new_word);
							//tree.insertBST(o);
							map.put(word, new_word);
							//System.out.print(word + "\n");
						} else {
							Xref reference = new Xref(line_number, i+1);
							Word existing_word = map.get(word);
							existing_word.addNodelist(reference);
							//ObjectTreeNode o = new ObjectTreeNode(existing_word);
							//tree.insertBSTDuplicate(o);
							map.put(word, existing_word);
						}
					}
				}
			}
		}
	}
	
	/**
	 * Print Data in HashMap
	 */
	public void printData() {


		for (Map.Entry<String, Word> entry : map.entrySet()) {
			String word = entry.getKey();
			Word value = entry.getValue();
			System.out.print(word + "\t" + String.valueOf(value.number_of_times) + "\t");
			pw.append(word + "\t" + String.valueOf(value.number_of_times) + "\t");
			ObjectList list = value.list;
	        ObjectListNode p = list.getFirstNode();
	        while (p != null) {
	        		Xref ref = (Xref) p.getInfo();
	        		System.out.print(String.valueOf(ref.get_line()) + "-" + String.valueOf(ref.get_word()) + "\t");
	        		pw.append(String.valueOf(ref.get_line()) + "-" + String.valueOf(ref.get_word()) + "\t");
	        		p = p.getNext();
	        }
	        System.out.print("\n");
	        pw.append("\n");
		}


	}
	public String get_word() {
		return this.word_stored;
	}
	
	/**
	 * Compares two words objects
	 */
	public int compareTo(Object o) {
		Word e = (Word) o;
		System.out.println(e.get_word());
		return word_stored.compareTo(e.get_word());
	}
	
	/**
	 * Copies the new info to the existing node
	 * @param o
	 * @return
	 */
	public void operate(Object o){
		Word e = (Word) o;
		this.list = e.list;
		this.number_of_times = e.number_of_times;
	}
	
	/**
	 * Visit method
	 * @return
	 */
	public void visit() {
		
	}
	
	/**
	 * Queries the tree
	 * @param word
	 */
	public void queryTree(String word) {
		//tree.equals(word);
		Word found = map.get(word);
		//ObjectTreeNode node = tree.searchBST(word);
		try {		
			System.out.print(word + "\t" + String.valueOf(found.number_of_times) + "\t");
			pw.append(word + "\t" + String.valueOf(found.number_of_times) + "\t");
			ObjectList list = found.list;
	        ObjectListNode p = list.getFirstNode();
	        while (p != null) {
	        		Xref ref = (Xref) p.getInfo();
	        		System.out.print(String.valueOf(ref.get_line()) + "-" + String.valueOf(ref.get_word()) + "\t");
	        		pw.append(String.valueOf(ref.get_line()) + "-" + String.valueOf(ref.get_word()) + "\t");
	        		p = p.getNext();
	        }
	        System.out.println("\t");
	        pw.append("\n");
		} catch(Exception ex) {
			if (word.equals("0")) {
				System.out.println("Goodbuy");
				pw.append("Goodbuy");
			} else {
				System.out.println("Word was not found, please ented a different word!");
				pw.append("Word was not found, please ented a different word!");
			}
		}
	}
	
	/**
	 * Print all entries
	 */	
	public void printTree(){
		tree.printTree(tree.getRoot());
	}
}
