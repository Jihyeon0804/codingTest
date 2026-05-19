import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        
        if (isRight(s)) {
            answer++;
        }
        for (int i = 1; i < s.length(); i++) {
            // 괄호 한 칸 씩 뒤로 이동
            char c = sb.charAt(0);
            sb.deleteCharAt(0).append(c);

            // 올바른 괄호인지 확인
            if (isRight(String.valueOf(sb))) {
                answer++;
            }
        }
        return answer;
    }

    // 올바른 괄호인지 확인하는 메소드
    public static boolean isRight(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (map.containsValue(c)) {  // 닫힌 괄호일 경우
                if (stack.isEmpty() || map.get(stack.pop()) != c) {
                    return false;  // 스택이 비어있거나 짝꿍이 아닌 경우
                }
            }
        }
        return stack.isEmpty();
    }
}