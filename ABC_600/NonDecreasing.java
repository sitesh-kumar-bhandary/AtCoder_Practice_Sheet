package ABC_600;
import java.io.*;

public class NonDecreasing {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        String[] exp = br.readLine().split(" ");
        for(int i=0;i<n;i++)
            a[i] = Integer.parseInt(exp[i]);

        nonDecreasing(n, a);
        br.close();
    }

    private static void nonDecreasing(int n, int[] a){
        int maxVal = Integer.MIN_VALUE;
        int maxInd = -1;

        int minVal = Integer.MAX_VALUE;
        int minInd = -1;

        for(int i=0;i<n;i++){
            int val = a[i];
            if(val > maxVal){
                maxVal = val;
                maxInd = i+1;
            }

            if(val < minVal){
                minVal = val;
                minInd = i+1;
            }
        }

        if(maxVal < 0){
            System.out.println(n-1);
            forAllNegatives(n, a);
        }

        else if(minVal >= 0){
            System.out.println(n-1);
            forAllPositives(n, a);
        }

        else {
            System.out.println(2*n-1);
            if(Math.abs(maxVal) >= Math.abs(minVal)){
                for(int i=0;i<n;i++){
                    a[i] = a[i] + maxVal;
                    System.out.println(maxInd+" "+(i+1));
                }

                forAllPositives(n, a);
            }

            else {
                for(int i=0;i<n;i++){
                    a[i] = a[i] + minVal;
                    System.out.println(minInd+" "+(i+1));
                }

                forAllNegatives(n, a);
            }
        }
    }

    private static void forAllPositives(int n, int[] a){
        for(int i=1;i<n;i++){
            a[i] = a[i] + a[i-1];
            System.out.println(i+" "+(i+1));
        }
    }

    private static void forAllNegatives(int n, int[] a){
        for(int i=n-2;i>=0;i--){
            a[i] = a[i] + a[i+1];
            System.out.println((i+2)+" "+(i+1));
        }
    }
}