/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 5
Due Date : 05/31/2016
Date Submitted :06/01/2016

 */
/**An abstract class which implements the methods from interfaces - CreateAuto, FixAuto and UpdateAuto
 * It acts as a proxy for BuildAuto class. It calls the various methods from automobile class
 * to implement it's own methods.
 * It has methods to build an auto, print the contents of auto model, fix errors during runtime
 * and update various aspects of the auto model. It uses various method from automobile class 
 * and AutoException class to accomplish this.
 * 

 * @author Nia vivek
 * @version 1.0
 */
package adapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Properties;

import exception.AutoException;
import model.*;
import scale.EditOptions;
import server.AutoServer;
import server.BuildCarModelOptions;

/*
 * The delegating proxy class is made abstract  to provide artificial security. If the classes
 * were back-engineered, having an abstract class will prevent instantiation of the class preventing
 * hacking or access to functionalities.

ProxyAutomobile bridges internal components to build the API.
 */
public abstract class ProxyAutomobile {

	/*
	 * In version 1.0 and 2.0, Making the auto variable as static in
	 * proxyAutomobile creates a singleton, where a single object is used to
	 * integrate the functionality. This is converted to a fleet in Version 3.0.
	 * 
	 * Proxyautomobile contains a static fleet object which is static to
	 * coordinate the different //functionalities of different interfaces.
	 */
	private static Fleet<Car> fleet1 = new Fleet<>();
	EditOptions edit1;

	/*
	 * Method implementation in the proxyautomobile were changed to reflect the
	 * usage of LinkedHashMap to store auto model.
	 */
	// Implementation of the various interface methods used by BuildAuto empty
	// class
	public void buildAuto(String modelName, String fileName) {

		fleet1.createFleetAuto(modelName, fileName, new Car());
	}
	public void buildAuto(int type,String modelName, String fileName) {
		
		fleet1.createFleetAuto(type,modelName, fileName, new Car());
	}

	// method to print auto- calls method from automotive class
	public void printAuto(String modelName) {
		if (fleet1.readFleetAuto(modelName) != null)
			fleet1.readFleetAuto(modelName).printAll();
	}

	// methods to update auto- calls methods from automotive class
	public void updateOptionSetName(String modelName, String optionSetName, String newName) {
		if (fleet1.readFleetAuto(modelName) != null) {
			fleet1.readFleetAuto(modelName).updateOpSetNameByName(optionSetName, newName);
		}
	}

	// method to update the option price of an option set
	public void updateOptionPrice(String modelName, String optionSetName, String Option, float newPrice) {

		Automobile auto = fleet1.readFleetAuto(modelName);
		if (auto != null) {
			auto.updateOptOfOpSetPriceByName(auto.findOpSetByName(optionSetName), Option, newPrice);

		}

	}

	// method to set the choices
	public void setChoice(String modelName, String setName, String optionName) {
		if (fleet1.readFleetAuto(modelName) != null) {
			fleet1.readFleetAuto(modelName).setOptionChoice(setName, optionName);

		}
	}

	// method to get the choice names
	public String getChoice(String modelName, String setName) {
		if (fleet1.readFleetAuto(modelName) != null) {
			fleet1.readFleetAuto(modelName).getOptionChoice(setName);

		}
		return "No Choice";
	}

	// method to get the total price of the model with selected options
	public float getPrice(String modelName) {
		if (fleet1.readFleetAuto(modelName) != null) {
			return fleet1.readFleetAuto(modelName).getTotalPrice();

		}
		return (float) 0.0;
	}

	// method to fix errors - calls method from autoexception class
	public void fixErrors(int errorNum) {
		AutoException autoExcep1 = new AutoException();
		autoExcep1.fix(errorNum);
	}

	// method to get the option choice price
	public float getChoicePrice(String modelName, String setName) {
		if (fleet1.readFleetAuto(modelName) != null) {
			return fleet1.readFleetAuto(modelName).getOptionChoicePrice(setName);

		}
		return (float) 0.0;
	}

	// method to print the choices and it's prices
	public void printChoiceAndPrice(String modelName) {
		if (fleet1.readFleetAuto(modelName) != null)
			fleet1.readFleetAuto(modelName).printChoiceAndPrice();
	}

	// method to update option set name by index
	public synchronized void updateOptionSetNameByIndex(String modelName, int index, String newName) {

		if (fleet1.readFleetAuto(modelName) != null) {
			fleet1.readFleetAuto(modelName).setOpSetNameByIndex(newName, index);
		}

	}

	/*
	 * ProxyAutomobile is the class which actually implements the EditThread
	 * interface to enable encapsulation. The below 2 methods of the interface,
	 * instantiates an EditOptions object and passes the parameters required to
	 * make the appropriate changes along with a thread number.
	 * 
	 */
	// methods to update option set name using thread, calls edit option's
	// method
	// to implement threads which in-turn calls method from proxyautomobile
	public void updateOptionSetNameThread(int x, int index, String[] args) {
		edit1 = new EditOptions(x, index, args);
	}

	// method to update the option price of an option set using thread, calls
	// edit option's method
	// to implement threads which in-turn calls method from proxyautomobile
	public void updateOptionPriceThread(int x, String[] args, float newPrice) {
		edit1 = new EditOptions(x, args, newPrice);
	}

	// A method was added to get the fleet object which acts as an object lock
	// for synchronization
	public static Fleet<Car> getFleet() {
		return fleet1;
	}

	// method to create automobile from properties object, this is exposed using
	// AutoServer interface
	public boolean createAutoObjectProp(Properties props) {
		fleet1.createFleetAuto(props, new Car(), 2);
		String modelName = props.getProperty("CarMake")+" "+props.getProperty("CarModel");
		if(fleet1.readFleetAuto(modelName) != null)
			return true;
		else
			return false;

	}

	// method to get an arraylist of all models in the linkedhashmap
	public ArrayList<String> getAllAutos() {
		return fleet1.getFleet();
	}

	// method to get an automobile object from model name
	public Automobile getAuto(String modelName) {
		return fleet1.readFleetAuto(modelName);
	}

}
