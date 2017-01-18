/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 5
Due Date : 05/31/2016
Date Submitted :06/01/2016

 */
package client;

//interface to handle session for default socket client
public interface SocketClientInterface {
	boolean openConnection();

	void handleSession();

	void closeSession();
}
