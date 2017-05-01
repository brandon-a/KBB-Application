package exception;

public class FileExceptionHelper {

	public FileExceptionHelper() {}
	
	public String fix1(){
		//Returns default file name for file not found.
		return "Ford's Focus Wagon ZTW.txt";
	}
	
	public String fix2(){
		// returns a default value of zero which can be converted to a double
		return "0";
	}
	
	public String fix3() {
		return "Num OptionSets missing, please fix the file.";
	}

	public String fix4() {
		return "Num options missing from file, please fix the file.";
	}

	public String fix5() {
		return "Total price of Auto has not been set.";
	}
	
}
