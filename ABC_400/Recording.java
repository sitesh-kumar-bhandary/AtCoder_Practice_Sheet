package ABC_400;
import java.io.*;
import java.util.*;

public class Recording {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int c = Integer.parseInt(exp[1]);

        int[][] time = new int[n][2];
        for(int i=0;i<n;i++){
            String[] exp1 = br.readLine().split(" ");
            int s = Integer.parseInt(exp1[0]);
            int t = Integer.parseInt(exp1[1]);
            time[i][0] = s;
            time[i][1] = t;
        }

        int result = recording(n, c, time);
        System.out.println(result);
        br.close();
    }

    private static int recording(int n, int c, int[][] time){
        Arrays.sort(time, (int[] a, int[] b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];

            else
                return a[1] - b[1];
        });

        ArrayList<ArrayList<int[]>> result = new ArrayList<>();
        for(int i=0;i<c;i++)
            result.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            int[] curr = time[i];

            for(int j=0;j<c;j++){
                ArrayList<int[]> list = result.get(j);

                if(list.size() == 0){
                    list.add(curr);
                    break;
                }

                int[] last = list.get(list.size()-1);
                if(curr[0] > last[1]){
                    list.add(curr);
                    break;
                }
            }
        }
        
        int ans = 0;
        for(ArrayList<int[]> list : result){
            if(list.size() != 0)
                ans++;
        }

        return ans;
    }
}