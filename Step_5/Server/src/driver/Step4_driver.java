/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 5
Due Date : 05/31/2016
Date Submitted :06/01/2016

 */
package driver;

import adapter.BuildAuto;
import adapter.CreateAuto;
import scale.EditOptions;
import scale.EditThread;
/**
 * DOCUMENTATION
 * VERSION 1.0
 * 1. An Automobile class was created to contain the option sets of each automobile.
 * 2. An OptionSet class was created to keep track of different options.
 * 3. OptionSet class has private variables and protected methods to encapsulate
 * the methods from other packages.
 * 4. Functionally relevant packages are created to contain the relevant classes.
 * 5. Option Set class has an inner protected class named Options - which contains
 * the various options and their prices for each Option set.
 * 6. Option Set has an array of Options as a protected variable to contain the various options
 * of each Option set.
 * 7. Option class has name and price as protected variables and relevant protected getters
 *  and setters for encapsulation.
 *  8. Having option as an inner class of OptionSet enables encapsulation by containment.
 *  9. Automobile class has an array of option sets to contain the various option sets for each
 *  automobile model.
 *  10. Automobile class has various public methods to access the instance variables as well as
 *  the protected methods of OptionSet and Option.
 *  11. StringBuffer was used to concatenate the various string to convert the options and
 *  option sets to string. This is because strings are immutable and waste lot of memory compared
 *  to StringBuffers.
 *  12. Various combinations of constructors and methods were created in automobile and OptionSet
 *  class for various CRUD (Create, Read, Update and Delete) operations for each variable and combination
 *  of variables as well as print operations.
 *  13. An input file is created to read the model information according to the user requirements.
 *  14. The input file contains the information about the model name, price, number of option sets,
 *  name of option sets, number of options and their various options with prices.
 *  15. To read the file, a FileIO class was created. This class reads the input file, tokenizes
 *  each line and stores the values in the instance variables of automobile, OptionSet and Option
 *  classes.
 *  16. This storing of variables is done without using any buffer as it may require additional
 *  memory and time.
 *  17. The lines are read and the number of option sets and number of options are stored as an 
 *  int variable and used as a counter and an index to input the array of option sets and options.
 *  18. The total number of option sets is stored as a variable and used as an index for 
 *  adding option set. Similarly, the number of options for each option set is stored as a variable
 *  and re-setted once it reaches zero. The information if optionSet name or Option name is read
 *  will be based on the counters.
 *  18. Methods are added to serialize and deserialize the automobile object.
 * 
 * VERSION 2.0
 * 1. API was designed with different packages, interfaces and abstract classes. An internal
 * and external component was designed to separate functions from functionality.
 * 2. Interfaces are being used to control access to various functionalities which would otherwise
 * be available to the end-users. This is also encapsulation using interfaces.
 * 3. BuildAuto class is written as empty class without any functionality for security. If the classes
 * were back-engineered, having BuildAuto class as empty will prevent access to functionalities
 * as the methods are defined in a proxy class.
 * 4. Delegating functionality to a proxyAutomobile class from BuildAuto is called value proposition
 * design pattern in OOP.
 * 5. The delegating proxy class is made abstract  to provide artificial security. If the classes
 * were back-engineered, having an abstract class will prevent instantiation of the class preventing
 * hacking or access to functionalities.
 * 6. The static variable in proxyAutomobile integrates functionality from across all existing classes
 * to create, print, update and delete autos.
 * 7. Making the auto variable as static in proxyAutomobile creates a singleton, where a single object
 * is used to integrate the functionality.
 * 8. BuildAuto bridges proxyAutomobile and interfaces.
 * 9. ProxyAutomobile bridges internal components to build the API.
 * 10. All the healing is centralized in one place using custom exception's class.
 * 11. Exceptions can be fixed in-line where errors occur or it can be propagated to the calling class.
 * 12. Exceptions are logged with a timestamp, error number and error messages.
 * 13. Software evolution is observed - FileIO with about 100 lines increased to 200+ lines
 * after adding 5 custom exceptions. If all the exceptions were to be fixed, the lines could
 * exceed 500 lines leading to software evolution.
 * 14. Exceptions can be thrown in 3 ways - using constructors of AutoException class,
 * using if, throw and catch and using while loop and catch.
 * 15. Making FixErrors an API would allow users to call fix methods based on the error number.
 * This is also helpful for software testers.
 * 16. The user never knows about the automobile class. It is encapsulated using interfaces.
 * 17. Machine learning is implemented using custom exceptions where exceptions are fixed by 
 * learning about the different exceptions that can occur.
 * 18. Functionally relevant packages are created to contain the relevant classes.
 * 
 * VERSION 3.0
 * 1. A fleet of automobiles can be modeled using LinkedHashMap.
 * 2. LinkedHashMap takes up the memory space of Linked List and Hash Map.
 * 3. Variable called choice in OptionSet saves the option for each option set.
 * 4. ArrayList called choices in Automobile saves an arraylist of options for the auto model.
 * 5. The option choice selected is reflected in arraylist choice, so the total
 *  price can be calculated using the choice arraylist.
 * 6. Option class is changed to a regular class from inner class. This is because inner class
 *  leads to spaghetti code and there is a requirement for option to be imported or become a
 *  regular class to be accessible in automobile class.
 * 7. Choice and ArrayList choice helps in saving the customer's preferences for a model
 * and helps in calculating the model price with the selected options.
 * 8. Changing the option sets and option array's to arraylist makes it more efficient
 * and allows to add elements to the arraylist without keeping track of indexes.
 * 9. In addition, the size of arraylist can be changed dynamically as opposed to arrays.
 * 10. Changing the option and option set to arraylist, changes the method in the fileIO
 * class to set the option and option set values to a method without using index, which makes
 * reading the file easier as there is no need to keep track of index to add the option
 * and option sets.
 * 11. Addition methods were added in the automobile and option set class to handle the arraylist
 * (arrays used indices) and also the current methods were changed to reflect the usage of arraylist.
 * 12. Methods in CreateAuto interface were changed to reflect the usage of LinkedHashMap
 * for storing auto.
 * 13. Method implementation in the proxyautomobile were changed to reflect the usage of 
 * LinkedHashMap to store auto model.
 * 14. BuildAuto is made final to prevent extending of the class.
 * 15. The use of templates enable any type of vehicle to be modeled using this program.
 * 16. To develop templates, automobile was declared abstract and the linkedhashMap object of autos
 * is a variable in a fleet class which acts as a template.
 * 17. Fleet class has a LinkedHashMap of a fleet of autos which enables instantiation of 
 * more than 1 auto object.
 * 18. Create, read, delete and update methods are added in the fleet class to enable building/reading/
 *deleting/updating  of auto objects.
 * 19. Proxyautomobile contains a fleet object which is static to coordinate the different
 * functionalities of different interfaces.
 * 20. Functionally relevant packages are created to contain the relevant classes.
 * 21. The driver of previous steps have to be run to check if the software is broken. All versions
 * should work to prevent breaking of software due to version update.
 * 
 * VERSION 4.0
 * 1.EditOptions is a class that implements multi-threading capability to the automobile
 *  building system.
 * 2.It mimics the condition where 2 users try to change the same property or price of property
 *  of the automobile at the same time.
 *  3. Multi threading allowing multiple threads to change the same property can lead to corrupted
 *  data as the threads can change the same property simultaneously and non-synchronized threads
 *  can change the property without any coordination between each other.
 *  4. An EditThread iterface was created to enable interaction between the user and the internal components
 *  like EditOptions.
 *  5. BuildAuto acts as a class that exposes the EditThread interface to the end user.
 *  6. ProxyAutomobile is the class which actually implements the EditThread interface to enable
 *  encapsulation.
 *  7. The method of the interface, instantiates an EditOptions object and passes the parameters 
 *  required to make the appropriate changes along with a thread number.
 *  8. In the EditOptions class, the parameters are stored in the appropriate variables, and a new thread
 *  is instantiated and started.
 *  9. The run method of the EditOptions class, uses a switch statement to call the method corresponding
 *  to the thread number.
 *  10. EditOptions class extends ProxyAutomobile where all the interface methods are implemented.
 *  11. EditOptions class uses the method defined in the ProxyAutomobile class to change the properties.
 *  12. EditOptions and ProxyAutomobile have a 2-way relationship, where EditOptions uses the
 *  methods of ProxyAutomobile and ProxyAutomobile uses EditOptions to implement multi-threading.
 *  The interface is used in the driver class, whose methods are defined in the ProxyAutomobile,
 *  which in turn instantiates an EditOptions object and starts the thread. The thread method 
 *  uses the methods from the ProxyAutomobile class. Thus, it is a 2-way relation.
 *  13. The methods in EditOptions are either synchronized or non-synchronized.
 *  14. Synchronized methods, use wait and notify to handle the thread so when a condition is true,
 *  the second thread would wait till the first thread releases the lock.
 *  15. In this case, the threads are instantiated using 2 different instance objects of EditOptions, this
 *  makes the object lock on fleetLock for the 2 threads and using notify will release the lock
 *  for the fleetLock object.
 *  16. Notify or NotifyAll will release the object lock of fleetLock. 
 *  The thread would run, if the condition fails after notification.
 *  17. For the condition check, since 2 different object instances run the thread, the variable is static
 *  to keep the values intact for both the threads.Also, 2 different checks are used, one to check if 
 *  another thread running the same method is active and another for thread running check between
 *  2 methods.
 *  18. The condition is true, when a thread is alive, and if the other thread is alive, the
 *  current thread waits till the other thread is completed. When a thread completes, the condition
 *  is changed to false and the second thread comes out of the wait state.
 *  19. The synchronized methods were used in EditOptions class, as it gives better control of all
 *  the internal methods used for changing the values, instead of synchronizing all the utilized methods,
 *  the parent method used for running the thread is synchronized and also gives better control
 *  of the statements inside the parent method.
 *  20. EditOptions and EditThread are in a package called scale.
 *  21. EditOptions extending ProxyAutomobile is a better choice than just importing the methods.
 *  22. The synchronized and non-synchronized methods have to be tested separately to prevent
 *  undetermined results.
 *  23. A method was added to get the fleet object which acts as an object lock for synchronization
 *  
 *
 *
 * @author vivek
 *
 */
