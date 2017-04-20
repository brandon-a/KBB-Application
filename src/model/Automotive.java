//Brandon Archbold
//CIS 35B

package model;
import java.io.Serializable;

import util.FileIO;

public class Automotive implements Serializable {

	private static final long serialVersionUID = 1L;
	private String model = "NULL";
	private double basePrice = -1.0;
	private double totalPrice = -1.0;
	private OptionSet[] optionsArr = new OptionSet[50]; 
	private int optPos = 0;
	
	//Automotive Constructor
	public Automotive() {
		for(int i = 0; i < optionsArr.length; i++){
			optionsArr[i] = new OptionSet();
		}
	};
	//Constructor with model name price and optionset
	public Automotive(String model, double price, OptionSet[] options){
		this.model = model;
		basePrice = price;
		optionsArr = options;
	}
	
	public String getModel() {return model;}
	public double getBasePrice() {return basePrice;}
	public double gettotalPrice() {return totalPrice;}
	public OptionSet getOptionSet(int choice) {return optionsArr[choice];}
	
	public void setModel(String model) {this.model = model;}
	public void setBasePrice(double price) {basePrice = price;}
	//takes a string and creates an optionSet
	public void setOption(String line) {
		optionsArr[optPos].setOption(line);
		optPos++;
	}
	public void setSpecificOptionSet(int i, String name){
		
	}
	
	
	public void updateOptionSetName(String originalName, String newName){
		optionsArr[findOptionSet(originalName)].setName(newName);
	}
	
	public void updateOptionPrice(String optionSetName, String name, int newPrice){
		optionsArr[findOptionSet(optionSetName)].updateOptionPrice(name, newPrice);
	}
	
	public void updateOptionName(String optionSetName, String oldName, String newName){
		optionsArr[findOptionSet(optionSetName)].updateOptionName(oldName, newName);
	}
	
	//Finds an option location given the name of the option
	public int findOptionSet(String input){
		for(int i = 0; i < optionsArr.length; i++){
			if(input.equalsIgnoreCase(optionsArr[i].getName())){
				System.out.println(input + " was found at location " + i + ".");
				return i;
			}	
		}
		System.out.println(input + " not found.");
		return -1;
	}
	
	public int findOption(int optionSetLocation, String option){
		return optionsArr[optionSetLocation].findOption(option);
	}
	
	public void deleteOptionSet(int location){
		if(location >= 0 && location < 50 && optionsArr[location].getCost() != -1.0){
			optionsArr[location].setName("NULL");
			optionsArr[location].setCost(-1.0);
			for(int i = 0; i < optionsArr[location].getOptionArr().length; i++)
				optionsArr[location].deleteOption(i);
			optionsArr[location].selectOption(-1);
			System.out.println("Option " + location + " successfully deleted.");
		}
		else
			System.out.println(location + " is not a valid location to delete.");
	}
	
	//Converts the object into a string
	public String toString() {
		StringBuilder temp = new StringBuilder("Name:");
		temp.append(model);
		temp.append("\nBase:");
		temp.append(basePrice);
		temp.append("\n");
		for(int i = 0; i < optionsArr.length; i++){
			if(!optionsArr[i].getName().equals("NULL")){
				temp.append(optionsArr[i].toString());
				temp.append("\n");
			}
		}
		return temp.toString();
	}
	

}
