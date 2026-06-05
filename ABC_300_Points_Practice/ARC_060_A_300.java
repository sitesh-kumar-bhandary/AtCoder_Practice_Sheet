package ABC_300_Points_Practice;
import java.io.*;
import java.util.*;

public class ARC_060_A_300 {

    static HashMap<String, Long> dp = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int a = Integer.parseInt(exp[1]);

        String[] exp1 = br.readLine().split(" ");
        int[] x = new int[n];
        for (int i = 0; i < n; i++)
            x[i] = Integer.parseInt(exp1[i]);

        long result = takAndCards(n, a, x);
        System.out.println(result);
        br.close();
    }

    public static long takAndCards(int n, int a, int[] x) {
        return helper(0, 0, 0, n, a, x);
    }

    private static long helper(int ind, int count, int sum, int n, int a, int[] x) {
        if(ind >= n)
            return 0;

        String key = ind+"#"+count+"#"+sum;
        if(dp.containsKey(key))
            return dp.get(key);

        // not take
        long notTake = 0 + helper(ind + 1, count, sum, n, a, x);

        // take
        long take = 0;
        sum += (long) x[ind];
        count++;
        if (sum == a * count)
            take = 1 + helper(ind + 1, count, sum, n, a, x);

        else
            take = 0 + helper(ind + 1, count, sum, n, a, x);

        dp.put(key, take + notTake);
        return dp.get(key);
    }
}