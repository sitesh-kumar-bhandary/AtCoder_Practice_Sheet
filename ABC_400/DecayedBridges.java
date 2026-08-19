package ABC_400;
import java.io.*;
import java.util.*;

public class DecayedBridges {

    static class DisjointSet {
        int[] parent;
        int[] size;

        DisjointSet(int n){
            parent = new int[n+1];
            for(int i=0;i<=n;i++)
                parent[i] = i;

            size = new int[n+1];
            Arrays.fill(size, 1);
        }

        public int find(int x){
            if(parent[x] != x)
                parent[x] = find(parent[x]);

            return parent[x];
        }

        public void union(int x, int y){
            int xParent = find(x);
            int yParent = find(y);

            if(size[xParent] >= size[yParent]){
                size[xParent] += size[yParent];
                parent[yParent] = xParent;
            }

            else {
                size[yParent] += size[xParent];
                parent[xParent] = yParent;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int m = Integer.parseInt(exp[1]);

        int[][] edges = new int[m][2];
        for(int i=0;i<m;i++){
            exp = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(exp[0]);
            edges[i][1] = Integer.parseInt(exp[1]);
        }

        String result = decayedBridges(n, m, edges);
        System.out.println(result);
        br.close();
    }

    private static String decayedBridges(int n, int m, int[][] edges){
        DisjointSet ds = new DisjointSet(n);
        long totalPairs = ((long) n * (n-1)) / 2;

        ArrayList<Long> result = new ArrayList<>();
        for(int i=m-1;i>=0;i--){
            result.add(totalPairs);

            int[] e = edges[i];
            int firstParent = ds.find(e[0]);
            int secondParent = ds.find(e[1]);
            if(firstParent != secondParent){
                int firstSize = ds.size[firstParent];
                int secondSize = ds.size[secondParent];

                long currPairs = (long) firstSize * secondSize;
                totalPairs -= currPairs;

                if(totalPairs < 0)
                    totalPairs = 0;

                ds.union(e[0], e[1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=result.size()-1;i>=0;i--)
            sb.append(result.get(i)).append("\n");

        return sb.toString();
    }
}