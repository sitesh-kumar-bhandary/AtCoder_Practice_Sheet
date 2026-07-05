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
    }
}