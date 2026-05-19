import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> que1 = new LinkedList<>();
        Queue<String> que2 = new LinkedList<>();
        
        for (String s : cards1) {
            que1.offer(s);
        }
        
        for (String s : cards2) {
            que2.offer(s);
        }
        
        for (String s : goal) {
            if (s.equals(que1.peek())) {
                que1.poll();
            } else if (s.equals(que2.peek())) {
                que2.poll();
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}