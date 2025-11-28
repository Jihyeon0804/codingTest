import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char c : s.toCharArray()) {
            left.push(c);
        }

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.charAt(0) == 'L') {
                if (!left.isEmpty()) {
                    right.push(left.pop());

                }
            } else if (str.charAt(0) == 'D') {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            } else if (str.charAt(0) == 'B') {
                if (!left.isEmpty()) {
                    left.pop();
                }
            } else if (str.charAt(0) == 'P') {
                left.push(str.charAt(str.length() - 1));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);

    }
}
