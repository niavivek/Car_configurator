/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 5
Due Date : 05/31/2016
Date Submitted :06/01/2016

 */
package client;

import java.net.*;

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

 */
public class DefaultSocketClient extends Thread implements SocketClientInterface, SocketClientConstants {

	private ObjectInputStream reader;
	private ObjectOutputStream writer;
	private Socket sock;
	private String strHost;
	private int iPort;

	/*
	 * A class to handle the socket and implements method to get and send
	 * objects to/from the client. This classes uses object streams for this
	 * purpose.
	 */
	public DefaultSocketClient(String strHost, int iPort) {
		setPort(iPort);
		setHost(strHost);
	}// constructor
		// A new constructor is added to the DefaultSocketClient class to pass
		// the server socket object.

	public DefaultSocketClient(Socket sock) {
		this.sock = sock;
	}// constructor

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
			if (sock == null)// if the socket object is null create a new socket
				sock = new Socket(strHost, iPort);
		} catch (IOException socketError) {
			if (DEBUG)
				System.err.println("Unable to connect to " + strHost);
			return false;
		}
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
				System.err.println("Unable to obtain stream to/from " + strHost);
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// This handles the requirements for the socket
	public void handleSession() {
		Object objInput = "";
		if (DEBUG)
			System.out.println("Handling session with " + strHost + ":" + iPort);
		try {
			while ((objInput = reader.readObject()) != null)
				getInput();
		} catch (IOException e) {
			if (DEBUG)
				System.out.println("Handling session with " + strHost + ":" + iPort);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Error reading object from server");
		}
	}

	// This method send the output using object streams
	public void sendOutput(Object objOutput) {
		if (DEBUG)
			System.out.println("Sending object");
		try {
			writer.writeObject(objOutput);
			writer.flush();// flush the stream to avoid remnants
		} catch (IOException e) {
			if (DEBUG)
				System.out.println("Error writing to " + strHost);
		}
	}

	public Object getInput() {
		// get the object stream to read object from server
		try {
			return reader.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Error reading object from server");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error reading object from server");
		}
		return new Object();
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
			if (DEBUG)
				System.out.println("Closed Client");
		} catch (IOException e) {
			if (DEBUG)
				System.err.println("Error closing socket to " + strHost);
		}
	}

	public void setHost(String strHost) {
		this.strHost = strHost;
	}

	public void setPort(int iPort) {
		this.iPort = iPort;
	}

}// class DefaultSocketClient
