/**
 * HashNode
 * 
 * Properties: key, data
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.1 - April 9th, 2014
 *
 */
public class HashNode {

	    private String key;
	    private String data;
	    private boolean deleted;
	    
	    public HashNode() {
	      this.key = null;
	      this.data = null;
	      this.deleted = false;
	    }

	    public HashNode(String inKey, String inData) {
	      this.key = inKey;
	      this.data = inData;
	      this.deleted = false;
	    }

	    public String getData() {
	      return data;
	    }

	    public void setData(String data) {
	      this.data = data;
	    }

	    public Object getKey() {
	      return key;
	    }
	    public void setKey(String key) {
	      this.key = key;
	    }

	    public void setDeleted()
	    {
	       deleted = true;
	    }
	    public boolean isDeleted()
	    {
	       return deleted;
	    }
	    
	    
	    /* Equality can be based on key alone because there can't be
	     * 2 nodes with the same key in the table */
	    public boolean equals(Object obj) {
	      if (obj instanceof HashNode) {
	        HashNode node = (HashNode)obj;
	        return this.key.equals(node.getKey());
	      }
	      else {
	        return false;
	      }
	    }

	    public String toString() {
	      return "Key: ["+this.key+"] data: ["+this.data+"]";
	    }
}
