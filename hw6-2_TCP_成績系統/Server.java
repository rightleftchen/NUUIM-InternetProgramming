import java.io.*;
import java.net.*;
import java.util.Date;

public class Server {
    ServerSocket  SS;
    DataOutputStream   outstream;
    DataInputStream   instream;
    Socket  socket;
    static int  port;
    static String messageout;
    static String messagein;
    Date currentDate;
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    String[][] stu_ary;
    String     str;
    int f_pt;
    public Server() {
        stu_ary = new String[100][10];
        f_pt=0;
        try{
            SS = new ServerSocket(1234);
            currentDate = new Date();
            System.out.println("Server created.");
            System.out.println("waiting for client to connect...");
            socket = SS.accept();
            instream = new DataInputStream(socket.getInputStream());
            outstream = new DataOutputStream(socket.getOutputStream());
            String ChoiceList = "*********************************"+"\n" +
                    "**        <<成績系統>>         **"+"\n" +
                    "*********************************"+"\n" +
                    "**  1. 新增   2.刪除    3.查詢 **"+"\n" +
                    "**  4. 修改   5.瀏覽    6.結束 **"+"\n" +
                    "*********************************"+"\n" +
                    "輸入您的選擇 (1~~6): ";
            while(true){
                /*
                System.out.println("connected from Client " +
                        socket.getInetAddress().getHostAddress());
                System.out.println("ClientName:" +
                        socket.getInetAddress().getHostName());
                System.out.println("date:" + currentDate);*/

                // Send choicelist to client
                outstream.writeUTF(ChoiceList);

                str = instream.readUTF();
                str = str.trim();
                System.out.println("Client's choice: "+str);
                int res = Integer.parseInt(str);
                switch(res){
                    case 1:    //新增
                    {
                        // sid sname pass sex tel addr chi eng  total average
                        br = new BufferedReader(new InputStreamReader(System.in));
                        outstream.writeUTF("請輸入學號:");
                        str = instream.readUTF();
                        str = str.trim(); //停止並等待數字輸入
                        stu_ary[f_pt][0]=str;
                        outstream.writeUTF("請輸入姓名:");
                        str = instream.readUTF();
                        str = str.trim();
                        stu_ary[f_pt][1]=str;
                        outstream.writeUTF("請輸入密碼:");
                        str = instream.readUTF();
                        str = str.trim();
                        stu_ary[f_pt][2]=str;
                        outstream.writeUTF("請輸入性別:");
                        str = instream.readUTF();
                        str = str.trim();
                        stu_ary[f_pt][3]=str;
                        outstream.writeUTF("請輸入電話:");
                        str = instream.readUTF();
                        str = str.trim();
                        stu_ary[f_pt][4]=str;
                        outstream.writeUTF("請輸入地址 :");
                        str = instream.readUTF();
                        str = str.trim();
                        stu_ary[f_pt][5]=str;
                        outstream.writeUTF("請輸入中文成績:");
                        str = instream.readUTF();
                        str = str.trim();
                        stu_ary[f_pt][6]=str;
                        outstream.writeUTF("請輸入英文成績:");
                        str = instream.readUTF();
                        str = str.trim();
                        stu_ary[f_pt][7]=str;
                        int tot = Integer.parseInt(stu_ary[f_pt][6]) + Integer.parseInt(stu_ary[f_pt][7]);
                        stu_ary[f_pt][8]=Integer.toString(tot);
                        double avg = (Double.parseDouble(stu_ary[f_pt][6]) + Double.parseDouble(stu_ary[f_pt][7]))/2;
                        stu_ary[f_pt][9]=Double.toString(avg);
                        f_pt++;
                        outstream.writeUTF("f_pt="+f_pt);
                        break;
                    }
                    case 2:   //刪除
                    {
                        String[][] stu_a2 = new String[100][10];
                        String num;
                        outstream.writeUTF("請輸入欲刪除之學號：");
                        num = instream.readUTF();
                        num = num.trim();
                        System.out.println(num);
                        outstream.writeUTF("確認刪除?(Y/N): ");
                        str = instream.readUTF();
                        str = str.trim();
                        System.out.println(str);
                        if (str.equals("Ｙ") || str.equals("y"))
                        {
                            for(int i=0; i<stu_ary.length-1; i++)
                            {
                                if (num.equals(stu_ary[i][0]))
                                {
                                    stu_ary[i][0] = "del";
                                }
                            }
                            for(int i=0; i<stu_ary.length-1; i++)
                            {
                                if ("del".equals(stu_ary[i][0]))
                                {
                                    if (stu_ary[i+1][0]==null)
                                    {
                                        stu_ary[i] = null;
                                        f_pt--;
                                        break;
                                    }
                                    else
                                    {
                                        for(int j=0; j<stu_ary[i].length; j++)
                                            stu_ary[i][j] = stu_ary[i+1][j];
                                    }
                                }
                            }
                            stu_ary[f_pt-1] = null;
                            f_pt--;
                        }
                        break;
                    }
                    case 3:     //查詢
                    {
                        outstream.writeUTF("請輸入欲修查詢學號：");
                        str = instream.readUTF();
                        // send stu_ary[0].length to client
                        outstream.writeUTF(String.valueOf(stu_ary[0].length));
                        for (int i=0; i<stu_ary.length; i++)
                        {
                            if (str.equals(stu_ary[i][0]))
                            {
                                outstream.writeUTF("\n--------------------------------------------------\n");
                                outstream.writeUTF("學號 姓名 密碼 性別 電話 地址 中文成績 英文成績 總分 平均\n");
                                for(int j=0; j<stu_ary[0].length; j++)
                                    outstream.writeUTF(stu_ary[i][j]+"   ");
                                outstream.writeUTF("\n--------------------------------------------------\n\n");
                                break;
                            }
                        }
                        break;
                    }

                    case 4:    //修改
                    {
                        break;
                    }

                    case 5:
                    {
                        outstream.writeUTF("--------------------------------------------------");
                        outstream.writeUTF("學號 姓名 密碼 性別 電話 地址 中文成績 英文成績 總分 平均");
                        String FPT = String.valueOf(f_pt);
                        outstream.writeUTF(FPT);
                        String len = String.valueOf(stu_ary[0].length);
                        outstream.writeUTF(len);
                        if (f_pt==0)
                        {
                            System.out.println("========== null =========");
                            break;
                        }
                        for(int i=0; i<f_pt; i++)
                        {
                            for(int j=0; j<stu_ary[0].length; j++)
                                outstream.writeUTF(stu_ary[i][j]+"   ");
                        }
                        outstream.writeUTF("--------------------------------------------------");
                        break;
                    }
                    default:
                        System.out.println("輸入錯誤,請重新輸入!");
                        break;
                }

                /*
                // read message from client
                messagein = instream.readUTF();
                System.out.println("Client : " + messagein);
                // sene message to client
                System.out.print("Server : ");
                messageout = br.readLine();
                outstream.writeUTF(messageout);
                //outstream.close();*/
            }
        }
        catch(IOException e){
            System.out.println(e.toString());
            e.printStackTrace();
            System.exit(1);
        }
    }
    public static void main(String[] args) throws IOException{
        Server grade = new Server();
    }
}
