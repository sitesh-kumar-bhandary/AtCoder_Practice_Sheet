package ABC_300;
import java.io.*;

public class DigitsInMultiplication {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        int result = digitsInMultiplication(n);
        System.out.println(result);
        br.close();
    }

    private static int digitsInMultiplication(long n){
        long maxDiv = 0;
        for(long i=1;i*i<=n;i++){
            if(n % i == 0){
                maxDiv = i;
            }
        }

        long div1 = maxDiv;
        long div2 = n / maxDiv;

        int digits1 = countDigits(div1);
        int digits2 = countDigits(div2);
        return Math.max(digits1, digits2);
    }

    private static int countDigits(long n){
        int count = 0;
        while(n != 0){
            n = n / 10;
            count++;
        }

        return count;
    }
}