package util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import model.Automotive;

public class FileIO implements Serializable {
	private static final long serialVersionUID = 1L;

	public FileIO(){}
	
	//Reads the file line by line and returns an array of strings.
	public Automotive buildAutoObject(String fileName){
		Automotive tAuto = new Automotive();
		try {
				FileReader file = new FileReader(fileName);
				BufferedReader buff = new BufferedReader(file);
				boolean eof = false;
				while (!eof) {
					String line = buff.readLine();
					if (line == null)
						eof = true;
					else{
						if(line.startsWith("Option:")){
							String tString = line.substring(7);
							tAuto.setOption(tString);
						}
						else if(line.startsWith("Base:")){
							tAuto.setBasePrice(Double.parseDouble(line.substring(5)));
						}
						else if(line.startsWith("Name:")){
							tAuto.setModel(line.substring(5));
						}
					}
				}
				buff.close();
			} catch (IOException e) {
				System.out.println("Error нн " + e.toString());
				return null;
			}
		return tAuto;
		
	}
	
}
