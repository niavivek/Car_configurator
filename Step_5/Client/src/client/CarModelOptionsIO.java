/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 5
Due Date : 05/31/2016
Date Submitted :06/01/2016

 */
package client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CarModelOptionsIO {
	// this class serializes the properties file using load method
	public Properties readPropFile(String fileName) {
		Properties prop = new Properties();
		FileInputStream in;
		try {
			in = new FileInputStream(fileName);
			prop.load(in);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // This loads the entire file in memory.
		return prop;
	}

}
