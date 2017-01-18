/*
 *
Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 6
Due Date : 06/20/2016
Date Submitted :06/20/2016
 */
package util;
/**A class which reads the data from an input file and build an automobile model.
 * It also serializes and deserializes an automobile object.
 * This is the second version and it contains custom exceptions to handle a few
 * errors.
 * @author Nia vivek
 * @version 2.0

 *  1. An input file is created to read the model information according to the user requirements.
 *  2. The input file contains the information about the model name, price, number of option sets,
 *  name of option sets, number of options and their various options with prices.
 *  3. To read the file, a FileIO class was created. This class reads the input file, tokenizes
 *  each line and stores the values in the instance variables of automobile, OptionSet and Option
 *  classes.
 *  4. This storing of variables is done without using any buffer as it may require additional
 *  memory and time.
 *  5. The lines are read and the number of option sets and number of options are stored as an 
 *  int variable and used as a counter and an index to input the array of option sets and options.
 *  6. The total number of option sets is stored as a variable and used as an index for 
 *  adding option set. Similarly, the number of options for each option set is stored as a variable
 *  and re-setted once it reaches zero. The information if optionSet name or Option name is read
 *  will be based on the counters.
 *  7. Methods are added to serialize and deserialize the automobile object.
 */
import java.io.*;
import java.util.StringTokenizer;

import model.Automobile;

public class FileIO {

	public FileIO() {

	}

	// method to read the file and store it as an automotive object
	public Automobile readData(String filename, Automobile a1) {
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
							auto.setPrice(Float.parseFloat(a.nextToken()));
							auto.buildOptionSet(Integer.parseInt(a.nextToken()));
							optionSetCtr = auto.opSize();// store size of option
															// sets
						} else {
							// reads from the second line
							if (optionCtr == 0) {
								// reads the option set when the option counter
								// is zero
								String l = a.nextToken();
								int size = Integer.parseInt(a.nextToken());
								auto.setOpSetNameSizeByIndex(l, (auto.opSize() - optionSetCtr), size);
								// store the size of options for each option set
								optionCtr = size;
								// decrement the option set counter as you read
								optionSetCtr--;
							} else {
								// reads the option when the option counter is
								// not zero
								String l = a.nextToken();
								float price = Float.parseFloat(a.nextToken());

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
