package ABC_400;
import java.io.*;
import java.util.*;

public class GridColoring {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int h = Integer.parseInt(exp[0]);
        int w = Integer.parseInt(exp[1]);

        int n = Integer.parseInt(br.readLine());

        String[] exp1 = br.readLine().split(" ");
        int[] a = new int[n];
        for(int i=0;i<n;i++)
            a[i] = Integer.parseInt(exp1[i]);

        gridColoring(h, w, n, a);
        br.close();
    }

    private static void gridColoring(int h, int w, int n, int[] a){
        StringBuilder sb = new StringBuilder();

        int k = 0;
        for(int i=0;i<h;i++){

            if(i % 2 == 0){
                for(int j=0;j<w;j++){
                    sb.append(k+1).append(" ");
                    a[k]--;

                    if(a[k] == 0)
                        k++;
                }
                sb.append("\n");
            }

            else {
                Stack<Integer> stack = new Stack<>();
                for(int j=w-1;j>=0;j--){
                    stack.push(k+1);
                    a[k]--;

                    if(a[k] == 0)
                        k++;
                }

                while(! stack.isEmpty())
                    sb.append(stack.pop()).append(" ");

                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}