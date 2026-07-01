import java.io.*;

public class OneTimeSwap {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        long result = oneTimeSwap(s);
        System.out.println(result);
        br.close();
    }

    private static long oneTimeSwap(String s){
        int n = s.length();

        int[] freq = new int[26];
        freq[s.charAt(n-1)-'a']++;
        long result = 0;
        for(int i=n-2;i>=0;i--){
            int ind = s.charAt(i)-'a';

            long currResult = 0;
            int count = 0;

            for(int j=0;j<26;j++){
                if(freq[j] > 0){
                    currResult += freq[j];
                    count++;
                }
            }

            if(freq[ind] == 0)
                count++;

            result = count == 1 ? 1 : result + currResult;

            freq[ind]++;
        }

        return result;
    }
}