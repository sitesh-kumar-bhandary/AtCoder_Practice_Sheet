package ABC_400;
import java.io.*;
import java.util.*;

public class FiveFiveEverywhere {

    static int INF = 55_555;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String result = fiveFiveEverywhere(n);
        System.out.println(result);
        br.close();
    }

    private static String fiveFiveEverywhere(int n){
        boolean[] isPrime = seive();

        StringBuilder sb = new StringBuilder();
        int j = 0;
        for(int i=1;i<=INF;i++){
            if(isPrime[i] && i % 5 == 1){
                sb.append(i).append(" ");
                j++;
            }

            if(j == n)
                break;
        }

        return sb.toString();
    }

    private static boolean[] seive(){
        boolean[] prime = new boolean[INF+1];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for(int i=2;i*i<=INF;i++){
            if(prime[i]){
                for(int j=i*i;j<=INF;j+=i)
                    prime[j] = false;
            }
        }

        return prime;
    }
}