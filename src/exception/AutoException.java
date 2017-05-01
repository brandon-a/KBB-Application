package exception;
import java.io.FileWriter;
import java.io.IOException;

import exception.FileExceptionHelper;

public class AutoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public enum errorType {
		FILE_NOT_FOUND(1, "File not found."),
		BASE_PRICE_MISSING(2, "Base price missing."),
		NUM_OPTIONSETS_MISSING(3, "The number of optionsets is missing from the file."),
		NUM_OPTIONS_MISSING(4, "The number of options are missing from the file."),
		TOTAL_PRICE_MISSING(5, "The total price of the Auto is missing.");
		
		
		
		public int errno;
		public String msg;
		
		private errorType(int errno, String msg){
			this.errno = errno;
			this.msg = msg;
		}
	}
	
	private errorType errID;
	private String errMsg;
	
	
	//getters
	public errorType getErrID() {return errID;}
	public String getErrMsg() {return errMsg;}
	//setters
	public void setErrID(errorType errID) {this.errID = errID;}
	public void setErrMsg(String errMsg) {this.errMsg = errMsg;}
	
	public AutoException() {}
	
	public AutoException(errorType errID, String errMsg) {
		this.errID = errID; 
		this.errMsg = errMsg;
	}
	
	public String fix(){
		if(errID.errno > 0 && errID.errno < 101){
			FileExceptionHelper fileEx = new FileExceptionHelper();
			switch(errID){
			case FILE_NOT_FOUND: return fileEx.fix1();
			case BASE_PRICE_MISSING: return fileEx.fix2();
			case NUM_OPTIONSETS_MISSING: return fileEx.fix3();
			case NUM_OPTIONS_MISSING: return fileEx.fix4();
			case TOTAL_PRICE_MISSING: return fileEx.fix5();
			default:
				break;
			}
		}
		return null;
	}
	
	
	
	public void log(String logFile){
		try {
			FileWriter outFile = new FileWriter(logFile, true);
			outFile.write(errID.toString() + " - " + errMsg + "\n");
			outFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
