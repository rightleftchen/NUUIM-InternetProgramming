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
System.out.println("**        <<���Z�t��>>         **"); 
System.out.println("*********************************"); 
System.out.println("**  1. �s�W   2.�R��    3.�d�� **"); 
System.out.println("**  4. �ק�   5.�s��    6.���� **"); 
System.out.println("*********************************"); 
System.out.println("��J�z����� (1~~6): "); 

br = new BufferedReader(new InputStreamReader(System.in));
str = br.readLine();  
int res = Integer.parseInt(str);
      switch(res){
         case 1:    //�s�W
		   {
				stu_ary[f_pt] = new stu();
				// sid sname pass sex tel addr chi eng  total average 
				br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("�п�J�Ǹ�:");      
				str = br.readLine(); //����õ��ݼƦr��J
				stu_ary[f_pt].sid = str;
				System.out.println("�п�J�m�W:");
				str = br.readLine(); 
				stu_ary[f_pt].sname = str;
				System.out.println("�п�J�ʧO:");
				str = br.readLine(); 
				stu_ary[f_pt].sex=str;
				System.out.println("�п�J�q��:");
				str = br.readLine(); 
				stu_ary[f_pt].tel=str;
				System.out.println("�п�J�a�} :");
				str = br.readLine(); 
				stu_ary[f_pt].addr=str;
				System.out.println("�п�J���妨�Z:");
				str = br.readLine(); 
				stu_ary[f_pt].chi=Integer.parseInt(str);
				System.out.println("�п�J�^�妨�Z:");
				str = br.readLine(); 
				stu_ary[f_pt].eng=Integer.parseInt(str);  
				f_pt++;
				System.out.println("f_pt="+f_pt);
				break;
		   }
         case 2:   //�R��
		   {
				break;			  
		   }
		   
         case 3:     //�d��
           {
				br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("�п�J���d�M���ǥ;Ǹ�:");      
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
					System.out.println("�S�����Ǹ�!");
				else
				{		
					for(int j=0; j<stu_ary[0].length; j++)
						System.out.print(stu_ary[pt][j]+"   ");
					System.out.println("");		
				}			
				break;
           }	
		   
         case 4:    //�ק�
           {
            break;			  
		   }   
		   
         case 5:
            {
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("�Ǹ�   �m�W   �K�X   �ʧO   �q��   �a�} ���妨�Z �^�妨�Z �`�� ����");
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
            System.out.println("��J���~,�Э��s��J!");
            break;
       }
}	 
} 
}