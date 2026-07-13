package ABC_350;
import java.io.*;
import java.util.*;

public class IdealHolidays {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int a = Integer.parseInt(exp[1]);
        int b = Integer.parseInt(exp[2]);

        int[] d = new int[n];
        String[] exp1 = br.readLine().split(" ");
        for(int i=0;i<n;i++)
            d[i] = Integer.parseInt(exp1[i]);

        String result = idealHolidays(n, a, b, d);
        System.out.println(result);
        br.close();
    }

    private static String idealHolidays(int n, int a, int b, int[] d){
        int totalDays = a + b;
        for(int i=0;i<n;i++){
            d[i] = d[i] % totalDays;
        }

        Arrays.sort(d);
        int maxDiff = d[0] + totalDays - d[n-1];

        for(int i=1;i<n;i++){
            int currDiff = d[i] - d[i-1];

            maxDiff = Math.max(maxDiff, currDiff);
        }

        if(maxDiff > b)
            return "Yes";

        return "No";
    }
}