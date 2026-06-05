import java.io.*;

public class AnOrdinaryGame {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        anOrdinaryGame(s);
        br.close();
    }

    private static void anOrdinaryGame(String s){
        int n = s.length();
        if(n % 2 == 1){
            if(s.charAt(0) == s.charAt(n-1)){
                System.out.println("Second");
                return;
            }

            else {
                System.out.println("First");
                return;
            }
        }

        else {
            if(s.charAt(0) == s.charAt(n-1)){
                System.out.println("First");
                return;
            }

            else {
                System.out.println("Second");
                return;
            }
        }
    }
}