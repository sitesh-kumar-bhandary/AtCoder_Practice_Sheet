import java.io.*;

public class AtcoderExpress {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n];
        int[] v = new int[n];
        String[] exp1 = br.readLine().split(" ");
        String[] exp2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(exp1[i]);
            v[i] = Integer.parseInt(exp2[i]);
        }

        double result = atcoderExpress(n, t, v);
        System.out.println(result);
        br.close();
    }

    private static double atcoderExpress(int n, int[] t, int[] v) {
        double totalArea = 0.0;

        if (n == 1) {
            if (t[0] > 2 * v[0]) {
                double currArea = v[0] * v[0];
                totalArea += currArea;

                double midArea = v[0] * (t[0] - 2 * v[0]);
                totalArea += midArea;
            }

            else {
                double currArea = (double) ((t[0] * t[0]) / (4.0));
                totalArea += currArea;
            }

            return totalArea;
        }

        int currSpeed = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                int remainTime = t[i] - currSpeed;
                double area1 = (currSpeed * currSpeed) / 2.0;
                totalArea += area1;

                if (v[i] > v[i - 1]) {
                    int remainSpeed = v[i] - v[i-1];

                    if(remainTime > 2*remainSpeed){
                        double area2 = (v[i] * v[i]) - (v[i-1] * v[i-1]);
                        double area3 = v[i] * (remainTime - 2 * remainSpeed);
                        totalArea += area2;
                        totalArea += area3;
                    }

                    else {
                        
                    }
                }

            }

            else {

            }

            return 0.0;
        }
    }

    private static double findAreaInSpecificRange(int time, int vel) {
        double totalArea = 0.0;

        if (time > 2 * vel) {
            double currArea = vel * vel;
            totalArea += currArea;

            double midArea = vel * (time - 2 * vel);
            totalArea += midArea;
        }

        else {
            double currArea = (double) ((time * time) / (4.0));
            totalArea += currArea;
        }

        return totalArea;
    }
}