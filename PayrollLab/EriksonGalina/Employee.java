/**
 * Employee class
 * 
 * Properties: firstName, lastName, gender, tenure, rate and salary
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.1 - April 9th, 2014
 *
 */

public class Employee implements Comparable {
	private String firstName;
	private String lastName;
	private String gender;
	private int tenure;
	private String rate;
	private float salary;
	
	/**
	 * Class constructor
	 * @param tokens
	 */
	public Employee(String[] tokens) {
		this.firstName = tokens[0];
		this.lastName = tokens[1];
		this.gender = tokens[2];
		this.tenure = Integer.parseInt(tokens[3]);
		this.rate = tokens[4];
		this.salary = Float.parseFloat(tokens[5]);
	}
	
	/**
	 * Returns first name
	 * @return
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * Returns the last name
	 * @return
	 */
	public String getLastName(){
		return this.lastName;
	}
	
	/**
	 * Returns the gender
	 * @return
	 */
	public String getGender() {
		return this.gender;
	}
	
	/**
	 * Returns the tenure
	 * @return
	 */
	public int getTenure() {
		return this.tenure;
	}
	
	/**
	 * Returns the rate
	 * @return
	 */
	public String getRate() {
		return this.rate;
	}
	
	/**
	 * Returns the salary
	 * @return
	 */
	public float getSalary(){
		return this.salary;
	}
	
	/**
	 * Sets a new salary
	 * @return
	 */
	public void setSalary(float new_salary){
		this.salary = new_salary;
	}
	
	/**
	 * Compares the last name of two Employee objects
	 */
	public int compareTo (Object o) {
		Employee e = (Employee) o;
		return lastName.compareTo(e.getLastName());
	}
}
