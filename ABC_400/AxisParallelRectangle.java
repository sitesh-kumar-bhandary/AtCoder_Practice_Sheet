package ABC_400;
import java.io.*;
import java.util.*;

public class AxisParallelRectangle {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int k = Integer.parseInt(exp[1]);

        long[][] points = new long[n][2];
        for(int i=0;i<n;i++){
            String[] exp1 = br.readLine().split(" ");
            points[i][0] = Long.parseLong(exp1[0]);
            points[i][1] = Long.parseLong(exp1[1]);
        }

        long result = axisParallelRectangle(n, k, points);
        System.out.println(result);
        br.close();
    }

    private static long axisParallelRectangle(int n, int k, long[][] points){
        long result = Long.MAX_VALUE;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                long minX = Math.min(points[i][0], points[j][0]);
                long maxX = Math.max(points[i][0], points[j][0]);

                ArrayList<Long> yPoints = new ArrayList<>();
                for(int p=0;p<n;p++){
                    long currX = points[p][0];

                    if(currX >= minX && currX <= maxX)
                        yPoints.add(points[p][1]);
                }

                if(yPoints.size() < k)
                    continue;

                Collections.sort(yPoints);
                int size = yPoints.size();
                for(int p=0;p+k-1<size;p++){
                    long xDiff = maxX - minX;
                    long yDiff = yPoints.get(p+k-1) - yPoints.get(p);

                    long currArea = xDiff * yDiff;
                    result = Math.min(result, currArea);
                }
            }
        }

        return result;
    }
}
