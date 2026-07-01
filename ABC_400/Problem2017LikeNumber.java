package ABC_400;
import java.io.*;
import java.util.*;

public class Problem2017LikeNumber {
    public static void main(String[] args) throws Exception {

        boolean[] isPrime = seive(100000);
        HashMap<Integer, Integer> likePrimeMap = new HashMap<>();

        int count = 0;
        for(int i=0;i<=100000;i++){
            if(isPrime[i]){
                if(isPrime[(i+1)/2])
                    count++;
            }

            likePrimeMap.put(i, count);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        for(int i=0;i<q;i++){
            String[] exp = br.readLine().split(" ");
            int l = Integer.parseInt(exp[0]);
            int r = Integer.parseInt(exp[1]);

            int result = likePrimeMap.get(r) - likePrimeMap.get(l-1);
            System.out.println(result);
        }

        br.close();
    }

    private static boolean[] seive(int n){
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=n;j+=i)
                    isPrime[j] = false;
            }
        }

        return isPrime;
    }
}