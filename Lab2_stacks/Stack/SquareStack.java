// SquareStack.java

public class SquareStack {
    private Square[] item;
    private int top;
    
    public SquareStack() {
        item = new Square[1];
        top = -1;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == item.length-1;
    }    

    public void clear() {
        item = new Square[1];
        top = -1;
    }
    
    public void push(Square s) {
        if (isFull())
            resize(2 * item.length);
        item[++top] = s;
    }

    private void resize(int size) {
        Square[] temp = new Square[size];
        for (int i = 0; i <= top; i++)
            temp[i] = item[i];
        item = temp;
    }

    public Square pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        Square s = item[top--];
        if (top == item.length/4)
            resize(item.length/2);
        return s;
    }

    public Square top() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(1);
        }    
        return(item[top]);
    }
}

    