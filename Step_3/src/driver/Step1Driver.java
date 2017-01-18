/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 3
Due Date : 05/10/2016
Date Submitted :05/10/2016

 */
package driver;
/*
 * Driver class to test the implementation of creation of auto object.
 * Functionally relevant packages are created to contain the relevant classes.
 * The driver of previous steps have to be run to check if the software is broken. All versions
 * should work to prevent breaking of software due to version update.

 */
import exception.AutoException;
import model.Automobile;

import model.Car;
import util.FileIO;

public class Step1Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Initialize instance variables for new Automotive object
		Automobile ford = new Car();
		Automobile ford1 = new Car();
		Automobile prius = new Car();
		Automobile prius1 = new Car();
		Automobile tesla = new Car();
		Automobile tesla1 = new Car();

		// instance variable for FileIO object
		FileIO file1 = new FileIO();

		// store the value of readData method in an automotive object
		try
		{
		ford = file1.readData("Ford_focus.txt", ford);
		prius = file1.readData("Toyota_Prius.txt", prius);
		tesla = file1.readData("Tesla_S.txt", tesla);
		}
		 catch (AutoException AE) {
			System.out.println(AE.fix(AE.getErrorNo()));
		}
		// serialize data
		file1.serialData(ford);
		file1.serialData(prius);
		file1.serialData(tesla);
		// deserialize data
		ford1 = file1.deserialData(ford.getName() + ".dat");
		prius1 = file1.deserialData(prius.getName() + ".dat");
		tesla1 = file1.deserialData(tesla.getName() + ".dat");
		// print the values
		ford1.printAll();
		System.out.println("\n\n");
		prius1.printAll();
		System.out.println("\n\n");
		tesla1.printAll();

	}

}
