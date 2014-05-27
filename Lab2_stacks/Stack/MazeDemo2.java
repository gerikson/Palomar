// MazeDemo2.java

import java.io.*;

public class MazeDemo2 {
    public static void main(String[] args) throws IOException {
        Maze2 m = new Maze2();        
        m.getMaze();
        m.processmaze();
        m.outputPath();
    }
}
