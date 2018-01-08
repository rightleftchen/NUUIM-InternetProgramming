import java.io.*;
import java.net.*;

public class UDP_S{ 
  public UDP_S() throws IOException
  {
    Sender_S S = new Sender_S("127.0.0.1",8000);
	S.send("hellow");
  }
  public static void main(String args[]) throws IOException {
       UDP_S sen=new UDP_S();
  }
}