/*
 * A driver class to test the functioning of multi-threading using synchronized and 
 * non-synchronized methods.
 * This class builds and prints an automobile. It also updates the option set name
 * and price.
 */
public class Step4_driver{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CreateAuto a1 = new BuildAuto();

		// build  the model using the interface
		a1.buildAuto("2014 Ford Focus Wagon ZTW", "Ford_focus.txt");
		a1.buildAuto("2008 Toyota Prius Two", "Toyota_Prius.txt");
		a1.buildAuto("2015 Tesla Model S", "Tesla_S.txt");

		//arrays to pass as property values
		String[] valThread12 = {"2014 Ford Focus Wagon ZTW", "Transmission", "Automatic"};
		String[] valThread3 = {"2014 Ford Focus Wagon ZTW","Power Sunroof"};
		String[] valThread4 = {"2014 Ford Focus Wagon ZTW","Power Moonroof"};

		/*
		 * The synchronized and non-synchronized methods have to be tested separately to prevent
    	undetermined results.

		 */
		//Interface to change the property values using thread

		EditThread t1 = new BuildAuto();

		//Synchronized method to change the price of the option	
		t1.updateOptionPriceThread(1,valThread12, (float) 100.0);					
		t1.updateOptionPriceThread(1,valThread12, (float) 500.0);

		//synchronized method to change option set name
		t1.updateOptionSetNameThread(2,4,valThread3);
		t1.updateOptionSetNameThread(2,4,valThread4);

		// Comment the above 2 lines and uncomment the below 4 lines to see non-synchronized behavior.		
		//Non-synchronized method to change the option set name using threads
		/*
		t1.updateOptionSetNameThread(3,4,valThread3);
		t1.updateOptionSetNameThread(3,4,valThread4);

		//Non-Synchronized method to change the price of the option	
		t1.updateOptionPriceThread(4,valThread12, (float) 100.0);					
		t1.updateOptionPriceThread(4,valThread12, (float) 500.0);

		 */


	}

}
