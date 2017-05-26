package adapter;
import java.util.LinkedHashMap;

import exception.AutoException;
import model.*;
import util.FileIO;

public abstract class ProxyAutomotive {

	private static Automobile auto = new Automobile();
	private static LinkedHashMap<String, Automobile> vehicles = new LinkedHashMap<String, Automobile>();
	private static FileIO fileIO = new FileIO();
	private static AutoException autoEx = new AutoException();
	
	
	public void buildAuto(String fileName) {try {
		auto = fileIO.buildAutoObject(fileName);
		StringBuilder key = new StringBuilder();
		key.append(auto.getYear());
		key.append("-");
		key.append(auto.getMake());
		key.append("-");
		key.append(auto.getModel());
		vehicles.put(key.toString(), auto);
	} catch (AutoException e) {
		try {
			auto = fileIO.buildAutoObject(e.fix());
		} catch (AutoException e1) {
			e1.log("errorLog.txt");
		}
		e.log("errorLog.txt");
	}}
	public Automobile getAuto(String key) {return vehicles.get(key);}
	public String printAuto(String key) {
		try{
		return vehicles.get(key).toString();
		} catch (NullPointerException e){
			return "Key not found! Cannot find specified car with Key Value: " + key;
		}
		}
	public synchronized void chooseOption(String key, String optionSetName, String optionName) {
		try{
			vehicles.get(key).chooseOptionChoice(optionSetName, optionName);
		} catch (NullPointerException e){
			System.out.println("Key not found! Cannot find specified car with Key Value: " + key);
		}
	}
	public void updateOptionSetName(String key, String Modelname, String OptionSetname, String newName) {vehicles.get(key).updateOptionSetName(OptionSetname, newName);}
	public void updateOptionPrice(String key, String Modelname, String OptionName, String Option, double newPrice) {vehicles.get(key).updateOptionPrice(OptionName, Option, newPrice);}
	public void updateOptionName(String key, String optionSetName, String oldName, String newName) {vehicles.get(key).updateOptionName(optionSetName, oldName, newName);}
	public String fix() {return autoEx.fix();}
}
