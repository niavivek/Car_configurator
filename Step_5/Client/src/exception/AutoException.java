/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 5
Due Date : 05/31/2016
Date Submitted :06/01/2016

 */
/**A class extending exception class to implement custom exceptions.
 * This version fixes the format of option set size and print error
 * messages for other errors like missing option price, format of option price,
 * format of model price and missing option size. It also logs the various error messages
 * and error number in a file with a timestamp.
 * 
 * 

 * @author Nia vivek
 * @version 1.0
 */
package exception;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AutoException extends Exception {
	/*
	 * Machine learning is implemented using custom exceptions where exceptions
	 * are fixed by learning about the different exceptions that can occur. All
	 * the healing is centralized in one place using custom exception's
	 * AutoException class. Exceptions are logged with a timestamp, error number
	 * and error messages.
	 * 
	 */
	// private static final long serialVersionUID = 1L;
	// private variables to store message and error numbers
	private int errorNo;
	private String errorMsg;

	public AutoException() {
		super();
	}

	public AutoException(AutoExcepEnum enum1) {
		super();
		this.errorNo = enum1.getValue();
		this.errorMsg = enum1.name();
		log();
		print(enum1);
	}

	// getters and setters for error number and messages
	public int getErrorNo() {
		return errorNo;
	}

	public void setErrorNo(AutoExcepEnum enum1) {
		this.errorNo = enum1.getValue();
	}

	public void setErrorMsg(AutoExcepEnum enum1) {
		this.errorMsg = enum1.name();
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void print(AutoExcepEnum enum1) {
		System.out.println("AutoException -" + enum1.toString());
	}

	// method to fix the error based on error number
	public String fix(int errorNum) {
		Fix1to100 f1 = new Fix1to100();

		switch (errorNum) {
		case 1:
			return f1.fix1();
		case 2:
			return f1.fix2();
		case 3:
			return f1.fix3();
		case 4:
			return f1.fix4();
		case 5:
			return f1.fix5();
		default:
			return "Not Fixed";
		}

	}

	// method to log the time stamp and error messages with error numbers into a
	// file
	public void log() {
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy_hh:mm:ss");
		Date currTime = cal1.getTime();
		String strDate = format1.format(currTime);

		try {
			FileWriter outputFile = new FileWriter("log.txt", true);
			BufferedWriter bufferOutput = new BufferedWriter(outputFile);
			StringBuffer stringToWrite = new StringBuffer(errorMsg);
			stringToWrite.append(" Error Number: ");
			stringToWrite.append(errorNo);

			bufferOutput.write(stringToWrite.toString());
			bufferOutput.newLine();
			bufferOutput.write(strDate);
			bufferOutput.newLine();

			bufferOutput.close();
			outputFile.close();
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}

	}
}
