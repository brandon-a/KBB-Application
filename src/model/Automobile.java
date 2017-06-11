//Brandon Archbold
//CIS 35B

package model;
import java.io.Serializable;
import java.util.ArrayList;

public class Automobile implements Serializable {

	private static final long serialVersionUID = 1L;
	private String make = "NULL";
	private String model = "NULL";
	private int year;
	private double basePrice = -1.0;
	private double totalPrice = -1.0;
	private ArrayList<OptionSet> optionsArr; 
	private int optPos = 0;
	
	//Automotive Constructor
	public Automobile() {};
	//Constructor with model name price and optionset
	public Automobile(String model, double price, ArrayList<OptionSet> options){
		this.model = model;
		basePrice = price;
		optionsArr = options;
	}
	
	public String getModel() {return model;}
	public double getBasePrice() {return basePrice;}
	public double gettotalPrice() {return totalPrice;}
	public OptionSet getOptionSet(int choice) {return optionsArr.get(choice);}
	public String getMake() {return make;}
	public int getYear() {return year;}
	
	public synchronized void setYear(int year) {this.year = year;}
	public synchronized void setMake(String make) {this.make = make;}
	public synchronized void setModel(String model) {this.model = model;}
	public synchronized void setBasePrice(double price) {basePrice = price; totalPrice = price;}
	public synchronized void setOptionSetSize(int size) {
		optionsArr = new ArrayList<OptionSet>(size);
		for(int i = 0; i < size; i++){
			optionsArr.add(new OptionSet());
		}
	}
	//takes a string and creates an optionSet
	public synchronized void setOption(String line) {
		optionsArr.get(optPos).setOption(line);
		optPos++;
	}
	
	public synchronized void setOptionProp(String line){
		optionsArr.get(optPos).setOptionProp(line);
		optPos++;
	}
	
	public synchronized void updateOptionSetName(String originalName, String newName){
		optionsArr.get(findOptionSet(originalName)).setName(newName);
	}
	
	public synchronized void updateOptionPrice(String optionSetName, String name, double newPrice){
		optionsArr.get(findOptionSet(optionSetName)).updateOptionPrice(name, newPrice);
	}
	
	public synchronized void updateOptionName(String optionSetName, String oldName, String newName){
		optionsArr.get(findOptionSet(optionSetName)).updateOptionName(oldName, newName);
	}
	
	//allows the user to select an option
	public synchronized void chooseOptionChoice(String optionSetName, String optionName){
		int setNum = findOptionSet(optionSetName);
		optionsArr.get(setNum).setOptionChoice(optionName);
		totalPrice += optionsArr.get(setNum).getCost();
	}
	
	//Finds an option location given the name of the option
	public int findOptionSet(String input){
		for(int i = 0; i < optionsArr.size(); i++){
			if(input.equalsIgnoreCase(optionsArr.get(i).getName())){
				System.out.println(input + " was found at location " + i + ".");
				return i;
			}	
		}
		System.out.println(input + " not found.");
		return -1;
	}
	
	//finds a specific option given an optionset and a name
	public int findOption(int optionSetLocation, String option){
		return optionsArr.get(optionSetLocation).findOption(option);
	}
	
	//deletes an option set and all of it's contents
	public synchronized void deleteOptionSet(int location){
		if(location >= 0 && location < 50 && optionsArr.get(location).getCost() != -1.0){
			optionsArr.get(location).setName("NULL");
			optionsArr.get(location).setCost(-1.0);
			for(int i = 0; i < optionsArr.get(location).getOptionArr().size(); i++)
				optionsArr.get(location).deleteOption(i);
			optionsArr.get(location).selectOption(-1);
			System.out.println("Option " + location + " successfully deleted.");
		}
		else
			System.out.println(location + " is not a valid location to delete.");
	}
	
	//Converts the object into a string
	public String toString() {
		StringBuilder temp = new StringBuilder("Make:");
		temp.append(make);
		temp.append("\nModel:");
		temp.append(model);
		temp.append("\nYear:");
		temp.append(year);
		temp.append("\nBase:");
		temp.append(basePrice);
		temp.append("\nTotal Price:");
		temp.append(totalPrice);
		temp.append("\n");
		for(int i = 0; i < optionsArr.size(); i++){
			if(!optionsArr.get(i).getName().equals("NULL")){
				temp.append(optionsArr.get(i).toString());
				temp.append("\n");
			}
		}
		return temp.toString();
	}
	

}
