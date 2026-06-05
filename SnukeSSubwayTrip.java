import java.io.*;
import java.util.*;

public class SnukeSSubwayTrip {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<>());

        int m = Integer.parseInt(exp[1]);
        for(int i=0;i<m;i++){
            String[] exp1 = br.readLine().split(" ");
            int p = Integer.parseInt(exp1[0]);
            int q = Integer.parseInt(exp1[1]);
            int c = Integer.parseInt(exp1[2]);

            adj.get(p).add(new int[]{q, c});
            adj.get(q).add(new int[]{p, c});
        }

        int result = snukeSubwayTrip(n, m, adj);
        System.out.println(result);
        br.close();
    }

    private static int snukeSubwayTrip(int n, int m, ArrayList<ArrayList<int[]>> adj){
        if(m == 0)
            return -1;

        ArrayDeque<int[]> dq = new ArrayDeque<>(); 
        
        HashMap<Long, Integer> cost = new HashMap<>();
        long key = encode(1, 0);
        cost.put(key, 0);

        dq.addFirst(new int[]{1, 0, 0});
        while(! dq.isEmpty()){
            int[] curr = dq.removeFirst();
            int currNode = curr[0];
            int currLine = curr[1];
            int currCost = curr[2];

            long currKey = encode(currNode, currLine);
            if(currCost > cost.getOrDefault(currKey, Integer.MAX_VALUE))
                continue;

            if(currNode == n)
                return currCost;

            for(int[] next : adj.get(currNode)){
                int nextNode = next[0];
                int nextLine = next[1];

                int add = currLine == nextLine ? 0 : 1;
                int nextCost = currCost + add;

                long nextKey = encode(nextNode, nextLine);
                
                if(nextCost < cost.getOrDefault(nextKey, Integer.MAX_VALUE)){
                    cost.put(nextKey, nextCost);

                    if(add == 0)
                        dq.addFirst(new int[]{nextNode, nextLine, nextCost});

                    else
                        dq.addLast(new int[]{nextNode, nextLine, nextCost});
                }
            }
        }

        return -1;
    }

    private static long encode(int node ,int line){
        return (long) node * 200_001 + line;
    }
}