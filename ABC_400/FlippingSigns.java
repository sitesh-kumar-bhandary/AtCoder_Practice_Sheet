package ABC_400;
import java.io.*;

public class FlippingSigns {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] exp = br.readLine().split(" ");

        long[] a = new long[n];
        for(int i=0;i<n;i++)
            a[i] = Long.parseLong(exp[i]);

        long result = flippingSigns(n, a);
        System.out.println(result);
        br.close();
    }

    private static long flippingSigns(int n, long[] a){
        long minVal = Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            minVal = Math.min(minVal, Math.abs(a[i]));
        }

        long totalSum = 0L;
        int totalNegSings = 0;
        for(long val : a){
            totalSum += Math.abs(val);
            if(val < 0)
                totalNegSings++;
        }

        if(totalNegSings % 2 == 1)
            totalSum -= 2 * minVal;

        return totalSum;
    }
}