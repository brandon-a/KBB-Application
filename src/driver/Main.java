package driver;
import java.util.Properties;

import adapter.*;
import scale.EditOptions;
import server.Server;

public class Main {

	public static void main(String[] args) {
		//Build Automobile Object from a file.
		String fileName = "Ford's Focus Wagon ZTW.prop";
		String fileName2 = "Tesla Model S.prop";
		String fileName3 = "Chevy Suburban.prop";
		BuildAuto autos = new BuildAuto();
		String key = "2003 Ford Focus Wagon ZTW";
		
		autos.buildAuto(fileName);
		autos.buildAuto(fileName2);
		autos.buildAuto(fileName3);
		
		//System.out.println(autos.getAvalibleModels());
		
		//System.out.println(autos.getAuto(key));
		
		Server server = new Server();
		server.run();
	
		
		//Print attributes with invalid file name, check error log for details.


	}

}
