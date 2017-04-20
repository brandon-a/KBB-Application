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
	
	public void serializeObject(Automotive auto, String fileName){
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
	
	public Automotive deSerializeObject(String fileName){
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
			try {
				Automotive auto = (Automotive)in.readObject();
				in.close();
				return auto;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
