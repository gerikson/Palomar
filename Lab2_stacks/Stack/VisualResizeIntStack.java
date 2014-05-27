// VisualResizeIntStack.java

public class VisualResizeIntStack {
    private int[] item;
    private int top;
    
    public VisualResizeIntStack() {
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
            pushResize(2 * item.length);
        item[++top] = x;
    }
   
    private void pushResize(int size) {
        System.out.println("Count = " + (top+1) + "\tArray Size = " + item.length);
        int[] temp = new int[size];
        for (int i = 0; i <= top; i++)
            temp[i] = item[i];
        item = temp;
        System.out.println("Resizing...\tArray Size = " + item.length + "\n");
    }
    
    private void popResize(int size) {
        System.out.println("Count = " + top + "\tArray Size = " + item.length);
        int[] temp = new int[size];
        for (int i = 0; i <= top; i++)
            temp[i] = item[i];
        item = temp;
        System.out.println("Resizing...\tArray Size = " + item.length + "\n");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        int temp = item[top--];
        if (top == item.length/4)
            popResize(item.length/2);
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
