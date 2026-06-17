package ABC_300;
import java.io.*;

public class Sentou {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        long t = Long.parseLong(exp[1]);

        long[] times = new long[n];
        String[] exp1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            times[i] = Long.parseLong(exp1[i]);

        long result = sentou(n, t, times);
        System.out.println(result);
        br.close();
    }

    private static long sentou(int n, long t, long[] times){
        long result = 0;
        long currTime = times[0];
        long startTime = currTime;

        for(int i=1;i<=n;i++){
            currTime = times[i-1] + t;

            if(i == n)
                break;

            if(currTime < times[i]){
                result += (currTime - startTime);
                startTime = times[i];
                currTime = -1;
            }
        }

        if(currTime != -1)
            result += currTime - startTime;

        return result;
    }
}