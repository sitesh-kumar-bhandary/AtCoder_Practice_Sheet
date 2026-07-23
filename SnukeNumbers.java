import java.io.*;

public class SnukeNumbers {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());

        String result = snukeNumbers(k);
        System.out.println(result);
        br.close();
    }

    private static String snukeNumbers(long k){
        long INF = 1_000_000_000_000_000L;
        long count = 0L;
        StringBuilder sb = new StringBuilder();
        for(long i=1;i<=8;i++){
            sb.append(i).append("\n");
            count++;

            if(count == k)
                break;
        }

        for(long i=9;i<=INF;i+=10){
            sb.append(i).append("\n");
            count++;

            if(count == k)
                break;
        }

        return sb.toString();
    }
}