/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 5
Due Date : 05/31/2016
Date Submitted :06/01/2016

 */
/**An empty class which handles the methods using interfaces and abstract class.
 * It hides all the method implementation by extending an abstract class which in-turn implements
 * all the interface methods.
 * 

 * @author Nia vivek
 * @version 1.0
 */
package adapter;

import scale.EditThread;

/*
 * BuildAuto is made final to prevent extending of the class.
 * This class implements all the interfaces and encapsulates Automobile class.
 * The methods in the automobile class is delegated to BuildAuto through proxyautomobile.
 * BuildAuto bridges proxyAutomobile and interfaces.
 * Delegating functionality to a proxyAutomobile class from BuildAuto is called value proposition
 * design pattern in OOP.
 * BuildAuto acts as a class that exposes the EditThread interface to the end user.
 */
public final class BuildAuto extends ProxyAutomobile
		implements CreateAuto, EditThread, UpdateAuto, FixAuto, CustomizeAuto {
	/*
	 * Empty class which handles all the methods using interfaces and abstract
	 * class.
	 *
	 * BuildAuto class is written as empty class without any functionality for
	 * security. If the classes were back-engineered, having BuildAuto class as
	 * empty will prevent access to functionalities as the methods are defined
	 * in a proxy class.
	 * 
	 */
}
