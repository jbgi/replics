package testMulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MultiCastTools {

	public static void send(int id, String msg, String address, int port) throws IOException {
		InetAddress group = InetAddress.getByName(address);
		MulticastSocket socket = new MulticastSocket(port);
		socket.joinGroup(group);
		// join a Multicast group and send the group salutations
		DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(),
		                             group, 6789);
		System.out.println("sent to "+address+":"+"+by "+id+" :"+new String(packet.getData()));
		socket.send(packet);
	}
	
	public static String receive(int id, String address, int port) throws IOException {
		InetAddress group = InetAddress.getByName(address);
		MulticastSocket socket = new MulticastSocket(port);
		socket.joinGroup(group);
		// get their responses!
		byte[] buf = new byte[1000];
		DatagramPacket recv = new DatagramPacket(buf, buf.length);
		socket.receive(recv);
		String msg = new String(recv.getData())+"-> "+recv.getSocketAddress().toString();
		System.out.println("receieved "+id+":"+msg);	
		// OK, I'm done talking - leave the group...
		socket.leaveGroup(group);
		
		return msg;
	}
}
