package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Properties;

import adapter.BuildAuto;
import model.Automobile;
import util.FileIO;

public class DefaultSocketClient extends Thread {

	Socket sock;
	BuildAuto tAuto = new BuildAuto();
	
	public DefaultSocketClient(Socket client){
		sock = client;
	}
	
	public void run(){
		ObjectInputStream inputStream;
		ObjectOutputStream outputStream;
		try {
			
			outputStream = new ObjectOutputStream(sock.getOutputStream());
			inputStream = new ObjectInputStream(sock.getInputStream());
		} catch (IOException e1) {
			System.out.println("Failed to get socket streams.");
			e1.printStackTrace();
			return;
		}
		String command;
		try {
			command = (String) inputStream.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		switch(command){
		case "display models":
			try {
				outputStream.writeObject(tAuto.getAvalibleModels());
			} catch (IOException e) {
				System.out.println("Error sending or getting models!");
				return;
			}
			break;
		case "get options":
			String model;
			try {
				model = (String) inputStream.readObject();
				Automobile auto = tAuto.getAuto(model);
				outputStream.writeObject(auto);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		
		/*FileIO file = new FileIO();
		Properties inputProp = (Properties) inputStream.readObject();
		Automobile auto = file.buildAutoObjectFromPropFile(inputProp);
		String returnString = auto.getMake() + " " + auto.getModel() + " " + auto.getYear() + " successfully created.";
		outputStream.writeObject(returnString);
		outputStream.writeObject(auto);*/
		
	}

	
}
