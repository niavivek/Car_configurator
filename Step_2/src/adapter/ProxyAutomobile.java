/*
 *
Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 2
Due Date : 04/30/2016
Date Submitted :04/30/2016
 */
/**An abstract class which implements the methods from interfaces - CreateAuto, FixAuto and UpdateAuto
 * It acts as a proxy for BuildAuto class. It calls the various methods from automobile class
 * to implement it's own methods.
 * It has methods to build an auto, print the contents of auto model, fix errors during runtime
 * and update various aspects of the auto model. It uses various method from automobile class 
 * and AutoException class to accomplish this.
 * @author Nia vivek
 * @version 1.0
 */
package adapter;

import exception.AutoException;
import model.*;
import util.FileIO;
public abstract class ProxyAutomobile {

	private static Automobile myObj;
	FileIO file = new FileIO();
	//implementation of the interface methods used by buildauto empty class
	public void buildAuto(String fileName) 
	{
		try
		{
			//catches and fixes the exception thrown from fileIO class
		myObj = file.readData(fileName,new Automobile()); 
		}
		catch(AutoException AE)
		{
			System.out.println(AE.fix(AE.getErrorNo()));
		}
	}
	//method to print auto- calls method from automotive class
	public void printAuto(String modelName)
	{		
		if(myObj != null && myObj.getName().equals(modelName))
			myObj.printAll();
	}
	//methods to update auto- calls methods from automotive class
	public void updateOptionSetName(String modelName, String optionSetName,String newName)
	{
		if(myObj != null && myObj.getName().equals(modelName))
			myObj.updateOpSetNameByName(optionSetName, newName);
	}
	public void updateOptionPrice(String modelName,String optionSetName,String Option,float newPrice)
	{
		if(myObj != null && myObj.getName().equals(modelName))
			myObj.updateOptOfOpSetPriceByName(myObj.findOpSetByName(optionSetName),Option,newPrice);
	}
	//method to fix errors - calls method from autoexception class
	public void fixErrors(int errorNum)
	{
		AutoException autoExcep1 = new AutoException();
		autoExcep1.fix(errorNum);
	}
}
