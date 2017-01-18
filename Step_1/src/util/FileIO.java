/*
 *
Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 1
Due Date : 04/20/2016
Date Submitted :04/20/2016
 */
package util;

import java.io.*;
import java.util.StringTokenizer;

import model.Automotive;

public class FileIO {

	public FileIO() {

	}

	// method to read the file and store it as an automotive object
	public Automotive readData(String filename, Automotive a1) {
		// create automotive object
		Automotive auto = a1;
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
	public void serialData(Automotive auto1) {
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
	public Automotive deserialData(String filename) {
		Automotive val = new Automotive();
		try {
			// read contents of automotive
			ObjectInputStream infile = new ObjectInputStream(new FileInputStream(filename));
			val = (Automotive) infile.readObject();
			infile.close();
		} catch (Exception e) {
			System.out.println("Error - " + e);
		}

		return val;
	}

}
