import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] divisor = new int[number];
        for (int i = 1; i <= number; i++) {
            int cnt = 0;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    cnt++;
                    int quotient = i / j;
                    if (j != quotient) {
                        cnt++;
                    }
                }

            }
            divisor[i - 1] = cnt; 
        }
        
        
        for (int i = 0; i < divisor.length; i++) {
            if (divisor[i] > limit) {
                divisor[i] = power;
            }
            answer += divisor[i];
        }
        
        return answer;
    }
}