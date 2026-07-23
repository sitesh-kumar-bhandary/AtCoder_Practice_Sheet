import java.io.*;
import java.util.*;

public class PatisserieAbc {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int m = Integer.parseInt(exp[1]);

        long[] combinedValue = new long[n];
        for(int i=0;i<n;i++){
            exp = br.readLine().split(" ");
            long b = Long.parseLong(exp[0]);
            long t = Long.parseLong(exp[1]);
            long p = Long.parseLong(exp[2]);

            long total = Math.abs(b) + Math.abs(t) + Math.abs(p);
            combinedValue[i] = total;
        }

        Arrays.sort(combinedValue);
        long result = 0L;
        for(int i=n-1;i>=0;i--){
            result += combinedValue[i];
            m--;

            if(m == 0)
                break;
        }

        System.out.println(result);
        br.close();
    }
}