package ABC_400;
import java.io.*;
import java.util.*;

public class LazyFaith {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Long> shrineSet = new TreeSet<>();
        TreeSet<Long> templeSet = new TreeSet<>();

        String[] exp = br.readLine().split(" ");
        int a = Integer.parseInt(exp[0]);
        int b = Integer.parseInt(exp[1]);
        int q = Integer.parseInt(exp[2]);

        for(int i=0;i<a;i++)
            shrineSet.add(Long.parseLong(br.readLine()));

        for(int i=0;i<b;i++)
            templeSet.add(Long.parseLong(br.readLine()));

        long INF = 1_000_000_000_000_000_000L;
        shrineSet.add(-INF);
        shrineSet.add(INF);

        templeSet.add(-INF);
        templeSet.add(INF);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<q;i++){
            long val = Long.parseLong(br.readLine());
            long result = Long.MAX_VALUE;

            long prevShrine = shrineSet.floor(val);
            long nextShrine = shrineSet.ceiling(val);
            long[] shrine = {prevShrine, nextShrine};

            long prevTemple = templeSet.floor(val);
            long nextTemple = templeSet.ceiling(val);
            long[] temple = {prevTemple, nextTemple};

            for(long s : shrine){
                for(long t : temple){

                    // from s --> t
                    result = Math.min(result, Math.abs(val - s)+Math.abs(s - t));

                    // from t --> s
                    result = Math.min(result, Math.abs(val - t) + Math.abs(s - t));
                }
            }

            sb.append(result).append("\n"); 
        }

        System.out.println(sb.toString());
        br.close();
    }
}