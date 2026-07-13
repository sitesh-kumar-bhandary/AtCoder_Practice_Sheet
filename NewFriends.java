import java.io.*;
import java.util.*;

public class NewFriends {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int m = Integer.parseInt(exp[1]);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            exp = br.readLine().split(" ");
            int a = Integer.parseInt(exp[0]);
            int b = Integer.parseInt(exp[1]);

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        if(m <= 1){
            System.out.println("0");
            return;
        }

        long result = newFriends(n, m, adj);
        System.out.println(result);
        br.close();
    }

    private static long newFriends(int n, int m, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[n+1];
        long result = 0L;
        for(int i=1;i<=n;i++){
            if(! visited[i]){
                result += bfs(i, visited, adj);
            }
        }

        return result;
    }

    private static long bfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        long nodeCount = 1L;
        long edgeCount = 0L;

        while(! queue.isEmpty()){
            int curr = queue.poll();

            edgeCount += adj.get(curr).size();
            for(int ngh : adj.get(curr)){
                if(! visited[ngh]){
                    queue.offer(ngh);
                    nodeCount++;
                    visited[ngh] = true;
                }
            }
        }

        return ((nodeCount*(nodeCount-1)) / 2L) - (edgeCount / 2L);
    }
}