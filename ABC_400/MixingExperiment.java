package ABC_400;
import java.io.*;

public class MixingExperiment {

    static int INF = 1_000_000_000;
    static Integer[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int ma = Integer.parseInt(exp[1]);
        int mb = Integer.parseInt(exp[2]);

        int[][] chemicals = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] exp1 = br.readLine().split(" ");
            int a = Integer.parseInt(exp1[0]);
            int b = Integer.parseInt(exp1[1]);
            int c = Integer.parseInt(exp1[2]);
            chemicals[i][0] = a;
            chemicals[i][1] = b;
            chemicals[i][2] = c;
        }

        int result = mixingExperiment(n, ma, mb, chemicals);
        System.out.println(result);
        br.close();
    }

    private static int mixingExperiment(int n, int ma, int mb, int[][] chemicals){
        dp = new Integer[n][401][401];
        int result = helper(0, 0, 0, ma, mb, chemicals);
        if(result == INF)
            result = -1;

        return result;
    }

    private static int helper(int ind, int currA, int currB, int ma, int mb, int[][] chemicals){
        if(ind >= chemicals.length){
            if(currA == 0 && currB == 0)
                return INF;

            if(ma * currB == mb * currA)
                return 0;

            return INF;
        }

        if(dp[ind][currA][currB] != null)
            return dp[ind][currA][currB];

        // not take
        int notTake = helper(ind+1, currA, currB, ma, mb, chemicals);

        // take 
        int take = chemicals[ind][2] + helper(ind+1, currA+chemicals[ind][0], currB+chemicals[ind][1], ma, mb, chemicals);

        return dp[ind][currA][currB] = Math.min(take, notTake);
    }
}