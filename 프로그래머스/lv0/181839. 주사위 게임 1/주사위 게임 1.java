class Solution {
    public int solution(int a, int b) {
        
        if  ((a * b) % 2 != 0) {       // 모두 홀수
            return a * a + b * b;
            
        } else if ((a + b) % 2 == 0) {  // 모두 짝수
            if (a > b) {
                return a - b;
            } else {
                return b - a;
            }
            
        } else {                        // 둘 중 하나만 홀수
            return 2 * (a + b);
        }
    }
}