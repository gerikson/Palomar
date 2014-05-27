// MazeDemo.java

import java.io.*;

public class MazeDemo {
    public static void main(String[] args) throws IOException {
        Maze m = new Maze();        
        m.getMaze();
        m.processmaze();
        m.outputPath();
    }
}
