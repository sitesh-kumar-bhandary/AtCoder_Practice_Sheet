package ABC_400;
import java.io.*;
import java.util.*;

public class EvenRelation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());    
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<n-1;i++){
            String[] exp = br.readLine().split(" ");
            int u = Integer.parseInt(exp[0])-1;
            int v = Integer.parseInt(exp[1])-1;
            int w = Integer.parseInt(exp[2]);

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        String result = evenRelation(n, adj);
        System.out.println(result);
        br.close();
    }

    public static String evenRelation(int n, ArrayList<ArrayList<int[]>> adj){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        int[] result = new int[n];
        Arrays.fill(result, -1);
        result[0] = 0;

        while(! queue.isEmpty()){
            int currNode = queue.poll();
            int currColor = result[currNode];

            for(int[] next : adj.get(currNode)){
                int newNode = next[0];
                int newWeight = next[1];

                if(result[newNode] == -1){
                    int newColor = newWeight % 2 == 0 ? currColor : 1-currColor;
                    queue.offer(newNode);
                    result[newNode] = newColor;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int val : result)
            sb.append(val).append("\n");

        return sb.toString();
    }
}