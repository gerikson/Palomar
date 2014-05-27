// DLLNode.java - Node class for doubly linked list class

public class DLLNode {
    private Object info;
    private DLLNode next;
    private DLLNode back;

    // Constructs an empty node.
    public DLLNode() {
        info = null;
        next = null;
        back = null;
    }

    // Constructs a node with an element in the info field.
    public DLLNode (Object o) {
        info = o;
        next = null;
        back = null;
    }    
    
    // Constructs a node with an element in an info field and a reference to a node in the next and back field.
    public DLLNode (Object o, DLLNode p, DLLNode q) {
        info = o;
        next = p;
        back = q;
    }

    // Assigns an element to the info field of the node.
    public void setInfo(Object o) {
        info = o;
    }
    
    // Returns the element in the info field of the node.
    public Object getInfo() {
        return info;
    }
    
    // Sets DLLNode p to the next field of the node.
    public void setNext(DLLNode p) {
        next = p;
    }
    
    // Returns the next field of the node.
    public DLLNode getNext() {
        return next;
    }

    // Sets Node p to the back field of the node.
    public void setBack(DLLNode p) {
        back = p;
    }
    
    // Returns the back field of the node.
    public DLLNode getBack() {
        return back;
    }
}
