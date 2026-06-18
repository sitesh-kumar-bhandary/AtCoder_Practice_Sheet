package ABC_350;
import java.io.*;
import java.util.*;

public class ElectionQuickReport {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int m = Integer.parseInt(exp[1]);

        int[] a = new int[m];
        String[] exp1 = br.readLine().split(" ");
        for(int i=0;i<m;i++)
            a[i] = Integer.parseInt(exp1[i]);

        electionQuickReport(n, m, a);
        br.close();
    }

    private static void electionQuickReport(int n, int m, int[] a){
        int[] freq = new int[200001];
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;

        for(int i=0;i<m;i++){
            int val = a[i];
            freq[val]++;

            if(freq[val] >= maxFreq){
                maxFreq = freq[val];

                int prevVal = map.getOrDefault(maxFreq, Integer.MAX_VALUE);
                if(val < prevVal)
                    map.put(maxFreq, val);
            }

            System.out.println(map.get(maxFreq));            
        }
    }
}