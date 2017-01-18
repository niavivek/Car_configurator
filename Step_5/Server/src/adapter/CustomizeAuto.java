/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 5
Due Date : 05/31/2016
Date Submitted :06/01/2016

 */
/**
 * 

 */
package adapter;
/*
 * The user never knows about the automobile class. It is encapsulated using interfaces.
 * Interfaces are being used to control access to various functionalities which would otherwise
 * be available to the end-users. This is also encapsulation using interfaces.

API was designed with different packages, interfaces and abstract classes. An internal
 * and external component was designed to separate functions from functionality.

 */
public interface CustomizeAuto {
	// method to get the option choice
		public String getChoice(String modelName, String setName);
		
		// method to get the option choice price
		public float getChoicePrice(String modelName,String setName);
			

		// method to set option choice
		public void setChoice(String modelName,String setName, String optionName);
		
		// method to print option choices and price
		public void printChoiceAndPrice(String modelName);
		public float getPrice(String modelName);

	
}
