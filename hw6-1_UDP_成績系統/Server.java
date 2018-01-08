import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Server {
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        Receiver_S RS = new Receiver_S(8000);
        Sender_S   SS = new Sender_S("127.0.0.1",8001);

        String[][] stu_ary;
        String     str;
        int f_pt;

        stu_ary = new String[100][10];
        f_pt=0;

        while(true)
        {
            SS.send("*********************************");
            SS.send("**        <<成績系統>>         **");
            SS.send("*********************************");
            SS.send("**  1. 新增   2.刪除    3.查詢 **");
            SS.send("**  4. 修改   5.瀏覽    6.結束 **");
            SS.send("*********************************");
            SS.send("輸入您的選擇 (1~~6): ");

            str = RS.receive();
            str = str.trim();
            System.out.println(str);
            int res = Integer.parseInt(str);
            switch(res){
                case 1:    //新增
                {
                    // sid sname pass sex tel addr chi eng  total average
                    br = new BufferedReader(new InputStreamReader(System.in));
                    SS.send("請輸入學號:");
                    str = RS.receive();
                    str = str.trim(); //停止並等待數字輸入
                    stu_ary[f_pt][0]=str;
                    SS.send("請輸入姓名:");
                    str = RS.receive();
                    str = str.trim();
                    stu_ary[f_pt][1]=str;
                    SS.send("請輸入密碼:");
                    str = RS.receive();
                    str = str.trim();
                    stu_ary[f_pt][2]=str;
                    SS.send("請輸入性別:");
                    str = RS.receive();
                    str = str.trim();
                    stu_ary[f_pt][3]=str;
                    SS.send("請輸入電話:");
                    str = RS.receive();
                    str = str.trim();
                    stu_ary[f_pt][4]=str;
                    SS.send("請輸入地址 :");
                    str = RS.receive();
                    str = str.trim();
                    stu_ary[f_pt][5]=str;
                    SS.send("請輸入中文成績:");
                    str = RS.receive();
                    str = str.trim();
                    stu_ary[f_pt][6]=str;
                    SS.send("請輸入英文成績:");
                    str = RS.receive();
                    str = str.trim();
                    stu_ary[f_pt][7]=str;
                    int tot = Integer.parseInt(stu_ary[f_pt][6]) + Integer.parseInt(stu_ary[f_pt][7]);
                    stu_ary[f_pt][8]=Integer.toString(tot);
                    double avg = (Double.parseDouble(stu_ary[f_pt][6]) + Double.parseDouble(stu_ary[f_pt][7]))/2;
                    stu_ary[f_pt][9]=Double.toString(avg);
                    f_pt++;
                    SS.send("f_pt="+f_pt);
                    break;
                }
                case 2:   //刪除
                {
                    String[][] stu_a2 = new String[100][10];

                    System.out.print("請輸入欲刪除之學號：");
                    String num = br.readLine();
                    System.out.print("確認刪除?(Y/N): ");
                    str = br.readLine();
                    if (str.equals("Ｙ") || str.equals("y"))
                    {
                        for(int i=0; i<stu_ary.length; i++)
                        {
                            if (num.equals(stu_ary[i][0]))
                            {
                                stu_ary[i][0] = "del";
                            }
                        }
                        for(int i=0; i<stu_ary.length-1; i++)
                        {
                            if ("del".equals(stu_ary[i][0]))
                                for(int j=0; j<stu_ary[i].length; j++)
                                    stu_ary[i][j] = stu_ary[i+1][j];
                            if (stu_ary[i+1][0]==null)
                            {
                                stu_ary[i] = null;
                                f_pt--;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 3:     //查詢
                {

                }

                case 4:    //修改
                {
                    break;
                }

                case 5:
                {
                    SS.send("--------------------------------------------------");
                    SS.send("學號 姓名 密碼 性別 電話 地址 中文成績 英文成績 總分 平均");
                    String FPT = String.valueOf(f_pt);
                    SS.send(FPT);
                    String len = String.valueOf(stu_ary[0].length);
                    SS.send(len);
                    for(int i=0; i<f_pt; i++)
                    {
                        for(int j=0; j<stu_ary[0].length; j++)
                            SS.send(stu_ary[i][j]+"   ");
                    }
                    SS.send("--------------------------------------------------");
                    break;
                }
                case 6:
                    System.exit(0);
                    break;

                default:
                    System.out.println("輸入錯誤,請重新輸入!");
                    break;
            }
        }
    }
}
