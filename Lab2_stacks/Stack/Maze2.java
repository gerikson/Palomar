// Maze2.java

import java.io.*;
import java.util.*;

public class Maze2 {
    private Square move;
    private char[][] maze;
    private OStack s;

    public Maze2() {
        s = new OStack();
        maze = new char[12][12];
    }

    public void getMaze() throws IOException {
        for (int row = 0; row < 12; ++row) {
            maze[row][0]  = '1';
            maze[row][11] = '1';
        }
        for (int col = 0; col < 11; ++col) {
            maze[0][col]  = '1';
            maze[11][col] = '1';
        }
        Scanner fileScan = new Scanner(new File("maze.txt"));
        for (int row = 1; row <= 10; ++row) {
            String line = fileScan.nextLine();
            String delims = "[ ]+";
            String[] tokens = line.split(delims);
            for (int col = 1; col <= 10; ++col)
                maze[row][col] = tokens[col-1].charAt(0);
            }
        fileScan.close();
    }

    // From the square MOVE, all adjacent squares containing a 0 or an E are put on the stack.
    void stackpossibles (Square move) {
        if ((maze[move.getRow()+1][move.getCol()] == '0') ||
            (maze[move.getRow()+1][move.getCol()] == 'E')) {
                Square newMove = new Square(move.getRow()+1, move.getCol());
                s.push(newMove);
        }
        if ((maze[move.getRow()-1][move.getCol()] == '0') ||
            (maze[move.getRow()-1][move.getCol()] == 'E')) {
                Square newMove = new Square(move.getRow()-1, move.getCol());
                s.push(newMove);
        }
        if ((maze[move.getRow()][move.getCol()+1] == '0') ||
          (maze[move.getRow()][move.getCol()+1] == 'E')) {
                Square newMove = new Square(move.getRow(), move.getCol()+1);
                s.push(newMove);
        }
        if ((maze[move.getRow()][move.getCol()-1] == '0') ||
            (maze[move.getRow()][move.getCol()-1] == 'E')) {
                Square newMove = new Square(move.getRow(), move.getCol()-1);
                s.push(newMove);
        }
    }   
    
    // Maze is printed with surrounding 1's.
    public void printmaze () {
        for (int row = 0; row < 12; ++row) {
            for (int col = 0; col < 12; ++col)
                System.out.print(" " + maze[row][col]);
            System.out.println();
        }
        System.out.println();
    }
   
     // Outputs path taken through maze.
    public void outputPath() {
        Square move;
        System.out.println("PATH TAKEN");
        while (!s.isEmpty()) {
            move = (Square) s.pop();
            if (maze[move.getRow()][move.getCol()] == '.')
                System.out.println(move.getRow() + "  " + move.getCol());
        }
    }


    // The maze is printed, and squares are visited until the square
    // with the E is moved into or there are no more squares to try.
    // The maze with the tried path is printed along with 
    // the outcome.
    public void processmaze () {
        Square move = new Square(10, 10);
        boolean freed = maze[move.getRow()][move.getCol()] == 'E';
        boolean trapped = maze[move.getRow()][move.getCol()] == '1';
        maze[move.getRow()][move.getCol()] = '*';
        System.out.println("INITIAL MAZE");
        printmaze();
        while (!trapped && !freed) {
            maze[move.getRow()][move.getCol()] = '.';
            s.push(move);
            stackpossibles(move);
            trapped = s.isEmpty();
            while (!trapped && (maze[move.getRow()][move.getCol()] == '.')) {
                move = (Square) s.pop();
                trapped = s.isEmpty();
            }
            freed = maze[move.getRow()][move.getCol()] == 'E';
        }
        if (freed) {
            maze[move.getRow()][move.getCol()] = '.';
            s.push(move);
        }
        System.out.println("FINAL MAZE");
        printmaze();
        if (freed)
            System.out.println("I AM FREE\n");
        else
            System.out.println("HELP, I AM TRAPPED\n");
    }
}

