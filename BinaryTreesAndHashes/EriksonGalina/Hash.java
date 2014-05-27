import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Hash class that manages the omited words
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.1 - April 9th, 2014
 */
  
public class Hash {
	
	   // declare table size and element array
	   public final int SIZE = 27;
	   private HashNode[] table = new HashNode[SIZE];
	   private Scanner inputFile;
	   private int count_probe;
	   private PrintWriter pw;
	   /**
	    * Class constructor
	    * @param input file
	    */
	   public Hash(Scanner input, PrintWriter pw) {
		   this.inputFile = input;
		   this.count_probe = 0;
		   this.pw = pw;
	   }
	   
		/**
		 * Method that reads the input file and adds each element in the hash
		 */
		public void ReadInputFile() {
			while (inputFile.hasNext()) {
				String buf = inputFile.nextLine();
				String[] tokens = buf.split("\t");
				for (int i =0; i < tokens.length; i++) {
					add(tokens[i], tokens[i]);
				}			
			}
		}
		
		
		public boolean findElement(String key) {
			boolean found = false;
			//String value = map.get(key);
			String value = this.retrieve(key);
			if (value != null) {
				found = true;
			}
			return found;
		}

		/**
		 * 
		 * @param Hash Value
		 * @return Hash Key
		 */
		public int hash(String s) {
			int sum = 0;
			
			for (int i = 0; i <s.length(); i++) {
				sum += (int) s.charAt(i);
			}
			return sum % SIZE;		
		}
	
		   /**
		    * calculate a hash code for a given string
		    * @param key
		    * @return
		    */
		public int code(String key)
		   {
			   int sum = 0;
			   for (int i=0; i <key.length(); i++) {
				   sum += (int) key.charAt(i);
			   }
			   return sum% SIZE;
		   }

		   /**
		    * add():  add a key-data pair to the table
		    * @param key
		    * @param data
		    * @return
		    */
		   public boolean add(String key, String data)
		   {
		      // probe place variable
		      int probe;
		      
		      // calculate hashcode from key
		      int code = code(key);
		      
		      // if hash item is empty, add straight away
		      if ((table[code] == null) || table[code].isDeleted())
		      {
		         table[code] = new HashNode(key, data);
		         probe = -1;
		      }
		      // otherwise, probe through the list for a free spot
		      else
		      {
		         // initialise probe to next spot
		         if (code == (table.length - 1) )
		            probe = 0;
		         else
		            probe = code + 1;
		      }
		      
		   
		      // keep probing while data hasn't been stored, and it
		      // hasn't looped back to the original item
		      while ((probe != -1) && (probe != code))
		      {
		    	  	 this.count_probe ++;
		         // if the probed element is null
		         if ((table[probe] == null) || table[probe].isDeleted())
		         {
		            // add the data and mark as being stored
		            table[probe] = new HashNode(key, data);
		            probe = -1;
		         }
		         // otherwise probe to the next item
		         else
		         {
		            if (probe == (table.length -1) )
		               probe = 0;
		            else
		               probe++;
		         }
		      }
		   
		      // return operation success
		      // if data was stored, return true, otherwise false
		      if (probe != -1)
		         return false;
		      else
		         return true;
		   }
		   
		 /**
		  *  retrieve(): retrieve the data for a given key
		  * @param key
		  * @return
		  */
		 public String retrieve(String key)
		   {
		      // probe place variable
		      int probe;
		      
		      // calculate hashcode from key
		      int code = code(key);
		      
		   
		      // if its empty to start, return false
		      if (table[code] == null)
		         return null;
		      // if hash item is a match, return straight away
		      else if (table[code].getKey().equals(key))
		         return table[code].getData();
		      // otherwise, probe through the list for a free spot
		      else
		      {
		         // initialise probe to next spot
		         if (code == (table.length - 1) )
		            probe = 0;
		         else
		            probe = code + 1;
		      }
		      
		      // keep probing while data hasn't been stored, and it
		      // hasn't looped back to the original item
		      while ((probe != -1) && (probe != code))
		      {
		         // if the probed element is COMPLETELY empty, return
		         if (table[probe] == null)
		            return null;
		         // if the probed element is a match
		         else if (table[probe].getKey().equals(key))
		         {
		            // return the data
		            return table[probe].getData();
		         }
		         // otherwise probe to the next item
		         else
		         {
		            if (probe == (table.length - 1) )
		               probe = 0;
		            else
		               probe++;
		         }
		      }
		         
		      // if nothing has been returned, data is not present.
		      // return null
		      return null;

		   }
		 
		 /**
		  * Display the hash table
		  */
		 public void display_hash_table() {
			 System.out.println("Display Omited Hash Table:");
			 pw.append("Display Omited Hash Table:\n");
			 for (int i = 0; i < table.length; i++) {
				 System.out.println(String.valueOf(i) + "\t" + table[i].getData());
				 pw.append(String.valueOf(i) + "\t" + table[i].getData() + "\n");
			 }
			 System.out.println("Total number of probes: " + String.valueOf(this.count_probe) + "\n");
			 pw.append("Total number of probes: " + String.valueOf(this.count_probe) + "\n");
		 }
}

   