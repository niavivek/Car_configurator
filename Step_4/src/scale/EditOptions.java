/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 4
Due Date : 05/20/2016
Date Submitted :05/21/2016

 */
package scale;

import adapter.ProxyAutomobile;

/*EditOptions and EditThread are in a package called scale.
 * This is a class to implement multi-threading capability to the automobile building system.
 * It mimics the condition where 2 users try to change the same property or price of property
    of the automobile at the same time.
 *Multi threading allowing multiple threads to change the same property can lead to corrupted
    data as the threads can change the same property simultaneously and non-synchronized threads
    can change the property without any coordination between each other.
 * EditOptions class extends ProxyAutomobile where all the interface methods are implemented.
 * EditOptions and ProxyAutomobile have a 2-way relationship, where EditOptions uses the
    methods of ProxyAutomobile and ProxyAutomobile uses EditOptions to implement multi-threading.
    The interface is used in the driver class, whose methods are defined in the ProxyAutomobile,
    which in turn instantiates an EditOptions object and starts the thread. The thread method 
    uses the methods from the ProxyAutomobile class. Thus, it is a 2-way relation.
 * The synchronized methods were used in EditOptions class, as it gives better control of all
    the internal methods used for changing the values, instead of synchronizing all the utilized methods,
    the parent method used for running the thread is synchronized and also gives better control
    of the statements inside the parent method.


 */
public class EditOptions extends ProxyAutomobile implements Runnable {
	// EditOptions extending ProxyAutomobile is a better choice than just
	// importing the methods.

	// variables to store the properties of the fleet automobile
	private String model;
	private String opSetName;
	private String optionName;
	private float price;
	private String opSetNewName;
	private int index;
	// variable to store the thread number
	private int op;
	// thread to run the methods
	private Thread a;

	// For the condition check, since 2 different object instances run the
	// thread,
	// the variable is static to keep the values intact for both the threads.

	private static boolean t1Alive = false;
	private static boolean t2Alive = false;

	/*
	 * In the EditOptions class, the parameters are stored in the appropriate
	 * variables, and a new thread is instantiated and started.
	 * 
	 */
	// constructors for creating the object
	public EditOptions(int op, int index, String[] values) {
		this.op = op;
		a = new Thread(this);
		model = values[0];
		opSetNewName = values[1];
		this.index = index;
		a.start();
	}

	public EditOptions(int op, String[] values, float price) {
		this.op = op;
		a = new Thread(this);
		model = values[0];
		opSetName = values[1];
		optionName = values[2];
		this.price = price;
		a.start();
	}

	/*
	 * The run method of the EditOptions class, uses a switch statement to call
	 * the method corresponding to the thread number.
	 */
	public void run() {
		synchronized (this) {
			switch (op) {
			case 1:
				t1Alive = true;
				thread1();
				break;

			case 2:
				t2Alive = true;
				thread2();
				break;
			case 3:
				thread3();
				break;

			case 4:
				thread4();
				break;
			}
		}
	}
	// These methods uses the method defined in the ProxyAutomobile class to
	// change the properties.
	// The methods in EditOptions are either synchronized or non-synchronized.

	/*
	 * Synchronized methods, use wait and notify to handle the thread so when a
	 * condition is true, the second thread would wait till the first thread
	 * releases the lock.
	 * 
	 * In this case, the threads are instantiated using 2 different instance
	 * objects of EditOptions, this makes the object lock separate for the 2
	 * threads and using notify will not release the lock for the other object.
	 * So, a wait method with a time is introduced, so after the time, the
	 * condition is checked again to further proceed or wait.
	 * 
	 * 
	 */
	// Synchronized method to update price of an option of option set
	private synchronized void thread1() {

		while (t2Alive) {
			try {
				/*
				 * The condition is true, when a thread is alive, and if the
				 * other thread is alive, the current thread waits till the
				 * other thread is completed. When a thread completes, the
				 * condition is changed to false and the second thread comes out
				 * of the wait state.
				 * 
				 */
				wait(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Entering thread1.");

		System.out.println("Updating price");
		// updates the property
		updateOptionPrice(model, opSetName, optionName, price);

		System.out.println("Exiting thread1.");
		// printAuto(model);
		t1Alive = false;
		notifyAll();// Notify or NotifyAll becomes irrelevant here due to the
		// use of wait(1) in the condition
		// as apposed to wait(). The thread would run, if the condition fails.

	}

	// Synchronized method to update price of an option of option set
	private synchronized void thread2() {

		while (t1Alive) {
			try {
				/*
				 * The condition is true, when a thread is alive, and if the
				 * other thread is alive, the current thread waits till the
				 * other thread is completed. When a thread completes, the
				 * condition is changed to false and the second thread comes out
				 * of the wait state.
				 * 
				 */
				wait(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Entering thread2.");

		System.out.println("Updating price");
		// updates the property
		updateOptionPrice(model, opSetName, optionName, price);

		System.out.println("Exiting thread2.");
		// printAuto(model);
		t2Alive = false;
		notifyAll();// Notify or NotifyAll becomes irrelevant here due to the
		// use of wait(1) in the condition
		// as apposed to wait(). The thread would run, if the condition fails.
		printAuto(model);
	}

	// Non-synchronized method to update option set name - no waiting for other
	// threads to complete
	private void thread3() {

		System.out.println("Entering thread3.");

		System.out.println("Updating Option name");
		// updates the property
		updateOptionSetNameByIndex(model, index, opSetNewName);

		System.out.println("Exiting thread3.");
		// printAuto(model);

	}

	// Non-synchronized method to update option set name- no waiting for other
	// threads to complete
	private void thread4() {

		System.out.println("Entering thread4.");

		System.out.println("Updating Option name");
		// updates the property
		updateOptionSetNameByIndex(model, index, opSetNewName);

		System.out.println("Exiting thread4.");
		// printAuto(model);
	}

}
