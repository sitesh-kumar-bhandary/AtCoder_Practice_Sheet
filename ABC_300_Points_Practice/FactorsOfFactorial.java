package ABC_300_Points_Practice;
import java.io.*;
import java.util.*;

public class FactorsOfFactorial {

    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = factorsOfFactorial(n);
        System.out.println(result);
        br.close();
    }

    private static int factorsOfFactorial(int n) {
        boolean[] isPrime = seive(n);
        for (int i = n; i >= 2; i--) {
            findPrimeFactors(i, isPrime);
        }

        long result = 1;
        long mod = 1_000_000_007;
        for (int key : map.keySet()) {
            long val = (long) map.get(key);
            result = (result * (val + 1)) % mod;
        }

        return (int) result;
    }

    private static boolean[] seive(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

    private static void findPrimeFactors(int n, boolean[] isPrime) {
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                while (n % i == 0) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                    n = n / i;
                }
            }
        }

        if (n > 1)
            map.put(n, map.getOrDefault(n, 0) + 1);
    }
}