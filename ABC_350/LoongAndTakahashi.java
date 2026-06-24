package ABC_350;
import java.io.*;

public class LoongAndTakahashi {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        loongAndTakahashi(n);
        br.close();
    }

    private static void loongAndTakahashi(int n) {
        int[][] arr = new int[n+1][n+1];
        int half = (n+1)/2;
        arr[half][half] = 10000;

        int val = 1;
        int counter = 1;

        while (counter < (n+1) / 2) {
            // I - Printing the top row
            for (int c = counter; c <= n-counter+1; c++) {
                int r = counter;
                arr[r][c] = val++;
            }

            // II - Printing the last column
            for (int r = counter + 1; r <= n-counter+1; r++) {
                int c = n-counter+1;
                arr[r][c] = val++;
            }

            // III - Printing the last row
            for (int c = n-counter; c >= counter; c--) {
                int r = n-counter+1;
                arr[r][c] = val++;
            }

            // IV - Printing the first column
            for (int r = n-counter; r > counter; r--) {
                int c = counter;
                arr[r][c] = val++;
            }

            counter++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == 10000)
                    sb.append('T').append(" ");

                else
                    sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}