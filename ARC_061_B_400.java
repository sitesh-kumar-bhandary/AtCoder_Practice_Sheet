import java.io.*;
import java.util.*;

public class ARC_061_B_400 {
    public static void main(String[] args) throws IOException{

        HashSet<String> set = new HashSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        long h = Long.parseLong(exp[0]);
        long w = Long.parseLong(exp[1]);
        int n = Integer.parseInt(exp[2]);

        for(int i=0;i<n;i++){
            String key = br.readLine();
            set.add(key);
        }

        snukeColoring(h, w, n, set);
        br.close();
    }

    private static void snukeColoring(long h, long w, int n, HashSet<String> set){
        HashMap<Integer, Long> map = new HashMap<>();
        HashSet<String> visited = new HashSet<>();

        for(String s : set){
            String[] str = s.split(" ");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);

            int sr = (r-2 >= 1) ? r-2 : (r-1 >= 1 ? r-1 : r);
            int sc = (c-2 >= 1) ? c-2 : (c-1 >= 1 ? c-1 : c);

            for(int i=sr;i<=r;i++){
                for(int j=sc;j<=c;j++){

                    if(i > h-2 || j > w-2)
                        continue;

                    String newKey = i + " "+j;
                    if(! visited.contains(newKey)){

                        int colors = 0;
                        for(int k=i;k<i+3;k++){
                            for(int l=j;l<j+3;l++){
                                String key = k+" "+l;
                                if(set.contains(key)){
                                    colors++;
                                }
                            }
                        }

                        map.put(colors, map.getOrDefault(colors, 0L)+1L);
                        visited.add(newKey);
                    }
                }
            }
        }

        // counting total subrectanges having atleast some colors
        long totals = 0;
        for(long val : map.values())
            totals += val;

        long totalSubrectranges = (long) ((h-2) * (w-2));
        StringBuilder sb = new StringBuilder();
        sb.append(totalSubrectranges - totals).append("\n");
        for(int i=1;i<=9;i++){
            long val = map.getOrDefault(i, 0L);
            sb.append(val).append("\n");
        }

        System.out.println(sb.toString());
    }
}