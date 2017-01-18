/*
 * Name : Nianthrini Vivekanandan
Class and Section : CIS 35B De Anza -Java programming
Assignment Number : Lab 4
Due Date : 05/20/2016
Date Submitted :05/21/2016

 */
/**
 * 


 */
package model;

import java.io.Serializable;
/*
 * Option was a protected inner class in the first version. This was done to encapsulate
 * the option and its method from other classes. This was encapsulation with containment.
 * In Version 3.0, Automobile class contains an Arraylist of Options called choice to store
 * the selections of the user for a particular model. This requires importing the Option class
 * into the automobile class. This can be avoided by making Option a regular class. This would
 * also prevent the spaghetti code from usage of inner classes.
 */
public class Option implements Serializable {
	// private instance variables
	private String name;
	private float price;
	//combination of methods for getting and setting various instance variables
	//Option class has name and price as protected variables and relevant protected getters
	//and setters for encapsulation.

	// no-arg constructor
	protected Option() {

	}

	// different combination constructors
	protected Option(String name1) {
		this.name = name1;
	}

	protected Option(float price) {
		this.price = price;
	}

	protected Option(String name1, float price) {
		this.name = name1;
		this.price = price;
	}

	// getters and setters for private variables
	// get option name
	protected String getName() {
		return name;
	}

	// set option name
	protected void setName(String name1) {
		this.name = name1;
	}

	// get option price
	protected float getPrice() {
		return price;
	}

	// set option price
	protected void setPrice(float price) {
		this.price = price;
	}

}