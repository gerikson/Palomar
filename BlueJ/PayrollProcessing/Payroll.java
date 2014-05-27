import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Class that manages the payroll
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.1 - April 9th, 2014
 */

public class Payroll {

	private Scanner inputFile;
	private PrintWriter pw;
	private ObjectList database;
	private Scanner hireFile;
	private Scanner fireFile;
	/**
	 * Class constructor
	 * @param Input file name
	 * @param output file
	 */
	public Payroll(Scanner input, PrintWriter pw, Scanner hire, Scanner fire) {
		this.inputFile = input;
		this.pw = pw;
		this.database = new ObjectList();
		this.hireFile = hire;
		this.fireFile = fire;
	}

	/**
	 * Method that reads the input file and creates an employee object from each line 
	 */
	public void ReadInputFile() {
		while (inputFile.hasNext()) {
			String buf = inputFile.nextLine();
			String[] tokens = buf.split("\\s+");
			if (tokens.length < 6) {
				System.out.println("Input String smaller then 6");
			} else {
				Employee emp = new Employee(tokens);
				ObjectListNode node = new ObjectListNode(emp);
				UpdateDatabase(node);
			}
		}
	}
	
	/**
	 * Method that inserts employee objectListNode in ObjectList database
	 */
	public void UpdateDatabase(ObjectListNode emp) {
		database.addLast(emp);
	}
	
	/**
	 * Outputs the header
	 */
	public void outputHeader() {
		System.out.println("First Name\tLast Name\tGender\tTenure\tRate\tSalary");
		pw.write("First Name\tLast Name\tGender\tTenure\tRate\tSalary\n");
	}
	
	/**
	 * Prints employee database to file
	 */
	public void printEmployeeData() {
		int count = 0;
        ObjectListNode p = database.getFirstNode();
        while (p != null) {
        		++count;
        		Employee emp = (Employee) p.getInfo();
        		System.out.println(emp.getFirstName() + "\t" + emp.getLastName() + "\t" + emp.getGender() + "\t" + String.valueOf(emp.getTenure()) + "\t" + emp.getRate() + "\t" + String.valueOf(emp.getSalary()));
            pw.write(emp.getFirstName() + "\t" + emp.getLastName() + "\t" + emp.getGender() + "\t" + String.valueOf(emp.getTenure()) + "\t" + emp.getRate() + "\t" + String.valueOf(emp.getSalary()) + "\n");
        		p = p.getNext();
        }
        System.out.println("\nNumber of employees in the database is: " + String.valueOf(count));
        pw.write("\nNumber of employees in the database is: " + String.valueOf(count) + "\n");
	}
	
	/**
	 * Prints sorted database to file
	 */
	public void printSortedData() {
        ObjectListNode p = database.getFirstNode();
        while (p != null) {
        		Employee emp = (Employee) p.getInfo();
        		System.out.println(emp.getFirstName() + "\t" + emp.getLastName() + "\t" + emp.getGender() + "\t" + String.valueOf(emp.getTenure()) + "\t" + emp.getRate() + "\t" + String.valueOf(emp.getSalary()));
            pw.write(emp.getFirstName() + "\t" + emp.getLastName() + "\t" + emp.getGender() + "\t" + String.valueOf(emp.getTenure()) + "\t" + emp.getRate() + "\t" + String.valueOf(emp.getSalary()) + "\n");
        		p = p.getNext();
        }

	}
	
	/**
	 * Prints First and Last name of each employee
	 */
	public void printFirstLast() {
		int count = 0;
		System.out.println("First Name\tLast Name");
		pw.write("First Name\tLast Name\n");
        ObjectListNode p = database.getFirstNode();
        while (p != null) {
        		++count;
        		Employee emp = (Employee) p.getInfo();
        		System.out.println(emp.getFirstName() + "\t" + emp.getLastName());
            pw.write(emp.getFirstName() + "\t" + emp.getLastName() + "\n");
        		p = p.getNext();
        }
        System.out.println("\nNumber of employees in the database is: " + String.valueOf(count));
        pw.write("\nNumber of employees in the database is: " + String.valueOf(count) + "\n");

	}
	/**
	 * Prints the women on the payroll
	 */
	public void printWomen() {
        ObjectListNode p = database.getFirstNode();
        System.out.println("\nFirst name of all the women in the database are: " );
        pw.write("\nFirst name of all the women in the database are: \n");
        while (p != null) {
        		Employee emp = (Employee) p.getInfo();
        		if (emp.getGender().equals("F")) {
        			System.out.println(emp.getFirstName());
        			pw.write(emp.getFirstName()  + "\n");
        		}
        		p = p.getNext();
        }
	}
	
