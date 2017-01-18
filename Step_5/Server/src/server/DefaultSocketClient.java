/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 5
Due Date : 05/31/2016
Date Submitted :06/01/2016

 */
package server;

import java.net.*;
import java.util.ArrayList;
import java.util.Properties;

import adapter.BuildAuto;

import java.io.*;

/*
 * A class to handle the socket and implements method to get and send objects to/from the client.
 * This classes uses object streams for this purpose. This class is designed so that it extends
 * thread and can handle multiple threads without data corruption on its own.
 * The output stream has to opened and flushed to send all the object stream out without any remnants.
 * Then the input stream has to be opened, this is due to how the streams are designed.
 * The streams are opened as soon as the connection is opened. Then when the thread starts,
 * the session is handled based on the requirement.
 * This class can also send and receive objects and also close the session, once the program exits.

 *   Two sets of projects are created identically with additional client/server side for each client and
 server side. This helps in keeping the sessions separate and data corruption. This also prevents
 client side to see the objects in the server side unless explicitly send by the server and vice-versa.
 Thus, a model can be configured on the client side without passing/ storing on the server side.

 */
public class DefaultSocketClient extends Thread implements SocketClientInterface, SocketClientConstants {
	/*
	 * A class to handle the socket and implements method to get and send
	 * objects to/from the client. This classes uses object streams for this
	 * purpose. This class calls methods from BuildCarModelOptions to get the
	 * models, automobile object and to parse properties file
	 */
	private ObjectInputStream reader;
	private ObjectOutputStream writer;
	private Socket sock;
	private AutoServer auto1 = new BuildAuto();

	// A new constructor is added to the DefaultSocketClient class to pass
	// the server socket object.

	public DefaultSocketClient(Socket sock) {
		// TODO Auto-generated constructor stub
		this.sock = sock;
	}

	public void run() {
		if (openConnection()) {
			handleSession();
			closeSession();
		}
	}// run

	public boolean openConnection() {
		/*
		 * The streams are opened as soon as the connection is opened. Then when
		 * the thread starts, the session is handled based on the requirement.
		 */

		try {
			/*
			 * The output stream has to opened and flushed to send all the
			 * object stream out without any remnants. Then the input stream has
			 * to be opened, this is due to how the streams are designed.
			 */
			writer = new ObjectOutputStream(sock.getOutputStream());
			writer.flush();
			reader = new ObjectInputStream(sock.getInputStream());

		} catch (Exception e) {
			if (DEBUG)
				System.err.println("Server: Unable to obtain stream to/from host");
			return false;
		}
		return true;
	}

	// This handles the requirements for the socket
	public void handleSession() {
	String response;
		while (true)// continue until close session
		{
			// get the object from the client side and store it as an object
			
			Object objFromClient = getInput();
			// cast the object to a string
			if(objFromClient == null)
				response = "QUIT";
			else
			response = (String) objFromClient;
			if (DEBUG)
				System.out.println("Running Server");
			// instantiate an buildcarmodeloptions object
				
			switch (response) {
			case "UPLOADING":
				// if the object is a property, cast it to properties
				// use the buildcarmodeloptions class to parse the object to
				// create
				// auto object and send a success message to the client
				Object propFile = getInput();
				Properties prop = (Properties) propFile;
				if (prop != null) {
					if(auto1.createAutoObjectProp(prop))
					{
					System.out.println("File successfully created");
					sendOutput("Success");
					}
					else
						sendOutput("Fail");
				}
				break;
			case "ALLMODELS":
				// if the value is to get all models, get all the models using
				// the
				// BuildCarModelOptions object and send the auto names to the
				// client
				ArrayList<String> autoNames = auto1.getAllAutos();
				System.out.println("Sending all models to Client");
				sendOutput(autoNames);
				break;
			case "CHOOSING":
				String value = (String) getInput();
				if (auto1.getAuto(value) != null) {
					// get the auto object using the BuildCarModelOptions method
					// and send
					// the auto object to the client
					System.out.println("Sending selected auto to Client");
					sendOutput(auto1.getAuto(value));
				}
				break;
			case "QUIT":
				// if the value is to quit, then quit the session
				closeSession();
				return;
			default:
				closeSession();
				return;
			}
		}

	}

	// This method send the output using object streams
	public void sendOutput(Object objOutput) {
		if (DEBUG)
			System.out.println("Handling session with host");
		try {
			writer.writeObject(objOutput);
			writer.flush();// flush the stream to avoid remnants
		} catch (IOException e) {
			if (DEBUG)
				System.out.println("Server: Error writing to host");
			closeSession();// close the session if any error occurs
		}
	}

	public Object getInput() {
		// get the object stream to read object from client
		try {
			if(reader != null)//if client is closed, the reader is null-then terminate the socket
			return reader.readObject();
			else 
				return null;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Error reading object from client");
			closeSession();// close the session if any error occurs
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error reading object from client");
			closeSession();// close the session if any error occurs
			return null;
		}
	}

	public void handleInput(String strInput) {
		System.out.println(strInput);
	}

	// closes the session and the object streams to avoid leakage
	public void closeSession() {
		try {
			writer = null;
			reader = null;
			sock.close();
		} catch (IOException e) {
			if (DEBUG)
				System.err.println("Error closing socket to host");
		}
	}

}
