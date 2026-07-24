package ABC_400;
import java.io.*;
import java.util.*;

public class Handstand {
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int k = Integer.parseInt(exp[1]);
        String s = br.readLine();

        int result = handstand(n, k, s);
        System.out.println(result);
        br.close();
    }

    private static int handstand(int n, int k, String s){
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{-1, -1});

        int start = -1;
        int end = -1;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            if(ch == '0'){
                if(start == -1){
                    start  = i;
                    end = i;
                }

                else
                    end = i;
            }

            else {
                if(start != -1 && end != -1){
                    list.add(new int[]{start, end});
                    start = -1;
                    end = -1;
                }
            }
        }

        if(start != -1 && end != -1)
            list.add(new int[]{start, end});

        list.add(new int[]{n, n});

        int size = list.size();
        if(size-2 <= k)
            return s.length();

        int result = 0;
        for(int i=1;i<size-k;i++){
            int endPoint = list.get(i+k)[0];
            int startPoint = list.get(i-1)[1];
            int sizeDiff = endPoint - startPoint -1;
            result = Math.max(result, sizeDiff);
        }

        return result;
    }
}