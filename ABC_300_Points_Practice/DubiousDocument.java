package ABC_300_Points_Practice;
import java.io.*;

public class DubiousDocument {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] str = new String[n];
        for(int i=0;i<n;i++)
            str[i] = br.readLine();

        String result = dubiousDocument(n, str);
        System.out.println(result);
        br.close();
    }

    private static String dubiousDocument(int n, String[] str){
        StringBuilder sb = new StringBuilder();

        for(char ch ='a';ch<='z';ch++){

            int maxFreq = Integer.MAX_VALUE;
            for(String s : str){

                int currFreq = 0;
                for(char c : s.toCharArray()){
                    if(ch == c)
                        currFreq++;
                }

                maxFreq = Math.min(maxFreq, currFreq);
            }

            while(maxFreq != 0){
                sb.append(ch);
                maxFreq--;
            }
        }

        return sb.toString();
    }
}