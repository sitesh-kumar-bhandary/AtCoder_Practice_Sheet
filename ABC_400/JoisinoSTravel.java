package ABC_400;
import java.io.*;
import java.util.*;

public class JoisinoSTravel {

    static int INF = 1_000_000_0;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int m = Integer.parseInt(exp[1]);
        int r = Integer.parseInt(exp[2]);

        int[][] distance = new int[n+1][n+1];
        for(int[] arr : distance)
            Arrays.fill(arr, INF);

        for(int i=0;i<=n;i++)
            distance[i][i] = 0;

        String[] exp1 = br.readLine().split(" ");
        int[] cities = new int[r];
        for(int i=0;i<r;i++)
            cities[i] = Integer.parseInt(exp1[i]);

        for(int i=0;i<m;i++){
            String[] exp2 = br.readLine().split(" ");
            int a = Integer.parseInt(exp2[0]);
            int b = Integer.parseInt(exp2[1]);
            int c = Integer.parseInt(exp2[2]);

            distance[a][b] = c;
            distance[b][a] = c;
        }

        // Using floyd-warshall algorithm here
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        joisonTravel(r, cities, distance);
        System.out.println(result);
        br.close();
    }

    private static void joisonTravel(int r, int[] cities, int[][] distance){
        boolean[] visited = new boolean[r];
        for(int i=0;i<r;i++){
            visited[i] = true;
            helper(cities[i], 1, 0, cities, visited, distance);
            visited[i] = false;
        }
    }

    private static void helper(int prev, int count, int totalCost, int[] cities, boolean[] visited, int[][] distance){
        if(count == cities.length){
            result = Math.min(result, totalCost);
            return;
        }

        for(int i=0;i<cities.length;i++){

            if(! visited[i]){
                visited[i] = true;
                helper(cities[i], count+1, totalCost+distance[prev][cities[i]], cities, visited, distance);
                visited[i] = false;
            }
        }
    }
}