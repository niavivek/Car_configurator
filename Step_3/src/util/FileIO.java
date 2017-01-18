/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 3
Due Date : 05/10/2016
Date Submitted :05/10/2016

 */
/**A class which reads the data from an input file and build an automobile model.
 * It also serializes and deserializes an automobile object.
 * This is the second version and it contains custom exceptions to handle a few
 * errors.
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
 * @version 2.0
 */
package util;

/*
 * An input file is created to read the model information according to the user requirements.
 * The input file contains the information about the model name, price, number of option sets,
 *  name of option sets, number of options and their various options with prices.
 * To read the file, a FileIO class was created. 

 */
import java.io.*;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import exception.AutoException;
import exception.AutoExcepEnum;
import model.Automobile;

public class FileIO {

	public FileIO() {

	}

	// method to read the file and store it as an automotive object
	public Automobile readData(String filename, Automobile a1) throws AutoException {
		// create automotive object
		Automobile auto = a1;
		boolean DEBUG = false;
		boolean fixed = false;
		boolean fixed1 = false;
		boolean fixed2 = false;
		boolean fixed3 = false;
		int opSetSize1 = -1;
		try {
			// open the file
			/*
			 * This class reads the input file, tokenizes each line and stores
			 * the values in the instance variables of automobile, OptionSet and
			 * Option classes.
			 */
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file);
			int ctr = 0;// counter for the number of lines
			int optionCtr = 0;// counter for number of option sets
			int optionSetCtr = 0;// counter for number of options for option set
			boolean eof = false;
			// This storing of variables is done without using any buffer as it
			// may require additional memory and time.

			// read the line
			while (!eof) {
				String line = buff.readLine();
				ctr++;
				if (line == null)
					eof = true;
				else {
					if (DEBUG)
						System.out.println(line);
					/*
					 * The lines are read and the number of option sets and
					 * number of options are stored as an int variable and used
					 * as a counter and an index to input the array of option
					 * sets and options.
					 * 
					 */
					// parse the line - get one value and set it in the correct
					// location
					StringTokenizer a = new StringTokenizer(line, ",");
					while (a.hasMoreTokens()) {
						if (ctr == 1) {
							// stores the values from the first line of the file
							// auto = new
							// Automotive(a.nextToken(),Float.parseFloat(a.nextToken()),Integer.parseInt(a.nextToken()));

							auto.setName(a.nextToken());
							// Custom exception - format of model price is not
							// valid
							do {
								try {
									auto.setPrice(Float.parseFloat(a.nextToken()));
									fixed1 = true;
								} catch (NumberFormatException nfe1) {
									throw new AutoException(AutoExcepEnum.ModelPriceFormatNotValid);
								}
							} while (fixed1 == false);
							// custom exception - format of option set size not
							// valid - get a custom value from user using
							// console and
							// pass it to auto object
							/*
							 * The fix method is called till the correct format
							 * is entered. This is done using a boolean in the
							 * try clause. Catch clause fixes the error.
							 * 
							 * Exceptions can be fixed in-line where errors
							 * occur or it can be propagated to the calling
							 * class.
							 * 
							 * The exception in the findNum method is thrown
							 * back to the calling class - main class which
							 * fixes it. The exception of other type are thrown
							 * to the class which calls the readData method.
							 * 
							 * Exceptions can be thrown in 3 ways - using
							 * constructors of AutoException class, using if,
							 * throw and catch and using while loop and catch.
							 * Here constructors as well as while loop was used.
							 * 
							 */
							String setSize = a.nextToken();
							do {
								try {
									opSetSize1 = findNum(setSize);
									fixed = true;

								} catch (AutoException AE1) {
									setSize = (AE1.fix(AE1.getErrorNo()));
								}
							} while (fixed == false);
							auto.buildOptionSet(opSetSize1);
							/*
							 * The total number of option sets is stored as a
							 * variable and used as an index for adding option
							 * set.
							 * 
							 */
							optionSetCtr = opSetSize1;// store size of option

						} else {
							// reads from the second line
							/*
							 * Similarly, the number of options for each option
							 * set is stored as a variable and re-setted once it
							 * reaches zero. The information if optionSet name
							 * or Option name is read will be based on the
							 * counters.
							 */
							if (optionCtr == 0) {
								// reads the option set when the option counter
								// is zero

								String l = a.nextToken();
								// custom exception - option size is empty
								do {
									try {
										int size = Integer.parseInt(a.nextToken());
										// System.out.println(size);
										// System.out.println(auto.opSize());
										auto.setOpSetNameSize(l, size);
										// store the size of options for each
										// option
										// set
										optionCtr = size;
										fixed2 = true;
									} catch (NullPointerException | NoSuchElementException nse1) {
										throw new AutoException(AutoExcepEnum.OptionSizeNotFound);
									}
								} while (fixed2 == false);
								// decrement the option set counter as you read
								optionSetCtr--;
							} else {
								// reads the option when the option counter is
								// not zero
								String l = a.nextToken();
								float price;
								// custom exception - option price is empty
								// and/or option price format is not valid
								do {
									try {
										price = Float.parseFloat(a.nextToken());
										fixed3 = true;
									} catch (NumberFormatException nfe5) {
										throw new AutoException(AutoExcepEnum.OptionPriceFormatNotValid);
									} catch (NullPointerException | NoSuchElementException npe4) {
										throw new AutoException(AutoExcepEnum.OptionPriceNotFound);
									}
								} while (fixed3 == false);
								/*
								 * Changing the option and option set to
								 * arraylist, changes the method in the fileIO
								 * class to set the option and option set values
								 * to a method without using index, which makes
								 * reading the file easier as there is no need
								 * to keep track of index to add the option and
								 * option sets.
								 * 
								 */
								int opSetSize = auto
										.sizeOfOptOfOpset(auto.getOpsetByIndex(opSetSize1 - optionSetCtr - 1));
								auto.setOptOfOpSetNamePrice(auto.getOpsetByIndex(opSetSize1 - optionSetCtr - 1), l,
										price);
								optionCtr--;// decrement option counter
							}
						}
					}
				}
			}
		} catch (IOException f2) {
			System.out.println("Error -- " + f2.toString());
		}

		return auto;

	}

	// method to catch and throw custom exception
	public int findNum(String val) throws AutoException {
		int numOpSets;

		try {
			// if value cannot be parsed throw exception
			numOpSets = Integer.parseInt(val);
		} catch (NumberFormatException e) {
			throw new AutoException(AutoExcepEnum.NumOfOptionSetFormatNotValid);
		}

		return numOpSets;
	}

	// Methods are added to serialize and deserialize the automobile object.
	// method to serialize data
	public void serialData(Automobile auto1) {
		try {
			String filename = auto1.getName() + ".dat";
			// write the serialized file
			ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream(filename));
			// store the contents of automotive
			outfile.writeObject(auto1);
			outfile.close();
		} catch (Exception e) {
			System.out.println("Error - " + e);
		}
	}

	// method to deserialize data
	public Automobile deserialData(String filename) {
		Automobile val;
		try {
			// read contents of automotive
			ObjectInputStream infile = new ObjectInputStream(new FileInputStream(filename));
			val = (Automobile) infile.readObject();
			infile.close();
			return val;
		} catch (Exception e) {
			System.out.println("Error - " + e);
		}

		return null;
	}

	/*
	 * Software evolution is observed - FileIO with about 100 lines increased to
	 * 200+ lines after adding 5 custom exceptions. If all the exceptions were
	 * to be fixed, the lines could exceed 500 lines leading to software
	 * evolution.
	 * 
	 */
}
