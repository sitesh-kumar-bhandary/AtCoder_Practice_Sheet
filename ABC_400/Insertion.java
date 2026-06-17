package ABC_400;
import java.io.*;
import java.util.*;

public class Insertion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        String result = insertion(n, s);
        System.out.println(result);
        br.close();
    }

    private static String insertion(int n, String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            if(stack.isEmpty())
                stack.push(ch);

            else {
                if(ch == '(')
                    stack.push(ch);

                else {
                    if(stack.peek() == '(')
                        stack.pop();

                    else
                        stack.push(ch);
                }
            }
        }

        int opens = 0;
        int closes = 0;
        while(! stack.isEmpty()){
            char ch = stack.pop();

            if(ch == '(')
                opens++;

            else
                closes++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<closes;i++)
            sb.append('(');

        sb.append(s);

        for(int i=0;i<opens;i++)
            sb.append(')');

        return sb.toString();
    }
}