/*
 *
Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 1
Due Date : 04/20/2016
Date Submitted :04/20/2016
 */
package model;

import java.io.Serializable;

import model.OptionSet.Option;

public class Automotive implements Serializable {

	// base model for the automotive which contains option set and methods to
	// access the protected methods of option sets and options
	private String name;
	private OptionSet opset[];
	private float price;

	// no-arg constructor
	public Automotive() {
	}

	// constructors with different combinations of instance variables
	public Automotive(String name) {
		this.name = name;
	}

	public Automotive(float basePrice) {
		price = basePrice;

	}

	public Automotive(int size) {
		opset = new OptionSet[size];
		for (int i = 0; i < opset.length; i++)
			opset[i] = new OptionSet();

	}

	public Automotive(String name, float basePrice) {
		this.name = name;
		price = basePrice;

	}

	public Automotive(float basePrice, int size) {
		opset = new OptionSet[size];
		for (int i = 0; i < opset.length; i++)
			opset[i] = new OptionSet();
		price = basePrice;
	}

	public Automotive(String name, int size) {
		opset = new OptionSet[size];
		for (int i = 0; i < opset.length; i++)
			opset[i] = new OptionSet();
		this.name = name;

	}

	public Automotive(String name, float basePrice, int size) {
		opset = new OptionSet[size];
		for (int i = 0; i < opset.length; i++)
			opset[i] = new OptionSet();
		this.name = name;
		price = basePrice;

	}

	// methods to perform CRUD operations for the various instance variables
	// CREATE OPERATIONS
	// build option set and name of auto
	public void buildOptionSetAndName(int size, String name) {
		opset = new OptionSet[size];
		for (int i = 0; i < opset.length; i++)
			opset[i] = new OptionSet();
		this.name = name;
	}

	// build option set
	public void buildOptionSet(int size) {
		opset = new OptionSet[size];
		for (int i = 0; i < opset.length; i++)
			opset[i] = new OptionSet();
	}

	// set auto name
	public void setName(String name) {
		this.name = name;
	}

	// set auto price
	public void setPrice(float price) {
		this.price = price;
	}

	// set option set
	public void setOpset(OptionSet[] opset) {
		this.opset = opset;
	}

	// set option set name by index
	public void setOpSetNameByIndex(String name1, int index) {
		opset[index].setName(name1);

	}

	// set option set name and option size by option set index
	public void setOpSetNameSizeByIndex(String name1, int index, int size) {
		opset[index].setName(name1);
		opset[index].setOptSize(size);

	}

	// set size of options for an option set by index
	public void setOpSetSizeByIndex(int index, int size) {
		opset[index].setOptSize(size);
	}

	// READ
	// get auto name
	public String getName() {
		return name;
	}

	// get auto price
	public float getPrice() {
		return price;
	}

	// get option set
	public OptionSet[] getOpset() {
		return opset;
	}

	// get an option set by index
	public OptionSet getOpsetByIndex(int index) {
		return opset[index];
	}

	// get name of option set by index of option set
	public String getOpsetNameByIndex(int index) {
		return opset[index].getName();
	}

	// find option set by name
	public OptionSet findOpSetByName(String name1) {
		for (int i = 0; i < opset.length; i++) {
			if (opset[i].getName().equals(name1)) {
				return opset[i];
			}
		}
		return null;

	}

	// get option set whose name contains the string val
	public OptionSet getOpSetNameContains(String val) {

		for (int i = 0; i < opset.length; i++) {
			if (opset[i].getName().contains(val)) {
				return opset[i];
			}
		}
		return null;
	}

	// get option set whose name starts with the string pre
	public OptionSet getOpSetNameStartsWith(String pre) {

		for (int i = 0; i < opset.length; i++) {
			if (opset[i].getName().startsWith(pre)) {
				return opset[i];
			}
		}
		return null;
	}

	// get size of option set
	public int opSize() {
		return opset.length;
	}

	// if option set is empty
	public boolean opIsEmpty() {
		return opset == null;
	}

	// return string of all option sets
	public StringBuffer[] toStringOpSet() {
		StringBuffer[] stringToPrint = new StringBuffer[opset.length];
		for (int i = 0; i < opset.length; i++) {
			if (opset[i] != null) {
				stringToPrint[i] = new StringBuffer("Option Set Name is " + opset[i].getName());
				stringToPrint[i].append("Size: " + opset[i].size());
			} else
				stringToPrint[i] = new StringBuffer("No Value");

		}
		return stringToPrint;
	}

	// print the auto, option set and option information
	public void printAll() {
		StringBuffer stringToPrint = new StringBuffer();
		stringToPrint = new StringBuffer("Automotive Name: " + getName());
		stringToPrint.append("\t Price: " + getPrice());
		stringToPrint.append("\t Number of Option Sets: " + opSize());
		System.out.println(stringToPrint);
		for (int i = 0; i < opset.length; i++) {
			if (opset[i] != null) {
				opset[i].printOption();
			} else
				System.out.println("No Value");

		}

	}

	// UPDATE
	// update option set size by option set name
	public void updateOpSetSizeByName(String name1, int size) {
		for (int i = 0; i < opset.length; i++) {
			if (opset[i].getName().equals(name1)) {
				opset[i].setOptSize(size);
			}
		}
	}

	// update option set new name by current name
	public void updateOpSetNameByName(String name1, String newName) {
		for (int i = 0; i < opset.length; i++) {
			if (opset[i].getName().equals(name1)) {
				opset[i].setName(newName);
			}
		}
	}

	// update option set name if name contains
	public void updateOptNameIfNameContains(String val, String newName) {
		for (int i = 0; i < opset.length; i++) {
			if (opset[i].getName().contains(val)) {
				opset[i].setName(newName);
			}
		}
	}

