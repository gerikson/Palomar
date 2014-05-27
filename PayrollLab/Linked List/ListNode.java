// ListNode.java

public class ListNode {
    private int info;
    private ListNode next;

    // Default ctor    
    public ListNode() {
        info = 0;
        next = null;
    }
    
    // One-arg ctor
    public ListNode (int i) {
        info = i;
        next = null;
    }
    
    // Two-arg ctor
    public ListNode (int i, ListNode p) {
        info = i;
        next = p;
    }
    
    // Sets info field
    public void setInfo(int i) {
        info = i;
    }
    
    // Returns item in info field
    public int getInfo() {
        return info;
    }
    
    // Sets next field
    public void setNext(ListNode p) {
        next = p;
    }
    
    // Returns item in info field
    public ListNode getNext() {
        return next;
    }
}
