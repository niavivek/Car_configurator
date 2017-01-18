/*
 *
Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 2
Due Date : 04/30/2016
Date Submitted :04/30/2016
 */
/**An interface to update option sets and options
 * @author Nia vivek
 * @version 1.0
 */
package adapter;

public interface UpdateAuto {
//interface to handle update methods
	public void updateOptionSetName(String modelName, String optionSetName,String newName);
	public void updateOptionPrice(String modelName,String optionName,String option,float newPrice);
}
