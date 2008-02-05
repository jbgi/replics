package replics.fake.client;
import java.io.PrintWriter;
import java.net.Socket;

class Client {
   public static void main(String args[]) {
      try {
         
    	 String data = "C:/Users/GiN/Desktop/PICS/elBus.jpg";
    	 
    	 Socket skt = new Socket("localhost", 1234);
         
         PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
         System.out.print("Sending string: '" + data + "'\n");
         out.print(data);
         out.close();
      }
      catch(Exception e) {
         System.out.print("Whoops! It didn't work!\n");
      }
   }
}