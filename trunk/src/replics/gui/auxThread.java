package replics.gui;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class auxThread extends Thread{
	
	String URL;
	
	public void run(){

		try {
	         ServerSocket srvr = new ServerSocket(1234);
	         Socket skt = srvr.accept();
	         System.out.print("Server has connected!\n");
	         System.out.print("Waiting for information!\n");
	         
	         BufferedReader in = new BufferedReader(new
	         InputStreamReader(skt.getInputStream()));
	         
	         while (!in.ready()) {}
	         System.out.print("Received URL: ");
	         System.out.println(URL=in.readLine()); // Read one line and output it

	         System.out.print("\n");
	         in.close();
	                 
	         skt.close();
	         srvr.close();
	      }
	      catch(Exception e) {
	         System.out.print("Whoops! It didn't work!\n");
	      }
	}
	
	public String getURL(){
		return URL;
	}

}
