class Solution {
    public int solution(int n) {
        
        return 7 / n > 0 ? 1 : n % 7 == 0 ? n / 7 : n / 7 + 1;
    }
}