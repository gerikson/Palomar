/**
 * Xref class
 * 
 * Properties: line_number, word_position
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.1 - April 9th, 2014
 *
 */


public class Xref {
	private ObjectList list;
	private int line_number;
	private int word_position;
	
	/**
	 * Class constructor
	 */
	public Xref() {
		this.line_number = 0;
		this.word_position = 0;
		this.list = new ObjectList();
	}
	
	/**
	 * Class constructor
	 * @param l_number
	 * @param w_position
	 */
	public Xref(int l_number, int w_position){
		this.line_number = l_number;
		this.word_position = w_position;		
	}
	
	/**
	 * Returns the line number
	 * @return
	 */
	public int get_line() {
		return this.line_number;
	}
	
	/**
	 * Returns the word count
	 * @return
	 */
	public int get_word() {
		return this.word_position;
	}
}
