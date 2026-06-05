package ABC_300_Points_Practice;
import java.io.*;


public class ARC_058_A_300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int k = Integer.parseInt(exp[1]);

        int[] d = new int[k];
        String[] exp1 = br.readLine().split(" ");
        for(int i=0;i<k;i++)
            d[i] = Integer.parseInt(exp1[i]);

        System.out.println(irohaSObsession(n, k, d));
    }

    private static int irohaSObsession(int n, int k, int[] d){
        boolean[] isDislike = new boolean[10];
        for(int val : d)
            isDislike[val] = true;

        for(int i=n;i<Integer.MAX_VALUE;i++){
            int val = i;
            while(val != 0){
                int rem = val % 10;
                if(isDislike[rem])
                    break;

                else
                    val = val / 10;
            }

            if(val == 0)
                return i;
        }

        return -1;
    }
}