package ABC_300_Points_Practice;
import java.io.*;

public class XYetAnotherDieGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long x = Long.parseLong(br.readLine());

        long div = x / 11;
        long result = 2 * div;

        long rem = x % 11;
        if(rem > 6)
            result += 2;

        else if(rem != 0)
            result++;

        System.out.println(result);
        br.close();
    }
}