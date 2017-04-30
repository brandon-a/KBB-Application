package adapter;

public interface UpdateAuto {

	public void updateOptionSetName(String Modelname, String OptionSetname, String newName);
	public void updateOptionPrice(String Modelname, String OptionName, String Option, double newPrice);
	public void updateOptionName(String optionSetName, String oldName, String newName);
}
