package testMulticast;

import java.io.IOException;
import java.net.DatagramPacket;
//import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;

public class MultiCastReceiver extends Thread {
	String msg;
	int id;
	int port;
	String address;
	
	public MultiCastReceiver(int i, String ad, int p) {
		msg=""; id=i; address=ad; port=p;
	}
	
	public void run() {
		try {
			while(true) {
				msg = MultiCastTools.receive(id, address, port);
				MultiCastTools.send(id, msg, address, port);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		new MultiCastReceiver(1, "230.0.0.1", 6789);
	}
	
}
