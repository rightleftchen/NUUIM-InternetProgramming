import java.io.IOException;

// Server_Receive
public class Car extends Thread{
    private String name;
    Server S1;
    String str1="";
    public Car(Server s){
        S1 = s;
    }
    public void run(){
        while(true){
            try {
                str1 = S1.receive();
            } catch (IOException e) {
            }
            System.out.println("Client : "+str1);
        }
    }
}
