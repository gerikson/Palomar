
/**
 * Object Stack Class
 *
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.3
 */

public class ObjectStack {
    
    private Object[] item;
    private int top;
    /**
     * Class constructor
     */
    public ObjectStack() {
        item = new Object[1];
        top = -1;
    }
    /**
     * Checks if the stack is empty
     */
    public boolean isEmpty() {
        return top == -1;
    }
    
    /**
     * Clears all of the elements from the stack
     */
    public void clear() {
        item = new Object[1];
        top = -1;
    }
    
    /**
     * Pushes a new element on top of the stack
     */
    public void push(String temp) {
        if (top == item.length-1) {
            resize(2 * item.length);
        }
        item[++top] = temp;
    }
    
    /**
     * resizes the stack
     */
    private void resize(int size) {
            Object[] temp = new Object[size];
        for (int i = 0; i <= top; i++) {
            temp[i] = item[i];
        }
        item = temp;
    }
    
    /**
     * Pops the last element from the end of the stack
     */
    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
       Object temp = item[top];
        item[top--] = null;
        if (top == item.length/4) {
            resize(item.length/2);
        }
        return temp;
    }
    
    /**
     * Extract the top of the stack
     */
    public Object top() {
            if (isEmpty()) {
                System.out.println("Stack Underflow");
                System.exit(1);
            }
            
            return item[top];
    }
    
}
