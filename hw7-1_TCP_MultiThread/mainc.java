import java.io.*;
import java.util.*; 

class mainc { 
public static void main(String args[])throws IOException { 

BufferedReader br;
String     str1, str2;

// initial the connection
Client C1 = new Client("127.0.0.1",1234);
Car2 car2 = new Car2(C1);
car2.start();
while(true)
{
	br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Please input a string:"); 
    str1 = br.readLine();	
	C1.send(str1);
}		


}
}