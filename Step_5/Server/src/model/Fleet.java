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
package model;

import java.util.ArrayList;
/*
 * This class is used to contain a fleet of automobiles using LinkedHashMap.
 * LinkedHashMap takes up the memory space of Linked List and Hash Map.
 * The use of templates enable any type of vehicle to be modeled using this program.
 */
import java.util.LinkedHashMap;
import java.util.Properties;

import exception.AutoException;
import util.FileIO;

public class Fleet<T extends Automobile> {
	/*
	 * Fleet class has a LinkedHashMap of a fleet of autos which enables
	 * instantiation of more than 1 auto object.
	 * 
	 * To develop templates, automobile was declared abstract and the
	 * linkedhashMap object of autos is a variable in a fleet class which acts
	 * as a template.
	 * 
	 */
	private LinkedHashMap<String, T> myObj = new LinkedHashMap<>();
	FileIO file = new FileIO();

	/*
	 * Create, read, delete and update methods are added in the fleet class to
	 * enable building/reading/ deleting/updating of auto objects.
	 * 
	 */
	public void createFleetAuto(String modelName, String fileName, T type) {
		try {
			// catches and fixes the exception thrown from fileIO class
			myObj.put(modelName, (T) file.readData(1, fileName, type));
		} catch (AutoException AE) {
			System.out.println(AE.fix(AE.getErrorNo()));
		}
	}
	public void createFleetAuto(int type, String modelName, String fileName, T Autotype) 
	{
		try {
			// catches and fixes the exception thrown from fileIO class
			myObj.put(modelName, (T) file.readData(type, fileName, Autotype));
		} catch (AutoException AE) {
			System.out.println(AE.fix(AE.getErrorNo()));
		}
	}
	// method to read and add the auto from properties object to the
	// linkedhashmap
	public void createFleetAuto(Properties props, T type, int fileType) {

		String CarMake = props.getProperty("CarMake"); // this is how you read a
														// property. It is like
														// gettting a value from
														// HashTable.
		String CarModel = props.getProperty("CarModel");
		try {
			// add the property file based auto to the linkedhashmap
			myObj.put(CarMake + " " + CarModel, (T) file.readData(props, type));
		} catch (AutoException AE) {
			System.out.println(AE.fix(AE.getErrorNo()));
		}
	}

	// method to read auto
	public T readFleetAuto(String modelName) {

		if (!myObj.isEmpty()) {
			return myObj.get(modelName);
		} else
			return null;

	}

	// method to update auto
	public void updateFleetAuto(String modelName, String fileName, T type) {
		try {
			// catches and fixes the exception thrown from fileIO class
			myObj.put(modelName, (T) file.readData(1, fileName, type));
		} catch (AutoException AE) {
			System.out.println(AE.fix(AE.getErrorNo()));
		}
	}

	// method to delete auto
	public boolean deleteFleetAuto(String modelName) {
		if (myObj.remove(modelName) != null)
			return true;
		else
			return false;

	}

	// method to get arraylist of auto names
	public ArrayList<String> getFleet() {
		ArrayList<String> autoArray = new ArrayList<>();
		autoArray.addAll(myObj.keySet());
		return autoArray;

	}

}