	/**
	 * Returns the first and last name and salary of all weekly employees who make more then 35k and 
	 * who have been with the company for at least 5 years
	 */
	public void weeklySalaryTenure() {
        ObjectListNode p = database.getFirstNode();
        System.out.println("\nFirst and last names and weekly salary of all weekly employees who make more then $35,000 per year and who have been with the company for at least five years: " );
        pw.write("\nFirst and last names and weekly salary of all weekly employees who make more then $35,000 per year and who have been with the company for at least five years: \n" );
        while (p != null) {
        		Employee emp = (Employee) p.getInfo();
        		if (emp.getRate().equals("W") && emp.getTenure() >= 5) {
        			float salary = emp.getSalary() * 52;
        			if (salary >= 35000.0) {
        				System.out.println(emp.getFirstName() + "\t" + emp.getLastName() + "\t" + String.valueOf(emp.getSalary()));
        				pw.write(emp.getFirstName()  + "\t" + emp.getLastName() + "\t" + String.valueOf(emp.getSalary()) + "\n");
        			}
        		}
        		p = p.getNext();
        }
	}
	
	/**
	 * Give $0.75 raise to all hourly employees and make less then 10$ an hour
	 * and 
	 * Give $50.00 raise per week to all employees who are paid on a weekly basis and make less then $350.00 per week 
	 */
	public void giveRaise() {
        ObjectListNode p = database.getFirstNode();
        System.out.println("\nFirst and last names and new salary for employees who have received raises: " );
        pw.write("\nFirst and last names and new salary for employees who have received raises: \n" );
        while (p != null) {
        		Employee emp = (Employee) p.getInfo();
        		if (emp.getRate().equals("W") && emp.getSalary() < 350.00) {
        			float new_salary = (float) (emp.getSalary() + 50.00);
        			emp.setSalary(new_salary);
    				System.out.println(emp.getFirstName() + "\t" + emp.getLastName() + "\t" + String.valueOf(emp.getSalary()));
    				pw.write(emp.getFirstName()  + "\t" + emp.getLastName() + "\t" + String.valueOf(emp.getSalary()) + "\n");
        		}
        		else if (emp.getRate().equals("H") && emp.getSalary() < 10.00) {
        			float new_salary = (float) (emp.getSalary() + 0.75);
        			emp.setSalary(new_salary);
    				System.out.println(emp.getFirstName() + "\t" + emp.getLastName() + "\t" + String.valueOf(emp.getSalary()));
    				pw.write(emp.getFirstName()  + "\t" + emp.getLastName() + "\t" + String.valueOf(emp.getSalary()) + "\n");
        		}
        		p = p.getNext();
        }
	}
	
	/**
	 * Sorts the database by last name
	 */
	public void sortLastName() {
		ObjectList sortedList = new ObjectList();
		ObjectListNode p = database.getFirstNode();
		while (p != null) {
			Employee emp = (Employee) database.removeFirst();
			sortedList.insert(emp);
			p = database.getFirstNode();
		}
		
		database = sortedList.copyList();
        System.out.println("\nSorted database by last name is: " );
        pw.write("\nSorted database by last name is: \n" );
        outputHeader();
        printSortedData();
	}
	
	/**
	 * Inserts new employees in the database
	 */
	public void hire() {
		while (hireFile.hasNext()) {
			String buf = hireFile.nextLine();
			String[] tokens = buf.split("\\s+");
			if (tokens.length < 6) {
				System.out.println("Input String smaller then 6");
			} else {
				Employee emp = new Employee(tokens);
				database.insert(emp);
			}
		}
        System.out.println("\nNew hired employees inserted in the database: " );
        pw.write("\nNew hired employees inserted in the database: \n" );
        printFirstLast();
	}
	
	/**
	 * Removes fired employees
	 */
	public void fire() {
		while (fireFile.hasNext()) {
			String buf = fireFile.nextLine();
			String[] tokens = buf.split("\\s+");
			ObjectListNode p = database.getFirstNode();
			while (p != null) {
				Employee emp = (Employee) p.getInfo();			
				if (emp.getLastName().equalsIgnoreCase(tokens[1])) {
					database.remove(emp);
				}
				p = p.getNext();
			}
		}
        System.out.println("\nFired employees deleted from the database: " );
        pw.write("\nFired employees deleted from the database: \n" );
        printFirstLast();
	}
}
