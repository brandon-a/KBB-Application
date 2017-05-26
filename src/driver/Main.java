package driver;
import adapter.*;

public class Main {

	public static void main(String[] args) {
		//Build Automobile Object from a file.
		String fileName = "Ford's Focus Wagon ZTW.txt";
		BuildAuto FordZTW = new BuildAuto();
		FordZTW.buildAuto(fileName);
		FordZTW.buildAuto(fileName);
		FordZTW.buildAuto(fileName);
		
		//Print attributes with invalid file name, check error log for details.

		System.out.println(FordZTW.printAuto(fileName));

	}

}
