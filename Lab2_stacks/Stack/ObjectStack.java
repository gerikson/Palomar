// ObjectStack.java

public class ObjectStack {
    private Object[] item;
    private int top;
    
    public ObjectStack() {
        item = new Object[1];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
    
    public void clear() {
        item = new Object[1];
        top = -1;
    }
    
    public void push(Object o) {
        if (top == item.length-1)
            resize(2 * item.length);
        item[++top] = o;
    }
    
    private void resize(int size) {
        Object[] temp = new Object[size];
        for (int i = 0; i <= top; i++)
            temp[i] = item[i];
        item = temp;
    }
    
    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        Object temp = item[top];
        item[top--] = null;
        if (top == item.length/4)
            resize(item.length/2);
        return temp;
    }
    
    public Object top() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(1);
        }    
        return item[top];
    }
}
