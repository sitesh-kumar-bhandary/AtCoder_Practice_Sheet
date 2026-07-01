import java.io.*;
import java.util.*;

public class FtRobot {

    static HashMap<String, Boolean> dp = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] exp = br.readLine().split(" ");
        int x = Integer.parseInt(exp[0]);
        int y = Integer.parseInt(exp[1]);

        String result = ftRobot(s, x, y);
        System.out.println(result);
        br.close();
    }

    private static String ftRobot(String s, int x, int y){
        boolean canXPossible = helper(0, 0, 0, x, s);
        boolean canYPossible = helper(0, 0, 0, y, s);
        return canXPossible && canYPossible ? "Yes" : "No";
    }

    private static boolean helper(int ind, int dir, int currX, int x, String s){
        if(ind == s.length()){
            if(currX == x)
                return true;

            return false;
        }

        String key = ind+"#"+dir+"#"+currX;
        if(dp.containsKey(key))
            return dp.get(key);

        boolean result = false;
        char ch = s.charAt(ind);
        if(ch == 'F'){
            if(dir == 0)
                currX++;

            else if(dir == 1)
                currX--;

            result = result | helper(ind+1, dir, currX, x, s);
        }

        else {
            if(dir == 1 || dir == 0){
                result = result | helper(ind+1, 2, currX, x, s);

                result = result | helper(ind+1, 3, currX, x, s);
            }
        }

        dp.put(key, result);
        return dp.get(key);
    }
}