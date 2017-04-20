package model;
import java.io.Serializable;

import util.FileIO;

public class Automotive implements Serializable {

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
	public Automotive(String model, double price, String options){
		/*FileIO file = new FileIO();
		this.model = model;
		basePrice = price;
		parseString(file.readFile("Ford's Focus Wagon ZTW.txt"));*/
	}
	
	public String getModel() {return model;}
	public double getBasePrice() {return basePrice;}
	public double gettotalPrice() {return totalPrice;}
	public OptionSet[] getOptionSet() {return optionsArr;}
	
	public void setModel(String model) {this.model = model;}
	public void setBasePrice(double price) {basePrice = price;}
	public void setOption(String line) {
		optionsArr[optPos].setOption(line);
		optPos++;
	}
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
