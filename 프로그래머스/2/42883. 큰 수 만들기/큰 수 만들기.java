import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);

            while (sb.length() > 0 && sb.charAt(sb.length() - 1) < ch && k > 0) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(ch);
        }

        return sb.substring(0, sb.length() - k);
    }
}