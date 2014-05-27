// ResizeIntStack.java

public class ResizeIntStack {
    private int[] item;
    private int top;
    
    public ResizeIntStack() {
        item = new int[1];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == item.length-1;
    }

    public void clear() {
        item = new int[1];
        top = -1;
    }
    
    public void push(int x) {
        if (isFull())
            resize(2 * item.length);
        item[++top] = x;
    }
   
    private void resize(int size) {
        int[] temp = new int[size];
        for (int i = 0; i <= top; i++)
            temp[i] = item[i];
        item = temp;
    }
    
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        int temp = item[top--];
        if (top == item.length/4)
            resize(item.length/2);
        return temp;
    }
        
    public int top() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(1);
        }    
        return item[top];
    }
}
