/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 5
Due Date : 05/31/2016
Date Submitted :06/01/2016

 */
/**A class that represents a model of automobile. It implements various method calls
 * to call the protected methods from the option set class. 
 * It basically helps in building a model
 * of automobile with various option sets and options. This class implements serializable.
 * 


 * 
 * @author Nia vivek
 * @version 1.0
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * To develop templates, automobile was declared abstract and the linkedhashMap object of autos
 * is a variable in a fleet class which acts as a template.
 * 
 * The user never knows about the automobile class. It is encapsulated using interfaces.
 *The methods of automobile class are synchronized to enable object locking
 */
public abstract class Automobile implements Serializable {

	// Base model for the automotive which contains option set and methods to
	// access the protected methods of option sets and options
	private String name;
	private ArrayList<OptionSet> opset;
	/*
	 * Automobile class has an array of option sets to contain the various
	 * option sets for each automobile model.
	 * 
	 * In addition, the size of arraylist can be changed dynamically as opposed
	 * to arrays. Changing the option sets and option array's to arraylist makes
	 * it more efficient and allows to add elements to the arraylist without
	 * keeping track of indices.
	 */

	private float price;
	private String model;
	private String make;
	private int year;
	private ArrayList<Option> choices = new ArrayList<>();

	/*
	 * ArrayList choices helps in saving the customer's preferences for a model
	 * and helps in calculating the model price with the selected options.
	 */
	// no-arg constructor
	public Automobile() {
		opset = new ArrayList<OptionSet>();
	}

	// constructors with different combinations of instance variables
	public Automobile(String name) {
		this.name = name;
		String[] autoName = splitAutoName();
		make = autoName[0];
		model = autoName[1];
		opset = new ArrayList<OptionSet>();
	}

	public Automobile(float basePrice) {
		price = basePrice;

	}

	public Automobile(int size) {
		opset = new ArrayList<OptionSet>(size);

	}

	public Automobile(String name, float basePrice) {
		this.name = name;
		price = basePrice;
		String[] autoName = splitAutoName();
		make = autoName[0];
		model = autoName[1];
		opset = new ArrayList<OptionSet>();

	}

	public Automobile(float basePrice, int size) {
		opset = new ArrayList<OptionSet>(size);

		price = basePrice;
	}

	public Automobile(String name, int size) {
		opset = new ArrayList<OptionSet>(size);

		this.name = name;
		String[] autoName = splitAutoName();
		make = autoName[0];
		model = autoName[1];

	}

	public Automobile(String name, float basePrice, int size) {
		opset = new ArrayList<OptionSet>(size);

		this.name = name;
		price = basePrice;
		String[] autoName = splitAutoName();
		make = autoName[0];
		model = autoName[1];

	}
	/*
	 * Automobile class has various public methods to access the instance
	 * variables as well as the protected methods of OptionSet and Option.
	 * 
	 * Various combinations of constructors and methods were created in
	 * automobile and OptionSet class for various CRUD (Create, Read, Update and
	 * Delete) operations for each variable and combination of variables as well
	 * as print operations.
	 */

	/*
	 * methods to perform CRUD operations for the various instance variables
	 * CREATE OPERATIONS build option set and name of auto
	 */
	public void buildOptionSetAndName(int size, String name) {
		opset = new ArrayList<OptionSet>(size);

		// System.out.println(opset.size());
		this.name = name;
		String[] autoName = splitAutoName();
		make = autoName[0];
		model = autoName[1];
	}

	// build option set
	public void buildOptionSet(int size) {
		opset = new ArrayList<OptionSet>(size);

		// System.out.println(opset.size());
	}

	// set auto name
	public void setName(String name) {
		this.name = name;
		String[] autoName = splitAutoName();
		make = autoName[0];
		model = autoName[1];
	}

	// set auto price
	public void setPrice(float price) {
		this.price = price;
	}

	// set option set
	public void setOpset(ArrayList<OptionSet> opset) {
		this.opset = opset;
	}

	// set option set name by index
	public void setOpSetNameByIndex(String name1, int index) {
		opset.get(index).setName(name1);

	}

	// add new option set
	public void setNewOpSetName(String name1) {
		opset.add(new OptionSet(name1));

	}

	// set option set name and option size by option set index
	public void setOpSetNameSizeByIndex(String name1, int index, int size) {
		// opset.add(index, new OptionSet(name1, size));
		opset.get(index).setName(name1);
		opset.get(index).setOptSize(size);

	}

