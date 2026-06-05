package ABC_300_Points_Practice;
import java.io.*;

public class AtcodeerAndElectionReport {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] ratio = new long[n][2];
        for(int i=0;i<n;i++){
            String[] exp = br.readLine().split(" ");
            ratio[i][0] = Long.parseLong(exp[0]);
            ratio[i][1] = Long.parseLong(exp[1]);
        }

        long result = isPossibleVotes(n, ratio);
        System.out.println(result);
        br.close();
    }

    private static long isPossibleVotes(int n, long[][] ratio){
        long multiplier = 1;

        for(int i=1;i<n;i++){
            // for t
            long tprev = ratio[i-1][0];
            long tcurr = ratio[i][0];

            long firstMultiplication = multiplier * tprev;
            long currMultiplier1 = (firstMultiplication % tcurr == 0) ? firstMultiplication / tcurr : firstMultiplication /tcurr + 1;

            // for A
            long aprev = ratio[i-1][1];
            long acurr = ratio[i][1];

            long secondMultiplication = multiplier * aprev;
            long currMultiplier2 = (secondMultiplication % acurr == 0) ? secondMultiplication / acurr : secondMultiplication / acurr + 1;

            multiplier = Math.max(currMultiplier1, currMultiplier2);
        }

        return multiplier * (ratio[n-1][0] + ratio[n-1][1]);
    }
}