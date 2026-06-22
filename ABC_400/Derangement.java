package ABC_400;
import java.io.*;

public class Derangement {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] p = new int[n];
        String[] exp = br.readLine().split(" ");
        for(int i=0;i<n;i++)
            p[i] = Integer.parseInt(exp[i]);

        int result = derangement(n, p);
        System.out.println(result);
        br.close();
    }

    private static int derangement(int n, int[] p){
        int result = 0;

        for(int i=0;i<n;i++){
            if(i != n-1){
                if(p[i] == i+1){
                    int temp = p[i];
                    p[i] = p[i+1];
                    p[i+1] = temp;

                    result++;
                }
            }

            else {
                if(p[i] == i+1){
                    int temp = p[i];
                    p[i] = p[i-1];
                    p[i-1] = temp;

                    result++;
                }
            }
        }

        return result;
    }
}