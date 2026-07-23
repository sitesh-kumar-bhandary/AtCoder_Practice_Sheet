package ABC_400;
import java.io.*;
import java.util.*;

public class IslandsWar {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int m = Integer.parseInt(exp[1]);

        int[][] bridge = new int[m][2];
        for(int i=0;i<m;i++){
            exp = br.readLine().split(" ");
            bridge[i][0] = Integer.parseInt(exp[0]);
            bridge[i][1] = Integer.parseInt(exp[1]);
        }

        int result = islandWar(n, m, bridge);
        System.out.println(result);
        br.close();
    }

    private static int islandWar(int n, int m, int[][] bridge){
        Arrays.sort(bridge, (int[] a, int[] b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];

            else
                return a[1] - b[1];
        });


        ArrayList<int[]> list = new ArrayList<>();
        list.add(bridge[0]);

        for(int i=1;i<m;i++){
            int size = list.size();

            int[] curr = bridge[i];
            int currStart = curr[0];
            int currEnd = curr[1];

            int[] prev = list.get(list.size()-1);
            int prevEnd = prev[1];

            if(currStart < prevEnd){
                int newStart = Math.min(currStart, prevEnd);
                int newEnd = Math.min(prevEnd, currEnd);
                list.get(size-1)[0] = newStart;
                list.get(size-1)[1] = newEnd;
            }

            else
                list.add(curr);
        }

        return list.size();
    }
}