/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 5
Due Date : 05/31/2016
Date Submitted :06/01/2016

 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;

import adapter.BuildAuto;
import model.Automobile;

/*
 * This class implements the autoserver interface and creates an object using buildauto class.
 * Then uses the methods implemented in proxyautomobile class to get the appropriate objects/values.
 *This class is instantiated in the server to build the auto object, get the models and auto object
 *from the automobile class.
 *
 *This class also implements the methods of HandleServer interface to handle the server starting and closing operations
 *through the proxyautomobile class
 */
public class BuildCarModelOptions implements AutoServer,HandleServer {

	private AutoServer auto1 = new BuildAuto();
	private ServerSocket serverSocket = null;
	private Socket proxySocket = null;

	// method to create an auto from the properties object
	public boolean createAutoObjectProp(Properties prop) {
		// TODO Auto-generated method stub

		return auto1.createAutoObjectProp(prop);
	}

	// method to get all the model names
	@Override
	public ArrayList<String> getAllAutos() {
		// TODO Auto-generated method stub
		return auto1.getAllAutos();
	}

	// method to get the automobile object
	@Override
	public Automobile getAuto(String modelName) {
		// TODO Auto-generated method stub
		return auto1.getAuto(modelName);
	}
	/*
,		The socket from accept method is
	 *  passed to the client socket class of the server side defaultsocketclass 
	 *  and start the thread.
	 */
	@Override
	public void startServer(int port) {
		// TODO Auto-generated method stub
		 // This method instantiate the server socket class, 
		 // the server socket accepts a request from the client and returns a socket
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.err.println("Could not listen on port: "+port);
			System.exit(1);
		}

		DefaultSocketClient clientSocket = null;
		while (true) {
			try {
				// pass the server socket to a socket and then pass that socket
				// to
				// the client socket
				proxySocket = serverSocket.accept();
				clientSocket = new DefaultSocketClient(proxySocket);
				clientSocket.start();
			} catch (IOException e) {
				System.err.println("Accept failed.");
				System.exit(1);
			}

		}
	}
//this method closes the serversocket
	@Override
	public void terminateServer() {
		// TODO Auto-generated method stub
		try {
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
