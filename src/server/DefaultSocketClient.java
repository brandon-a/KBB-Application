package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Properties;

import model.Automobile;
import util.FileIO;

public class DefaultSocketClient extends Thread {

	Socket sock;
	
	public DefaultSocketClient(Socket client){
		sock = client;
	}
	
	public void run(){
		ObjectInputStream inputStream;
		ObjectOutputStream outputStream;
		try {
			FileIO file = new FileIO();
			outputStream = new ObjectOutputStream(sock.getOutputStream());
			inputStream = new ObjectInputStream(sock.getInputStream());
			Properties inputProp = (Properties) inputStream.readObject();
			Automobile auto = file.buildAutoObjectFromPropFile(inputProp);
			String returnString = auto.getMake() + " " + auto.getModel() + " " + auto.getYear() + " successfully created.";
			outputStream.writeObject(returnString);
			outputStream.writeObject(auto);
		} catch (IOException | ClassNotFoundException e1) {
			System.out.println("Failed to read in uploaded object.");
			e1.printStackTrace();
		}
		
	}

	
}
