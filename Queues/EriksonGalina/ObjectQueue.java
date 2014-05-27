/**
 * ObjectQueue class
 *
 */

public class ObjectQueue {
	private Object[] item;
	private int front;
	private int rear;
	private int count;

	/**
	 * Class constructor
	 */
    public ObjectQueue() {
        item = new Object[1];
        front = 0;
        rear  = -1;
        count = 0;
    }

    /**
     * verifies if the queue has any elements
     * @return true if queue is empty
     */
    public boolean isEmpty() {
        return count == 0;
    }
    
    /**
     * checks if the queue is full
     * @return true if queue is full
     */
    public boolean isFull() {
        return count == item.length;
    }
    
    /**
     * Clears all of the elements from the queue
     */
    public void clear() {
        item = new Object[1];
        front = 0;
        rear  = -1;
        count = 0;
    }
     
    /**
     * Inserts a new object in the queue
     * @param Object
     */
    public void insert(Object o) {
        if (isFull())
            resize(2 * item.length);
        rear = (rear+1) % item.length;
        item[rear] = o;
        ++count;
    }
    
    /**
     * Removes one element from the front of the queue
     * @return the object removed
     */
    public Object remove() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            new Exception("Remove Runtime error: Queue Underflow").printStackTrace();
            System.exit(1);
        }
        Object temp = item[front];
        item[front] = null;
        front = (front+1) % item.length;
        --count;
        if (item.length != 1 && count == item.length/4)
            resize(item.length/2);
        return temp;
    }
    
    /**
     * Queries the queue without removing the element
     * @return the first element of the queue
     */
    public Object query() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            new Exception("Remove Runtime error: Queue Underflow").printStackTrace();
            System.exit(1);
        }
        return item[front];
    }
    
    /**
     * Resizes the queue
     * @param size 
     */
    private void resize(int size) {
        Object[] temp = new Object[size];
        for (int i = 0; i < count; ++i) {
            temp[i] = item[front];
            front = (front+1) % item.length;
        }
        front = 0;
        rear = count-1;
        item = temp;
    }
}
