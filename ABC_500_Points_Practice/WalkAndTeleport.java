package ABC_500_Points_Practice;
import java.io.*;

public class WalkAndTeleport {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        long a = Long.parseLong(exp[1]);
        long b = Long.parseLong(exp[2]);

        long[] x = new long[n];
        String[] exp1 = br.readLine().split(" ");
        for(int i=0;i<n;i++)
            x[i] = Long.parseLong(exp1[i]);

        long result = walkAndTeleport(n, a, b, x);
        System.out.println(result);
        br.close();
    }

    private static long walkAndTeleport(int n, long a, long b, long[] x){
        long[] dp = new long[n];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            long diff = x[i] - x[i-1];
            long val = diff * a;

            dp[i] = Math.min(dp[i-1]+val, dp[i-1]+b);
        }

        return dp[n-1];
    }
}