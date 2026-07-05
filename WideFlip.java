import java.io.*;

public class WideFlip {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int result = wideFlip(s);
        System.out.println(result);
        br.close();
    }

    private static int wideFlip(String s){
        int n = s.length();

        int maxConsecutiveZeros = 0;
        int zeros = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            if(ch == '1'){
                maxConsecutiveZeros = Math.max(maxConsecutiveZeros, zeros);
                zeros = 0;
            }

            else
                zeros++;f
        }

        maxConsecutiveZeros = Math.max(maxConsecutiveZeros, zeros);
        return maxConsecutiveZeros;
    }
}