import java.util.Scanner;

public class Palomar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter two numbers: ");
		int num1 = keyboard.nextInt();
		int num2 = keyboard.nextInt();
		//White space
		System.out.println("The sum of " + num1 + " and " +num2 + " is " + (num1+num2));
		System.out.println("The sum of " + num1 + " and " +num2 + " is " + num1+num2);

	}

}
