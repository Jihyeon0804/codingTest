import java.util.*;

class Solution {
    public int solution(int num, int k) {
        
        int answer = -1;
        String[] arr = String.valueOf(num).split("");
        for (int i = 0; i < arr.length; i++) {
            if (Integer.parseInt(arr[i]) == k) {
                answer = i + 1;
                break;
            }

        }
        return answer;
    }
}