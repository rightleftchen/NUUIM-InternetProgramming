import java.io.*;
import java.util.*; 

class mains { 
public static void main(String args[])throws IOException { 

BufferedReader br;
String   str1, str2;

// initial the connection
Server S1 = new Server(1234);
S1.accept();
Car car1 = new Car(S1);
car1.start();


while(true)
{
	br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Please input a string:"); 
    str1 = br.readLine();	
	S1.send(str1);
}

}
}