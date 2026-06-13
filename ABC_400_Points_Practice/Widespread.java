package ABC_400_Points_Practice;
import java.io.*;

public class Widespread {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        long a = Long.parseLong(exp[1]);
        long b = Long.parseLong(exp[2]);

        long[] h = new long[n];
        for(int i=0;i<n;i++)
            h[i] = Long.parseLong(br.readLine());
        
        long result = widespread(n, a, b, h);
        System.out.println(result);
        br.close();
    }

    private static long widespread(int n, long a, long b, long[] h){
        long start = 1;
        long end = 1_000_000_000;
        long result = end;
        while(start <= end){
            long mid = start + (end - start) / 2;

            if(possible(mid, a, b, n, h)){
                result = mid;
                end = mid - 1;
            }

            else   
                start = mid + 1;
        }

        return result;
    }

    private static boolean possible(long mid, long a, long b, int n, long[] h){
        long totalSubB = mid * b;
        long rem = a - b;
        for(int i=0;i<n;i++){
            long val = h[i];
            val -= totalSubB;

            if(val > 0){
                long div = val / rem;

                if(val % rem != 0)
                    div++;

                mid -= div;
            }
        }

        return mid >= 0;
    }
}