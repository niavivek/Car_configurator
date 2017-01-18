/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 5
Due Date : 05/31/2016
Date Submitted :06/01/2016

 */
/**
 * 
 * 

 * @author Nia vivek
 * @version 1.0
 */
package exception;
/*
 * A helper class to delegate fixes for each exception.
 * This is to handle exception in the util package. The current
 * version gets an input from the user to fix the number of option sets format exception.
 */
import java.util.Scanner;

public class Fix1to100 {

	Fix1to100() {

	}
//methods to fix the errors
	public String fix1() {
		//gets an input from user for the error and returns it
		System.out.println("Enter the number of option sets ");
		Scanner in = new Scanner(System.in);
		String num = in.next();
		return num;
	}
	public String fix2() {
		
		return "Fix not implemented";
	}
	public String fix3() {
		return "Fix not implemented";
	}
	public String fix4() {
		return "Fix not implemented";
	}
	public String fix5() {
		return "Fix not implemented";
	}
}
