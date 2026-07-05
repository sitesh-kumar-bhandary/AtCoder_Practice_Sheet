package ABC_400;
import java.io.*;
import java.util.*;

public class ScoreAttack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");

        int n = Integer.parseInt(exp[0]);
        int m = Integer.parseInt(exp[1]);

        long[][] edges = new long[m][3];

        // Reverse graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for(int i = 0; i < m; i++){
            String[] exp1 = br.readLine().split(" ");

            int u = Integer.parseInt(exp1[0]) - 1;
            int v = Integer.parseInt(exp1[1]) - 1;
            long w = Long.parseLong(exp1[2]);

            edges[i][0] = u;
            edges[i][1] = v;
            edges[i][2] = -w;         

            adj.get(v).add(u);  
        }

        scoreAttack(n, m, edges, adj);
    }

    static void scoreAttack(int n, int m, long[][] edges, ArrayList<ArrayList<Integer>> adj){

        boolean[] canReachEnd = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n - 1);
        canReachEnd[n - 1] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int next : adj.get(node)){
                if(!canReachEnd[next]){
                    canReachEnd[next] = true;
                    queue.offer(next);
                }
            }
        }

        long INF = Long.MAX_VALUE;

        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for(int i = 0; i < n - 1; i++){

            boolean updated = false;

            for(int e = 0; e < m; e++){

                int u = (int)edges[e][0];
                int v = (int)edges[e][1];
                long w = edges[e][2];

                if(dist[u] == INF)
                    continue;

                if(dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                    updated = true;
                }
            }

            if(!updated)
                break;
        }

        for(int e = 0; e < m; e++){

            int u = (int)edges[e][0];
            int v = (int)edges[e][1];
            long w = edges[e][2];

            if(dist[u] == INF)
                continue;

            if(dist[u] + w < dist[v] && canReachEnd[v]){
                System.out.println("inf");
                return;
            }
        }

        System.out.println(-dist[n - 1]);
    }
}