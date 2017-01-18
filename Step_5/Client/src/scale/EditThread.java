/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 5
Due Date : 05/31/2016
Date Submitted :06/01/2016

 */
package scale;

/*
 * An EditThread iterface was created to enable interaction between the user and the internal components
    like EditOptions.
 *EditOptions and EditThread are in a package called scale.
 */
public interface EditThread {
	// interface methods to change the option set name and option price
	public void updateOptionSetNameThread(int x, int index, String[] args);

	public void updateOptionPriceThread(int x, String[] args, float newPrice);
}
