/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 5
Due Date : 05/31/2016
Date Submitted :06/01/2016

 */
/**A class which reads the data from an input file and build an automobile model.
 * It also serializes and deserializes an automobile object.
 * This is the second version and it contains custom exceptions to handle a few
 * errors.
 * 
 * 

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
import java.util.Properties;
import java.util.StringTokenizer;

import exception.AutoException;
import exception.AutoExcepEnum;
import model.Automobile;

public class FileIO {

	public FileIO() {

	}

	// method to read the file and store it as an automotive object
	public Automobile readData(int type, String filename, Automobile a1) throws AutoException {

		switch (type) {
		case 1:
			return readUserFile(filename, a1);
		case 2:
			return readPropFile(filename, a1);
		default:
			return null;
		}
	}

	// method to read engineer friendly file
	public Automobile readData(String filename, Automobile a1) throws AutoException {

		return readUserFile(filename, a1);

	}

	// method to read user friendly property file
	public Automobile readData(Properties prop, Automobile a1) throws AutoException {

		return readPropFile1(prop, a1);

	}

	// method to read engineer friendly file
	public Automobile readUserFile(String filename, Automobile a1) throws AutoException {
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

	// method to read user-friendly file - based on filename
	public Automobile readPropFile(String filename, Automobile a1) {
		Automobile auto = a1;
		Properties props = new Properties(); //
		FileInputStream in;
		try {
			// load the properties file and load it into property object
			in = new FileInputStream(filename);
			props.load(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // This loads the entire file in memory.
			// get the properties of the automobile
		String CarMake = props.getProperty("CarMake"); // this is how you read a
		// property. It is like
		// gettting a value from
		// HashTable.
		// if the file is not empty read more
		if (!CarMake.equals(null)) {
			String CarModel = props.getProperty("CarModel");
			// add the make and model to get the auto name
			auto.setName(CarMake + " " + CarModel);
			String modelPrice = props.getProperty("CarPrice");
			auto.setPrice(Float.parseFloat(modelPrice));
			String optionSet;
			String option;
			String optionPrice;
			// read the option sets and options based on index and character
			// values
			for (int k = 1;; k++) {
				optionSet = props.getProperty("Option" + k);
				// break the loop if no property is read for the index
				if (optionSet == null)
					break;
				auto.setNewOpSetName(optionSet);

				for (int l = 0;; l++) { // character increment
					char val = (char) ('a' + l);
					option = props.getProperty("OptionValue" + k + val);
					// break the loop if no property is read for the index
					if (option == null)
						break;
					auto.setNewOptOfOpSet(auto.findOpSetByName(optionSet), option);
					optionPrice = props.getProperty("OptionPrice" + k + val);
					auto.setOptPriceByIndex(auto.findOpSetByName(optionSet), l, Float.parseFloat(optionPrice));

				}
			}

		}

		return auto;
	}

	// method to read user-friendly file - based on property object
	public Automobile readPropFile1(Properties props, Automobile a1) {
		Automobile auto = a1;
		// get the properties of the automobile
		String CarMake = props.getProperty("CarMake"); // this is how you read a
		// property. It is like
		// gettting a value from
		// HashTable.
		// if the file is not empty read more
		if (!CarMake.equals(null)) {
			String CarModel = props.getProperty("CarModel");
			// add the make and model to get the auto name
			auto.setName(CarMake + " " + CarModel);
			String modelPrice = props.getProperty("CarPrice");
			auto.setPrice(Float.parseFloat(modelPrice));
			String optionSet;
			String option;
			String optionPrice;
			// read the option sets and options based on index and character
			// values
			for (int k = 1;; k++) {
				optionSet = props.getProperty("Option" + k);
				// break the loop if no property is read for the index
				if (optionSet == null)
					break;
				auto.setNewOpSetName(optionSet);

				for (int l = 0;; l++) { // character increment
					char val = (char) ('a' + l);
					option = props.getProperty("OptionValue" + k + val);
					// break the loop if no property is read for the index
					if (option == null)
						break;
					auto.setNewOptOfOpSet(auto.findOpSetByName(optionSet), option);
					optionPrice = props.getProperty("OptionPrice" + k + val);
					auto.setOptPriceByIndex(auto.findOpSetByName(optionSet), l, Float.parseFloat(optionPrice));

				}
			}

		}

		return auto;
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
