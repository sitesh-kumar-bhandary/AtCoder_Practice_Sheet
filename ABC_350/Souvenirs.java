package ABC_350;
import java.io.*;
import java.util.*;

public class Souvenirs {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int m = Integer.parseInt(exp[1]);

        int[] a = new int[n];
        exp = br.readLine().split(" ");
        for(int i=0;i<n;i++)
            a[i] = Integer.parseInt(exp[i]);

        int[] b = new int[m];
        exp = br.readLine().split(" ");
        for(int i=0;i<m;i++)
            b[i] = Integer.parseInt(exp[i]);

        long result = souvenirs(n, m, a, b);
        System.out.println(result);
        br.close();
    }

    private static long souvenirs(int n, int m, int[] a, int[] b){
        Arrays.sort(a);
        Arrays.sort(b);

        long result = 0L;

        int j = 0;
        for(int i=0;i<n;i++){
            if(a[i] >= b[j]){
                result += (long) a[i];
                j++;

                if(j == m)
                    break;
            }
        }

        if(j != m)
            return -1;

        return result == 0L ? -1 : result;
    }
}