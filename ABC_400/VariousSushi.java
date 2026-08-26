package ABC_400;
import java.io.*;
import java.util.*;

public class VariousSushi {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int n = Integer.parseInt(exp[0]);
        int k = Integer.parseInt(exp[1]);

        int[][] sushi = new int[n][2];
        for(int i=0;i<n;i++){
            exp = br.readLine().split(" ");
            sushi[i][0] = Integer.parseInt(exp[0]);
            sushi[i][1] = Integer.parseInt(exp[1]);
        }

        long result = variousSushi(n, k, sushi);
        System.out.println(result);
        br.close();
    }

    private static long variousSushi(int n, int k, int[][] sushi){
        Arrays.sort(sushi, (int[] a, int[] b) -> Integer.compare(b[1], a[1]));

        PriorityQueue<Integer> duplicatesPq = new PriorityQueue<>();
        HashSet<Integer> typeSet = new HashSet<>();

        // I take the first k max deliciousness
        long totalSum = 0L;
        for(int i=0;i<k;i++){
            int toppins = sushi[i][0];
            int deliciousness = sushi[i][1];

            totalSum += (long) deliciousness;
            if(! typeSet.contains(toppins))
                typeSet.add(toppins);

            else
                duplicatesPq.add(deliciousness);
        }

        // II - check for every new toppings type
        int uniqueTypes = typeSet.size();
        long result = totalSum + ((long) uniqueTypes * uniqueTypes);

        for(int i=k;i<n;i++){
            int toppins = sushi[i][0];
            int deliciousness = sushi[i][1];

            if(typeSet.contains(toppins))
                continue;

            if(duplicatesPq.isEmpty())
                break;

            int currDuplicateDeliciousness = duplicatesPq.poll();

            totalSum -= (long) currDuplicateDeliciousness;
            totalSum += (long) deliciousness;

            typeSet.add(toppins);
            uniqueTypes++;  

            result = Math.max(result, totalSum + ((long) uniqueTypes * uniqueTypes));
        }

        return result;
    }
}