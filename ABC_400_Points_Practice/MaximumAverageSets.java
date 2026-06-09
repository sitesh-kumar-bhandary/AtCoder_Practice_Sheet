package ABC_400_Points_Practice;
import java.io.*;
import java.util.*;

public class MaximumAverageSets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int a = Integer.parseInt(exp[1]);
        int b = Integer.parseInt(exp[2]);

        long[] v = new long[n];
        String[] exp1 = br.readLine().split(" ");
        for(int i=0;i<n;i++)
            v[i] = Long.parseLong(exp1[i]);

        maximumAverageSets(n, a, b, v);
        br.close();
    }

    private static void maximumAverageSets(int n, int a, int b, long[] v){
        Arrays.sort(v);

        double mean = 0.0;
        long sum = 0;
        int count = 0;
        int currCount = 0;

        for(int i=n-1;i>=0;i--){
            sum += v[i];
            count++;

            if(count >= a && count <= b){
                double currMean = (double) sum / count;

                if(currMean > mean){
                    mean = currMean;
                    currCount = count;
                }
            }
        }

        // finding value of NCR using Pascal's Triangle
        long[][] dp = new long[51][51];
        for(int i=0;i<51;i++){
            dp[i][0] = 1;
            dp[i][i] = 1;

            for(int j=1;j<i;j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        long result = 0;
        long boundaryValue = v[n-currCount];
        int totalFreq = 0;
        for(int i=0;i<n;i++){
            if(v[i] == boundaryValue)
                totalFreq++;
        }

        int reqFreq = 0;
        for(int i=n-currCount;i<n;i++){
            if(v[i] == boundaryValue)
                reqFreq++;
        }

        if(boundaryValue == v[n-1]){
            for(int i=a;i<=b;i++){
                long currResult = dp[totalFreq][i];
                result += currResult;
            }
        }

        else {
            long currResult = dp[totalFreq][reqFreq];
            result += currResult;
        }

        System.out.println(mean);
        System.out.println(result);
    }
}