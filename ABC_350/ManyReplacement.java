package ABC_350;
import java.io.*;

public class ManyReplacement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());

        char[] map = new char[26];
        for(int i=0;i<26;i++)
            map[i] = (char) ('a' + i);

        for(int i=0;i<q;i++){
            String exp = br.readLine();
            char c = exp.charAt(0);
            char d = exp.charAt(2);

            for(int j=0;j<26;j++){
                if(map[j] == c)
                    map[j] = d;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            sb.append(map[ch-'a']);
        }

        System.out.println(sb.toString());
        br.close();
    }
}