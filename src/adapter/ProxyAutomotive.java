package adapter;
import java.util.LinkedHashMap;

import exception.AutoException;
import model.*;
import util.FileIO;

public abstract class ProxyAutomotive {

	private static Automobile auto = new Automobile();
	private LinkedHashMap<String, Automobile> vehicles = new LinkedHashMap<String, Automobile>();
	private static FileIO fileIO = new FileIO();
	private static AutoException autoEx = new AutoException();
	public void buildAuto(String fileName) {try {
		auto = fileIO.buildAutoObject(fileName);
		vehicles.put(fileName, auto);
	} catch (AutoException e) {
		try {
			auto = fileIO.buildAutoObject(e.fix());
		} catch (AutoException e1) {
			e1.log("errorLog.txt");
		}
		e.log("errorLog.txt");
	}}
	public Automobile getAuto(String fileName) {return vehicles.get(fileName);}
	public String printAuto(String fileName) {return vehicles.get(fileName).toString();}
	public void updateOptionSetName(String fileName, String Modelname, String OptionSetname, String newName) {vehicles.get(fileName).updateOptionSetName(OptionSetname, newName);}
	public void updateOptionPrice(String fileName, String Modelname, String OptionName, String Option, double newPrice) {vehicles.get(fileName).updateOptionPrice(OptionName, Option, newPrice);}
	public void updateOptionName(String fileName, String optionSetName, String oldName, String newName) {vehicles.get(fileName).updateOptionName(optionSetName, oldName, newName);}
	public String fix() {return autoEx.fix();}
}
