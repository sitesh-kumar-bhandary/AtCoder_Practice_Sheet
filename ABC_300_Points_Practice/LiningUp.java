package ABC_300_Points_Practice;
import java.io.*;

public class LiningUp {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] exp = br.readLine().split(" ");
        for(int i=0;i<n;i++)
            a[i] = Integer.parseInt(exp[i]);

        int result = liningUp(n, a);
        System.out.println(result);
        br.close();
    }

    private static int liningUp(int n, int[] a){
        int[] freq = new int[n+1];
        for(int i=0;i<n;i++){
            freq[a[i]]++;
        }
 
        if(n % 2 == 0){
            for(int i=1;i<=n;i+=2){
                if(freq[i] != 2)
                    return 0;
            }
        }

        else {
            if(freq[0] != 1)
                return 0;

            for(int i=2;i<=n;i+=2){
                if(freq[i] != 2)
                    return 0;
            }
        }

        int result = getPossibleWays(n/2);
        return result;
    }

    private static int getPossibleWays(int size){
        long val = 1;
        while(size != 0){
            val = (val * 2) % 1_000_000_007;
            size--;
        }

        return (int) val;
    }
}