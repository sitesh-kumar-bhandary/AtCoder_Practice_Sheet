package ABC_400_Points_Practice;
import java.io.*;

public class ARC_059_B_400 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        unbalanced(s);
    }

    private static void unbalanced(String s){
        int n = s.length();

        if(n > 1){
            for(int i=1;i<n;i++){
                if(s.charAt(i) == s.charAt(i-1)){
                    System.out.println((i)+" "+(i+1));
                    return;
                }
            }
        }

        if(n > 2){
            for(int i=2;i<n;i++){
                if(s.charAt(i) == s.charAt(i-2)){
                    System.out.println((i-1)+" "+(i+1));
                    return;
                }
            }
        }

        System.out.println("-1 -1");
    }
}
