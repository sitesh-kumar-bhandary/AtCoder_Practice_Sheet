import java.io.*;

public class Socks2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int k = Integer.parseInt(exp[1]);

        String[] exp1 = br.readLine().split(" ");
        int[] a = new int[k];
        for (int i = 0; i < k; i++)
            a[i] = Integer.parseInt(exp1[i]);

        long result = socks(n, k, a);
        System.out.println(result);
        br.close();
    }

    private static long socks(int n, int k, int[] a) {
        // K is even
        if ((k & 1) == 0) {

            long ans = 0;

            for (int i = 0; i < k; i += 2) {
                ans += (long) a[i + 1] - a[i];
            }

            return ans;
        }

        long[] pref = new long[k];
        long[] suff = new long[k];

        // pref[i]
        // cost of pairing from left side up to i

        for (int i = 1; i < k; i += 2) {

            long curr = (long) a[i] - a[i - 1];

            pref[i] = curr;

            if (i >= 2) {
                pref[i] += pref[i - 2];
            }
        }

        // suff[i]
        // cost of pairing from i to end

        for (int i = k - 2; i >= 0; i -= 2) {

            long curr = (long) a[i + 1] - a[i];

            suff[i] = curr;

            if (i + 2 < k) {
                suff[i] += suff[i + 2];
            }
        }

        long ans = Long.MAX_VALUE;

        // Conceptually:
        // remove each possible sock
        //
        // Optimized observation:
        // only even positions need to be checked

        for (int remove = 0; remove < k; remove ++) {

            long cost = 0;

            // left part

            if (remove - 1 >= 0) {
                cost += pref[remove - 1];
            }

            // right part

            if (remove + 1 < k) {
                cost += suff[remove + 1];
            }

            ans = Math.min(ans, cost);
        }

        return ans;

    }

}