package ABC_300;
import java.io.*;
import java.util.*;

public class ColorfulLeaderboard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        String[] exp = br.readLine().split(" ");
        for(int i=0;i<n;i++)
            a[i] = Integer.parseInt(exp[i]);

        colorfulLeaderboard(n, a);
        br.close();
    }

    private static void colorfulLeaderboard(int n, int[] a){
        HashSet<String> set = new HashSet<>();

        int count = 0;
        for(int val : a){

            if(val >= 3200)
                count++;

            else {
                String color = findColor(val);
                set.add(color);
            }
        }

        int size = set.size();
        int resultMin = size == 0 ? 1 : size;
        int resultMax = size+count;
        System.out.println(resultMin+" "+resultMax);
    }
    
    private static String findColor(int val){
        if(val < 400)
            return "gray";

        else if(val < 800)
            return "brown";

        else if(val < 1200)
            return "green";

        else if(val < 1600)
            return "cyan";

        else if(val < 2000)
            return "blue";

        else if(val < 2400)
            return "yellow";

        else if(val < 2800)
            return "orange";

        else
            return "red";
    }
}