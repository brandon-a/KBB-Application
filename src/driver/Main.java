package driver;
import model.*;
import util.*;

public class Main {

	public static void main(String[] args) {
		//Build Automobile Object from a file.
		FileIO file = new FileIO();
		Automotive FordZTW = file.buildAutoObject("Ford's Focus Wagon ZTW.txt");
		System.out.println(FordZTW.toString());

		//Print attributes before serialization

		//FordZTW.print();

		//Serialize the object

		//Lab1.autoutil.FileIO.serializeAuto(FordZTW);

		//Deserialize the object and read it into memory.

		//Automobile newFordZTW = Lab1.autoutil.FileIO.DeserializeAuto("auto.ser");

		//Print new attributes.

		//newFordZTW.print();

	}

}
