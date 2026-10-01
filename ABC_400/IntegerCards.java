package ABC_400;
import java.io.*;
import java.util.*;

public class IntegerCards {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int m = Integer.parseInt(exp[1]);

        int[] a = new int[n];
        exp = br.readLine().split(" ");
        for(int i=0;i<n;i++)
            a[i] = Integer.parseInt(exp[i]);

        int[][] change = new int[m][2];
        for(int i=0;i<m;i++){
            exp = br.readLine().split(" ");
            change[i][0] = Integer.parseInt(exp[0]);
            change[i][1] = Integer.parseInt(exp[1]);
        }

        long result = integerCards(n, m, a, change);
        System.out.println(result);
        br.close();
    }

    private static long integerCards(int n, int m, int[] a, int[][] change){
        HashMap<Long, Long> currMap = new HashMap<>();
        for(int i=0;i<m;i++){
            long b = (long) change[i][0];
            long c = (long) change[i][1];

            currMap.put(c, currMap.getOrDefault(c, 0L)+b);
        }

        int size = currMap.size();
        long[][] newChange = new long[size][2];
        int i = 0;
        for(long key : currMap.keySet()){
            newChange[i][0] = key;
            newChange[i][1] = currMap.get(key);
            i++;
        }

        Arrays.sort(newChange, (long[] l1, long[] l2) -> Long.compare(l2[0], l1[0]));
        PriorityQueue<Long> minPq = new PriorityQueue<>();
        for(int val : a)
            minPq.add((long) val);

        for(i=0;i<size;i++){
            long[] curr = newChange[i];
            long currLength = curr[1];
            long currVal = curr[0];

            long j = 0;
            for(;j<currLength;j++){
                if(minPq.isEmpty() || minPq.peek() >= currVal)
                    break;

                minPq.poll();
                minPq.add(currVal);
            }

            if(j < currLength)
                break;
        }

        long result = 0L;
        while(! minPq.isEmpty()){
            long top = minPq.poll();
            result += top;
        }

        return result;
    }
}