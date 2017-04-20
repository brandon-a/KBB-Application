package driver;
import model.*;
import util.*;

public class Main {

	public static void main(String[] args) {
		//Build Automobile Object from a file.
		FileIO file = new FileIO();
		Automotive FordZTW = file.buildAutoObject("Ford's Focus Wagon ZTW.txt");
		
		//Print attributes before serialization

		System.out.println(FordZTW.toString());

		//Serialize the object

		file.serializeObject(FordZTW, "Ford_ZTW.dat");

		//Deserialize the object and read it into memory.

		Automotive newFordZTW = file.deSerializeObject("Ford_ZTW.dat");

		//Print new attributes.

		System.out.println(newFordZTW.toString());

	}

}
