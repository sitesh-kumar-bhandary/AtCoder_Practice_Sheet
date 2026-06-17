package ABC_400;
import java.io.*;
import java.util.*;

public class CandidatesOfNoShortestPaths {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp1 = br.readLine().split(" ");
        int n = Integer.parseInt(exp1[0]);
        int m = Integer.parseInt(exp1[1]);

        int[][] dist = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++)
            dist[i][i] = 0;

        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            String[] exp2 = br.readLine().split(" ");
            int a = Integer.parseInt(exp2[0]);
            int b = Integer.parseInt(exp2[1]);
            int c = Integer.parseInt(exp2[2]);
            edges[i][0] = a;
            edges[i][1] = b;
            edges[i][2] = c;

            dist[a][b] = c;
            dist[b][a] = c;
        }

        int result = candidatesOfNoShortestPaths(n, m, dist, edges);
        System.out.println(result);
        br.close();
    }

    private static int candidatesOfNoShortestPaths(int n, int m, int[][] dist, int[][] edges) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (dist[j][i] != Integer.MAX_VALUE && dist[i][k] != Integer.MAX_VALUE) {

                        dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                    }
                }
            }
        }

        int result = 0;
        for (int[] e : edges) {
            boolean used = false;

            for (int i = 1; i <= n; i++) {
                if (dist[i][e[0]] + e[2] == dist[i][e[1]] ||
                        dist[i][e[1]] + e[2] == dist[i][e[0]]) {
                    used = true;
                    break;
                }
            }

            if (!used)
                result++;
        }

        return result;
    }
}