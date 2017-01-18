/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 5
Due Date : 05/31/2016
Date Submitted :06/01/2016

 */
package client;

import java.net.*;
import java.util.ArrayList;
import java.util.Properties;

import model.Automobile;

import java.io.*;

/* A new sub-class for DefaultSocketClient class was created to override the handlesession
 *  method to incorporate the things needed for the client-server interaction.
 *  
 *   Two sets of projects are created identically with additional client/server side for each client and
 server side. This helps in keeping the sessions separate and data corruption. This also prevents
 client side to see the objects in the server side unless explicitly send by the server and vice-versa.
 Thus, a model can be configured on the client side without passing/ storing on the server side.
 */
public class ClientDSC extends DefaultSocketClient {
	// variables to store the state of the thread
	private static final int MENU = 1;
	private static final int UPLOADING = 2;
	private static final int SELECTING = 3;
	private static final int CHOOSING = 4;
	private static final int CHECK = 5;
	private static final int QUIT = 6;


	// when starting the thread, the state is uploading
	private int state = MENU;
	private String selectAutoName;

	private CarModelOptionsIO obj1 = new CarModelOptionsIO();
	private SelectCarOption select = new SelectCarOption();

	public ClientDSC(String strHost, int iPort) {
		super(strHost, iPort);
	}// constructor

	public ClientDSC(Socket sock) {
		super(sock);

	}

	// this overrides the DefaultSocketClient handlesession method
	public void handleSession() {
		if (DEBUG)
			System.out.println("Running Client");
		// get a bufferedreader object for the console output
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// continue the session until the connection is closed
		while (true) {
			switch (state) {
			// 
			case MENU:
				/*
				 * Display a menu to user and prompt for an entry
				 */
				System.out.println("Enter 1 to upload a file");
				System.out.println("Enter 2 to configure a car");
				String reply;
				try {
					reply = in.readLine();
					if (reply.equals("1")) {
						state = UPLOADING;
					}
					if (reply.equals("2")) {
						state = SELECTING;
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				break;
			case UPLOADING:
				//if the state is uploading, get a property file name and serialize
				// and
				// send it to the server using the load function, CarModelOptionsIO
				// is used
				// to serialize the file.
				// The property object is send to the server and the success message
				// from the
				// server is received and displayed.
				super.sendOutput("UPLOADING");
				System.out.println("Enter the properties file name");

				String fileName;
				try {
					fileName = in.readLine();
					if (fileName != null) {

						Properties prop = obj1.readPropFile(fileName);
						super.sendOutput(prop);
						System.out.println("Waiting for upload status");
						Object success = getInput();
						String val = (String) success;
						if (val.equals("Success"))
							System.out.println("Upload successfull");
						else
							System.out.println("Upload not successfull");
					}
					// based on the user response, change the states and break
					// the loop
					// to switch case again
					state = CHECK;
					break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.err.println("Error reading/writing file");
					super.sendOutput("QUIT");
				}
				/*
				 * if the state is selecting, get an arraylist of all the models
				 * from the server and prompt user to select a model for
				 * configuration
				 */
			case SELECTING:
				/*
				 * If the state is to configure a car, get all models from the server
				 * and display the names and prompt for an entry, when an entry is made,
				 *chsnge the state to choosing
				 */
				System.out.println("Do you want to configure a car?Y or N");
				ArrayList<String> inputFromServer;
				try {
					if ((in.readLine()).equalsIgnoreCase("y")) {
						System.out.println("Getting all models");
						super.sendOutput("ALLMODELS");
						Object objFromServer1 = getInput();
						inputFromServer = (ArrayList<String>) objFromServer1;
						if (inputFromServer.size() == 0) {
							System.out.println("No auto found");
							state = CHECK;
						}

						else {
							System.out.println("Please select the model");

							// display all models
							for (int i = 1; i <= inputFromServer.size(); i++)
								System.out.println("Enter " + i + " to select " + inputFromServer.get(i - 1));

							// based on the user response, change the states and
							// break
							// the
							// loop
							// to switch case again

							int autoNum = Integer.parseInt(in.readLine());
							selectAutoName = inputFromServer.get(autoNum - 1);

							state = CHOOSING;
						}
					} else {
						state = CHECK;
					}
					break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.err.println("Error reading/writing model");
					super.sendOutput("QUIT");
				}

				/*
				 * if the state is choosing, get the selected auto object from
				 * the server and display all the option sets and their options
				 * and prompt for configuring the model, use SelectCarOption
				 * class to configure and display the configured auto
				 */
			case CHOOSING:
				super.sendOutput("CHOOSING");
				super.sendOutput(selectAutoName);
				System.out.println("Please select the options");

				Object objFromServer2 = getInput();
				Automobile auto = (Automobile) objFromServer2;
				select.selectOption(auto);
				System.out.println("Enter Y to display choices");
				// based on the user response, change the states and break the
				// loop
				// to switch case again
				try {
					String response = in.readLine();
					if (response.equals("Y") || response.equals("y")) {
						select.displaySelection(auto);

						state = SELECTING;
					} else {
						state = CHECK;
					}
					break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.err.println("Error reading/writing automobile");
					super.sendOutput("QUIT");
				}
				// if the state is quit, then close the session
			
			case CHECK:
				/*
				 * To check what the user wants to do
				 */
				System.out.println("Do you want to upload a file?Y or N");
				String response2;
				try {
					response2 = in.readLine();

					if (response2.equalsIgnoreCase("Y")) {
						state = UPLOADING;
					} else {
						System.out.println("Do you want to quit?Y or N");
						String response3 = in.readLine();
						if (response3.equalsIgnoreCase("Y"))
							state = QUIT;
						else {
							state = SELECTING;
						}
					}
					break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			case QUIT:
				//when the state is to quit, close the session
				//send a message to server to close the connection
				super.sendOutput("QUIT");
				System.out.println("Exiting program");
				return;
			default:
				// close the session
				//send a message to server to close the connection
				super.sendOutput("QUIT");
				System.out.println("Exiting program");
				return;
			}

		}

	}

}
