import java.io.*;

public class Problem1DReversi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int result = oneDReversi(s);
        System.out.println(result);
        br.close();
    }

    private static int oneDReversi(String s){
        char prev = s.charAt(0);
        int result = 1;

        for(char curr : s.toCharArray()){
            if(prev != curr){
                prev = curr;
                result++;
            }
        }

        return result-1;
    }
}