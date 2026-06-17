package ABC_300;
import java.io.*;
import java.util.*;

public class CatSnukeAndAVoyage {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int m = Integer.parseInt(exp[1]);

        HashSet<String> set = new HashSet<>();
        for(int i=0;i<m;i++){
            String[] exp1 = br.readLine().split(" ");
            int a = Integer.parseInt(exp1[0]);
            int b = Integer.parseInt(exp1[1]);

            String key1 = a + "#" + b;
            String key2 = b + "#" + a;
            set.add(key1);
            set.add(key2);
        }

        String result = catSnukeAndAVoyage(n, m, set);
        System.out.println(result);
        br.close();
    }

    private static String catSnukeAndAVoyage(int n, int m, HashSet<String> set){
        for(int i=2;i<n;i++){
            String key1 = 1 + "#" + i;
            String key2 = i + "#" + n;

            if(set.contains(key1) && set.contains(key2))
                return "POSSIBLE";
        }

        return "IMPOSSIBLE";
    }
}