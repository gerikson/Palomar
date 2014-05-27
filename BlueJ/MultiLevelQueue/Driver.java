import java.io.*;
import java.util.Scanner;

/**
 * Computer Lab: Multi-Level Feedback Queue Simulation
 *   
 * This project simulates an operating system's job scheduling policy 
 * to determine which process will be assigned the CPU when it becomes available  
 * Driver Class
 * 
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.1 - March 23, 2014
 */

public class Driver {

	/**
	 * Main method
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter("results.txt"));
		Scanner inputFile = new Scanner(new File("mfq.txt"));
		MFQ mfq = new MFQ(inputFile, pw);
		mfq.getJobs();	
		mfq.outputHeader();
		mfq.runSimulation();
		mfq.outStats();
		inputFile.close();
		pw.close();
	}

}
