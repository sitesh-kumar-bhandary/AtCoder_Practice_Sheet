package ABC_300;
import java.io.*;
import java.util.*;

public class BigArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        long k = Long.parseLong(exp[1]);

        int[][] a = new int[n][2];
        for(int i=0;i<n;i++){
            String[] exp1 = br.readLine().split(" ");
            a[i][0] = Integer.parseInt(exp1[0]);
            a[i][1] = Integer.parseInt(exp1[1]);
        }

        int result = bigArray(n, k, a);
        System.out.println(result);
        br.close();
    }

    private static int bigArray(int n, long k, int[][] a){
        Arrays.sort(a, ((int[] b1, int[] b2) -> Integer.compare(b1[0], b2[0])));

        for(int[] a1 : a){
            if(a1[1] >= k)
                return a1[0];

            else
                k = k - (long) a1[1];
        }

        return -1;
    }
}