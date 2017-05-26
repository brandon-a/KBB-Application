package driver;
import adapter.*;
import scale.EditOptions;

public class Main {

	public static void main(String[] args) {
		//Build Automobile Object from a file.
		String fileName = "Ford's Focus Wagon ZTW.txt";
		BuildAuto autos = new BuildAuto();
		String key = "2003-Ford-Focus Wagon ZTW";
		
		autos.buildAuto(fileName);
		
		EditOptions e1 = new EditOptions(autos, key, "Transmission", "manual");
		EditOptions e2 = new EditOptions(autos, key, "Brakes/Traction Control", "ABS with Advanced Trac");
		
		e1.start();
		e2.start();
		
		//Print attributes with invalid file name, check error log for details.

		System.out.println(autos.printAuto(key));

	}

}
