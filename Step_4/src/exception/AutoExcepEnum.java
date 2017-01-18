/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 4
Due Date : 05/20/2016
Date Submitted :05/21/2016

 */
/**An enumeration containing various possible errors and error numbers.
 * 
 * 

 * @version 1.0
 */
package exception;

/*This class contains the possible enumerations for the custom exception cases.
The enumeration value gives the error number and the enumeration denotes the
error. A switch statement switches the enumeration value to print the error 
number and the error message.*/

public enum AutoExcepEnum {
	// defines the enum
	NumOfOptionSetFormatNotValid(1), ModelPriceFormatNotValid(2), OptionSizeNotFound(3), OptionPriceNotFound(
			4), OptionPriceFormatNotValid(5);
	private int value;

	// constructor with value as argument
	AutoExcepEnum(int value) {
		this.value = value;
	}

	// method to get a string of the error message and error number based on the
	// value of the enum
	public String toString() {
		StringBuffer stringToPrint = new StringBuffer();
		switch (value) {
		case 1:
			stringToPrint.append("Format for Number of option sets is not valid");
			stringToPrint.append(" with error number 1");
			break;
		case 2:
			stringToPrint.append("Model price format");
			stringToPrint.append(" with error number 2");
			break;
		case 3:
			stringToPrint.append("Option Size not found");
			stringToPrint.append(" with error number 3");
			break;
		case 4:
			stringToPrint.append("Option price not found");
			stringToPrint.append(" with error number 4");
			break;
		case 5:
			stringToPrint.append("Option price format");
			stringToPrint.append(" with error number 5");
			break;
		default:
			stringToPrint.append("All other exceptions");
			stringToPrint.append(" which were not fixed");
			break;
		}

		return stringToPrint.toString();
	}

	// method to get the value of enum
	protected int getValue() {
		return value;
	}

};
