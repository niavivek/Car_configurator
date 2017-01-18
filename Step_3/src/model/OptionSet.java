/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 3
Due Date : 05/10/2016
Date Submitted :05/10/2016

 */
/**A class to contain the various option sets and it's size. 
 * It also has an inner class which handles the options
 * and it's prices. This protected inner class constitutes encapsulation 
 * with class containment. 
 * It also has various getters and setters for option sets and options.
 * This class implements Serializable.
 * 
 * 
DOCUMENTATION
 * VERSION 1.0
 * 1. An Automobile class was created to contain the option sets of each automobile.
 * 2. An OptionSet class was created to keep track of different options.
 * 3. OptionSet class has private variables and protected methods to encapsulate
 * the methods from other packages.
 * 4. Functionally relevant packages are created to contain the relevant classes.
 * 5. Option Set class has an inner protected class named Options - which contains
 * the various options and their prices for each Option set.
 * 6. Option Set has an array of Options as a protected variable to contain the various options
 * of each Option set.
 * 7. Option class has name and price as protected variables and relevant protected getters
 *  and setters for encapsulation.
 *  8. Having option as an inner class of OptionSet enables encapsulation by containment.
 *  9. Automobile class has an array of option sets to contain the various option sets for each
 *  automobile model.
 *  10. Automobile class has various public methods to access the instance variables as well as
 *  the protected methods of OptionSet and Option.
 *  11. StringBuffer was used to concatenate the various string to convert the options and
 *  option sets to string. This is because strings are immutable and waste lot of memory compared
 *  to StringBuffers.
 *  12. Various combinations of constructors and methods were created in automobile and OptionSet
 *  class for various CRUD (Create, Read, Update and Delete) operations for each variable and combination
 *  of variables as well as print operations.
 *  13. An input file is created to read the model information according to the user requirements.
 *  14. The input file contains the information about the model name, price, number of option sets,
 *  name of option sets, number of options and their various options with prices.
 *  15. To read the file, a FileIO class was created. This class reads the input file, tokenizes
 *  each line and stores the values in the instance variables of automobile, OptionSet and Option
 *  classes.
 *  16. This storing of variables is done without using any buffer as it may require additional
 *  memory and time.
 *  17. The lines are read and the number of option sets and number of options are stored as an 
 *  int variable and used as a counter and an index to input the array of option sets and options.
 *  18. The total number of option sets is stored as a variable and used as an index for 
 *  adding option set. Similarly, the number of options for each option set is stored as a variable
 *  and re-setted once it reaches zero. The information if optionSet name or Option name is read
 *  will be based on the counters.
 *  18. Methods are added to serialize and deserialize the automobile object.
 * 
 * VERSION 2.0
 * 1. API was designed with different packages, interfaces and abstract classes. An internal
 * and external component was designed to separate functions from functionality.
 * 2. Interfaces are being used to control access to various functionalities which would otherwise
 * be available to the end-users. This is also encapsulation using interfaces.
 * 3. BuildAuto class is written as empty class without any functionality for security. If the classes
 * were back-engineered, having BuildAuto class as empty will prevent access to functionalities
 * as the methods are defined in a proxy class.
 * 4. Delegating functionality to a proxyAutomobile class from BuildAuto is called value proposition
 * design pattern in OOP.
 * 5. The delegating proxy class is made abstract  to provide artificial security. If the classes
 * were back-engineered, having an abstract class will prevent instantiation of the class preventing
 * hacking or access to functionalities.
 * 6. The static variable in proxyAutomobile integrates functionality from across all existing classes
 * to create, print, update and delete autos.
 * 7. Making the auto variable as static in proxyAutomobile creates a singleton, where a single object
 * is used to integrate the functionality.
 * 8. BuildAuto bridges proxyAutomobile and interfaces.
 * 9. ProxyAutomobile bridges internal components to build the API.
 * 10. All the healing is centralized in one place using custom exception's class.
 * 11. Exceptions can be fixed in-line where errors occur or it can be propagated to the calling class.
 * 12. Exceptions are logged with a timestamp, error number and error messages.
 * 13. Software evolution is observed - FileIO with about 100 lines increased to 200+ lines
 * after adding 5 custom exceptions. If all the exceptions were to be fixed, the lines could
 * exceed 500 lines leading to software evolution.
 * 14. Exceptions can be thrown in 3 ways - using constructors of AutoException class,
 * using if, throw and catch and using while loop and catch.
 * 15. Making FixErrors an API would allow users to call fix methods based on the error number.
 * This is also helpful for software testers.
 * 16. The user never knows about the automobile class. It is encapsulated using interfaces.
 * 17. Machine learning is implemented using custom exceptions where exceptions are fixed by 
 * learning about the different exceptions that can occur.
 * 18. Functionally relevant packages are created to contain the relevant classes.
 * 
 * VERSION 3.0
 * 1. A fleet of automobiles can be modeled using LinkedHashMap.
 * 2. LinkedHashMap takes up the memory space of Linked List and Hash Map.
 * 3. Variable called choice in OptionSet saves the option for each option set.
 * 4. ArrayList called choices in Automobile saves an arraylist of options for the auto model.
 * 5. The option choice selected is reflected in arraylist choice, so the total
 *  price can be calculated using the choice arraylist.
 * 6. Option class is changed to a regular class from inner class. This is because inner class
 *  leads to spaghetti code and there is a requirement for option to be imported or become a
 *  regular class to be accessible in automobile class.
 * 7. Choice and ArrayList choice helps in saving the customer's preferences for a model
 * and helps in calculating the model price with the selected options.
 * 8. Changing the option sets and option array's to arraylist makes it more efficient
 * and allows to add elements to the arraylist without keeping track of indexes.
 * 9. In addition, the size of arraylist can be changed dynamically as opposed to arrays.
 * 10. Changing the option and option set to arraylist, changes the method in the fileIO
 * class to set the option and option set values to a method without using index, which makes
 * reading the file easier as there is no need to keep track of index to add the option
 * and option sets.
 * 11. Addition methods were added in the automobile and option set class to handle the arraylist
 * (arrays used indices) and also the current methods were changed to reflect the usage of arraylist.
 * 12. Methods in CreateAuto interface were changed to reflect the usage of LinkedHashMap
 * for storing auto.
 * 13. Method implementation in the proxyautomobile were changed to reflect the usage of 
 * LinkedHashMap to store auto model.
 * 14. BuildAuto is made final to prevent extending of the class.
 * 15. The use of templates enable any type of vehicle to be modeled using this program.
 * 16. To develop templates, automobile was declared abstract and the linkedhashMap object of autos
 * is a variable in a fleet class which acts as a template.
 * 17. Fleet class has a LinkedHashMap of a fleet of autos which enables instantiation of 
 * more than 1 auto object.
 * 18. Create, read, delete and update methods are added in the fleet class to enable building/reading/
 *deleting/updating  of auto objects.
 * 19. Proxyautomobile contains a fleet object which is static to coordinate the different
 * functionalities of different interfaces.
 * 20. Functionally relevant packages are created to contain the relevant classes.
 * 21. The driver of previous steps have to be run to check if the software is broken. All versions
 * should work to prevent breaking of software due to version update.

 * @author Nia vivek
 * @version 1.0
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/*An OptionSet class was created to keep track of different options.
 *OptionSet class has private variables and protected methods to encapsulate
 * the methods from other packages.
 *Option Set class has an inner protected class named Options - which contains
 * the various options and their prices for each Option set.

 * Option was a protected inner class in the first version. This was done to encapsulate
 * the option and its method from other classes. This was encapsulation with containment.
 */
