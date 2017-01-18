/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 5
Due Date : 05/31/2016
Date Submitted :06/01/2016

 */
/**A class to contain the various option sets and it's size. 
 * It also has an inner class which handles the options
 * and it's prices. This protected inner class constitutes encapsulation 
 * with class containment. 
 * It also has various getters and setters for option sets and options.
 * This class implements Serializable.
 * 
 * 


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
		opt = new ArrayList<Option>();
	}

	protected OptionSet(int size) {
		opt = new ArrayList<Option>(size);

	}

	protected OptionSet(String name1) {
		opt = new ArrayList<Option>();
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

	// get an arraylist of all option names for an option set
	protected ArrayList<String> getAllOptNames() {
		ArrayList<String> arrayOpt = new ArrayList<>();
		for (int i = 0; i < opt.size(); i++)
			arrayOpt.add(opt.get(i).getName());
		return arrayOpt;
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

	// set new option name
	protected void setNewOptName(String name1) {
		opt.add(new Option(name1));
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
