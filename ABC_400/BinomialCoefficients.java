package ABC_400;
import java.io.*;

public class BinomialCoefficients {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] exp = br.readLine().split(" ");

        int[] a = new int[n];
        for(int i=0;i<n;i++)
            a[i] = Integer.parseInt(exp[i]);

        String result = binomialCoefficients(n, a);
        System.out.println(result);
        br.close();
    }

    private static String binomialCoefficients(int n, int[] a){
        if(n == 2)
            return Math.max(a[0], a[1])+" "+Math.min(a[0], a[1]);

        int maxVal = 0;
        for(int val : a)
            maxVal = Math.max(val, maxVal);

        int first = maxVal;
        int second = -1;

        int half = (maxVal+1) / 2;
        int maxDiff = half;
        for(int val : a){
            int currDiff = Math.abs(val-half);

            if(currDiff < maxDiff){
                second = val;
                maxDiff = currDiff;
            }
        }

        return first+" "+second;
    }
}