package adapter;
import model.*;
import util.FileIO;

public abstract class ProxyAutomotive {

	private static Automobile auto = new Automobile();
	private static FileIO fileIO = new FileIO();
	public void buildAuto(String fileName) {auto = fileIO.buildAutoObject(fileName);}
	public String printAuto(String modelName) {return auto.toString();}
	public void updateOptionSetName(String Modelname, String OptionSetname, String newName) {auto.updateOptionSetName(OptionSetname, newName);}
	public void updateOptionPrice(String Modelname, String OptionName, String Option, double newPrice) {auto.updateOptionPrice(OptionName, Option, newPrice);}
	public void updateOptionName(String optionSetName, String oldName, String newName) {auto.updateOptionName(optionSetName, oldName, newName);}
}
