package ABC_300;
import java.io.*;

public class BackAndForth {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exp = br.readLine().split(" ");
        int sx = Integer.parseInt(exp[0]);
        int sy = Integer.parseInt(exp[1]);
        int tx = Integer.parseInt(exp[2]);
        int ty = Integer.parseInt(exp[3]);

        String result = backAndForth(sx, sy, tx, ty);
        System.out.println(result);
    }

    private static String backAndForth(int sx, int sy, int tx, int ty){    
        StringBuilder sb = new StringBuilder();

        // I - going from sy - ty
        int s1y = sy;
        while(s1y != ty){
            sb.append("U");
            s1y++;
        }

        // I - going from sx - tx
        int s1x = sx;
        while(s1x != tx){
            sb.append('R');
            s1x++;
        }

        // II - coming from ty - sy
        while(s1y != sy){
            sb.append('D');
            s1y--;
        }

        // II - coming from tx  - sx
        while(s1x != sx){
            sb.append('L');
            s1x--;
        }

        // III - Trying to use some other row and column to get on that same line
        sb.append('L');
        while(s1y != ty+1){
            sb.append('U');
            s1y++;
        }

        while(s1x != tx+1){
            sb.append('R');
            s1x++;
        }
        sb.append('D');

        // Iv - Try to use some other row and column again
        sb.append('R');
        while(s1y != sy){
            sb.append("D");
            s1y--;
        }

        while(s1x != sx){
            sb.append('L');
            s1x--;
        }
        sb.append('U');

        return sb.toString();
    }
}