package ABC_400;
import java.io.*;
import java.util.*;

public class FennecVsSnuke {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<n-1;i++){
            String[] exp = br.readLine().split(" ");
            int a = Integer.parseInt(exp[0])-1;
            int b = Integer.parseInt(exp[1])-1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        String result = fennecVsSnuke(n, adj);
        System.out.println(result);
        br.close();
    }

    private static String fennecVsSnuke(int n, ArrayList<ArrayList<Integer>> adj){
        int[] dist1 = bfs(n, adj, 0);
        int[] dist2 = bfs(n, adj, n-1);

        int count = 0;
        for(int i=0;i<n;i++){
            if(dist1[i] <= dist2[i])
                count++;
        }

        return count * 2 > n ? "Fennec" : "Snuke";
    }

    private static int[] bfs(int n, ArrayList<ArrayList<Integer>> adj, int src){
        int[] dist = new int[n];
        dist[src] = 0;

        boolean[] visited = new boolean[n];
        visited[src] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);

        while(! queue.isEmpty()){
            int curr = queue.poll();

            for(int ngh : adj.get(curr)){
                if(! visited[ngh]){
                    queue.offer(ngh);
                    dist[ngh] = dist[curr] + 1;
                    visited[ngh] = true;
                }
            }
        }

        return dist;
    }
}