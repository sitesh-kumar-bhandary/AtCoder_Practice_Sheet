package ABC_400;
import java.io.*;

public class WeLikeAgc {

    static long mod = 1_000_000_007L;
    static Long[][][][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = weLikeAgc(n);
        System.out.println(result);
        br.close();
    }

    private static int weLikeAgc(int n){
        dp = new Long[n+1][4][4][4];
        long result = helper(0, 3, 3, 3, n);

        return (int) result;
    }

    // Mapping -> 0 - a, 1 - c, 2 - g, 3 - t
    public static long helper(int ind, int a, int b, int c, int n){
        if(ind == n)
            return 1;

        if(dp[ind][a][b][c] != null)
            return dp[ind][a][b][c];

        long result = 0L;
        for(int d=0;d<=3;d++){
            if(isValidString(a, b, c, d))
                result = (result + helper(ind+1, b, c, d, n)) % mod;
        }

        return dp[ind][a][b][c] = result;
    }

    private static boolean isValidString(int c1, int c2, int c3, int c4) {
        if (c2 == 0 && c3 == 2 && c4 == 1) return false; // "AGC"
        if (c2 == 0 && c3 == 1 && c4 == 2) return false; // "ACG"
        if (c2 == 2 && c3 == 0 && c4 == 1) return false; // "GAC"
        if (c1 == 0 && c3 == 2 && c4 == 1) return false; // "A?GC"
        if (c1 == 0 && c2 == 2 && c4 == 1) return false; // "AG?C"
        return true;
    }
}
