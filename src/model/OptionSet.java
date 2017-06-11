//Brandon Archbold
//CIS 35B

package model;

import java.io.Serializable;
import java.util.ArrayList;

//OptionSet class contains an array of options.
public class OptionSet implements Serializable {

	private static final long serialVersionUID = 1L;
	//instance variables
	private String name = "NULL";
	private Double costOfSelection = -1.0;
	private ArrayList<Option> optionArr;
	private int selection = -1;
	private int optPos = 0;
	
	//Default constructor
	OptionSet() {}
	
	//Constructor
	OptionSet(String name, ArrayList<Option> options){
		this.name = name;
		optionArr = options;
	}
	
	//getters
	protected String getName() {return name;}
	protected double getCost() {return costOfSelection;}
	protected int getCurrSelection() {return selection;}
	protected ArrayList<Option> getOptionArr() {return optionArr;}
	protected Option getOptionChoice() {
		if(selection != -1){
			return optionArr.get(selection);
		}
		else
			return null;
	}
	
	//Finds an option and returns its location.
	protected int findOption(String name){
		for(int i = 0; i < optionArr.size(); i++){
			if(name.equalsIgnoreCase(optionArr.get(i).getSelection())){
				System.out.println(name + " was found at location " + i + ".");
				return i;
			}	
		}
		System.out.println(name + " not found.");
		return -1;
	}
	
	protected void updateOptionPrice(String name, double newPrice){
		optionArr.get(findOption(name)).setCost(newPrice);
	}
	
	protected void updateOptionName(String oldName, String newName){
		optionArr.get(findOption(oldName)).setSelection(newName);
	}
	
	//setters
	protected void setOptionChoice(String optionName) {
		selection = findOption(optionName);
		costOfSelection = optionArr.get(selection).getCost();
		}
	protected void setName(String name) {this.name = name;}
	protected void setCost(double cost) {costOfSelection = cost;}
	protected void setOption(String option){
		String[] namNOptions = option.split(":");
		name = namNOptions[1];
		int arrSize = Integer.parseInt(namNOptions[0]);
		optionArr = new ArrayList<Option>(arrSize);		// sets the size of the OptionsArr
		for(int i = 0; i < arrSize; i++){
			optionArr.add(new Option());
		}
		String[] optionSArr = namNOptions[2].split(", ");
		int length = optionSArr.length;
		for(int i = 0; i < length; i+=2){
			optionArr.get(optPos).setSelection(optionSArr[i]);
			optionArr.get(optPos).setCost(Double.parseDouble(optionSArr[i+1]));
			optPos++;
			}
	}
	
	protected void setOptionProp(String option){
		String[] namNOptions = option.split(":");
		name = namNOptions[0];
		int arrSize = namNOptions.length;
		optionArr = new ArrayList<Option>(arrSize);		// sets the size of the OptionsArr
		String[] optionSArr = namNOptions[1].split(", ");
		int length = optionSArr.length;
		for(int i = 0; i < length; i++){
			optionArr.add(new Option());
		}
		optPos = 0;
		for(int i = 0; i < length; i+=2){
			optionArr.get(optPos).setSelection(optionSArr[i]);
			optionArr.get(optPos).setCost(Double.parseDouble(optionSArr[i+1]));
			optPos++;
			}
	}
	
	protected void createOptionArr(){
		for(int i = 0; i < optionArr.size(); i++){
			optionArr.add(new Option());
		}
	}
	
	protected void deleteOption(int location){
		if(location >= 0 && location < 50 && optionArr.get(location).getCost() != -1.0){
			optionArr.get(location).setSelection("NULL");
			optionArr.get(location).setCost(-1.0);
			System.out.println("Option " + location + " successfully deleted.");
		}
		else
			System.out.println(location + " is not a valid location to delete.");
	}
	
	//Allows calls to this function to choose the desired option for the car.
	protected void selectOption(int choice){
		selection = choice;
		costOfSelection = optionArr.get(selection).getCost();
	}
	
	//Converts the object to a string and returns that String.
	public String toString() {
		StringBuilder temp = new StringBuilder(name);
		temp.append(":");
		for(int i = 0; i < optionArr.size(); i++){
			if(!optionArr.get(i).getSelection().equals("NULL"))
				temp.append(optionArr.get(i).toString());
		}
		return temp.toString();
	}
	
}
