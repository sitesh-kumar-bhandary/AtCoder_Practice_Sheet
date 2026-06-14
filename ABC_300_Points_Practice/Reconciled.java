package ABC_300_Points_Practice;
import java.io.*;

public class Reconciled {

    static int mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int m = Integer.parseInt(exp[1]);

        long result = reconciled(n, m);
        System.out.println(result);
        br.close();
    }

    private static long reconciled(int n, int m){
        if(Math.abs(n-m) > 1)
            return 0;

        else {
            long result1 = findValue(n);
            long result2 = findValue(m);
            long result = (result1 * result2) % mod;

            if(Math.abs(n-m) == 0)
                result = (result * 2) % mod;

            return result;
        }
    }

    private static long findValue(int n){
        long result = 1;
        for(int i=1;i<n;i++){
            result = (result * (i+1)) % mod;
        }

        return result;
    }
}