import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=""; String input ="";
        Receiver_C RC = new Receiver_C(8001);
        Sender_C   SC = new Sender_C("127.0.0.1",8000);

        while(true) {
            String s = RC.receive();
            System.out.println(s);
            s = RC.receive();
            System.out.println(s);
            s = RC.receive();
            System.out.println(s);
            s = RC.receive();
            System.out.println(s);
            s = RC.receive();
            System.out.println(s);
            s = RC.receive();
            System.out.println(s);
            s = RC.receive();
            System.out.print(s);
            input = br.readLine();
            SC.send(input);
            switch (input){
                case "1":
                    s = RC.receive();//print
                    System.out.println(s);
                    input = br.readLine();
                    SC.send(input);
                    s = RC.receive();//print
                    System.out.println(s);
                    input = br.readLine();
                    SC.send(input);
                    s = RC.receive();//print
                    System.out.println(s);
                    input = br.readLine();
                    SC.send(input);
                    s = RC.receive();//print
                    System.out.println(s);
                    input = br.readLine();
                    SC.send(input);
                    s = RC.receive();//print
                    System.out.println(s);
                    input = br.readLine();
                    SC.send(input);
                    s = RC.receive();//print
                    System.out.println(s);
                    input = br.readLine();
                    SC.send(input);
                    s = RC.receive();//print
                    System.out.println(s);
                    input = br.readLine();
                    SC.send(input);
                    s = RC.receive();//print
                    System.out.println(s);
                    input = br.readLine();
                    SC.send(input);
                    s = RC.receive();//print f_pt
                    System.out.println(s);
                    break;
                case "5":
                    s = RC.receive();//print ---------------------------
                    System.out.println(s);
                    System.out.println("");
                    s = RC.receive();//print
                    System.out.println(s);
                    s = RC.receive();//receive f_pt
                    s = s.trim();
                    int f_pt = Integer.parseInt(s);
                    s = RC.receive();//receive stu_ary[0].length
                    s = s.trim();
                    int len = Integer.parseInt(s);

                    for(int i=0; i<f_pt; i++)
                    {
                        for(int j=0; j<len; j++)
                        {
                            s = RC.receive();//print
                            s = s.trim();
                            System.out.print(s+"  ");
                        }
                        System.out.println("");
                    }
                    s = RC.receive();//print end-----------------------
                    System.out.println(s);

            }
        }
    }
}
