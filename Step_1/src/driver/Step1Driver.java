/*
 *
Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 1
Due Date : 04/20/2016
Date Submitted :04/20/2016
 */
package driver;

import model.Automotive;
import util.FileIO;

public class Step1Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Initialize instance variables for new Automotive object
		Automotive ford = new Automotive();
		Automotive ford1 = new Automotive();
		Automotive prius = new Automotive();
		Automotive prius1 = new Automotive();
		Automotive tesla = new Automotive();
		Automotive tesla1 = new Automotive();

		// instance variable for FileIO object
		FileIO file1 = new FileIO();

		// store the value of readData method in an automotive object
		ford = file1.readData("Ford_focus.txt", ford);
		prius = file1.readData("Toyota_Prius.txt", prius);
		tesla = file1.readData("Tesla_S.txt", tesla);
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
