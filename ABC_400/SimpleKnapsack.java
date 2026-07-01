package ABC_400;
import java.io.*;
import java.util.*;

public class SimpleKnapsack {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int w = Integer.parseInt(exp[1]);

        int[] weight = new int[n];
        int[] value = new int[n];
        for(int i=0;i<n;i++){
            String[] exp1 = br.readLine().split(" ");
            weight[i] = Integer.parseInt(exp1[0]);
            value[i] = Integer.parseInt(exp1[1]);
        }

        long result = simpleKnapsack(n, w, weight, value);
        System.out.println(result);
        br.close();
    }

    private static long simpleKnapsack(int n, int w, int[] weight, int[] value){
        ArrayList<ArrayList<Integer>> groupedWts = new ArrayList<>();
        for(int i=0;i<4;i++)
            groupedWts.add(new ArrayList<>());

        long firstWt = (long) weight[0];
        for(int i=0;i<n;i++){
            int val = weight[i];
            groupedWts.get(val-(int) firstWt).add(value[i]);
        }

        for(int i=0;i<4;i++)
            Collections.sort(groupedWts.get(i), Collections.reverseOrder());

        ArrayList<long[]> pref = new ArrayList<>();

        for(int i=0;i<4;i++){
            ArrayList<Integer> currGr = groupedWts.get(i);
            long[] prefix = new long[currGr.size()+1];
            prefix[0] = 0;
            for(int j=1;j<=currGr.size();j++)
                prefix[j] = prefix[j-1] + currGr.get(j-1);

            pref.add(prefix);
        }

        long maxTotalVal = 0L;
        for(int a=0;a<=groupedWts.get(0).size();a++){
            for(int b=0;b<=groupedWts.get(1).size();b++){
                for(int c=0;c<=groupedWts.get(2).size();c++){
                    for(int d=0;d<=groupedWts.get(3).size();d++){
                        long totalWt = a*(firstWt) + b*(firstWt+1L) + c*(firstWt+2L) + d*(firstWt+3L);

                        if(totalWt <= w){
                            long currTotalVal = pref.get(0)[a] + pref.get(1)[b] + pref.get(2)[c] + pref.get(3)[d];
                            maxTotalVal = Math.max(maxTotalVal, currTotalVal);
                        }
                    }
                }
            }
        }

        return maxTotalVal;
    }
}