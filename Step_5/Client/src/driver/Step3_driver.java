/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 5
Due Date : 05/31/2016
Date Submitted :06/01/2016

 */
package driver;

/*
 * Driver class to test the implementation of choice and creation of fleet of automobiles.
 * Functionally relevant packages are created to contain the relevant classes.
 * The driver of previous steps have to be run to check if the software is broken. All versions
 * should work to prevent breaking of software due to version update.

 */
import adapter.BuildAuto;
import adapter.CreateAuto;
import adapter.CustomizeAuto;

public class Step3_driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Use interfaces to build, print and select option choices.
		 */
		// instantiate a create and customize auto object

		CreateAuto a1 = new BuildAuto();
		CustomizeAuto a2 = new BuildAuto();
		// build and print the model
		a1.buildAuto("2014 Ford Focus Wagon ZTW", "Ford_focus.txt");
		a1.buildAuto("2008 Toyota Prius Two", "Toyota_Prius.txt");
		a1.buildAuto("2015 Tesla Model S", "Tesla_S.txt");

		a1.printAuto("2014 Ford Focus Wagon ZTW");
		a1.printAuto("2008 Toyota Prius Two");
		a1.printAuto("2015 Tesla Model S");

		// Select options for Ford focus
		a2.setChoice("2014 Ford Focus Wagon ZTW", "Power Moonroof", "Present");
		a2.setChoice("2014 Ford Focus Wagon ZTW", "Color", "French Blue ClearCoat Metallic");
		a2.setChoice("2014 Ford Focus Wagon ZTW", "Power Moonroof", "Not Present");
		a2.setChoice("2014 Ford Focus Wagon ZTW", "Color", "Infra-Red ClearCoat");
		a2.setChoice("2014 Ford Focus Wagon ZTW", "Transmission", "Automatic");
		a2.setChoice("2014 Ford Focus Wagon ZTW", "Brakes/Traction Control", "Standard");
		a2.setChoice("2014 Ford Focus Wagon ZTW", "Side Impact Air Bags", "Present");

		// Select options for Toyota Prius
		a2.setChoice("2008 Toyota Prius Two", "Color", "Grabber Green ClearCoat Metallic");
		a2.setChoice("2008 Toyota Prius Two", "Transmission", "Manual");
		a2.setChoice("2008 Toyota Prius Two", "Brakes/Traction Control", "ABS");
		a2.setChoice("2008 Toyota Prius Two", "Side Impact Air Bags", "Not Present");
		a2.setChoice("2008 Toyota Prius Two", "Power Moonroof", "Present");
		a2.setChoice("2008 Toyota Prius Two", "Driver Assistance Package", "Present");

		// Select options for Tesla Model S
		// Order of selection should not matter to store the correct options
		a2.setChoice("2015 Tesla Model S", "Color", "Cloud 9 White ClearCoat");
		a2.setChoice("2015 Tesla Model S", "Transmission", "Automatic");
		a2.setChoice("2015 Tesla Model S", "Brakes/Traction Control", "Standard");
		a2.setChoice("2015 Tesla Model S", "Side Impact Air Bags", "Present");
		a2.setChoice("2015 Tesla Model S", "Power Moonroof", "Present");
		a2.setChoice("2015 Tesla Model S", "Driver Assistance Package", "Present");
		a2.setChoice("2015 Tesla Model S", "Collision Mitigation package", "Present");
		a2.setChoice("2015 Tesla Model S", "Auto Pilot", "Not Present");

		System.out.println("Total Price and options: ");

		// print the choice and prices using interface
		a2.printChoiceAndPrice("2014 Ford Focus Wagon ZTW");
		a2.printChoiceAndPrice("2008 Toyota Prius Two");
		a2.printChoiceAndPrice("2015 Tesla Model S");
	}

}
