package testMulticast;

import java.io.IOException;
import java.util.Date;

public class MultiCastSender extends Thread {
	String msg;
	int id;
	int port;
	String address;
	
	public MultiCastSender(int i, String m, String ad, int p) {
		id=i; msg=m; port=p; address=ad;
	}
	
	public void run() {
		try {
			while(true) {
				MultiCastTools.send(id, msg, address, port);
				sleep(10000);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		new MultiCastSender(0,new Date().toString(),"230.0.0.1",6789).start();
	}
}
