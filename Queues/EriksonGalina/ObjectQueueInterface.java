
/**
 * Interface for ObjectQueue Class
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.1 - March 23, 2014
 */
public interface ObjectQueueInterface {
	
	public boolean isEmpty();
	public boolean isFull();
	public void clear();
	public void insert(Object o);
	public Object remove();
	public Object query();
	
}
