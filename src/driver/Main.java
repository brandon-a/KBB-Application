package driver;
import java.util.LinkedHashMap;

import adapter.*;
import model.Automobile;

public class Main {

	public static void main(String[] args) {
		//Build Automobile Object from a file.
		BuildAuto FordZTW = new BuildAuto();
		FordZTW.buildAuto("Ford's Focus Wagon ZTW.txt");
		LinkedHashMap<String, Automobile> vehicles = new LinkedHashMap<String, Automobile>(3);
		vehicles.put("Ford's Focus Wagon ZTW.txt", FordZTW.getAuto());
		vehicles.put("Ford's Focus Wagon ZTW.txt", FordZTW.getAuto());
		
		
		//Print attributes with invalid file name, check error log for details.

		System.out.println(FordZTW.printAuto("Ford's Focadfsus Wagon ZTW"));

	}

}
