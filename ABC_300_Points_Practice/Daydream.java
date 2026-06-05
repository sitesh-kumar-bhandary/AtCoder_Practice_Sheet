package ABC_300_Points_Practice;
import java.io.*;

public class Daydream {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        boolean result = daydream(s);
        System.out.println(result == true ? "YES" : "NO");
        br.close();
    }

    private static boolean daydream(String s){
        String[] str = {"dream", "dreamer", "erase", "eraser"};

        StringBuilder sb = new StringBuilder(s);
        while(sb.length() != 0){
            int prevLength = sb.length();

            for(int i=0;i<4;i++){
                String newStr = str[i];
                int len = newStr.length();

                if(prevLength >= len && sb.substring(prevLength-len).equals(newStr)){
                    sb.delete(prevLength-len, prevLength);
                    break;
                }
            }

            int currLength = sb.length();
            if(prevLength == currLength)
                return false;
        }

        return true;
    }
}