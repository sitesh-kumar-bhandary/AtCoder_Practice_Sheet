package ABC_300_Points_Practice;
import java.io.*;

public class Pushpush {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        String[] exp = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(exp[i]);
        }

        String result = pushpush(n, a);
        System.out.println(result);
        br.close();
    }

    private static String pushpush(int n, int[] a){
        StringBuilder sb = new StringBuilder();
        for(int i=n-1;i>=0;i-=2)
            sb.append(a[i]).append(" ");

        if(n % 2 == 0){
            for(int i=0;i<n;i+=2)
                sb.append(a[i]).append(" ");
        }

        else {
            for(int i=1;i<n;i+=2)
                sb.append(a[i]).append(" ");
        }

        return sb.toString().trim();
    }
}