public class OptionSet implements Serializable {
	// This class contains an array of options for each option set
	// private variables for encapsulation
	private ArrayList<Option> opt;
	/*
	 * Array of options from Version 1.0, is changed to Arraylist in Version
	 * 3.0. Changing the option array's to arraylist makes it more efficient and
	 * allows to add elements to the arraylist with keeping track of indices. In
	 * addition, the size of arraylist can be changed dynamically as opposed to
	 * arrays.
	 */
	private String name;
	// Variable called choice in OptionSet saves the user selected option for
	// each option set.
	private Option choice;

	/*
	 * Various combinations of constructors and methods were created in
	 * OptionSet class for various CRUD (Create, Read, Update and Delete)
	 * operations for each variable and combination of variables as well as
	 * print operations.
	 * 
	 */
	// different combinations of constructors
	protected OptionSet() {
	}

	protected OptionSet(int size) {
		opt = new ArrayList<Option>(size);

	}

	protected OptionSet(String name1) {
		name = name1;
	}

	protected OptionSet(String name1, int size) {
		name = name1;
		opt = new ArrayList<Option>(size);

	}

	// get name of option set
	protected String getName() {
		return name;
	}

	// get options
	protected ArrayList<Option> getOpt() {
		return opt;
	}

	// find option by name
	protected Option findOptByName(String name1) {
		for (int i = 0; i < opt.size(); i++) {
			if (opt.get(i).getName().equals(name1)) {
				return opt.get(i);
			}
		}
		return null;

	}

	// find option by index
	protected Option findOptByIndex(int index) {
		return opt.get(index);

	}

	// get option if option name contains
	protected Option OptNameContains(String val) {

		for (int i = 0; i < opt.size(); i++) {
			if (opt.get(i).getName().contains(val)) {
				return opt.get(i);
			}
		}
		return null;
	}

	// get option if option name starts with
	protected Option OptNameStartsWith(String pre) {

		for (int i = 0; i < opt.size(); i++) {
			if (opt.get(i).getName().startsWith(pre)) {
				return opt.get(i);
			}
		}
		return null;
	}

	// get size of options
	protected int size() {
		return opt.size();
	}

	// check if option is empty
	protected boolean isEmpty() {
		return opt.isEmpty();
	}

