package ABC_400;
import java.io.*;
import java.util.*;

public class PeopleOnALine {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<>());

        int m = Integer.parseInt(exp[1]);
        for(int i=0;i<m;i++){
            String[] exp1 = br.readLine().split(" ");
            int l = Integer.parseInt(exp1[0]);
            int r = Integer.parseInt(exp1[1]);

            int d = Integer.parseInt(exp1[2]);

            adj.get(l).add(new int[]{r, d});
            adj.get(r).add(new int[]{l, -d});
        }

        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        boolean result = true;
        for(int i=0;i<=n;i++){
            if(! visited[i])
                result = result & dfs(i, visited, distance, adj);

            if(result == false)
                break;
        }

        if(result)
            System.out.println("Yes");

        else
            System.out.println("No");

        br.close();
    }

    private static boolean dfs(int val, boolean[] visited, int[] distance, ArrayList<ArrayList<int[]>> adj){
        Stack<Integer> stack = new Stack<>();

        stack.push(val);
        distance[val] = 0;

        visited[val] = true;

        while(! stack.isEmpty()){
            int curr = stack.pop();

            for(int[] ngh : adj.get(curr)){
                int node = ngh[0];
                int dist = ngh[1];
                
                if(! visited[node]){
                    distance[node] = distance[curr] + dist;
                    stack.push(node);
                    visited[node] = true;
                }

                else {
                    int currDist = distance[node] - distance[curr];
                    if(currDist != dist)
                        return false;
                }
            }
        }

        return true;
    }
}
