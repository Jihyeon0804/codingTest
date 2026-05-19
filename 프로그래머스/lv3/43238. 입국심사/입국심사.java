import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        
        long start = 1;
        long end = (long) Arrays.stream(times).max().getAsInt() * n;
        long time = end;
        
        while (start <= end) {
            long num = 0;
            long idx = (start + end) / 2;
            for (long i : times) {
                num += idx / i;
                
            }
            if (num < n) {
                start = idx + 1;
            } else {
                time = idx;
                end = idx - 1;
            }
        }
        return time;
    }
}