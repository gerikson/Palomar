// IntStack.java

public class IntStack {
    private int[] item;
    private int top;
    private int size;
    
    public IntStack() {
        size = 100;
        item = new int[size];
        top = -1;
    }

    public IntStack(int max) {
        size = max;
        item = new int[size];
        top = -1;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == item.length-1;
    }
    
    public void clear() {
        top = -1;
    }
    
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            System.exit(1);
        }    
        item[++top] = x;
    }
    
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return item[top--];
    }
        
    public int top() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(1);
        }    
        return item[top];
    }
}
