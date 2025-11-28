import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");

        Stack<String> stack = new Stack<>();

        for (String s : arr) {
            if (stack.isEmpty() || s.equals("(")) {
                stack.push(s);
            } else {
                if (s.equals(")") && stack.peek().equals("(")) {
                    stack.pop();
                } else {
                    stack.push(s);
                }
            }
        }

        System.out.println(stack.size());
    }
}
