// Test.Java

import java.io.*;

public class Test {
    public static void main(String[] args) {
        VisualIntQueue q = new VisualIntQueue();

        for (int i = 1; i <= 300; i++)
            q.insert(i);
        while (!q.isEmpty())
            q.remove();
    }
}
