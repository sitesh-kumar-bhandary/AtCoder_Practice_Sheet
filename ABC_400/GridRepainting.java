package ABC_400;
import java.io.*;
import java.util.*;

public class GridRepainting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int h = Integer.parseInt(exp[0]);
        int w = Integer.parseInt(exp[1]);

        char[][] grid = new char[h][w];
        int totalBlacks = 0;
        for(int i=0;i<h;i++){
            String s = br.readLine();
            for(int j=0;j<w;j++){
                grid[i][j] = s.charAt(j);
                if(grid[i][j] == '#')
                    totalBlacks++;
            }
        }

        int result = gridRepainting(h, w, grid);
        if(result != -1)
            result -= totalBlacks;

        System.out.println(result);
        br.close();
    }

    private static int gridRepainting(int h, int w, char[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        boolean[][] visited = new boolean[h][w];
        visited[0][0] = true;

        int[][] distance = new int[h][w];
        for(int[] a : distance)
            Arrays.fill(a, Integer.MAX_VALUE);

        distance[0][0] = 1;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(! queue.isEmpty()){
            int[] curr = queue.poll();

            if(curr[0] == h-1 && curr[1] == w-1)
                break;

            for(int[] d : directions){
                int newRow = curr[0] + d[0];
                int newCol = curr[1] + d[1];

                if(newRow >= 0 && newRow < h && newCol >= 0 && newCol < w && ! visited[newRow][newCol] && grid[newRow][newCol] == '.'){
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                    distance[newRow][newCol] = distance[curr[0]][curr[1]] + 1;
                }
            }
        }

        if(distance[h-1][w-1] == Integer.MAX_VALUE)
            return -1;


        return (h*w) - distance[h-1][w-1];
    }
}