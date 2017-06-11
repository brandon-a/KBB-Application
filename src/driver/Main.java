package driver;
import adapter.*;
import scale.EditOptions;
import server.Server;

public class Main {

	public static void main(String[] args) {
		//Build Automobile Object from a file.
		String fileName = "Ford's Focus Wagon ZTW.txt";
		BuildAuto autos = new BuildAuto();
		String key = "2003-Ford-Focus Wagon ZTW";
		
		autos.buildAuto(fileName);
		
		Server server = new Server();
		server.run();
	
		
		//Print attributes with invalid file name, check error log for details.


	}

}
