import java.net.*;
import java.io.*;
import java.util.*;
public class Sender {
    FileInputStream    fis;
    int i;
    public Sender(){
        try{
            DatagramPacket pack;
            byte[] buffer = new byte[1024];

            DatagramSocket socket = new DatagramSocket();

            fis = new FileInputStream("a.mp3");

            i=fis.read(buffer, 0, 1024);
            while(i>0) {
                System.out.println("read = "+i);
                pack = new DatagramPacket(buffer, i, InetAddress.getByName("127.0.0.1"), 8000);
                socket.send(pack);
                i = fis.read(buffer,0,1024);
                try {
                    Thread.sleep(5); // 延遲 10 ms 以免掉封包
                } catch (Exception e) { }
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String args[]){
        Sender ServerStart=new Sender();
    }
}
