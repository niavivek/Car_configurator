/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 5
Due Date : 05/31/2016
Date Submitted :06/01/2016

 */
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import adapter.BuildAuto;
import model.Automobile;
import model.Option;
import model.OptionSet;

//use SelectCarOption class to configure and display the configured auto
/*
 *  The configuration of the auto object is done on the
 *client side without any interaction from the server. The auto object is stored locally on the client
 *side and displayed. For this purpose, 2 projects one for client and another for server is used.
 */
public class SelectCarOption {
	// prompts the user to select the options
	public void selectOption(Automobile auto) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// displays the options for each option set
		ArrayList<OptionSet> opSets = auto.getOpset();
		for (int i = 0; i < opSets.size(); i++) {
			System.out.println("Select " + auto.getOpsetNameByIndex(i));
			ArrayList<String> options = auto.getOptnameOfOpSet(opSets.get(i));
			for (int j = 1; j <= options.size(); j++) {
				System.out.println("Enter " + j + " to select " + options.get(j - 1));
			}
			String optionSelect;
			// based on the selection, set the choices for each option set
			try {
				optionSelect = in.readLine();
				int value = Integer.parseInt(optionSelect);
				auto.setOptionChoice(auto.getOpsetNameByIndex(i), options.get(value - 1));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// display the selected options and the total price
	public void displaySelection(Automobile auto) {
		System.out.println("The Configured options are");
		auto.printChoiceAndPrice();
	}

}
