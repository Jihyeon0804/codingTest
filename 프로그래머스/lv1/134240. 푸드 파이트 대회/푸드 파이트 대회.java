import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        for (int i = 1; i < food.length; i++) {
            answer += Integer.toString(i).repeat(food[i] / 2);
        }
        
        StringBuffer sb = new StringBuffer(answer);
        answer = answer + "0" + sb.reverse().toString();
        return answer;
    }
}