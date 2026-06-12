package ABC_500_Points_Practice;
import java.io.*;
import java.util.*;

public class Problem3NNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] a = new long[3*n];

        String[] exp = br.readLine().split(" ");
        for(int i=0;i<3*n;i++)
            a[i] = Long.parseLong(exp[i]);

        long result = threeNNumbers(n, a);
        System.out.println(result);
        br.close();
    }

    private static long threeNNumbers(int n, long[] a){
        PriorityQueue<Long> maxPQ = new PriorityQueue<>((Long b1, Long b2) -> Long.compare(b2, b1));
        long[] suffSum = new long[n+1];

        long currSum = 0;
        for(int i=3*n-1;i>=2*n;i--){
            currSum += a[i];
            maxPQ.add(a[i]);
        }

        for(int i=2*n-1;i>=n-1;i--){
            suffSum[i-(n-1)] = currSum;

            currSum += a[i];
            maxPQ.add(a[i]);
            if(maxPQ.size() > n){
                long first = maxPQ.poll();
                currSum -= first;
            } 
        }

        PriorityQueue<Long> minPQ = new PriorityQueue<>();
        currSum = 0;
        for(int i=0;i<n;i++){
            currSum += a[i];
            minPQ.add(a[i]);
        }

        long result = Long.MIN_VALUE;
        for(int i=n;i<=2*n;i++){
            result = Math.max(result, currSum - suffSum[i-n]);

            currSum += a[i];
            minPQ.add(a[i]);

            if(minPQ.size() > n){
                long val = minPQ.poll();
                currSum -= val;
            }
        }

        return result;
    }
}