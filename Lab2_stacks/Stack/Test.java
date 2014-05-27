// Test.Java

import java.io.*;

public class Test {
    public static void main(String[] args) {
        VisualResizeIntStack s = new VisualResizeIntStack();

        for (int i = 1; i <= 100; i++)
            s.push(i);
        while (!s.isEmpty())
            s.pop();
    }
}
