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
        int start = 1;
        int end = s.length();
        int result = 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(isPossibleToConvert(mid, s)){
                result = mid;
                start = mid + 1;
            }

            else
                end = mid - 1;
        }

        return result;
    }

    private static boolean isPossibleToConvert(int mid, String s){
        int n = s.length();

        char[] str = s.toCharArray();
        for(int i=0;i<n-mid;i++){

            if(str[i] == '1'){
                for(int j=i;j<mid;j++)
                    str[j] = (str[j] == '1' ? '0' : '1');
            }
        }

        for(int i=n-mid;i<n;i++){
            if(str[i] == '1')
                return false;
        }

        return true;
    }
}