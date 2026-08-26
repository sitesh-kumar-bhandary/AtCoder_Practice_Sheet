package ABC_400;
import java.io.*;
import java.util.*;

public class Xxor {

    static long k;
    static final int BIT = 40;
    static final int[] countBits = new int[BIT];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        k = Long.parseLong(exp[1]);

        long[] a = new long[n];
        exp = br.readLine().split(" ");
        for(int i=0;i<n;i++)
            a[i] = Long.parseLong(exp[i]);

        long result = xXor(n, a);
        System.out.println(result);
        br.close();
    }

    private static long xXor(int n, long[] a){
        // counting 1s at every bit
        for(int bit = 0;bit < BIT;bit++){
            for(int i=0;i<n;i++){
                if(((a[i] >> bit) & 1) == 1)
                    countBits[bit]++;
            }
        }

        long[][] dp = new long[BIT][2];
        for(long[] arr : dp)
            Arrays.fill(arr, -1L);

        long result = helper(BIT-1, 1, n, dp);
        return result;
    }

    public static long helper(int bit, int tight, int n, long[][] dp){
        if(bit < 0)
            return 0L;

        int kthBit = (int) ((k >> bit) & 1);

        int limit = tight == 1 ? kthBit : 1;

        if(dp[bit][tight] != -1)
            return dp[bit][tight];

        long result = 0;
        for(int xBit=0;xBit<=limit;xBit++){

            long contributions = xBit == 0 ? countBits[bit] * (1L << bit) : (n - countBits[bit]) * (1L << bit);

            int nextTight = (tight == 1 &&  (xBit == kthBit)) ? 1 : 0;

            result = Math.max(result, contributions + helper(bit-1, nextTight, n, dp));
        }

        return dp[bit][tight] = result;
    }
}