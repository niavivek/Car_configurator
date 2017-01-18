/*
 *
Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 2
Due Date : 04/30/2016
Date Submitted :04/30/2016
 */
/**An interface for building and printing of automobile
 * @author Nia vivek
 * @version 1.0
 */
package adapter;

public interface CreateAuto {
	//interface to handle building and print auto
	public void buildAuto(String fileName);
	public void printAuto(String modelName);

}
