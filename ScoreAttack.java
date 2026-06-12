import java.io.*;
import java.util.*;

public class ScoreAttack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);

        ArrayList<ArrayList<long[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        int m = Integer.parseInt(exp[1]);
        int[] inDegree = new int[n];
        for(int i=0;i<m;i++){
            String[] exp1 = br.readLine().split(" ");
            int a = Integer.parseInt(exp1[0])-1;
            int b = Integer.parseInt(exp1[1])-1;
            long c = Long.parseLong(exp1[2]);
            adj.get(a).add(new long[]{b, c});

            inDegree[b]++;
        }

        boolean isCycle = detectCycle(n, inDegree, adj);
        if(isCycle)
            System.out.println("inf");

        else {
            long result = scoreAttact(n, adj);
            System.out.println(result);
        }

        br.close();
    }

    private static long scoreAttact(int n, ArrayList<ArrayList<long[]>> adj){
        boolean[] visited = new boolean[n];
        visited[0] = true;

        long[] result = new long[n];
        Arrays.fill(result, Long.MIN_VALUE);
        result[0] = 0;

        Stack<long[]> stack = new Stack<>();
        stack.push(new long[]{0L, 0L});

        while(! stack.isEmpty()){
            long[] curr = stack.pop();
            long currNode = curr[0];
            long currWt = curr[1];

            for(long[] next : adj.get((int) currNode)){
                long nextNode = next[0];
                long nextWt = next[1];

                if(currWt + nextWt > result[(int) nextNode]){
                    result[(int) nextNode] = currWt + nextWt;
                    stack.push(new long[]{nextNode, result[(int) nextNode]});
                }
            }
        }

        return result[n-1];
    }

    private static boolean detectCycle(int n, int[] inDegree, ArrayList<ArrayList<long[]>> adj){
        int countZeroIndegrees = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i] == 0){
                queue.offer(i);
                countZeroIndegrees++;
            }
        }

        while(! queue.isEmpty()){
            int node = queue.poll();

            for(long[] next : adj.get(node)){
                inDegree[(int) next[0]]--;

                if(inDegree[(int) next[0]] == 0){
                    queue.offer((int) next[0]);
                    countZeroIndegrees++;
                }
            }
        }

        if(countZeroIndegrees != n)
            return true;

        return false;
    }
}