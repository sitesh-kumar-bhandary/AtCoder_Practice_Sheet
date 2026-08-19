package ABC_400;
import java.io.*;
import java.util.*;

public class MatchMatching {

    static int[] costs = {2,5,5,4,5,6,3,7,6};
    static Integer[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int m = Integer.parseInt(exp[1]);

        int[] digits = new int[m];
        exp = br.readLine().split(" ");
        for(int i=0;i<m;i++)
            digits[i] = Integer.parseInt(exp[i]);

        Arrays.sort(digits);
        String result = matchMatching(n, m, digits);
        System.out.println(result);
        br.close();      
    }

    private static String matchMatching(int n, int m, int[] digits){ 
        dp = new Integer[n+1];    
        dp[0] = 0;
        helper(n, digits);

        // System.out.println(dp[n]);
        String result = reconstructString(n, digits);
        return result;
    }

    private static int helper(int totalCosts, int[] digits){
        if(totalCosts == 0)
            return 0;

        if(dp[totalCosts] != null)
            return dp[totalCosts];

        int maxLength = Integer.MIN_VALUE;
        for(int d : digits){
            int newCost = costs[d-1];

            if(newCost <= totalCosts){
                int nextLen = helper(totalCosts - newCost, digits);

                if(nextLen != Integer.MIN_VALUE)
                    maxLength = Math.max(maxLength, 1 + nextLen);
            }  
        }

        return dp[totalCosts] = maxLength;
    }

    private static String reconstructString(int n, int[] digits){
        StringBuilder sb = new StringBuilder();
        int remainCost = n;
        int neededLen = dp[n];

        while(neededLen > 0){
            for(int i=digits.length-1;i>=0;i--){
                int d = digits[i];
                int currCost = costs[d-1];

                if(currCost <= remainCost && dp[remainCost - currCost] == neededLen-1){
                    sb.append(d);
                    remainCost -= currCost;
                    neededLen--;
                    break;
                }
            }
        }

        return sb.toString();
    }
}