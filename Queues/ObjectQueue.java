// ObjectQueue.java

public class ObjectQueue {
	private Object[] item;
	private int front;
	private int rear;
	private int count;

    public ObjectQueue() {
        item = new Object[1];
        front = 0;
        rear  = -1;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == item.length;
    }
    
    public void clear() {
        item = new Object[1];
        front = 0;
        rear  = -1;
        count = 0;
    }
     
    public void insert(Object o) {
        if (isFull())
            resize(2 * item.length);
        rear = (rear+1) % item.length;
        item[rear] = o;
        ++count;
    }
    
    public Object remove() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
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
    
    public Object query() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            System.exit(1);
        }
        return item[front];
    }
    
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
