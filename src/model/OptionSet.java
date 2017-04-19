//Brandon Archbold
//CIS 35B

package model;

//OptionSet class contains an array of options.
public class OptionSet {

	//instance variables
	private String name = "NULL";
	private Double costOfSelection = -1.0;
	private Option[] optionArr;
	private int arrSize = -1;
	private int selection = -1;
	
	//Default constructor
	OptionSet() {}
	
	//Constructor
	OptionSet(String name, Option[] options){
		this.name = name;
		optionArr = options;
		arrSize = options.length;
	}
	
	//getters
	protected String getName() {return name;}
	protected double getCost() {return costOfSelection;}
	protected int getNumOptions() {return arrSize;}
	protected int getCurrSelection() {return selection;}
	
	//setters
	protected void setName(String name) {this.name = name;}
	protected void setCost(double cost) {costOfSelection = cost;}
	protected void setOptions(String options){
		String[] namNOptions = options.split(":");
		name = namNOptions[0];
		String[] optionSArr = namNOptions[1].split(", ");
		int length = optionSArr.length;
		int j = 0;
		while(optionArr[j] != null){
			for(int i = 0; i < length; i+=2){
				optionArr[j].setSelection(optionSArr[i]);
				optionArr[j].setCost(Double.parseDouble(optionSArr[i+1]));
				j++;
			}
		}
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
		for(int i = 0; i < arrSize; i++){
			temp.append(optionArr[i].toString());
		}
		return temp.toString();
	}
	
	//Option class that contains one selection each
	protected class Option {
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
			return temp.toString();
		}
	}
}
