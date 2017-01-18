/*
 *
Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 2
Due Date : 04/30/2016
Date Submitted :04/30/2016
 */
/**A driver class to test the functioning of interfaces and abstract class.
 * This class builds and prints an automobile. It also updates the option set name
 * and price.
 * @author Nia vivek
 * @version 1.0
 */
package driver;

import adapter.*;


public class Step2_driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//instantiate a createauto object
		
		CreateAuto a1 = new BuildAuto();
		
		//build and print the model
		a1.buildAuto("Ford_focus.txt");

		a1.printAuto("Ford Focus Wagon ZTW");
		
		//instantiate an updateauto object
		UpdateAuto a2 = new BuildAuto();
		
		//update the option name and price
		a2.updateOptionSetName("Ford Focus Wagon ZTW", "Transmission", "Tranmission Type");
		a2.updateOptionPrice("Ford Focus Wagon ZTW", "Tranmission Type", "Automatic", (float) 100.0);
		
		//print model again
		a1.printAuto("Ford Focus Wagon ZTW");
		
		/*
		CreateAuto a1 = new BuildAuto();
		
		//build and print the model
		a1.buildAuto("Toyota_Prius.txt");

		a1.printAuto("Toyota Prius Two");
		
		//instantiate an updateauto object
		UpdateAuto a2 = new BuildAuto();
		
		//update the option name and price
		a2.updateOptionSetName("Toyota Prius Two", "Transmission", "Tranmission Type");
		a2.updateOptionPrice("Toyota Prius Two", "Tranmission Type", "Automatic", (float) 100.0);
		
		//print model again
		a1.printAuto("Toyota Prius Two");
		*/
	}

}
