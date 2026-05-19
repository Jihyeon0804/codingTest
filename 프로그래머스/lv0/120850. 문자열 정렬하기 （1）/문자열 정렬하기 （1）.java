import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        my_string = my_string.replaceAll("[a-z]", "");

        int[] answer = new int[my_string.length()];
        int idx = 0;
        for (char c : my_string.toCharArray()) {
            answer[idx++] = (int) c - 48;
        }
        
        Arrays.sort(answer);
        return answer;
    }
}