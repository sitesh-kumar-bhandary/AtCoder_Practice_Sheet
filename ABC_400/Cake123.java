package ABC_400;
import java.io.*;
import java.util.*;

public class Cake123  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int x = Integer.parseInt(exp[0]);
        int y = Integer.parseInt(exp[1]);
        int z = Integer.parseInt(exp[2]);
        int k = Integer.parseInt(exp[3]);

        long[] a = new long[x];
        exp = br.readLine().split(" ");
        for(int i=0;i<x;i++)
            a[i] = Long.parseLong(exp[i]);

        long[] b = new long[y];
        exp = br.readLine().split(" ");
        for(int i=0;i<y;i++)
            b[i] = Long.parseLong(exp[i]);

        long[] c = new long[z];
        exp = br.readLine().split(" ");
        for(int i=0;i<z;i++)
            c[i] = Long.parseLong(exp[i]);

        String result = cake(x, y, z, k, a, b, c);
        System.out.println(result);
        br.close();
    }

    private static String cake(int x, int y, int z, int k, long[] a, long[] b, long[] c){
        PriorityQueue<Long> pq1 = new PriorityQueue<>();
        PriorityQueue<Long> pq2 = new PriorityQueue<>();
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                pq1.add(a[i]+b[j]);

                if(pq1.size() > k)
                    pq1.remove();
            }
        }

        while(! pq1.isEmpty()){
            long peekVal = pq1.remove();

            for(int i=0;i<z;i++){
                pq2.add(peekVal + c[i]);

                if(pq2.size() > k)
                    pq2.remove();
            }
        }

        Stack<Long> stack = new Stack<>();
        while(! pq2.isEmpty())
            stack.push(pq2.remove());

        StringBuilder sb = new StringBuilder();
        while(! stack.isEmpty())
            sb.append(stack.pop()).append("\n");

        return sb.toString();
    }
}