import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < skip.length(); i++) {
            char c = skip.charAt(i);
            alpha = alpha.replace(c, ' ');
        }
        alpha = alpha.replace(" ", "");

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            answer.append(alpha.charAt((alpha.indexOf(c) + index) % alpha.length()));


        }
        return answer.toString();
    }
}