// TestList.java

public class TestList {
    public static void main() {
        List list = new List();
        
        System.out.println(list.isEmpty());
        
        for (int i = 1; i <= 5; i++) 
            list.addLast(i);
        list.traverse();
        System.out.println();
        
        list.addFirst(100);
        list.addLast(200);
        list.traverse();
        System.out.println();
        
        list.removeFirst();
        list.removeLast();
        list.traverse();
        System.out.println();
        
        System.out.println(list.size());
        System.out.println();

        list.addLast(500);
        list.addLast(25);
        list.traverse();
        System.out.println();
        
        list.remove(3);
        list.traverse();
        System.out.println();

        System.out.println(list.sumElements());
        System.out.println();
        
        List newList = list.copyList();
        list.traverse();        
        System.out.println();
        newList.traverse();
        System.out.println();
        
        ListNode p = list.select(5);
        list.deleteAfter(p);
        list.traverse();
        System.out.println();
        
        ListNode r = list.select(5);
        list.insertAfter(r, 100);
        list.traverse();
        System.out.println();
    }    
}   
