package ABC_300;
import java.io.*;

public class SplittingPile {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] a = new long[n];
        String[] exp = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            a[i] = Long.parseLong(exp[i]);
        }

        long result = splittingPile(n, a);
        System.out.println(result);
        br.close();
    }

    private static long splittingPile(int n, long[] a){
        long totalSum = 0;
        for(long val : a)
            totalSum += val;

        long currSum = 0;
        long result = Long.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            long val = a[i];
            currSum += val;
            totalSum -= val;

            result = Math.min(result, Math.abs(currSum - totalSum));
        }

        return result;
    }
}