// List.java

public class List {
    private ListNode list;
    
    // Constructs an empty list
    public List() {
        list = null;
    }

    // Returns the first node in the list
    public ListNode getFirstNode() {
        return list;
    }

    // Returns the last node in the list
    public ListNode getLastNode() {
        if (list == null)
            return null;
        ListNode p = list;
        while (p.getNext() != null)
            p = p.getNext();
        return p;
    }

    // Returns the first element in a list
    public int getFirst() {
        if (list == null) {
            System.out.println("Runtime Error: getFirst()");
            System.exit(1);
        }
        return list.getInfo();
    }

    // Returns the last element in a list
    public int getLast() {
        if (list == null) {
            System.out.println("Runtime Error: getLast()");
            System.exit(1);
        }
        ListNode p = list;
        while (p.getNext() != null)
            p = p.getNext();
        return p.getInfo();
    }

    // Adds an item to the front of a list
    public void addFirst(int i) {
        ListNode p = new ListNode(i, list);
        list = p;
    }

    // Adds an item to the front of a list
    public void addFirst(ListNode p) {
        if (p == null) {
            System.out.println("Runtime Error: addFirst()");
            System.exit(1);
        }
        p.setNext(list);
        list = p;
    }

    // Adds an item to the end of the list
    public void addLast(int i) {
        ListNode p = new ListNode(i);        
        if (list == null)
            list = p;
        else {
            ListNode q = list;
            while (q.getNext() != null)
                q = q.getNext();
            q.setNext(p);
        }
    }
	
    // Adds an item to the end of the list
    public void addLast(ListNode p) {
        if (p == null) {
            System.out.println("Runtime Error: addLast()");
            System.exit(1);
        }
        p.setNext(null);
        if (list == null)
            list = p;
        else {
            ListNode q = list;
            while (q.getNext() != null)
                q = q.getNext();
            q.setNext(p);
        }
    }
    
    // Removes the first item from the list
    public int removeFirst() {
        if (list == null) {
            System.out.println("Runtime Error: removeFirst()");
            System.exit(1);
        }
        ListNode p = list;
        list = p.getNext();
        return p.getInfo();
    }

    // Removes the last item from the list
    public int removeLast() {
        if (list == null) {
            System.out.println("Runtime Error: removeLast()");
            System.exit(1);
        }
        ListNode p = list;
        ListNode q = null;
        while (p.getNext() != null) {
            q = p;
            p = p.getNext();
        }
        if (q == null)
            list = null;
        else
            q.setNext(null);
        return p.getInfo();
    }

    // Inserts a node after the node referenced by p
    public void insertAfter(ListNode p, int i) {
        if (list == null || p == null) {
            System.out.println("Runtime Error: insertAfter()");
            System.exit(1);
        }
        ListNode q = new ListNode(i, p.getNext());
        p.setNext(q);
    }

    // Inserts a node after the node referenced by p
    public void insertAfter(ListNode p, ListNode q) {
        if (list == null || p == null || q == null) {
            System.out.println("Runtime Error: insertAfter()");
            System.exit(1);
        }
        q.setNext(p.getNext());
        p.setNext(q);
    }
    
    // Deletes the node after the node referenced by p
     public int deleteAfter(ListNode p) {
        if (list == null || p == null || p.getNext() == null) {
            System.out.println("Runtime Error: deleteAfter()");
            System.exit(1);
        }
        ListNode q = p.getNext();
        p.setNext(q.getNext());
        return q.getInfo();
    }

    // Traverses a list and outputs data from the info fields
    public void traverse() {
        ListNode p = list;
        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getNext();
        }
    }

    // Inserts an item into its correct location within an ordered list
    public void insert(int i) {
        ListNode p = list;
        ListNode q = null;
        while (p != null && p.getInfo() < i) {
            q = p;
            p = p.getNext();
        }
        if (q == null)
            addFirst(i);
        else
            insertAfter(q, i);
    }

    // Inserts an item into its correct location in an ordered list
    public void insert(ListNode r) {
        ListNode p = list;
        ListNode q = null;
        while (p != null && p.getInfo() < r.getInfo()) {
            q = p;
            p = p.getNext();
        }
        if (q == null)
            addFirst(r);
        else 
            insertAfter(q, r);
    }
    
    // Removes the first occurrence of an item in a list
    public int remove(int i) {
        ListNode p = list;
        ListNode q = null;
        while (p != null && p.getInfo() != i) {
            q = p;
            p = p.getNext();
        }
        if (p == null)
            return -1;
        else return q == null ? removeFirst() : deleteAfter(q);
    }

    // Returns true if the item is found in the list
    public boolean contains(int i) {
        ListNode p = list;
        while (p != null && p.getInfo() != i)
            p = p.getNext();
        return p != null;
    }

    // Determines whether or not a list is empty
    public boolean isEmpty() {
        return list == null;
    }

    // Removes all elements from a list
    public void clear() {
        list = null;
    }

    // Returns the number of elements in the list
    public int size() {
        int count = 0;
        ListNode p = list;
        while (p != null) {
            ++count;
            p = p.getNext();
        }
        return count;
    }
    
    // Returns sum of the integers in the list
    public int sumElements() {
        int sum = 0;
        ListNode p = list;
        
        while (p != null) {
            sum += p.getInfo();
            p = p.getNext();
        }
        return sum;
    }

    // Returns a reference to the node with the requested value
    // Returns null otherwise
    public ListNode select(int i) {
        ListNode p = list;
        while (p != null) 
            if (p.getInfo() == i)
                return p;
            else
                p = p.getNext();
        return null;
    }

    // Makes a copy of a list
    public List copyList() {
        ListNode p;
        ListNode q = null;  // to satisfy compiler
        ListNode r = list;
        
        List newList = new List();
        while (r != null) {
            p = new ListNode(r.getInfo(), null);
            if (newList.isEmpty())
                newList.addLast(p);
            else 
                q.setNext(p);
            q = p;
            r = r.getNext();
        }
        return newList;
    }
 
    // Reverses a list
    public void reverse() {
        ListNode p = list;
        ListNode q = null;
        ListNode r;
        
        while (p != null) {
            r = q;
            q = p;
            p = p.getNext();
            q.setNext(r);
        }
        list = q;
    }   
}
