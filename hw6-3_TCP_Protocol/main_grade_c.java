import java.net.*;
import java.io.*;

class main_grade_c {
    public static void main(String args[])throws IOException {
        Client C1;
        String ip="127.0.0.1";
        int port=1234;
        String messagein;
        int over;

        C1 = new Client(ip, port);

        over=0;
        while(over==0)
        {
            messagein=C1.receive();
            String s1=messagein.substring(0, 1);
            String s2=messagein.substring(1, messagein.length());

            System.out.print(s2);

            if(s1.equals("1"))
            { System.out.println();}

            if(s1.equals("2"))
            {
                BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
                messagein = br.readLine();
                C1.send(messagein);
            }

            if(s1.equals("3"))
            {
                over=1;
            }
        }
        C1.close();


    }
}