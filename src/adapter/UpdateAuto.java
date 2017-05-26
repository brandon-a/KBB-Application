package adapter;

public interface UpdateAuto {

	public void updateOptionSetName(String fileName, String Modelname, String OptionSetname, String newName);
	public void updateOptionPrice(String fileName, String Modelname, String OptionName, String Option, double newPrice);
	public void updateOptionName(String fileName, String optionSetName, String oldName, String newName);
}
