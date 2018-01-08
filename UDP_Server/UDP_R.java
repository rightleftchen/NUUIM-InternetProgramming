import java.io.*;
import java.net.*;

public class UDP_R{ 
  public UDP_R() throws IOException
  {
    Receiver_S R = new Receiver_S(8000);
	String str = R.receive();
	System.out.println(">>>>"+str);
  }
  public static void main(String args[]) throws IOException {
       UDP_R rec=new UDP_R();
  }
}
