package ABC_300;
import java.io.*;

public class SccPuzzle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        long n = Long.parseLong(exp[0]);
        long m = Long.parseLong(exp[1]);

        long result = sccPuzzle(n, m);
        System.out.println(result);
        br.close();
    }

    public static long sccPuzzle(long n, long m){
        long result = 0;

        if(m >= n*2){
            result += n;

            m -= (2*n);
            if(m >= 0){
                long div = m / 4;
                result += div;
            }
        }

        else
            result += m / 2;

        return result;
    }
}