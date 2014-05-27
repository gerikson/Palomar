// TestObject.Java

import java.io.*;

public class TestObject {
    public static void main(String[] args) {
        int num = 0;
        ObjectQueue q = new ObjectQueue();
        for (int i = 1; i <= 100; i++)
            q.insert("Hello");
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
            ++num;
            if (num % 10 == 0)
                System.out.println();
            }
            
    }
}
