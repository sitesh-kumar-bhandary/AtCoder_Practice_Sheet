package ABC_300_Points_Practice;
import java.io.*;
import java.util.*;

public class OneStrokePath {

    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int m = Integer.parseInt(exp[1]);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            String[] exp1 = br.readLine().split(" ");
            int a = Integer.parseInt(exp1[0])-1;
            int b = Integer.parseInt(exp1[1])-1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int result = oneStrokePath(n, m, adj);
        System.out.println(result);
        br.close();
    }

    private static int oneStrokePath(int n, int m, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[n];
        dfs(0, 0, visited, adj);

        return result;
    }

    private static void dfs(int node, int count, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        count++;

        for(int ngh : adj.get(node)){
            if(! visited[ngh])
                dfs(ngh, count, visited, adj);
        }

        if(count == adj.size())
            result++;

        visited[node] = false;
        count--;
    }
}