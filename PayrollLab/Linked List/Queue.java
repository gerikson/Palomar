// Queue.java - Queue represented as a circular linked list.

public class Queue {
    private ObjectListNode queue;
    
    // Constructs an empty queue
    public Queue() {
        queue = null;
    }

   // Inserts an item into a queue represented by a circular list.
    public void insert(Object o) {
        ObjectListNode p = new ObjectListNode(o);
        if (queue == null)
            p.setNext(p);
        else {
            p.setNext(queue.getNext());
            queue.setNext(p);
        }
        queue = p;
    }

    // Removes an item from a queue represented by a circular list.
    public Object remove() {
        if (queue == null) {
            System.out.println("Runtime Error: Queue Underflow.");
            System.exit(1);
        }
        ObjectListNode p = queue.getNext();
        if (p == queue)
            queue = null;
        else
            queue.setNext(p.getNext());
        return p.getInfo();
    }
}
