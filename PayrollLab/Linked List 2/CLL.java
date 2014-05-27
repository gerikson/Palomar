// CLL.java

public class CLL {
    private ObjectListNode list;
    
    // Constructs an empty circular linked list
    public CLL() {
        list = null;
    }

    // Adds the given element to the beginning of the circular list.
    public void addFirst(Object o) {
        ObjectListNode p = new ObjectListNode(o);
        if (list == null) {
            p.setNext(p);
            list = p;
        }
        else {
            p.setNext(list.getNext());
            list.setNext(p);
        }
    }

    // Appends the given element to the end of the circular list.
    public void addLast(Object o) {
        ObjectListNode p = new ObjectListNode(o);        
        if (list == null)
            p.setNext(p);
        else {
            p.setNext(list.getNext());
            list.setNext(p);
        }
        list = p;
    }

    // Removes and returns the first element from the circular list
    public Object removeFirst() {
        if (list == null) {
            System.out.println("Runtime Error: removeFront()");
            System.exit(1);
        }
        ObjectListNode p = list.getNext();
        if (p == list)
            list = null;
        else
            list.setNext(p.getNext());
        return p.getInfo();
    }

    // Removes and returns the last element from the circular list
    public Object removeLast() {
        if (list == null) {
            System.out.println("Runtime Error: removeLast()");
            System.exit(1);
        }
        ObjectListNode p = list;
	    ObjectListNode q = list;
        while (p.getNext() != list)
            p = p.getNext();
        if (p == list)
            list = null;
        else {
            p.setNext(list.getNext());
            list = p;
        }
        return q.getInfo();
    }
}
