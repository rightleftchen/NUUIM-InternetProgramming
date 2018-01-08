import java.io.*;

class main_grade_s {
    public static void main(String args[])throws IOException {

        BufferedReader br;
        String[][] stu_ary;
        String     str;
        int f_pt;
        stu_ary = new String[100][10];
        f_pt=0;
        int port = 1234;
        int over = 0;
        String messagein="";
        Server S1 = new Server(port);
        S1.accept();

        while(over==0)
        {
            S1.send("1*********************************");
            S1.send("1**        <<成績系統>>         **");
            S1.send("1*********************************");
            S1.send("1**  1. 新增   2.刪除    3.查詢 **");
            S1.send("1**  4. 修改   5.瀏覽    6.結束 **");
            S1.send("1*********************************");
            S1.send("2輸入您的選擇 (1~~6): ");
            messagein = S1.receive();
            int res = Integer.parseInt(messagein);
            switch(res){
                case 1:    //新增
                {
                    // sid sname pass sex tel addr chi eng  total average
                    S1.send("2請輸入學號:");
                    messagein = S1.receive();
                    stu_ary[f_pt][0]=messagein;
                    S1.send("2請輸入姓名:");
                    messagein = S1.receive();
                    stu_ary[f_pt][1]=messagein;
                    S1.send("2請輸入密碼:");
                    messagein = S1.receive();
                    stu_ary[f_pt][2]=messagein;
                    S1.send("2請輸入性別:");
                    messagein = S1.receive();
                    stu_ary[f_pt][3]=messagein;
                    S1.send("2請輸入電話:");
                    messagein = S1.receive();
                    stu_ary[f_pt][4]=messagein;
                    S1.send("2請輸入地址 :");
                    messagein = S1.receive();
                    stu_ary[f_pt][5]=messagein;
                    S1.send("2請輸入中文成績:");
                    messagein = S1.receive();
                    stu_ary[f_pt][6]=messagein;
                    S1.send("2請輸入英文成績:");
                    messagein = S1.receive();
                    stu_ary[f_pt][7]=messagein;
                    int tot = Integer.parseInt(stu_ary[f_pt][6]) + Integer.parseInt(stu_ary[f_pt][7]);
                    stu_ary[f_pt][8]=Integer.toString(tot);
                    double avg = (Double.parseDouble(stu_ary[f_pt][6]) + Double.parseDouble(stu_ary[f_pt][7]))/2;
                    stu_ary[f_pt][9]=Double.toString(avg);
                    f_pt++;
                    S1.send("1f_pt="+f_pt);
                    break;
                }
/*
                case 2:   //刪除
                {
                    break;
                }
                case 3:     //查詢
                {
                    br = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("請輸入欲查尋之學生學號:");
                    str = br.readLine();

                    int pt=10000;
                    for(int i=0; i<f_pt; i++)
                    {
                        if(str.equals(stu_ary[i][0]))
                        {
                            pt=i;
                            break;
                        }
                    }

                    if (pt==10000)
                        System.out.println("沒有此學號!");
                    else
                    {
                        for(int j=0; j<stu_ary[0].length; j++)
                            System.out.print(stu_ary[pt][j]+"   ");
                        System.out.println("");
                    }
                    break;
                }

                case 4:    //修改
                {
                    break;
                }
*/
                case 5:
                {
                    S1.send("1-------------------------------------------------------------------------");
                    S1.send("1學號   姓名   密碼   性別   電話   地址 中文成績 英文成績 總分 平均");
                    for(int i=0; i<f_pt; i++)
                    {
                        for(int j=0; j<stu_ary[0].length; j++)
                            S1.send("0"+stu_ary[i][j]+"   ");
                        S1.send("1");
                    }
                    S1.send("1-------------------------------------------------------------------------");
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
        S1.close();
    }
}