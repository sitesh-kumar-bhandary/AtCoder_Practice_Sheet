package ABC_400;
import java.io.*;

public class XorWorld {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        long a = Long.parseLong(exp[0]);
        long b = Long.parseLong(exp[1]);

        long result = xorWorld(a, b);
        System.out.println(result);
        br.close();
    }

    private static long xorWorld(long a, long b){
        long result = 0;

        long start = a % 2 == 0 ? a : a+1;
        long end = b % 2 == 1 ? b : b-1;

        long diff = (end - start + 1) / 2;
        if(diff % 2 == 1)
            result = 1;

        if(a % 2 == 1)
            result = result ^ a;

        if(b % 2 == 0)
            result = result ^ b;

        return result;
    }
}