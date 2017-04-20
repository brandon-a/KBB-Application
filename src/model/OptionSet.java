//Brandon Archbold
//CIS 35B

package model;

import java.io.Serializable;

//OptionSet class contains an array of options.
public class OptionSet implements Serializable {

	private static final long serialVersionUID = 1L;
	//instance variables
	private String name = "NULL";
	private Double costOfSelection = -1.0;
	private Option[] optionArr = new Option[50];
	private int selection = -1;
	private int optPos = 0;
	
	//Default constructor
	OptionSet() {
		for(int i = 0; i < optionArr.length; i++){
			optionArr[i] = new Option();
		}
	}
	
	//Constructor
	OptionSet(String name, Option[] options){
		this.name = name;
		optionArr = options;
	}
	
	//getters
	protected String getName() {return name;}
	protected double getCost() {return costOfSelection;}
	protected int getCurrSelection() {return selection;}
	protected Option[] getOptionArr() {return optionArr;}
	
	//Finds an option and returns its location.
	protected int findOption(String name){
		for(int i = 0; i < optionArr.length; i++){
			if(name.equalsIgnoreCase(optionArr[i].getSelection())){
				System.out.println(name + " was found at location " + i + ".");
				return i;
			}	
		}
		System.out.println(name + " not found.");
		return -1;
	}
	
	protected void updateOptionPrice(String name, double newPrice){
		optionArr[findOption(name)].setCost(newPrice);
	}
	
	protected void updateOptionName(String oldName, String newName){
		optionArr[findOption(oldName)].setSelection(newName);
	}
	
	//setters
	protected void setName(String name) {this.name = name;}
	protected void setCost(double cost) {costOfSelection = cost;}
	protected void setOption(String option){
		String[] namNOptions = option.split(":");
		name = namNOptions[0];
		String[] optionSArr = namNOptions[1].split(", ");
		int length = optionSArr.length;
		for(int i = 0; i < length; i+=2){
			optionArr[optPos].setSelection(optionSArr[i]);
			optionArr[optPos].setCost(Double.parseDouble(optionSArr[i+1]));
			optPos++;
			}
	}
	
	protected void deleteOption(int location){
		if(location >= 0 && location < 50 && optionArr[location].getCost() != -1.0){
			optionArr[location].setSelection("NULL");
			optionArr[location].setCost(-1.0);
			System.out.println("Option " + location + " successfully deleted.");
		}
		else
			System.out.println(location + " is not a valid location to delete.");
	}
	
	//Allows calls to this function to choose the desired option for the car.
	protected void selectOption(int choice){
		selection = choice;
		costOfSelection = optionArr[selection].getCost();
	}
	
	//Converts the object to a string and returns that String.
	public String toString() {
		StringBuilder temp = new StringBuilder(name);
		temp.append(":");
		for(int i = 0; i < optionArr.length; i++){
			if(!optionArr[i].getSelection().equals("NULL"))
				temp.append(optionArr[i].toString());
		}
		return temp.toString();
	}
	
	//Option class that contains one selection each
	protected class Option implements Serializable {
		private static final long serialVersionUID = 1L;
		Option() {}
		//instance variables
		private String selection = "NULL";
		private Double cost = -1.0;
		//constructor
		Option(String name, Double price) {selection = name; cost = price;}
		//getters
		protected String getSelection() {return selection;}
		protected Double getCost() {return cost;}
		//setters
		protected void setSelection(String name) {selection = name;}
		protected void setCost(Double cost) {this.cost = cost;}
		//converts the object to a string
		public String toString() {
			StringBuilder temp = new StringBuilder(selection);
			temp.append(", ");
			temp.append(cost);
			temp.append(", ");
			return temp.toString();
		}
	}
}
