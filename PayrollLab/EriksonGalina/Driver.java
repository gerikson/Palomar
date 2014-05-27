import java.io.*;
import java.util.Scanner;

/**
 * Computer Lab: Payroll Processing
 * 
 * Program that retrieves, updates and manipulates a small payroll database
 * 
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.1 - April 9th, 2014
 */

public class Driver {

	/**
	 * Main method
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
		Scanner inputFile = new Scanner(new File("payfile.txt"));
		Scanner hireFile = new Scanner(new File("hirefile.txt"));
		Scanner fireFile = new Scanner(new File("firefile.txt"));
		Payroll payroll = new Payroll(inputFile, pw, hireFile, fireFile);
		payroll.ReadInputFile();
		payroll.outputHeader();
		payroll.printEmployeeData();
		payroll.printWomen();
		payroll.weeklySalaryTenure();
		payroll.giveRaise();
		payroll.sortLastName();
		payroll.hire();
		payroll.fire();
		inputFile.close();
		pw.close();
	}

}
