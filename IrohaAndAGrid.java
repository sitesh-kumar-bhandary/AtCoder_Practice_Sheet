import java.io.*;
import java.util.*;

public class IrohaAndAGrid {

    static HashMap<String, Long> dp = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int h = Integer.parseInt(exp[0]);
        int w = Integer.parseInt(exp[1]);
        int a = Integer.parseInt(exp[2]);
        int b = Integer.parseInt(exp[3]);

        int result = irohaAndGrid(h, w, a, b);
        System.out.println(result);
    }

    private static int irohaAndGrid(int h, int w, int a, int b){
        int mod = 1_000_000_007;
        long result = helper(1, 1, h-a+1, b, h, w);
        return (int) result % mod;
    }

    private static long helper(int r, int c, int row, int col, int h, int w){
        if(r > h || r < 0 || c > w || c < 0)
            return 0;

        if(r >= row && c <= col)
            return 0;

        if(r == h && c == w)
            return 1;

        String key = r+"#"+c;
        if(dp.containsKey(key))
            return dp.get(key);

        // take right
        long right = helper(r+1, c, row, col, h, w);

        // take down
        long down = helper(r, c+1, row, col, h, w);

        dp.put(key, right+down);
        return dp.get(key);
    }
}