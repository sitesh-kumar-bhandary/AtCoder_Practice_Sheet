import java.io.*;
import java.util.*;

public class ARC_061_A_300 {

    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        long result = manyFormulas(s);
        System.out.println(result);
        br.close();
    }

    private static long manyFormulas(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        helper(1, s, sb);

        long result = 0;
        for(String str : set){

            // System.out.println(str);

            long currResult = 0;
            String[] strArr = str.split("\\+");
            for(String ss : strArr){
                long curr = Long.parseLong(ss);
                currResult += curr;
            }

            result += currResult;
        }

        return result;
    }

    private static void helper(int ind, String s, StringBuilder sb){
        if(ind == s.length()){
            set.add(sb.toString());
            return;
        }

        // don't insert here
        sb.append(s.charAt(ind));
        helper(ind+1, s, sb);
        sb.deleteCharAt(sb.length()-1);

        // insert here
        sb.append('+');
        sb.append(s.charAt(ind));

        helper(ind+1, s, sb);

        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
    }
}