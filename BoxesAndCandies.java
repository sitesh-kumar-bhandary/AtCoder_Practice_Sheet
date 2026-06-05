import java.io.*;

public class BoxesAndCandies {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        long x = Integer.parseInt(exp[1]);

        String[] exp1 = br.readLine().split(" ");
        long[] a = new long[n];
        for(int i=0;i<n;i++)
            a[i] = Long.parseLong(exp1[i]);

        long result = boxesAndCandies(n, x, a);
        System.out.println(result);
        br.close();
    }

    private static long boxesAndCandies(int n, long x, long[] a){
        long result = 0;
        for(int i=1;i<n;i++){
            if(a[i] + a[i-1] > x){
                long diff = Math.abs(x - (a[i]+a[i-1]));
                a[i] -= diff;
                result += diff;

                if(a[i] < 0){
                    long val = Math.abs(a[i]);
                    a[i] = 0;
                    a[i-1] -= val;
                }
            }
        }

        return result;
    }
}