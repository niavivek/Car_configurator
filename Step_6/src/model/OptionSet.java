/*
 *
Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 6
Due Date : 06/20/2016
Date Submitted :06/20/2016
 */
package model;
/**A class that represents a model of automobile. It implements various method calls
* to call the protected methods from the option set class. 
* It basically helps in building a model
* of automobile with various option sets and options. This class implements serializable.
* @author Nia vivek
* @version 1.0

 * 1. An OptionSet class was created to keep track of different options.
 * 2. OptionSet class has private variables and protected methods to encapsulate
 * the methods from other packages. 
 * 3. Option Set class has an inner protected class named Options - which contains
 * the various options and their prices for each Option set.
 * 4. Option Set has an array of Options as a protected variable to contain the various options
 * of each Option set.
 * 5. Option class has name and price as protected variables and relevant protected getters
 *  and setters for encapsulation.
 *  6. Having option as an inner class of OptionSet enables encapsulation by containment.
 *  7. StringBuffer was used to concatenate the various string to convert the options and
 *  option sets to string. This is because strings are immutable and waste lot of memory compared
 *  to StringBuffers.
 *  8. Various combinations of constructors and methods were created in automobile and OptionSet
 *  class for various CRUD (Create, Read, Update and Delete) operations for each variable and combination
 *  of variables as well as print operations.
 * 
*/
import java.io.Serializable;

public class OptionSet implements Serializable {

	// private variables for encapsulation
	private Option opt[];
	private String name;

	// different combinations of constructors
	protected OptionSet() {
	}

	protected OptionSet(int size) {
		opt = new Option[size];
		for (int i = 0; i < size; i++) {
			opt[i] = new Option();
		}
	}

	protected OptionSet(String name1) {
		name = name1;
	}

	protected OptionSet(String name1, int size) {
		opt = new Option[size];
		name = name1;
		for (int i = 0; i < size; i++) {
			opt[i] = new Option();
		}
	}

	// get name of option set
	protected String getName() {
		return name;
	}

	// get options
	protected Option[] getOpt() {
		return opt;
	}

	// find option by name
	protected Option findOptByName(String name1) {
		for (int i = 0; i < opt.length; i++) {
			if (opt[i].name.equals(name1)) {
				return opt[i];
			}
		}
		return null;

	}

	// find option by index
	protected Option findOptByIndex(int index) {
		return opt[index];

	}

	// get option if option name contains
	protected Option OptNameContains(String val) {

		for (int i = 0; i < opt.length; i++) {
			if (opt[i].name.contains(val)) {
				return opt[i];
			}
		}
		return null;
	}

	// get option if option name starts with
	protected Option OptNameStartsWith(String pre) {

		for (int i = 0; i < opt.length; i++) {
			if (opt[i].name.startsWith(pre)) {
				return opt[i];
			}
		}
		return null;
	}
	// get all option names
		protected String[] getAllOptName() {
			String[] optNames = new String[opt.length];
			for (int i = 0; i < opt.length; i++) {
				optNames[i] = opt[i].getName();
			}
			return optNames;
		}
		// get all option price
				protected float[] getAllOptPrice() {
					float[] optPrices = new float[opt.length];
					for (int i = 0; i < opt.length; i++) {
						optPrices[i] = opt[i].getPrice();
					}
					return optPrices;
				}

	// get size of options
	protected int size() {
		return opt.length;
	}

	// check if option is empty
	protected boolean isEmpty() {
		return (opt == null);
	}

	// CREATE OPERATIONS
	// set option size
	protected void setOptSize(int size) {
		// opt = null;
		opt = new Option[size];

		for (int i = 0; i < opt.length; i++) // initialize object to avoid null
			// pointer
		{
			opt[i] = new Option();
		}

	}

	// set options
	protected void setOpt(Option[] opt) {
		this.opt = opt;
	}

	// set option name
	protected void setName(String name1) {
		this.name = name1;
	}

	// set option price by name
	protected void setOptPriceByName(String name1, float price) {
		for (int i = 0; i < opt.length; i++) {
			if (opt[i].name.equals(name1)) {
				opt[i].price = price;
			}
		}

	}

	// UPDATE OPERATIONS
	// update option name by old name
	protected void updateOptNameByName(String name1, String newName1) {
		for (int i = 0; i < opt.length; i++) {
			if (opt[i].name.equals(name1)) {
				opt[i].name = newName1;
			}
		}
	}

	// set option name by index
	protected void setOptNameByIndex(int index, String name1) {
		opt[index].name = name1;
	}

	// set option price by index
	protected void setOptPriceByIndex(int index, float price) {
		opt[index].price = price;
	}

	// set option name and price by index
	protected void setOptNamePriceByIndex(int index, String name1, float price) {
		opt[index].name = name1;
		opt[index].price = price;
	}

	// set price if option name contains
	protected boolean setPriceOptNameContains(String val, float price) {
		boolean found = false;
		for (int i = 0; i < opt.length; i++) {
			if (opt[i].name.contains(val)) {
				found = true;
				opt[i].price = price;
			}
		}
		return found;
	}

	// set price if option name starts with
	protected boolean setPriceOptNameStartsWith(String pre, float price) {
		boolean found = false;
		for (int i = 0; i < opt.length; i++) {
			if (opt[i].name.startsWith(pre)) {
				found = true;
				opt[i].price = price;
			}
		}
		return found;
	}

	// DELETE OPERATIONS
	// delete option by name
	protected boolean deleteOptByName(String name1) {
		boolean found = false;
		for (int i = 0; i < opt.length; i++) {
			if (opt[i].name.equals(name1)) {
				found = true;
				opt[i] = null;
			}
		}
		return found;
	}

	// delete option by index
	protected boolean deleteOptByIndex(int index) {
		boolean found = false;
		if (opt[index] != null) {
			opt[index] = null;
			found = true;
		}
		return found;
	}

	// clear all options
	protected boolean clearOptions() {
		boolean found = false;
		if (opt != null) {
			found = true;
			opt = null;
		}
		return found;
	}

	// PRINT OPERATIONS
	// convert options to string
	protected StringBuffer[] toStringOpt() {
		StringBuffer[] stringToPrint = new StringBuffer[opt.length];
		for (int i = 0; i < opt.length; i++) {
			if (opt[i] != null) {
				stringToPrint[i] = new StringBuffer("Option Name is " + opt[i].getName());
				stringToPrint[i].append(" Price " + opt[i].getPrice());
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
		for (int i = 0; i < opt.length; i++) {
			if (opt[i] != null) {
				StringBuffer stringToPrint1 = new StringBuffer(opt[i].getName());
				StringBuffer stringToPrint2 = new StringBuffer("" + opt[i].getPrice());
				System.out.printf("\n%-50s%s", stringToPrint1, stringToPrint2);
			} else
				System.out.println("No Value");

		}
		System.out.println();

	}

	// inner protected class for encapsulation with containment
	protected class Option implements Serializable {
		// private instance variables
		private String name;
		private float price;

		// no-arg constructor
		protected Option() {

		}

		// different combination constructors
		protected Option(String name1) {
			this.name = name1;
		}

		protected Option(float price) {
			this.price = price;
		}

		protected Option(String name1, float price) {
			this.name = name1;
			this.price = price;
		}

		// getters and setters for private variables
		// get option name
		protected String getName() {
			return name;
		}

		// set option name
		protected void setName(String name1) {
			this.name = name1;
		}

		// get option price
		protected float getPrice() {
			return price;
		}

		// set option price
		protected void setPrice(float price) {
			this.price = price;
		}

	}
}
