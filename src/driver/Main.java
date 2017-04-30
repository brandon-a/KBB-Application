package driver;
import adapter.*;

public class Main {

	public static void main(String[] args) {
		//Build Automobile Object from a file.
		BuildAuto FordZTW = new BuildAuto();
		FordZTW.buildAuto("Ford's Focus Wagon ZTW.txt");
		
		//Print attributes before serialization

		System.out.println(FordZTW.printAuto("Ford's Focus Wagon ZTW"));

		//Print new attributes.

		System.out.println(FordZTW.printAuto("Ford's Focus Wagon ZTW"));

	}

}
