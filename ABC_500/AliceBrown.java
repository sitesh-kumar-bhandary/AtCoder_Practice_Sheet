package ABC_500;
import java.io.*;

public class AliceBrown {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");;
        long x = Long.parseLong(exp[0]);
        long y = Long.parseLong(exp[1]);

        if(Math.abs(x-y) <= 1)
            System.out.println("Brown");

        else
            System.out.println("Alice");
            
        br.close();
    }
}