/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 5
Due Date : 05/31/2016
Date Submitted :06/01/2016

 */
package server;

import java.util.ArrayList;
import java.util.Properties;

import model.Automobile;

//Interface to create the auto from the properties object passed from the client side,
//get an arraylist of all models and to gets the auto object to pass to the client.
//These methods are implemented in the proxyautomobile class.
//It also has methods to start and terminate the server
public interface AutoServer {

	public boolean createAutoObjectProp(Properties prop);
	public ArrayList<String> getAllAutos();
	public Automobile getAuto(String modelName);
}
