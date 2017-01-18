/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 4
Due Date : 05/20/2016
Date Submitted :05/21/2016

 */
/**An interface to update option sets and options
 * 
 * 

 * @author Nia vivek
 * @version 1.0
 */
package adapter;
/*
 * The user never knows about the automobile class. It is encapsulated using interfaces.
 * Interfaces are being used to control access to various functionalities which would otherwise
 * be available to the end-users. This is also encapsulation using interfaces.

API was designed with different packages, interfaces and abstract classes. An internal
 * and external component was designed to separate functions from functionality.

 */
public interface UpdateAuto {
//interface to handle update methods
	public void updateOptionSetName(String modelName, String optionSetName,String newName);
	public void updateOptionSetNameByIndex(String modelName, int index,String newName);
	public void updateOptionPrice(String modelName,String optionName,String option,float newPrice);
}
