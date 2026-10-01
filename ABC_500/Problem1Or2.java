package ABC_500;
import java.io.*;
import java.util.*;

public class Problem1Or2 {

    static class DisjointSet {
        int[] parent;
        int[] rank;

        DisjointSet(int size){
            this.parent = new int[size+1];
            for(int i=0;i<=size;i++)
                parent[i] = i;

            this.rank = new int[size+1];
            Arrays.fill(rank, 1);
        }

        public int find(int p){
            if(parent[p] != p)
                parent[p] = find(parent[p]);

            return parent[p];
        }

        public void union(int a, int b){
            int aRoot = find(a);
            int bRoot = find(b);

            if(rank[aRoot] > rank[bRoot]){
                parent[bRoot] = aRoot;
            }

            else if(rank[aRoot] < rank[bRoot]){
                parent[aRoot] = bRoot;
            }

            else {
                parent[bRoot] = aRoot;
                rank[aRoot]++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int m = Integer.parseInt(exp[1]);

        int[][] edges = new int[m][3];
        for(int i=0;i<m;i++){
            exp = br.readLine().split(" ");
            int x = Integer.parseInt(exp[0]);
            int y = Integer.parseInt(exp[1]);
            int z = Integer.parseInt(exp[2]);

            edges[i][0] = x;
            edges[i][1] = y;
            edges[i][2] = z;
        }

        long result = oneOrTwo(n, m, edges);
        System.out.println(result);
        br.close();
    }

    public static long oneOrTwo(int n, int m, int[][] edges){
        DisjointSet ds = new DisjointSet(n);
        for(int i=0;i<m;i++){
            ds.union(edges[i][0], edges[i][1]);
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i=1;i<=n;i++){
            int currParent = ds.find(i);
            set.add(currParent);
        }

        return set.size();
    }
}