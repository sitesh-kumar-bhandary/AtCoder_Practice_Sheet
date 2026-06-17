package ABC_500;
import java.io.*;

public class DigitSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long s = Long.parseLong(br.readLine());

        long result = digitSum(n, s);
        System.out.println(result);
    }

    private static long digitSum(long n, long s) {
        // CASE I
        if (n == s)
            return n + 1;

        long result = Long.MAX_VALUE;
        // CAse II - SQRT Decomposition
        for (long b = 2; b * b <= n; b++) {
            if (isPossibleDigitSum(b, n, s)) {
                result = Math.min(result, b);
                return result;
            }
        }

        // CASE III - for large b values
        for(long p=1;p*p<n;p++){
            long divisor = n - s + p;

            if(divisor % p != 0)
                continue;

            long b = divisor / p;

            if(b >= 2 && isPossibleDigitSum(b, n, s)){
                result = Math.min(result, b);
            }
        }

        if(result == Long.MAX_VALUE)
            return -1;

        return result;
    }

    private static boolean isPossibleDigitSum(long b, long n, long s) {
        long sum = 0;
        while (n != 0) {
            long rem = n % b;
            sum += rem;
            n = n / b;
        }

        return sum == s;
    }
}