	/*
	 * Addition methods like below were added in the automobile class to handle
	 * the arraylist (arrays used indices) and also the current methods were
	 * changed to reflect the usage of arraylist .get(index) is used instead of
	 * array[i]
	 * 
	 * Methods to set option set name and option size by option set without
	 * using index as when arrays were used
	 */
	public void setOpSetNameSize(String name1, int size) {
		opset.add(new OptionSet(name1, size));
		// opset.get(index).setName(name1);
		// opset.get(index).setOptSize(size);

	}

	// set size of options for an option set by index
	public void setOpSetSizeByIndex(int index, int size) {
		opset.get(index).setOptSize(size);
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
	public ArrayList<OptionSet> getOpset() {
		return opset;
	}

	// get an option set by index
	public OptionSet getOpsetByIndex(int index) {
		return opset.get(index);
	}

	// get name of option set by index of option set
	public String getOpsetNameByIndex(int index) {
		return opset.get(index).getName();
	}

	// find option set by name
	public OptionSet findOpSetByName(String name1) {
		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i).getName().equals(name1)) {
				return opset.get(i);
			}
		}
		return null;

	}

	// get option set whose name contains the string val
	public OptionSet getOpSetNameContains(String val) {

		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i).getName().contains(val)) {
				return opset.get(i);
			}
		}
		return null;
	}

	// get option set whose name starts with the string pre
	public OptionSet getOpSetNameStartsWith(String pre) {

		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i).getName().startsWith(pre)) {
				return opset.get(i);
			}
		}
		return null;
	}

	// get all option names of an option set
	public ArrayList<String> getOptnameOfOpSet(OptionSet opset1) {
		return opset1.getAllOptNames();
	}

	// get size of option set
	public int opSize() {
		return opset.size();
	}

	// if option set is empty
	public boolean opIsEmpty() {
		return opset.isEmpty();
	}

	/*
	 * return string of all option sets StringBuffer was used to concatenate the
	 * various string to convert the options and option sets to string. This is
	 * because strings are immutable and waste lot of memory compared to
	 * StringBuffers.
	 */

	public StringBuffer[] toStringOpSet() {
		StringBuffer[] stringToPrint = new StringBuffer[opset.size()];
		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i) != null) {
				stringToPrint[i] = new StringBuffer("Option Set Name is " + opset.get(i).getName());
				stringToPrint[i].append("Size: " + opset.get(i).size());
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
		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i) != null) {
				opset.get(i).printOption();
			} else
				System.out.println("No Value");

		}
		System.out.println("\n\n");

	}

	// UPDATE
	// update option set size by option set name
	public void updateOpSetSizeByName(String name1, int size) {
		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i).getName().equals(name1)) {
				opset.get(i).setOptSize(size);
			}
		}
	}

	// update option set new name by current name
	public void updateOpSetNameByName(String name1, String newName) {
		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i).getName().equals(name1)) {
				opset.get(i).setName(newName);
			}
		}
	}

	// update option set name if name contains
	public void updateOptNameIfNameContains(String val, String newName) {
		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i).getName().contains(val)) {
				opset.get(i).setName(newName);
			}
		}
	}

	// update option set name if name starts with
	public void updateOptNameifNameStartsWith(String pre, String newName) {
		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i).getName().startsWith(pre)) {
				opset.get(i).setName(newName);
			}
		}
	}

	// update option set size if name contains
	public void updateOptSizeNameContains(String val, int size) {
		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i).getName().contains(val)) {
				opset.get(i).setOptSize(size);
				;
			}
		}
	}

	// update option set size if name starts with
	public void updateOptSizeNameStartsWith(String pre, int size) {
		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i).getName().startsWith(pre)) {
				opset.get(i).setOptSize(size);
				;
			}
		}
	}

	// DELETE
	// delete option set by name
	public boolean deleteOpSetByName(String name1) {
		boolean found = false;
		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i).getName().equals(name1)) {
				found = true;
				opset.get(i).clearOptions();
				opset.remove(i);

			}
		}
		return found;
	}

	// delete option set by index
	public boolean deleteOpSetByIndex(int index) {
		boolean found = false;

		if (opset.get(index) != null) {
			found = true;
			opset.get(index).clearOptions();
			opset.remove(index);
		}
		return found;
	}

	// clear all option sets and their options
	public void clearOpSet() {

		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i) != null) {
				opset.get(i).clearOptions();
				opset.remove(i);

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
	public void setOptOfOpSet(OptionSet opset1, ArrayList<Option> opt) {
		opset1.setOpt(opt);
	}
	// set new option name

	public void setNewOptOfOpSet(OptionSet opset1, String name1) {
		opset1.setNewOptName(name1);
	}

	// set option name by index of options
	public void setOptOfOpSetNameByIndex(OptionSet opset1, int index, String name1) {
		opset1.setOptNameByIndex(index, name1);
	}

	// set option name by index of options
	public void setOptOfOpSetName(OptionSet opset1, String name1) {
		opset1.setOptName(name1);
	}

	// set option price by option index
	public void setOptPriceByIndex(OptionSet opset1, int index, float price) {
		opset1.findOptByIndex(index).setPrice(price);
	}

	// set option name and price by option index
	public void setOptOfOpSetNamePrice(OptionSet opset1, int index, String name1, float price) {

		opset1.setOptNamePriceByIndex(index, name1, price);

	}

	// set option name and price by option index
	public void setOptOfOpSetNamePrice(OptionSet opset1, String name1, float price) {

		opset1.setOptNamePrice(name1, price);

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
	public ArrayList<Option> getOptOfOpSet(OptionSet opset1) {
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

	// method to split the auto name into year,make and model
	private String[] splitAutoName() {
		return name.split("[ \t]", 3);
	}

	// method to get the make of the automobile
	public String getMake() {
		return make;
	}

	// method to get year
	public int getYear() {
		return year;
	}

	// method to set the make of the automobile
	public void setMake(String make) {
		this.make = make;
	}

	// method to get the automobile model
	public String getModel() {
		return model;
	}

	// method to set the auotmobile model
	public void setModel(String model) {
		this.model = model;
	}

	// method to get the option choice
	public String getOptionChoice(String setName) {
		return findOpSetByName(setName).getOptName(findOpSetByName(setName).getOptionChoice());
	}

	// method to get the option choice price
	public float getOptionChoicePrice(String setName) {
		return findOpSetByName(setName).getOptPrice(findOpSetByName(setName).getOptionChoice());
	}

	// method to set option choice

	/*
	 * This is done by checking if an optionset has a choice selected. If it
	 * already contains a choice, then the choice is updated else a new choice
	 * is added
	 */

	public void setOptionChoice(String setName, String optionName) {
		int index = choices.size();
		boolean found = false;
		if (findOpSetByName(setName).getOptionChoice() != null) {
			if (choices.contains(findOpSetByName(setName).getOptionChoice())) {
				index = choices.indexOf((findOpSetByName(setName).getOptionChoice()));
				found = true;
			}
		}
		findOpSetByName(setName).setOptionChoice(optionName);
		if (found == true)
			choices.set(index, findOpSetByName(setName).getOptionChoice());
		else
			choices.add(findOpSetByName(setName).getOptionChoice());
		// for (int i = 0; i < choice.size(); i++)
		// System.out.println(choice.get(i).getName());
	}

	/*
	 * method to get the total price with all the option total price is
	 * calculated using the choices variable which is added/updated when a
	 * choice is made for an option set
	 */
	public float getTotalPrice() {
		float totalPrice = price;
		for (int i = 0; i < choices.size(); i++)
			totalPrice += choices.get(i).getPrice();
		return totalPrice;

	}

	// method to print all the options with the selected choice and price
	public void printChoiceAndPrice() {
		System.out.println("Model Name: " + name);
		System.out.println("Base model price: " + price);
		System.out.printf("%-30s%-40s%-7s\n", "Option", "Choice", "Price");
		for (int i = 0; i < opset.size(); i++)

		{
			/*
			 * check if an choice is selected for an option set if yes print the
			 * choice and price if no print no selection
			 */
			if (opset.get(i).getOptionChoice() != null)
				System.out.printf("%-30s%-40s%-7s\n", opset.get(i).getName(), opset.get(i).getOptionChoice().getName(),
						opset.get(i).getOptionChoice().getPrice());
			else
				System.out.printf("%-30s%-40s%-7s\n", opset.get(i).getName(), "No choice", "No choice");
		}
		System.out.println("Total price with Options: " + getTotalPrice());
		System.out.println();
	}
}
