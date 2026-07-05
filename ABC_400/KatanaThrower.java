package ABC_400;
import java.io.*;
import java.util.*;

public class KatanaThrower {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int h = Integer.parseInt(exp[1]);

        int[][] damages = new int[n][2];
        for(int i=0;i<n;i++){
            String[] exp1 = br.readLine().split(" ");
            damages[i][0] = Integer.parseInt(exp1[0]);
            damages[i][1] = Integer.parseInt(exp1[1]);
        }

        long result = katanaThrower(n, h, damages);
        System.out.println(result);
        br.close();
    }

    private static long katanaThrower(int n, int h, int[][] damages){
        long firstVal = 0L;
        for(int[] d : damages)
            firstVal = Math.max(firstVal, (long) d[0]);

        Arrays.sort(damages, (int[] a, int[] b) -> Integer.compare(b[1], a[1]));
        long totalPoints = 0L;
        long count = 0;
        
        for(int[] d : damages){
            if((long) d[1] > firstVal){
                totalPoints += (long) d[1];
                count++;
            }

            if(totalPoints >= h)
                return count;
        }

        long remainingPoints = ((long) h - totalPoints) + (firstVal-1);
        count += remainingPoints / firstVal;

        return count;
    }
}