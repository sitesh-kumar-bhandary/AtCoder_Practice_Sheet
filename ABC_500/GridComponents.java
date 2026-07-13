package ABC_500;
import java.io.*;

public class GridComponents {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int a = Integer.parseInt(exp[0]);
        int b = Integer.parseInt(exp[1]);

        String result = gridComponents(a, b);
        System.out.println(result);
        br.close();
    }

    private static String gridComponents(int a, int b){
        char[][] grid = new char[100][100];

        // I - Painting first half of the grid with white and last half with blac
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(i < 50)
                    grid[i][j] = '.';

                else
                    grid[i][j] = '#';
            }
        }
        
        a--;
        b--;

        if(b > 0){
            // Now painting the remaining oppsite colors in the grids in an alternate way so that it will create a diff components
            boolean flag = true;
            for(int i=0;i<49;i++){
                for(int j=0;j<100;j++){
                    if(i % 2 == 1 && j % 2 == 1){
                        grid[i][j] = '#';
                        b--;

                        if(b == 0){
                            flag = false;
                            break;
                        }
                    }
                }

                if(! flag)
                    break;
            }
        }

        if(a > 0){
            boolean flag = true;
            for(int i=51;i<100;i++){
                for(int j=0;j<100;j++){
                    if(i % 2 == 1 && j % 2 == 1){
                        grid[i][j] = '.';
                        a--;

                        if(a == 0){
                            flag = false;
                            break;
                        }
                    }
                }

                if(! flag)
                    break;
            }
        }

        System.out.println("100 100");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<100;i++)
            sb.append(new String(grid[i])).append("\n");

        return sb.toString();
    }
}