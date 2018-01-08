import java.io.IOException;

// Client_Receive
public class Car2 extends Thread{
    private String name;
    Client C1;
    String str1="";
    public Car2(Client c){
        C1 = c;
    }
    public void run(){
        while(true){
            try {
                str1 = C1.receive();
            } catch (IOException e) {
            }
            System.out.println("Server : "+str1);
        }
    }
}
