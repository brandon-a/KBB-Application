package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	ServerSocket serverSocket = null;
	
	public Server(){
		
		try{
			serverSocket = new ServerSocket(4444);
			System.out.println("New socket opened on port: 4444");
		} catch (IOException e) {
			System.err.println("Clould not listen on port: 4444.");
			System.exit(1);
		}
	}
	
	public void run() {
		while(true){
			Socket client;
			DefaultSocketClient clientThread;
			try {
				client = serverSocket.accept();
				clientThread = new DefaultSocketClient(client);
				clientThread.start();
				System.out.println("Connection successfully established from: " + client.getInetAddress());
			} catch (IOException e) {
				System.out.println("Server failed to accept connection from client.");
				e.printStackTrace();
			}
		}
	}
	
}
