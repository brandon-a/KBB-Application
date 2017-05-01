package driver;
import adapter.*;

public class Main {

	public static void main(String[] args) {
		//Build Automobile Object from a file.
		BuildAuto FordZTW = new BuildAuto();
		FordZTW.buildAuto("Ford's Focdgfsus Wagon ZTW.txt");
		
		//Print attributes with invalid file name, check error log for details.

		System.out.println(FordZTW.printAuto("Ford's Focadfsus Wagon ZTW"));

	}

}
