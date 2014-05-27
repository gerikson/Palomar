// VisualIntQueue.java

public class VisualIntQueue {
	private int[] item;
	private int front;
	private int rear;
	private int count;

    public VisualIntQueue() {
        item = new int[1];
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
        item = new int[1];
        front = 0;
        rear  = -1;
        count = 0;
    }
     
    public void insert(int x) {
        if (isFull())
            resize(2 * item.length);
        rear = (rear+1) % item.length;
        item[rear] = x;
        ++count;
    }
    
    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            System.exit(1);
        }
        int temp = item[front];        
        front = (front+1) % item.length;
        --count;
        if (item.length != 1 && count == item.length/4)
            resize(item.length/2);
        return temp;
    }
    
    public int query() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            System.exit(1);
        }
        return item[front];
    }
    
    private void resize(int size) {
        System.out.println("Count = " + count + "\tArray Size = " + item.length);
        int[] temp = new int[size];
        for (int i = 0; i < count; ++i) {
            temp[i] = item[front];
            front = (front+1) % item.length;
        }
        front = 0;
        rear = count-1;
        item = temp;
        System.out.println("Resizing...\tArray Size = " + item.length + "\n");
    }
}

