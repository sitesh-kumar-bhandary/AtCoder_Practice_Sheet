package ABC_400;
import java.io.*;
import java.util.*;

public class Equeue {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int k = Integer.parseInt(exp[1]);

        int[] v = new int[n];
        exp = br.readLine().split(" ");
        for(int i=0;i<n;i++)
            v[i] = Integer.parseInt(exp[i]);

        int result = equeue(n, k, v);
        System.out.println(result);
        br.close();
    }

    private static int equeue(int n, int k, int[] v){
        int result = Integer.MIN_VALUE;

        for(int start=0; start<=Math.min(n, k); start++){
            for(int end=0; end <= k-start; end++){

                int currSum = 0;
                PriorityQueue<Integer> minPq = new PriorityQueue<>();

                if(start + end > n)
                    continue;

                for(int i=0; i<start; i++){
                    minPq.add(v[i]);
                    currSum += v[i];
                }

                for(int j=n-1; j>=(n-end); j--){
                    minPq.add(v[j]);
                    currSum += v[j];
                }

                int removeCount = k - start - end;

                while(! minPq.isEmpty() && removeCount != 0){
                    int top = minPq.peek();
                    if(top >= 0)
                        break;

                    currSum -= top;
                    minPq.remove();
                    removeCount--;
                }

                result = Math.max(result, currSum);
            }
        }

        return result;
    }
}