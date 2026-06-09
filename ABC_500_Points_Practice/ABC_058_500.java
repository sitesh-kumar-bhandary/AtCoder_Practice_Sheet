package ABC_500_Points_Practice;
import java.io.*;

public class ABC_058_500 {

    static int mod = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int m = Integer.parseInt(exp[1]);
        long[] x = new long[n];
        String[] exp1 = br.readLine().split(" ");
        for(int i=0;i<n;i++)
            x[i] = Long.parseLong(exp1[i]);

        long[] y = new long[m];
        String[] exp2 = br.readLine().split(" ");
        for(int i=0;i<m;i++)
            y[i] = Long.parseLong(exp2[i]);

        int result = findTotalArea(n, m, x, y);
        System.out.println(result);
        br.close();
    }

    private static int findTotalArea(int n, int m, long[] x, long[] y){
        int totals = n + m - 4;
        long length = x[n-1] - x[0];
        long breadth = y[m-1] - y[0];
        long currArea = (length % mod * breadth % mod) % mod;

        long factor = 1;
        for(int i=0;i<totals;i++){
            factor = (factor * 2) % mod;
        }

        long totalArea = (((factor % mod * currArea % mod ) % mod) + mod) % mod;
        return (int) totalArea;
    }
}