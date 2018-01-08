import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client_1a2b {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Receiver_C RC = new Receiver_C(8001);
        Sender_C   SC = new Sender_C("127.0.0.1",8000);
        String str;
        while(true){
            System.out.print("Guess: ");
            str = br.readLine();
            SC.send(str); // send guess
            str = RC.receive(); // receive answer
            str = str.trim();
            if (str.equals("4A0B"))
                break;
            System.out.println("Answer: "+str);
        }
        System.out.println("恭喜! 你猜對了!");
    }
}