	// update option set name if name starts with
	public void updateOptNameifNameStartsWith(String pre, String newName) {
		for (int i = 0; i < opset.length; i++) {
			if (opset[i].getName().startsWith(pre)) {
				opset[i].setName(newName);
			}
		}
	}

	// update option set size if name contains
	public void updateOptSizeNameContains(String val, int size) {
		for (int i = 0; i < opset.length; i++) {
			if (opset[i].getName().contains(val)) {
				opset[i].setOptSize(size);
				;
			}
		}
	}

	// update option set size if name starts with
	public void updateOptSizeNameStartsWith(String pre, int size) {
		for (int i = 0; i < opset.length; i++) {
			if (opset[i].getName().startsWith(pre)) {
				opset[i].setOptSize(size);
				;
			}
		}
	}

	// DELETE
	// delete option set by name
	public boolean deleteOpSetByName(String name1) {
		boolean found = false;
		for (int i = 0; i < opset.length; i++) {
			if (opset[i].getName().equals(name1)) {
				found = true;
				opset[i].clearOptions();
				opset[i] = null;

			}
		}
		return found;
	}

	// delete option set by index
	public boolean deleteOpSetByIndex(int index) {
		boolean found = false;

		if (opset[index] != null) {
			found = true;
			opset[index].clearOptions();
			opset[index] = null;
		}
		return found;
	}

	// clear all option sets and their options
	public void clearOpSet() {

		for (int i = 0; i < opset.length; i++) {
			if (opset[i] != null) {
				opset[i].clearOptions();
				opset[i] = null;

			}
		}
		opset = null;
	}

	// METHODS TO ACCESS OPTIONS OF OPTION SET
	// CREATE
	// set size of options
	public void setOptSizeOfOpSet(OptionSet opset1, int size) {
		opset1.setOpt(null);
		opset1.setOptSize(size);
	}

	// set options
	public void setOptOfOpSet(OptionSet opset1, Option[] opt) {
		opset1.setOpt(opt);
	}

	// set option name by index of options
	public void setOptOfOpSetNameByIndex(OptionSet opset1, int index, String name1) {
		opset1.findOptByIndex(index).setName(name1);
	}

	// set option price by option index
	public void setOptPriceByIndex(OptionSet opset1, int index, float price) {
		opset1.findOptByIndex(index).setPrice(price);
	}

	// set option name and price by option index
	public void setOptOfOpSetNamePriceByIndex(OptionSet opset1, int index, String name1, float price) {
		opset1.findOptByIndex(index).setName(name1);
		opset1.findOptByIndex(index).setPrice(price);

	}

	// set option price if option name contains
	public void setPriceOptOfOpSetNameContains(OptionSet opset1, String val, float price) {
		opset1.OptNameContains(val).setPrice(price);
	}

	// set option price if option name starts with
	public void setPriceOptOfOpsetNameStartsWith(OptionSet opset1, String pre, float price) {
		opset1.OptNameStartsWith(pre).setPrice(price);
	}

	// READ
	// get the options of option set
	public Option[] getOptOfOpSet(OptionSet opset1) {
		return opset1.getOpt();
	}

	// find option by name
	public Option findOptOfOpSetByName(OptionSet opset1, String name1) {
		return opset1.findOptByName(name1);
	}

	// find option by index
	public Option findOptOfOpsetByIndex(OptionSet opset1, int index) {
		return opset1.findOptByIndex(index);

	}

	// find option if option name contains
	public Option getOptOfOpSetNameContains(OptionSet opset1, String val) {
		return opset1.OptNameContains(val);
	}

	// find option if option name starts with
	public Option getOptOfOpSetNameStartsWith(OptionSet opset1, String pre) {
		return opset1.OptNameStartsWith(pre);
	}

	// get option size
	public int sizeOfOptOfOpset(OptionSet opset1) {
		return opset1.size();
	}

	// see if options are empty
	public boolean isOptOfOpSetEmpty(OptionSet opset1) {
		return opset1.isEmpty();
	}

	// convert options to string
	public StringBuffer[] toStringOptOfOpSet(OptionSet opset1) {
		return opset1.toStringOpt();
	}

	// print options
	public void PrintAllOptOfOpSet(OptionSet opset1) {
		opset1.printOption();
	}

	// UPDATE
	// update name and price of options
	public void updateOptOfOpSetPriceByName(OptionSet opset1, String name1, float price) {

		opset1.findOptByName(name1).setPrice(price);
		;

	}

	// update name of options by old name
	public void updateOptOfOpSetNameByName(OptionSet opset1, String name1, String newName) {

		opset1.updateOptNameByName(name1, newName);

	}

	// update option name by index
	public void updateOptOfOpSetNameByIndex(OptionSet opset1, int index, String name1) {
		opset1.findOptByIndex(index).setName(name1);
	}

	// update option price by index
	public void updatePriceByIndex(OptionSet opset1, int index, float price) {
		opset1.findOptByIndex(index).setPrice(price);
	}

	// update option name and price by index
	public void updateOptOfOpSetNamePriceByIndex(OptionSet opset1, int index, String name1, float price) {
		opset1.findOptByIndex(index).setName(name1);
		opset1.findOptByIndex(index).setPrice(price);

	}

	// DELETE
	// delete option by name
	public boolean deleteOptOfOpSetByName(OptionSet opset1, String name1) {

		return opset1.deleteOptByName(name1);
	}

	// delete option by index
	public boolean deleteOptOfOpSetByIndex(OptionSet opset1, int index) {
		return opset1.deleteOptByIndex(index);
	}

	// delete all options of an option set
	public boolean clearOptionsOfOpSet(OptionSet opset1) {
		return opset1.clearOptions();
	}

}
