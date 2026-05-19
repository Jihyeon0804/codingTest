import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || c == '(') {
                stack.push(c);
            } else {
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}