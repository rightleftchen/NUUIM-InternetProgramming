import java.io.*;
import java.net.*;

public class Client {
    Socket socket;
    DataOutputStream  outstream;
    DataInputStream  instream;
    String messagein;
    BufferedReader br;
    static String messageout;
    static String servername;
    static int port;
    public Client() {
        try{
            socket=new Socket(InetAddress.getByName(servername),port);
            outstream = new DataOutputStream(socket.getOutputStream());
            instream=new DataInputStream(socket.getInputStream());
            br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("Client : ");
                messageout = br.readLine();
                outstream.writeUTF(messageout);
                // read the message from server
                messagein = instream.readUTF();
                System.out.println("Server : " + messagein);
            }
            //socket.close();
        }

        catch(IOException e){
            System.out.println("IOException when connecting Server!");
        }
    }
    //------------------------------------------------------------------------------
    public static void main(String args[]) {
        /*if (args.length < 3){
            System.out.println("USAGE: java Client3 127.0.0.1 1234 response");
            System.exit(1);
        }

        servername= args[0];
        port=Integer.parseInt(args[1]);
        messageout = args[2];*/
        servername = "127.0.0.1";
        port = 1234;
        messageout = "Sorry, I'm late.";
        Client ClientStart=new Client();
    }
}




