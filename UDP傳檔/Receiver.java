import java.io.*;
import java.net.*;

public class Receiver {
    int i;
    public Receiver() {
        try{
            byte[] buffer = new byte[1024];

            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            DatagramSocket ds = new DatagramSocket(8000);

            FileOutputStream fos = new FileOutputStream("copy.mp3");

            ds.receive(p);
            byte[] data = p.getData();
            //fos.write(buffer,0,buffer.length);
            i=1;
            while(p.getLength()>=1024) {
                System.out.println("data.length="+data.length);
                System.out.println("buffer.length="+buffer.length);
                System.out.println("PACKET.length="+p.getLength());
                System.out.println("====> i="+i);
                fos.write(data,0,p.getLength());
                ds.receive(p);
                data = p.getData();
                i++;
            }
            fos.write(data,0,p.getLength());
            fos.close();
        }
        catch(IOException e){
            System.out.println("IOException when connecting Server!");
        }
    }

    public static void main(String args[]) {

        Receiver ClientStart=new Receiver();
    }
}
