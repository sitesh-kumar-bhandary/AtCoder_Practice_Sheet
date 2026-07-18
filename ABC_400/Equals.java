package ABC_400;
import java.io.*;

public class Equals {

    static class DisjointSet {
        int[] parent;
        int[] rank;

        DisjointSet(int n){
            parent = new int[n+1];
            for(int i=0;i<=n;i++)
                parent[i] = i;

            rank = new int[n+1];
        }

        public int find(int x){
            if(parent[x] != x)
                parent[x] = find(parent[x]);

            return parent[x];
        }

        public void union(int x, int y){
            int xParent = find(x);
            int yParent = find(y);

            if(xParent == yParent)
                return;

            if(rank[xParent] >= rank[yParent])
                parent[yParent] = xParent;

            else if(rank[xParent] < rank[yParent])
                parent[xParent] = yParent;

            else {
                parent[yParent] = xParent;
                rank[xParent]++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp =  br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int m = Integer.parseInt(exp[1]);

        DisjointSet ds = new DisjointSet(n);

        int[] premutation = new int[n];
        exp = br.readLine().split(" ");
        for(int i=0;i<n;i++)
            premutation[i] = Integer.parseInt(exp[i]);

        for(int i=0;i<m;i++){
            exp = br.readLine().split(" ");
            int x = Integer.parseInt(exp[0]);
            int y = Integer.parseInt(exp[1]);
            ds.union(x, y);
        }

        int result = 0;
        for(int i=1;i<=n;i++){
            if(ds.find(i) == ds.find(premutation[i-1]))
                result++;
        }

        System.out.println(result);
        br.close();
    }
}
