package ABC_400;
import java.io.*;
import java.util.*;

public class AnInvisibleHand {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int t = Integer.parseInt(exp[1]);

        String[] exp1 = br.readLine().split(" ");
        int[] a = new int[n];
        for(int i=0;i<n;i++)
            a[i] = Integer.parseInt(exp1[i]);

        int result = anInvisibleHand(n, t, a);
        System.out.println(result);
        br.close();
    }

    private static int anInvisibleHand(int n, int t, int[] a){
        int maxVal = a[n-1];
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        for(int i=n-2;i>=0;i--){
            int diff = maxVal - a[i];

            maxVal = Math.max(maxVal, a[i]);
            map.put(diff, map.getOrDefault(diff, 0)+1);
        }

        return map.get(map.firstKey());
    }
}
