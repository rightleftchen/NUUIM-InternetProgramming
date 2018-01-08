import java.io.*;


class Stu{
    String sid;
    String sname;
    String sex;
    String tel;
    String addr;
    int chi;
    int eng;
    Double tot;
    Double avg;

    void show () {
        System.out.println(sid+"  "+sname+"  "+sex+"  "+tel+"  "+addr+"  "+chi+"  "+eng+"  "+tot+"  "+avg);
    }
    void compute_tot_avg(){
        tot = Double.valueOf(chi + eng);
        avg = tot/2;
    }

}

class main_grade {
    public static void main(String args[])throws IOException {

        BufferedReader br;
        String     str;
        int f_pt;
        Stu[] stu_ary = new Stu[100];
        f_pt=0;

        while(true)
        {
            System.out.println("*********************************");
            System.out.println("**        <<成績系統>>         **");
            System.out.println("*********************************");
            System.out.println("**  1. 新增   2.刪除    3.查詢 **");
            System.out.println("**  4. 修改   5.瀏覽    6.結束 **");
            System.out.println("*********************************");
            System.out.println("輸入您的選擇 (1~~6): ");

            br = new BufferedReader(new InputStreamReader(System.in));
            str = br.readLine();
            int res = Integer.parseInt(str);
            switch(res){
                case 1:    //新增
                {
                    Stu Tmp = new Stu();
                    // sid sname pass sex tel addr chi eng  total average
                    br = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("請輸入學號:");
                    str = br.readLine(); //停止並等待數字輸入
                    Tmp.sid = str;
                    System.out.println("請輸入姓名:");
                    str = br.readLine();
                    Tmp.sname = str;
                    System.out.println("請輸入性別:");
                    str = br.readLine();
                    Tmp.sex=str;
                    System.out.println("請輸入電話:");
                    str = br.readLine();
                    Tmp.tel=str;
                    System.out.println("請輸入地址 :");
                    str = br.readLine();
                    Tmp.addr=str;
                    System.out.println("請輸入中文成績:");
                    str = br.readLine();
                    Tmp.chi=Integer.parseInt(str);
                    System.out.println("請輸入英文成績:");
                    str = br.readLine();
                    Tmp.eng=Integer.parseInt(str);
                    Tmp.compute_tot_avg();
                    stu_ary[f_pt] = Tmp;
                    f_pt++;
                    System.out.println("f_pt="+f_pt);
                    break;
                }
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
                        if(str.equals(stu_ary[i].sid))
                        {
                            pt=i;
                            break;
                        }
                    }

                    if (pt==10000)
                        System.out.println("沒有此學號!");
                    else
                    {
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println("學號   姓名   性別   電話   地址 中文成績 英文成績 總分 平均");
                        stu_ary[pt].show();
                        System.out.println("-------------------------------------------------------------------------");
                    }
                    break;
                }

                case 4:    //修改
                {
                    break;
                }

                case 5:
                {
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("學號   姓名   性別   電話   地址 中文成績 英文成績 總分 平均");
                    for(int i=0; i<f_pt; i++)
                    {
                        stu_ary[i].show();
                    }
                    System.out.println("-------------------------------------------------------------------------");
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