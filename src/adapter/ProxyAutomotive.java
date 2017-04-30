package adapter;
import model.*;
import util.FileIO;

public abstract class ProxyAutomotive {

	private static Automotive auto;
	private static FileIO fileIO;
	
	public void buildAuto(String fileName) {auto = fileIO.buildAutoObject(fileName);}
	public void printAuto(String modelName) {auto.toString();}
	public void updateOptionSetName(String Modelname, String OptionSetname, String newName) {auto.updateOptionSetName(OptionSetname, newName);}
	public void updateOptionPrice(String Modelname, String OptionName, String Option, double newPrice) {auto.updateOptionPrice(OptionName, Option, newPrice);}
	public void updateOptionName(String optionSetName, String oldName, String newName) {auto.updateOptionName(optionSetName, oldName, newName);}
}
