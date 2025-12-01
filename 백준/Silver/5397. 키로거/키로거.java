import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i  = 0 ; i < n; i++) {
            String s = br.readLine();
            sb.append(getPassword(s));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static String getPassword(String string) {

        if (string.matches("^[a-zA-Z0-9]+$")) {
            return string;
        } else {
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            for (char c : string.toCharArray()) {
                if (c == '<') {
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                } else if (c == '>') {
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                } else if (c == '-') {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                } else {
                    left.push(c);
                }
            }

            StringBuilder sb = new StringBuilder();

            while (!left.isEmpty()) {
                right.push(left.pop());
            }

            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            return sb.toString();
        }
    }
}
