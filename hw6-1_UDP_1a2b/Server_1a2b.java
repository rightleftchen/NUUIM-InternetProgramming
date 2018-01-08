import java.io.*;
class Server_1a2b
{
    public static void main(String[] args) throws IOException
    {
        Receiver_S RS = new Receiver_S(8000);
        Sender_S   SS = new Sender_S("127.0.0.1",8001);
        int[] A={3,5,6,1};  // answer array
        int[] B=new int[4];
        String ans;
        while(true)
        {
            //  請把程式寫在下列  //***********//  之間, please use Compute_AB.java
            //******************************************************************//
            String tmp = RS.receive();
            tmp = tmp.trim();
            for(int i=0; i<B.length; i++)
            {
                B[i] = Character.getNumericValue(tmp.charAt(i));
            }
            Compute_AB res = new Compute_AB(A,B);

            ans = res.judge();
            //******************************************************************//
            SS.send(ans);
        }
    }
}