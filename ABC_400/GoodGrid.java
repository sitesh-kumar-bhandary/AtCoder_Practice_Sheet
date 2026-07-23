package ABC_400;
import java.io.*;
import java.util.*;

public class GoodGrid {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(exp[0]);
        int c = Integer.parseInt(exp[1]);

        int[][] d = new int[c][c];
        for(int i=0;i<c;i++){
            exp = br.readLine().trim().split("\\s+");
            for(int j=0;j<c;j++)
                d[i][j] = Integer.parseInt(exp[j]);
        }

        int[][] grid = new int[n][n];
        for(int i=0;i<n;i++){
            exp = br.readLine().trim().split("\\s+");
            for(int j=0;j<n;j++)
                grid[i][j] = Integer.parseInt(exp[j])-1;
        }

        long result = goodGrid(n, c, d, grid);
        System.out.println(result);
        br.close();
    }

    private static long goodGrid(int n, int c, int[][] d, int[][] grid){
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int key = (i+j) % 3;
                String value = i+" "+j;
                ArrayList<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(value);
                map.put(key, list);
            }
        }

        HashMap<Integer, HashMap<Integer, Long>> remToColSumMap = new HashMap<>();
        for(int i=0;i<3;i++){
            remToColSumMap.put(i, new HashMap<>());

            for(int j=0;j<c;j++){

                ArrayList<String> list = map.getOrDefault(i, new ArrayList<>());
                long totalSum = 0;
                for(String str : list){
                    String[] s = str.split(" ");
                    int row = Integer.parseInt(s[0]);
                    int col = Integer.parseInt(s[1]);

                    int prevColor = grid[row][col];
                    int currColor = j;
                    totalSum += (long) d[prevColor][currColor];
                }

                remToColSumMap.get(i).put(j, totalSum);
            }
        }

        long totalSum = Long.MAX_VALUE;
        for(int i=0;i<c;i++){
            for(int j=0;j<c;j++){
                if(i ==  j)
                    continue;
                
                for(int k=0;k<c;k++){
                    if(i == k || j == k)
                        continue;

                    long currSum = remToColSumMap.get(0).get(i) + 
                                remToColSumMap.get(1).get(j) + 
                                remToColSumMap.get(2).get(k);

                    totalSum = Math.min(totalSum, currSum);
                }
            }
        }

        return totalSum;
    }
}