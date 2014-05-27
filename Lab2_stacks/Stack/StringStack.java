// StringStack.java

public class StringStack {
    private String[] item;
    private int top;
    
    public StringStack() {
        item = new String[1];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == item.length-1;
    }
    
    public void clear() {
        item = new String[1];
        top = -1;
    }
    
    public void push(String s) {
        if (isFull())
            resize(2 * item.length);
        item[++top] = s;
    }
   
    private void resize(int size) {
        String[] temp = new String[size];
        for (int i = 0; i <= top; i++)
            temp[i] = item[i];
        item = temp;
    }
    
    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        String temp = item[top--];
        if (top == item.length/4)
            resize(item.length/2);
        return temp;
    }
        
    public String top() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(1);
        }    
        return item[top];
    }
}
