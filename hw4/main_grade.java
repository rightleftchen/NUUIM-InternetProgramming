import java.io.*;


class stu{
String sid;
String sname;
String sex;
String tel;
String add;
int chi;
int eng;
Double tot;
Double avg;

void show (){
	
}



}



class main_grade { 
public static void main(String args[])throws IOException { 

BufferedReader br;
String[] stu_ary;
String     str;
int f_pt;


stu_ary = new String[100];
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
				stu_ary[f_pt] = new stu();
				// sid sname pass sex tel addr chi eng  total average 
				br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("請輸入學號:");      
				str = br.readLine(); //停止並等待數字輸入
				stu_ary[f_pt].sid = str;
				System.out.println("請輸入姓名:");
				str = br.readLine(); 
				stu_ary[f_pt].sname = str;
				System.out.println("請輸入性別:");
				str = br.readLine(); 
				stu_ary[f_pt].sex=str;
				System.out.println("請輸入電話:");
				str = br.readLine(); 
				stu_ary[f_pt].tel=str;
				System.out.println("請輸入地址 :");
				str = br.readLine(); 
				stu_ary[f_pt].addr=str;
				System.out.println("請輸入中文成績:");
				str = br.readLine(); 
				stu_ary[f_pt].chi=Integer.parseInt(str);
				System.out.println("請輸入英文成績:");
				str = br.readLine(); 
				stu_ary[f_pt].eng=Integer.parseInt(str);  
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
		   
         case 5:
            {
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("學號   姓名   密碼   性別   電話   地址 中文成績 英文成績 總分 平均");
				for(int i=0; i<f_pt; i++)
				{
					for(int j=0; j<stu_ary[0].length; j++)
						System.out.print(stu_ary[i][j]+"   ");
					System.out.println("");		
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