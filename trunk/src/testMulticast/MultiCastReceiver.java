package testMulticast;

import java.io.IOException;
import java.net.DatagramPacket;
//import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;

public class MultiCastReceiver {
	public static void main(String args[]) throws IOException {
		
		//Counter c = Counter.getInstance();
		int id = 2;
		InetAddress group = InetAddress.getByName("230.0.0.1");
		MulticastSocket socket = new MulticastSocket(6789);
		socket.joinGroup(group);

		// get their responses!
		byte[] buf = new byte[1000];
		DatagramPacket recv = new DatagramPacket(buf, buf.length);
		socket.receive(recv);
		System.out.println("receieved "+id+":"+new String(recv.getData()));
		
		// OK, I'm done talking - leave the group...
		//socket.leaveGroup(group);
			
		try{
			Thread.sleep(1000);
		} catch (InterruptedException e){
			e.printStackTrace();
		} 		
	}
}
