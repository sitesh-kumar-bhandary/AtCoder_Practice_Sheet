package ABC_350;
import java.io.*;
import java.util.*;

public class AtcoderMagics {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cards = new int[n][3];

        for(int i=0;i<n;i++){
            String[] exp = br.readLine().split(" ");
            cards[i][0] = Integer.parseInt(exp[0]);
            cards[i][1] = Integer.parseInt(exp[1]);
            cards[i][2] = i+1;
        }

        atcoderMagics(n, cards);
        br.close();
    }

    private static void atcoderMagics(int n, int[][] cards){
        Arrays.sort(cards, (int[] a, int[] b) -> b[0] - a[0]);

        PriorityQueue<int[]> minPQ = new PriorityQueue<>((int[] a, int[] b) -> a[1] - b[1]);
        minPQ.add(cards[0]);

        for(int i=1;i<n;i++){
            int[] cd = cards[i];
            if(cd[1] <= minPQ.peek()[1])
                minPQ.add(cd);

            else
                continue;
        }

        System.out.println(minPQ.size());
        StringBuilder sb = new StringBuilder();
        int[] result = new int[minPQ.size()];

        int i = 0;
        while(! minPQ.isEmpty()){
            int[] crd = minPQ.poll();
            result[i++] = crd[2];
        }

        Arrays.sort(result);
        for(int val : result)
            sb.append(val).append(" ");

        System.out.println(sb.toString().trim());
    }
}