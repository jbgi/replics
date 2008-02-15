package testMulticast;

import java.io.IOException;
import java.net.DatagramPacket;
//import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;

public class MultiCastThread extends Thread {
	
	private int id;
	private String msg;
	
	int loopIndex; 
	
	public MultiCastThread(int id, String msg) {
		this.id = id;
		this.msg = msg;
		loopIndex = 0;
	}
	public MultiCastThread(int id) {
		this.id = id;
		this.msg = "";
		loopIndex = 0;
	}
	
	public void run() {
		try {
			receive();
			//send();
			//receive();
			//send();
		} 
		catch(Exception e) {
			System.err.println("erreur send or receive:"+e.getMessage());
		}
		
	}
	
	public void send() throws IOException {
		InetAddress group = InetAddress.getByName("230.0.0.1");
		MulticastSocket socket = new MulticastSocket(6789);
		socket.joinGroup(group);
		// join a Multicast group and send the group salutations
		DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(),
		                             group, 6789);
		System.out.println("sent said "+id+":"+(loopIndex++)+" :"+new String(packet.getData()));
		socket.send(packet);
		//return new String(packet.getData());
		receive();
	}
	
	public void receive() throws IOException {
		InetAddress group = InetAddress.getByName("230.0.0.1");
		MulticastSocket socket = new MulticastSocket(6789);
		socket.joinGroup(group);
		// get their responses!
		byte[] buf = new byte[1000];
		DatagramPacket recv = new DatagramPacket(buf, buf.length);
		socket.receive(recv);
		msg = new String(recv.getData())+"-> "+recv.getSocketAddress().toString();
		System.out.println("receieved said "+id+":"+msg);	
		// OK, I'm done talking - leave the group...
		socket.leaveGroup(group);
		//return new String(recv.getData());		
		send();
	}
	
	public static void main(String[] args) {
		
		MultiCastThread mct1 = new MultiCastThread(1, new Date().toString());
		MultiCastThread mct2 = new MultiCastThread(2, new Date().toString());
		mct1.start();
		mct2.start();
		
		//MultiCastThread mct = new MultiCastThread(new Date().toString());
		/*
		MultiCastThread m[] = new MultiCastThread[20];
		int p = 0;
		for(int i=0; i<20;i++) {
			m[i] = new MultiCastThread("String :"+p++);
			m[i].start();
			//p++;
		}
		*/
	}
}

