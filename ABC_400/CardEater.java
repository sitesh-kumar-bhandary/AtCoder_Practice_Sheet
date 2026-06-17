package ABC_400;
import java.io.*;
import java.util.*;

public class CardEater {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] exp = br.readLine().split(" ");
        int[] a = new int[n];
        for(int i=0;i<n;i++)
            a[i] = Integer.parseInt(exp[i]);

        int result = cardEater(n, a);
        System.out.println(result);
        br.close();
    }

    private static int cardEater(int n, int[] a){
        HashSet<Integer> set = new HashSet<>();
        for(int val : a)
            set.add(val);

        int distinct = set.size();
        int dubplicate = n - distinct;

        return dubplicate % 2 == 0 ? distinct : distinct - 1;
    }
}