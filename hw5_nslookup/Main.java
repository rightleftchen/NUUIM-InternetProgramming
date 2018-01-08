import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

class Nslookup{
    public void main(){
        BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
        String uhost=""; // uhost 為 輸入的名稱
        try {
            InetAddress myHost;
            while(true){
                System.out.print("> ");
                uhost = kin.readLine();
                if (uhost.equals("exit"))
                    break;
                myHost = InetAddress.getByName(uhost);
                char res = uhost.charAt(0);
                // 如果 HostName = "1.1.1.1" ，則 HostAddress 會回傳 "1.1.1.1"
                if (myHost.getHostName().equals(myHost.getHostAddress()))
                {
                    System.out.println("= Domain name Not Found =");
                    continue;
                }

                if (Character.getNumericValue(res)>=1 && Character.getNumericValue(res)<=9)
                {
                    System.out.println(myHost.getHostName());
                    continue;
                }
                // getAllByName 方法
                InetAddress[] alladdrs = InetAddress.getAllByName(uhost);
                String tmp="";
                String[] tmp2 = new String[2];
                for (int i = 0; i < alladdrs.length; i++){
                    /*tmp = String.valueOf(alladdrs[i]);
                    tmp2 = tmp.split("/");
                    System.out.println(tmp2[1]);*/
                    System.out.println(alladdrs[i].getHostAddress());
                }
                System.out.println();
            }
        } catch (Exception e){
            System.out.println("= Host Not Found =");
            Nslookup b = new Nslookup();
            b.main();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            InetAddress myHost = InetAddress.getLocalHost();
            System.out.println("----------------------------------------------------------------");
            System.out.print("主機名稱 : " + myHost.getHostName());
            System.out.println("  IP位址 : " + myHost.getHostAddress());
            System.out.println("------------------------ 輸入 exit 離開 -------------------------");
        } catch (Exception e){
        }
        Nslookup a = new Nslookup();
        a.main();
    }
}
