class Solution {
    public int solution(int n) {
        int start = 1;
        int end = 1;
        int total = 1;
        int count = 0;
        while (start <= end && end <= n) {      // start <= end 조건 없어도 됨
            if (total == n) {
                count++;
                end++;
                total += end;
            } else if (total < n) {
                end++;
                total += end;
            } else {
                total -= start;
                start++;
            }
        }
        
        return count;
    }
}