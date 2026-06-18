package ABC_400;
import java.io.*;

public class ColoringDominoes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();

        long result = coloringDominoes(n, s1, s2);
        System.out.println(result);
        br.close();
    }

    private static long coloringDominoes(int n, String s1, String s2){
        int mod = 1_000_000_007;

        long result = 1L;
        int i = 0;

        if(s1.charAt(0) == s2.charAt(0)){
            result = (result * 3L) % mod;
            i++;
        }

        else {
            result = (result * 6L) % mod;
            i += 2;
        }

        while(i < n){
            if(s1.charAt(i-1) == s2.charAt(i-1)){
                if(s1.charAt(i) == s2.charAt(i)){
                    result = (result * 2L) % mod;
                    i++;
                }

                else {
                    result = (result * 2L) % mod;
                    i += 2;
                }
            }

            else {
                if(s1.charAt(i) == s2.charAt(i)){
                    result = (result * 1L) % mod;
                    i++;
                }

                else {
                    result = (result * 3L) % mod;
                    i += 2;
                }
            }
        }

        return result;
    }
}