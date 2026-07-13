package ABC_400;
import java.io.*;
import java.util.*;

public class PracticalSkillTest {

    static HashMap<Integer, int[]> valToIndexMap = new HashMap<>();
    static HashMap<Integer, Integer> prefMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int h = Integer.parseInt(exp[0]);
        int w = Integer.parseInt(exp[1]);
        int d = Integer.parseInt(exp[2]);

        for(int i=0;i<h;i++){
            String[] exp1 = br.readLine().split(" ");
            for(int j=0;j<w;j++){
                int val = Integer.parseInt(exp1[j]);
                valToIndexMap.put(val, new int[]{i, j});
            }
        }

        practicalSkillTest(h, w, d);

        int q = Integer.parseInt(br.readLine());
        for(int i=0;i<q;i++){
            String[] exp1 = br.readLine().split(" ");
            int l = Integer.parseInt(exp1[0]);
            int r = Integer.parseInt(exp1[1]);

            System.out.println(prefMap.get(r) - prefMap.get(l));
        }

        br.close();
    }

    private static void practicalSkillTest(int h, int w, int d){
        for(int i=1;i<=h*w;i++){
            int j = i-d;

            if(j > 0){
                int[] prev = valToIndexMap.get(j);
                int[] curr = valToIndexMap.get(i);

                int result = Math.abs(prev[0] - curr[0]) + Math.abs(prev[1] - curr[1]);
                int prevResult = prefMap.get(j);
                prefMap.put(i, prevResult + result);                
            }

            else
                prefMap.put(i, 0);
        }
    }
}