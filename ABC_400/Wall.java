package ABC_400;
import java.io.*;

public class Wall{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int h = Integer.parseInt(exp[0]);
        int w = Integer.parseInt(exp[1]);

        int[][] c = new int[10][10];
        for(int i=0;i<10;i++){
            String[] exp1 = br.readLine().split(" ");

            for(int j=0;j<10;j++)
                c[i][j] = Integer.parseInt(exp1[j]);
        }

        int[][] a = new int[h][w];
        for(int i=0;i<h;i++){
            String[] exp1 = br.readLine().split(" ");

            for(int j=0;j<w;j++)
                a[i][j] = Integer.parseInt(exp1[j]);
        }

        int result = wall(h, w, c, a);
        System.out.println(result);
        br.close();
    }

    private static int wall(int h, int w, int[][] c, int[][] a){
        for(int k=0;k<10;k++){
            for(int i=0;i<10;i++){
                for(int j=0;j<10;j++)
                    c[i][j] = Math.min(c[i][j], c[i][k]+c[k][j]);
            }
        }

        int result = 0;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(a[i][j] != -1 && a[i][j] != 1){
                    int value = c[a[i][j]][1];
                    result += value;
                }
            }
        }

        return result;
    }
}