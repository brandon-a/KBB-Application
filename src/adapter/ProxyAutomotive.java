package adapter;
import exception.AutoException;
import model.*;
import util.FileIO;

public abstract class ProxyAutomotive {

	private static Automobile auto = new Automobile();
	private static FileIO fileIO = new FileIO();
	private static AutoException autoEx = new AutoException();
	public void buildAuto(String fileName) {try {
		auto = fileIO.buildAutoObject(fileName);
	} catch (AutoException e) {
		try {
			auto = fileIO.buildAutoObject(e.fix());
		} catch (AutoException e1) {
			e1.log("errorLog.txt");
		}
		e.log("errorLog.txt");
	}}
	public Automobile getAuto() {return auto;}
	public String printAuto(String modelName) {return auto.toString();}
	public void updateOptionSetName(String Modelname, String OptionSetname, String newName) {auto.updateOptionSetName(OptionSetname, newName);}
	public void updateOptionPrice(String Modelname, String OptionName, String Option, double newPrice) {auto.updateOptionPrice(OptionName, Option, newPrice);}
	public void updateOptionName(String optionSetName, String oldName, String newName) {auto.updateOptionName(optionSetName, oldName, newName);}
	public String fix() {return autoEx.fix();}
}
