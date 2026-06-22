package ABC_500;
import java.io.*;

public class RestoringRoadNetwork {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] roads = new long[n][n];
        for (int i = 0; i < n; i++) {

            String[] exp = br.readLine().split(" ");
            for (int j = 0; j < n; j++)
                roads[i][j] = Long.parseLong(exp[j]);
        }

        restoringRoadNetwork(n, roads);
        br.close();
    }

    private static void restoringRoadNetwork(int n, long[][] roads) {
        long result = 0L;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                boolean isRequired = true;
                for (int k = 0; k < n; k++) {

                    if(k == i || k == j)
                        continue;

                    if (roads[i][k] + roads[k][j] < roads[i][j]) {
                        System.out.println("-1");
                        return;
                    }

                    if (roads[i][k] + roads[k][j] == roads[i][j])
                        isRequired = false;
                }

                if (isRequired)
                    result += roads[i][j];
            }
        }

        System.out.println(result/2);
    }
}