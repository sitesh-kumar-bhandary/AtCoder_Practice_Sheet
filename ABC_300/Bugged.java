package ABC_300;
import java.io.*;

public class Bugged {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] s = new int[n];
        for(int i=0;i<n;i++)
            s[i] = Integer.parseInt(br.readLine());

        int result = bugged(n, s);
        System.out.println(result);
        br.close();
    }

    private static int bugged(int n, int[] s){
        int totals = 0;
        for(int val : s)
            totals += val;

        if(totals % 10 != 0)
            return totals;

        int result = 0;
        for(int val : s){
            if((totals-val) % 10 != 0)
                result = Math.max(result, totals-val);
        }

        return result;
    }
}