	// CREATE OPERATIONS
	// set option size
	protected void setOptSize(int size) {
		// opt = null;
		opt = new ArrayList<Option>(size);

	}

	// set options
	protected void setOpt(ArrayList<Option> opt) {
		this.opt = opt;
	}

	// set option name
	protected void setName(String name1) {
		this.name = name1;
	}

	// set option price by name
	protected void setOptPriceByName(String name1, float price) {
		for (int i = 0; i < opt.size(); i++) {
			if (opt.get(i).getName().equals(name1)) {
				opt.get(i).setPrice(price);
			}
		}

	}

	// UPDATE OPERATIONS
	// update option name by old name
	protected void updateOptNameByName(String name1, String newName1) {
		for (int i = 0; i < opt.size(); i++) {
			if (opt.get(i).getName().equals(name1)) {
				opt.get(i).setName(newName1);
			}
		}
	}

	// set option name by index
	protected void setOptNameByIndex(int index, String name1) {
		opt.get(index).setName(name1);
	}

	/*
	 * Addition methods like below without using index were added in the option
	 * set class to handle the arraylist (arrays used indices) and also the
	 * current methods were changed to reflect the usage of arraylist like
	 * adding get(i) to get an option
	 * 
	 */
	// set option name
	protected void setOptName(String name1) {
		opt.add(new Option(name1));
	}

	// set option price by index
	protected void setOptPriceByIndex(int index, float price) {
		opt.get(index).setPrice(price);
	}

	// get option name
	protected String getOptName(Option optionVal) {
		return optionVal.getName();
	}

	// get option price
	protected float getOptPrice(Option optionVal) {
		return optionVal.getPrice();
	}

	// set option name and price by index
	protected void setOptNamePriceByIndex(int index, String name1, float price) {
		opt.get(index).setName(name1);
		opt.get(index).setPrice(price);
	}

	// set option name and price
	protected void setOptNamePrice(String name1, float price) {
		opt.add(new Option(name1, price));
	}

	// set price if option name contains
	protected boolean setPriceOptNameContains(String val, float price) {
		boolean found = false;
		for (int i = 0; i < opt.size(); i++) {
			if (opt.get(i).getName().contains(val)) {
				found = true;
				opt.get(i).setPrice(price);
			}
		}
		return found;
	}

	// set price if option name starts with
	protected boolean setPriceOptNameStartsWith(String pre, float price) {
		boolean found = false;
		for (int i = 0; i < opt.size(); i++) {
			if (opt.get(i).getName().startsWith(pre)) {
				found = true;
				opt.get(i).setPrice(price);
			}
		}
		return found;
	}

	// DELETE OPERATIONS
	// delete option by name
	protected boolean deleteOptByName(String name1) {
		boolean found = false;
		for (int i = 0; i < opt.size(); i++) {
			if (opt.get(i).getName().equals(name1)) {
				found = true;
				opt.remove(i);
			}
		}
		return found;
	}

	// delete option by index
	protected boolean deleteOptByIndex(int index) {
		boolean found = false;
		if (opt.get(index) != null) {
			opt.remove(index);
			found = true;
		}
		return found;
	}

	// clear all options
	protected boolean clearOptions() {
		boolean found = false;
		if (opt != null) {
			found = true;
			opt.clear();
		}
		return found;
	}

	// PRINT OPERATIONS
	// convert options to string
	/*
	 * StringBuffer was used to concatenate the various string to convert the
	 * options and option sets to string. This is because strings are immutable
	 * and waste lot of memory compared to StringBuffers.
	 * 
	 */
	protected StringBuffer[] toStringOpt() {
		StringBuffer[] stringToPrint = new StringBuffer[opt.size()];
		for (int i = 0; i < opt.size(); i++) {
			if (opt.get(i) != null) {
				stringToPrint[i] = new StringBuffer("Option Name is " + opt.get(i).getName());
				stringToPrint[i].append(" Price " + opt.get(i).getPrice());
			} else
				stringToPrint[i] = new StringBuffer("No Value");

		}
		return stringToPrint;
	}

	// print the options
	protected void printOption() {
		StringBuffer stringToPrint = new StringBuffer();
		stringToPrint = new StringBuffer(getName());
		System.out.printf("\n%-50s%s", stringToPrint, "Price");
		for (int i = 0; i < opt.size(); i++) {
			if (opt.get(i) != null) {
				StringBuffer stringToPrint1 = new StringBuffer(opt.get(i).getName());
				StringBuffer stringToPrint2 = new StringBuffer("" + opt.get(i).getPrice());
				System.out.printf("\n%-50s%s", stringToPrint1, stringToPrint2);
			} else
				System.out.println("No Value");

		}
		System.out.println();

	}

	// method to get the selected option
	protected Option getOptionChoice() {
		return choice;
	}

	// method to set the option choice
	protected void setOptionChoice(String optionName) {
		choice = findOptByName(optionName);
		// System.out.println(choice.getName());
	}

}
