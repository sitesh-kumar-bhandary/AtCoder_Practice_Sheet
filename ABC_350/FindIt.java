package ABC_350;
import java.io.*;
import java.util.*;

public class FindIt {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] next = new int[n+1];
        String[] exp = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            int u = i+1;
            int v = Integer.parseInt(exp[i]);
           next[u] = v;
        }
 
        findIt(n, next);
        br.close();
    }

    private static void findIt(int n, int[] next){
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> path = new ArrayList<>();

        int curr = 1;
        while(! map.containsKey(curr)){
            map.put(curr, path.size());
            path.add(curr);
            curr = next[curr];
        }

        int start = map.get(curr);
        System.out.println(path.size()-start);

        StringBuilder sb = new StringBuilder();
        for(int i=start; i<path.size();i++){
            sb.append(path.get(i)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}