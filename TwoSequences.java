import java.io.*;
import java.util.HashMap;

public class TwoSequences {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] exp = br.readLine().split(" ");
        for(int i=0;i<n;i++)
            a[i] = Integer.parseInt(exp[i]);

        exp = br.readLine().split(" ");
        int[] b = new int[n];
        for(int i=0;i<n;i++)
            b[i] = Integer.parseInt(exp[i]);

        long result = twoSequences(n, a, b);
        System.out.println(result);
        br.close();
    }

    private static long twoSequences(int n, int[] a, int[] b){
        HashMap<Long, Long> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                long currSum = (long) a[i] + (long) b[j];
                map.put(currSum, map.getOrDefault(currSum, 0L)+1L);
            }
        }

        long result = 0L;
        for(long key : map.keySet()){
            if(map.get(key) % 2 != 0)
                result = result ^ key;
        }

        return result;
    }
}