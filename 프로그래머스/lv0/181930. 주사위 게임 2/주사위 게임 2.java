import java.util.*;

class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        if ((a != b) && (b != c) && (a != c)) {
            answer += (a + b + c);
        } else if (((a == b) && (b != c)) || ((a != b) && (b == c)) || ((a != b) && (a == c))) {
            answer += ((a + b + c) * (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)));
        } else {
            answer += ((a + b + c) * (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)) * (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3)));
        }
        return answer;
    }
}