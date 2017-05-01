//Brandon Archbold
//CIS 35B

package util;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import exception.AutoException;
import model.Automobile;

public class FileIO implements Serializable {
	private static final long serialVersionUID = 1L;

	public FileIO(){}
	
	//Reads the file line by line and returns an array of strings.
	public Automobile buildAutoObject(String fileName) throws AutoException{
		Automobile tAuto = new Automobile();
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
						else if(line.startsWith("Model:")){
							tAuto.setModel(line.substring(6));
						}
						else if(line.startsWith("NumOptionSet:")){
							tAuto.setOptionSetSize(Integer.parseInt(line.substring(13)));
						}
					}
				}
				buff.close();
			} catch (FileNotFoundException e) {
				throw new AutoException(AutoException.errorType.FILE_NOT_FOUND, "File not found, please check the path and file name.");
			} catch (IOException e) {
				System.out.println("Error " + e.toString());
				return null;
			} 
		return tAuto;
		
	}
	
	
	public void serializeObject(Automobile auto, String fileName){
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
			out.writeObject(auto);
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Automobile deSerializeObject(String fileName){
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
			try {
				Automobile auto = (Automobile)in.readObject();
				in.close();
				return auto;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
