package ABC_300_Points_Practice;
import java.io.*;

public class Sequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n];
        String[] exp = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            a[i] = Long.parseLong(exp[i]);

        long result1 = sequence(n, a, 1);
        long result2 = sequence(n, a, -1);
        System.out.println(Math.min(result1, result2));
        br.close();
    }

    private static long sequence(int n, long[] a, int firstSign) {
        long operations = 0;
        int expectedSign = firstSign;

        long totalSum = 0;
        for(int i=0;i<n;i++){
            totalSum += a[i];

            if(expectedSign == 1){
                if(totalSum <= 0){
                    long delta = 1-totalSum;
                    operations += delta;
                    totalSum = 1;
                }
            }

            else {
                if(totalSum >= 0){
                    long delta = (totalSum + 1);
                    operations += delta;
                    totalSum = -1;
                }
            }

            expectedSign *= -1;
        }

        return operations;
    }
}