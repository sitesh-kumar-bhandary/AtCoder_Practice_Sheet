package ABC_400;
import java.io.*;
import java.util.*;

public class Connectivity {

    static class DisjointSet {
        int[] parent;
        int[] size;

        public DisjointSet(int n){
            this.parent = new int[n];
            for(int i=0;i<n;i++)
                this.parent[i] = i;

            this.size = new int[n];
            Arrays.fill(this.size, 1);
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

            if(size[xParent] < size[yParent]){
                parent[xParent] = yParent;
                size[yParent] += size[xParent];
            }

            else {
                parent[yParent] = xParent;
                size[xParent] += size[yParent];
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int k = Integer.parseInt(exp[1]);
        int l = Integer.parseInt(exp[2]);

        DisjointSet ds1 = new DisjointSet(n+1);
        for(int i=0;i<k;i++){
            String[] exp1 = br.readLine().split(" ");
            int p = Integer.parseInt(exp1[0]);
            int q = Integer.parseInt(exp1[1]);
            ds1.union(p, q);
        }

        DisjointSet ds2 = new DisjointSet(n+1);
        for(int i=0;i<l;i++){
            String[] exp1 = br.readLine().split(" ");
            int r = Integer.parseInt(exp1[0]);
            int s = Integer.parseInt(exp1[1]);
            ds2.union(r, s);
        }

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            int par1 = ds1.find(i);
            int par2 = ds2.find(i);
            String key = par1+"#" + par2;

            map.put(key, map.getOrDefault(key, 0)+1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            int par1 = ds1.find(i);
            int par2 = ds2.find(i);
            String key = par1+"#" + par2;

            sb.append(map.get(key)).append(" ");
        }
        System.out.println(sb.toString().trim());
        br.close();
    }
}