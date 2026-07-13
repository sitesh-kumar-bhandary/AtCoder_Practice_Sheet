package ABC_400;
import java.io.*;

public class RemainderReminder {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int k = Integer.parseInt(exp[1]);

        long result = remainderReminder(n, k);
        System.out.println(result);
        br.close();
    }

    private static long remainderReminder(int n, int k){
        long result = 0L;
        for(int b=k+1;b<=n;b++){
            int diff = b-k;
            int div = n / b;

            result = result + (long) (div * diff);
            int rem = n % b;

            if(rem >= k){
                if(k != 0)
                    result += (long) ((rem - k)+1);

                else
                    result += (long) (rem - k);
            }
                
        }

        return result;
    }
}