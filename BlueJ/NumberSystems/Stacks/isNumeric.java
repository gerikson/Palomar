
public class isNumeric {
	
	private String numeric;
	
	public isNumeric(String str) {
		numeric = str;
	}

	/**
	 * Method that checks if a string is a numeric character
	 * @param str
	 * @return
	 */
	public boolean isNum()  
	{  
	  try  
	  {  
	    int d = Integer.parseInt(numeric);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}

}
