package ABC_400;
import java.io.*;
import java.util.*;

public class TransitTreePath {

    static class Pair {
        int dest;
        long len;

        Pair(int dest, long len){
            this.dest = dest;
            this.len = len;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<n-1;i++){
            String[] exp = br.readLine().split(" ");
            int u = Integer.parseInt(exp[0])-1;
            int v = Integer.parseInt(exp[1])-1;
            long c = Long.parseLong(exp[2]);

            adj.get(u).add(new Pair(v, c));
            adj.get(v).add(new Pair(u, c));
        }

        String[] exp = br.readLine().split(" ");
        int q = Integer.parseInt(exp[0]);
        int k = Integer.parseInt(exp[1])-1;

        long[] distance = transitTreePath(n, k, adj);

        for(int i=0;i<q;i++){
            String[] exp1 = br.readLine().split(" ");
            int a = Integer.parseInt(exp1[0])-1;
            int b = Integer.parseInt(exp1[1])-1;

            long result = distance[a] + distance[b];
            System.out.println(result);
        }

        br.close();
    }

    private static long[] transitTreePath(int n, int src, ArrayList<ArrayList<Pair>> adj){
        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[src] = 0L;

        boolean[] visited = new boolean[n];
        visited[src] = true;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(src, 0L));

        while(! queue.isEmpty()){
            Pair curr = queue.poll();
            int currNode = curr.dest;

            for(Pair next : adj.get(currNode)){
                int nextNode = next.dest;
                long nextLen = next.len;

                if(! visited[nextNode]){
                    distance[nextNode] = Math.min(distance[nextNode], distance[currNode] + nextLen);
                    queue.offer(new Pair(nextNode, distance[nextNode]));
                    visited[nextNode] = true;
                }
            }
        }

        return distance;
    }
}