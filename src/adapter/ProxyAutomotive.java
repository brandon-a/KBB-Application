package adapter;
import model.*;
import util.FileIO;

public abstract class ProxyAutomotive {

	private static Automotive auto;
	private static FileIO fileIO;
	
	public void buildAuto(String fileName) {auto = fileIO.buildAutoObject(fileName);}
	public void printAuto(String modelName) {}
	public void updateOptionSetName(String Modelname, String OptionSetname, String newName) {}
	public void updateOptionPrice(String Modelname, String Optionname, String Option, float newprice) {}
}
