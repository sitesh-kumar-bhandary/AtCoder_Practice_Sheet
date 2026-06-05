import java.io.*;

public class AtcodeerAndRockPaper {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int result = atcodeerAndRockPaper(s);
        System.out.println(result);
        br.close();
    }

    private static int atcodeerAndRockPaper(String s){
        int n = s.length();

        int rocks = 0;
        int papers = 0;

        int result = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            if(papers < rocks){
                if(ch == 'g'){
                    result++;
                }

                papers++;      
            }

            else {
                if(ch == 'p')
                    result--;

                rocks++;
            }
        }

        return result;
        // int result = helper(0, 0, 0, s);
        // return result;
    }

    // private static int helper(int ind, int rocks, int papers, String s){
    //     if(ind >= s.length())
    //         return Integer.MIN_VALUE;

    //     char ch = s.charAt(ind);

    //     // don't take p
    //     int notTake = ch == 'g' ? 0 : -1 + helper(ind+1, rocks+1, papers, s);

    //     // take p
    //     int take = Integer.MIN_VALUE;
    //     if(papers < rocks){
    //         int add = ch == 'g' ? 1 : 0;
    //         take = Math.max(take, add + helper(ind+1, rocks, papers+1, s));
    //     }

    //     return Math.max(take, notTake);
    // }
}