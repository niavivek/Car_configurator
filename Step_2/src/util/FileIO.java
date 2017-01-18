/*
 *
Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 2
Due Date : 04/30/2016
Date Submitted :04/30/2016
 */
/**A class which reads the data from an input file and build an automobile model.
 * It also serializes and deserializes an automobile object.
 * This is the second version and it contains custom exceptions to handle a few
 * errors.
 * @author Nia vivek
 * @version 2.0
 */
package util;

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

		try {
			// open the file
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file);
			int ctr = 0;// counter for the number of lines
			int optionCtr = 0;// counter for number of option sets
			int optionSetCtr = 0;// counter for number of options for option set
			boolean eof = false;
			// read the line
			while (!eof) {
				String line = buff.readLine();
				ctr++;
				if (line == null)
					eof = true;
				else {
					if (DEBUG)
						System.out.println(line);

					// parse the line - get one value and set it in the correct
					// location
					StringTokenizer a = new StringTokenizer(line, ",");
					while (a.hasMoreTokens()) {
						if (ctr == 1) {
							// stores the values from the first line of the file
							// auto = new
							// Automotive(a.nextToken(),Float.parseFloat(a.nextToken()),Integer.parseInt(a.nextToken()));

							auto.setName(a.nextToken());
							//Custom exception - format of model price is not valid
							try {
								auto.setPrice(Float.parseFloat(a.nextToken()));
							} 
							catch (NumberFormatException nfe1) {
								throw new AutoException(AutoExcepEnum.ModelPriceFormatNotValid);
							}
							//custom exception - format of option set size not valid 
							//get a custom value from user using console and pass it to auto object
							try {
								auto.buildOptionSet(findNum(a.nextToken()));
							} 
							catch (AutoException AE1) {
								auto.buildOptionSet(Integer.parseInt(AE1.fix(AE1.getErrorNo())));
							}
							optionSetCtr = auto.opSize();// store size of option
							// sets
						} 
						else {
							// reads from the second line
							if (optionCtr == 0) {
								// reads the option set when the option counter
								// is zero

								String l = a.nextToken();
								//custom exception - option size is empty
								try {
									int size = Integer.parseInt(a.nextToken());
									auto.setOpSetNameSizeByIndex(l, (auto.opSize() - optionSetCtr), size);
									// store the size of options for each option
									// set
									optionCtr = size;
								} 
								catch (NullPointerException|NoSuchElementException nse1) {
									throw new AutoException(AutoExcepEnum.OptionSizeNotFound);
								} 
								// decrement the option set counter as you read
								optionSetCtr--;
							} 
							else {
								// reads the option when the option counter is
								// not zero
								String l = a.nextToken();
								float price;
								//custom exception - option price is empty and/or option price format is not valid
								try {
									price = Float.parseFloat(a.nextToken());
								} 
								catch (NumberFormatException nfe5) {
									throw new AutoException(AutoExcepEnum.OptionPriceFormatNotValid);
								} 
								catch (NullPointerException|NoSuchElementException npe4) {
									throw new AutoException(AutoExcepEnum.OptionPriceNotFound);
								} 

								int opSetSize = auto
										.sizeOfOptOfOpset(auto.getOpsetByIndex(auto.opSize() - optionSetCtr - 1));
								auto.setOptOfOpSetNamePriceByIndex(
										auto.getOpsetByIndex(auto.opSize() - optionSetCtr - 1), opSetSize - optionCtr,
										l, price);
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
//method to catch and throw custom exception
	public int findNum(String val) throws AutoException {
		int numOpSets;
		try {
			//if value cannot be parsed throw exception
			numOpSets = Integer.parseInt(val);
		} 
		catch (NumberFormatException e) {
			throw new AutoException(AutoExcepEnum.NumOfOptionSetFormatNotValid);
		}
		return numOpSets;
	}

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
		Automobile val = new Automobile();
		try {
			// read contents of automotive
			ObjectInputStream infile = new ObjectInputStream(new FileInputStream(filename));
			val = (Automobile) infile.readObject();
			infile.close();
		} catch (Exception e) {
			System.out.println("Error - " + e);
		}

		return val;
	}

}
