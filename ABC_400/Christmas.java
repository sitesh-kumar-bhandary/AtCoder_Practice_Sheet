package ABC_400;
import java.io.*;

public class Christmas {

    static long[] layers;
    static long[] patties;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        long x = Long.parseLong(exp[1]);

        long result = christmas(n, x);
        System.out.println(result);
        br.close();
    }

    private static long christmas(int n, long x){
        layers = new long[n+1];
        patties = new long[n+1];

        layers[0] = 1;
        patties[0] = 1;

        for(int l=1;l<=n;l++){
            layers[l] = 2 * layers[l-1] + 3;
            patties[l] = 2 * patties[l-1] + 1;
        }

        long result = helper(n, x);
        return result;
    }

    private static long helper(int level, long x){
        if(level == 0)
            return 1;

        long prevLayers = layers[level-1];

        // Pattern : [B] + [Level L-1] + [P] + [Level L-1] + [B]

        // Case 1
        if(x == 1)
            return 0;

        // Case 2
        if(x <= prevLayers + 1)
            return helper(level-1, x-1);

        // Case 3
        if(x == prevLayers + 2)
            return patties[level-1] + 1;

        // Case 4
        if(x <= 2 * prevLayers + 2){
            long alreadyEatenPatties = patties[level-1] + 1;

            long remainingLayers = x - (prevLayers + 2);

            return alreadyEatenPatties + helper(level-1, remainingLayers);
        }

        // Case 5
        return patties[level];

    }
}