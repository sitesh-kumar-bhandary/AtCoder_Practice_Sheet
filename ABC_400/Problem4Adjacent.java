package ABC_400;
import java.io.*;

public class Problem4Adjacent {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        String[] exp = br.readLine().split(" ");
        for(int i=0;i<n;i++)
            a[i] = Integer.parseInt(exp[i]);

        String result = adjacent(n, a);
        System.out.println(result);
        br.close();
    }

    private static String adjacent(int n, int[] a){
        int remZeros = 0;
        int remTwos = 0;
        int remOthers = 0;
        for(int val : a){
            if(val % 4 == 0)
                remZeros++;

            else if(val % 4 == 2)
                remTwos++;

            else
                remOthers++;
        }

        if(remTwos > 0){
            if(remZeros >= remOthers)
                return "Yes";

            else
                return "No";
        }

        else {
            if(remZeros + 1 >= remOthers)
                return "Yes";

            return "No";
        }
    }
}