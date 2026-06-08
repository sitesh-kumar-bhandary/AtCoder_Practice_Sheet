package ABC_500_Points_Practice;
import java.io.*;

public class Menagerie {

    static char[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        // Case I - Propagate structure like SS
        result = new char[n];
        result[0] = 'S';
        result[1] = 'S';

        int result1 = menagerie(n, s);
        String str1 = new String(result);

        // Case II - Propagate structure like SW
        result = new char[n];
        result[0] = 'S';
        result[1] = 'W';
        int result2 = menagerie(n, s);
        String str2 = new String(result);

        // Case III - Propagate structure like WW
        result = new char[n];
        result[0] = 'W';
        result[1] = 'W';
        int result3 = menagerie(n, s);
        String str3 = new String(result);

        // Case IV - Propagate structure like WS
        result = new char[n];
        result[0] = 'W';
        result[1] = 'S';
        int result4 = menagerie(n, s);
        String str4 = new String(result);

        if(result1 == -1 && result2 == -1 && result3 == -1 && result4 == -1)
            System.out.println("-1");

        else {
            if(result1 != -1)
                System.out.println(str1);

            else if(result2 != -1)
                System.out.println(str2);

            else if(result3 != -1)
                System.out.println(str3);

            else
                System.out.println(str4);
        }

        br.close();
    }

    private static int menagerie(int n, String s){
        for(int i=1;i<n-1;i++){

            if(result[i] == 'S'){
                if(s.charAt(i) == 'o'){
                    result[i+1] = result[i-1];
                }

                else {
                    result[i+1] = result[i-1] == 'S' ? 'W' : 'S';
                }
            }

            else {
                if(s.charAt(i) == 'o'){
                    result[i+1] = result[i-1] == 'S' ? 'W' : 'S';
                }

                else {
                    result[i+1] = result[i-1];
                }
            }
        }

        if(isSatisfiedCondition(n, s, result))
            return 1;

        else
            return -1;
    }

    private static boolean isSatisfiedCondition(int n, String s, char[] result){
        for(int i=0;i<n;i++){
            int next = i == n-1 ? 0 : i+1;
            int prev = i == 0 ? n-1 : i-1;

            if(result[i] == 'S'){

                if(s.charAt(i) == 'o'){
                    if(result[next] != result[prev])
                        return false;
                }

                else {
                    if(result[next] == result[prev])
                        return false;
                }
            }

            else {
                if(s.charAt(i) == 'o'){
                    if(result[next] == result[prev])
                        return false;
                }

                else {
                    if(result[next] != result[prev])
                        return false;
                }
            }
        }

        return true;
    }
}