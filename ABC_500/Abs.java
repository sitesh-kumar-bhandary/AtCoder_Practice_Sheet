package ABC_500;
import java.io.*;

public class Abs{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int z = Integer.parseInt(exp[1]);
        int w = Integer.parseInt(exp[2]);

        int[] a = new int[n];
        String[] exp1 = br.readLine().split(" ");
        for(int i=0;i<n;i++)
            a[i] = Integer.parseInt(exp1[i]);

        int result = abs(n, z, w, a);
        System.out.println(result);
        br.close();
    }

    private static int abs(int n, int z, int w, int[] a){
        if(n == 1)
            return Math.abs(a[0]-w);

        else {
            int result1 = Math.abs(a[n-1] - a[n-2]);
            int result2 = Math.abs(a[n-1]-w);

            return Math.max(result2, result1);
        }
    }
}