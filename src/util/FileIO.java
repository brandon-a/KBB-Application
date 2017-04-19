package util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import model.Automotive;

public class FileIO {

	public FileIO(){}
	
	//Reads the file line by line and returns an array of strings.
	public String[] buildAutoObject(String fileName){
		java.io.File inFile = new java.io.File(fileName);
		String fileArr[] = new String[50];
		Scanner scanner;
		int lineNum = 0;
		try {
			scanner = new Scanner(inFile);
			while(scanner.hasNext()){
				String input = scanner.nextLine();
				if(input != null){
					fileArr[lineNum] = input;
				}
				else
					System.out.println("Error reading line #" + lineNum + " in the file, continuing to read data...");
				lineNum++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return fileArr;
	}
	private void test(String fileName){
		try {
				FileReader file = new FileReader(fileName);
				BufferedReader buff = new BufferedReader(file);
				boolean eof = false;
				Automotive tAuto = new Automotive();
				while (!eof) {
					String line = buff.readLine();
					if (line == null)
						eof = true;
					else{
						if(line.startsWith("Option:")){
							String tString = line.substring(7);
							optionsArr[i].setOptions(tString);
						}
						else{
							tAuto.setModel(line);
						}
					}
				}
				buff.close();
			} catch (IOException e) {
				System.out.println("Error нн " + e.toString());
			}
	}

}
